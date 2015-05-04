package essence.plugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

import essence.inject.Injector;

public final class PluginLoader {

	public Collection<Plugin> loadAll(File file, Injector injector) {
		Collection<Plugin> plugins = new ArrayList<>();
		if (file.isDirectory()) {
			for (File child : file.listFiles())
				plugins.addAll(loadAll(child, injector));
		} else
			plugins.add(load(file, injector));
		return plugins;
	}

	public Plugin load(File file, Injector injector) {
		try {
			addToClasspath(file);
			Class<?> pluginClass = getPluginParent(file);
			return (Plugin) injector.getInstance(pluginClass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void addToClasspath(File file) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
		method.setAccessible(true);
		method.invoke((URLClassLoader) ClassLoader.getSystemClassLoader(), file.toURI().toURL());
	}

	private static Class<?> getPluginParent(File file) {
		List<Class<?>> plugins = getPlugins(file);
		if (plugins.isEmpty())
			return null;
		// TODO Find best "parent" of plugins
		return plugins.get(0);
	}

	private static List<Class<?>> getPlugins(File file) {
		try (ZipFile zip = new ZipFile(file)) {
			return zip.stream()
					.map(e -> e.getName())
					.map(PluginLoader::getClass)
					.filter(e -> e != null && e.isAnnotationPresent(PluginManifest.class))
					.collect(Collectors.toList());
		} catch (IOException ioe) {
			return Collections.emptyList();
		}
	}

	private static Class<?> getClass(String fileName) {
		int length = fileName.length();
		if (length > 7) {
			String formattedName = fileName.substring(0, length - 6).replace("/", ".");
			try {
				return Class.forName(formattedName);
			} catch (ClassNotFoundException e) {
			}
		}
		return null;
	}

}
