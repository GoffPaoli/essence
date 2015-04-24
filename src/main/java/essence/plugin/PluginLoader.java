package essence.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class PluginLoader {

	public Plugin load(File file) {
		// TODO needs major refactoring
		try {
			Class<?> pluginClass = null;

			Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			method.setAccessible(true);
			method.invoke((URLClassLoader) ClassLoader.getSystemClassLoader(), file.toURI().toURL());

			ZipFile zf = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = zf.entries();
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				if (e.getName().toLowerCase().endsWith(".class")) {
					Class<?> potentialClass = Class.forName(e.getName().substring(0, e.getName().length() - 6)
							.replace("/", "."));
					if (potentialClass.isAnnotationPresent(PluginManifest.class)) {
						pluginClass = potentialClass;
						break;
					}
				}
			}
			zf.close();

			if (pluginClass == null)
				throw new PluginLacksManifestException();

			return (Plugin) pluginClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Collection<Plugin> loadAll(File file) {
		Collection<Plugin> plugins = new ArrayList<>();
		if (file.isDirectory()) {
			for (File child : file.listFiles())
				plugins.addAll(loadAll(child));
		} else
			plugins.add(load(file));
		return plugins;
	}

}
