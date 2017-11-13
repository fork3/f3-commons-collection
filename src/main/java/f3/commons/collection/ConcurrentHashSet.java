/*
 * Copyright (c) 2010-2017 fork3
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
	private final static transient Object value = new Object();
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
