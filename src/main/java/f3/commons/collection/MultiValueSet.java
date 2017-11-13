/*
 * Copyright (c) 2010-2016 fork3
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

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * Хранилище параметров разного типа.
 * 
 * @author G1ta0
 *
 * @param <T> ключ для доступа к значению параметра
 */
public class MultiValueSet<T> extends HashMap<T, Object> implements IMultiValue<T> {
	private static final long serialVersionUID = 8071544899414292397L;
	
	public final static transient MultiValueSet<?> EMPTY = new MultiValueSet<>();
	@SuppressWarnings("unchecked")
	public static <T> MultiValueSet<T> getEmpty() {
		return (MultiValueSet<T>) EMPTY;
	}
	
	@Getter @Setter private transient boolean replaceStringValue;
	public MultiValueSet() {
		super();
	}

	public MultiValueSet(int size) {
		super(size);
	}

	public MultiValueSet(MultiValueSet<T> set) {
		super(set);
	}

	@Override
	public MultiValueSet<T> clone() {
		return new MultiValueSet<T>(this);
	}
}
