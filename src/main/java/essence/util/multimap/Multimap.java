package essence.util.multimap;

import java.util.Collection;
import java.util.Map;

public interface Multimap<K, V> {

	Map<K, Collection<V>> asMap();

	void put(K key, V value);

	Collection<V> get(K key);

	int size();

}
