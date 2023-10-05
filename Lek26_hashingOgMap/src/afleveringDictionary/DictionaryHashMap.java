package afleveringDictionary;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

	private Map<K, V>[] tabel;
	private static int N = 10;

	/**
	 * HashingMap constructor comment.
	 */
	public DictionaryHashMap() {
		tabel = new HashMap[N];
		for (int i = 0; i < N; i++) {
			tabel[i] = new HashMap<K, V>();
		}
	}

	@Override
	public V get(K key) {
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		return m.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		return empty;
	}

	@Override
	public V put(K key, V value) {
		// TODO
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		V v = m.get(key);
		m.put(key, value);
		return v;
	}

	@Override
	public V remove(K key) {
		// TODO
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		V v = m.get(key);
		m.remove(key, v);
		return v;
	}

	@Override
	public int size() {
		int counter = 0;
		for (int i = 0; i < N; i++) {
			counter += tabel[i].size();
		}
		return counter;
	}
}
