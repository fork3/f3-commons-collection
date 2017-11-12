/*
 * Copyright (c) 2010-2017 fork2
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

import java.util.HashSet;
import java.util.Set;

/**
 * @author n3k0nation
 *
 */
public class HistoryMultiValueSet<T> extends MultiValueSet<T> {
	private static final long serialVersionUID = -231346954212493480L;
	
	private final Set<T> deleteHistory = new HashSet<>();
	
	public HistoryMultiValueSet() {
		super();
	}

	public HistoryMultiValueSet(int size) {
		super(size);
	}

	public HistoryMultiValueSet(HistoryMultiValueSet<T> set) {
		super(set);
	}

	@Override
	public HistoryMultiValueSet<T> clone() {
		return new HistoryMultiValueSet<T>(this);
	}
	
	@Override
	public Object put(T key, Object value) {
		if(deleteHistory.contains(key)) {
			deleteHistory.remove(key);
		}
		
		return super.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object remove(Object key) {
		final Object value = super.remove(key);
		if(value != null) {
			deleteHistory.add((T) key);
		}
		return value;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object key, Object value) {
		final boolean result = super.remove(key, value);
		if(result) {
			deleteHistory.add((T) key);
		}
		return result;
	}

	public Set<T> getDeleteKeysHistory() {
		return deleteHistory;
	}
	
	public void clearHistory() {
		deleteHistory.clear();
	}
}
