package f3.commons.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author n3k0nation
 *
 */
public class ConcurrentHashSet<T> implements Set<T> {
	private final static Object value = new Object();
	private final Map<T, Object> set;
	
	public ConcurrentHashSet() {
		set = new ConcurrentHashMap<>();
	}
	
	public ConcurrentHashSet(int initCount, float loadFactor) {
		set = new ConcurrentHashMap<>(initCount, loadFactor);
	}
	
	public ConcurrentHashSet(int initCount) {
		set = new ConcurrentHashMap<>(initCount);
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return set.containsKey(o);
	}

	@Override
	public Iterator<T> iterator() {
		return set.keySet().iterator();
	}

	@Override
	public Object[] toArray() {
		return set.keySet().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return set.keySet().toArray(a);
	}

	@Override
	public boolean add(T e) {
		return set.put(e, value) == null;
	}

	@Override
	public boolean remove(Object o) {
		return set.remove(o, value);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return set.keySet().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T o : c) {
			set.put(o, value);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return set.keySet().retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o : c) {
			set.remove(o, value);
		}
		return true;
	}

	@Override
	public void clear() {
		set.clear();
	}

}
