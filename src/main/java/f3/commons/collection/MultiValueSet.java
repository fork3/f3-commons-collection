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
	
	public final static MultiValueSet<?> EMPTY = new MultiValueSet<>();
	@SuppressWarnings("unchecked")
	public static <T> MultiValueSet<T> getEmpty() {
		return (MultiValueSet<T>) EMPTY;
	}
	
	@Getter @Setter private boolean replaceStringValue;
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
