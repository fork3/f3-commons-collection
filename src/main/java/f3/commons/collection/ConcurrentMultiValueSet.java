package f3.commons.collection;

import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * Хранилище параметров разного типа. Конкурентная версия.
 * 
 * @author G1ta0
 *
 * @param <T> ключ для доступа к значению параметра
 */
public class ConcurrentMultiValueSet<T> extends ConcurrentHashMap<T, Object> implements IMultiValue<T> {
	private static final long serialVersionUID = -306613895895969833L;

	@Getter @Setter private transient boolean replaceStringValue;
	public ConcurrentMultiValueSet() {
		super();
	}

	public ConcurrentMultiValueSet(int size) {
		super(size);
	}

	public ConcurrentMultiValueSet(ConcurrentMultiValueSet<T> set) {
		super(set);
	}

	@Override
	public ConcurrentMultiValueSet<T> clone() {
		return new ConcurrentMultiValueSet<>(this);
	}
}
