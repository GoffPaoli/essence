package essence.util.multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class HashMultimap<K, V> extends AbstractMultimap<K, V> {

	static <K, V> HashMultimap<K, V> create() {
		return new HashMultimap<>();
	}

	private HashMultimap() {
		super(new HashMap<>());
	}

	@Override
	protected Collection<V> supplyCollection() {
		return new ArrayList<>();
	}

}
