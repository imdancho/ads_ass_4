public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "f" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // or Object[]
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
    }

    public MyHashTable(int M) {
        this.M = M;
    }

    private int hash(K key) {
        int keyHash = key.hashCode();
        int result = 1;
        result = (37 * result + keyHash) % M;
        return Math.abs(result);
    }

    public void put(K key, V value) {
        int bucket = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[bucket] != null)
            newNode.next = chainArray[bucket];
        chainArray[bucket] = newNode;
        size++;
    }

    public V get(K key) {
        int bucket = hash(key);
        HashNode<K, V> currentNode = chainArray[bucket];
        while (currentNode != null) {
            if (currentNode.key == key)
                return currentNode.value;
            currentNode = currentNode.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucket = hash(key);
        HashNode<K, V> currentNode = chainArray[bucket];
        HashNode<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key == key) {
                if (previousNode == null)
                    chainArray[bucket] = currentNode.next;
                else
                    previousNode.next = currentNode.next;
                size--;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(V value) {
        HashNode<K, V> currentNode;
        for (int i = 0; i < chainArray.length; i++) {
            currentNode = chainArray[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value))
                    return true;
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        HashNode<K, V> currentNode;
        for (int i = 0; i < chainArray.length; i++) {
            currentNode = chainArray[i++];
            while (currentNode != null) {
                if (currentNode.value.equals(value))
                    return currentNode.key;
                currentNode = currentNode.next;
            }
        }
        return null;
    }


}
