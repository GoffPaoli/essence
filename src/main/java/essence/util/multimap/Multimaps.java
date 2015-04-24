package essence.util.multimap;

public final class Multimaps {

	public static <K, V> Multimap<K, V> hash() {
		return HashMultimap.create();
	}

}
