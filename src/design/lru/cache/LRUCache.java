package design.lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache is a data structure that implements a Least Recently Used (LRU) policy.
 * It stores key-value pairs with a maximum capacity and evicts the least recently 
 * used items when the capacity is reached.
 */
public class LRUCache {
    
    /**
     * Inner class representing a node in the cache.
     */
    private static class CacheNode {
        int key;
        int value;
        CacheNode prev, next;
        
        /**
         * Constructs a new CacheNode with the given key and value.
         *
         * @param key   The key of the node.
         * @param value The value of the node.
         */
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
        
        /**
         * Default constructor for CacheNode.
         * Initializes key and value to 0.
         */
        @SuppressWarnings("unused")
        public CacheNode() {
            this(0, 0);
        }
    }
    
    private Map<Integer, CacheNode> cacheMap;
    private CacheNode MRUNode, LRUNode; 
    private final int MAX_CAPACITY;
    private int size;
    
    /**
     * Constructs a new LRUCache with the given capacity.
     *
     * @param capacity The maximum capacity of the cache.
     */
    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<Integer, CacheNode>();
        this.MRUNode = this.LRUNode = null;
    }
    
    /**
     * Adds or updates a key-value pair in the cache.
     *
     * @param key   The key of the item to be added or updated.
     * @param value The value associated with the key.
     */
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // Update the value for existing key
            CacheNode node = cacheMap.get(key);
            node.value = value;
            updateCacheNode(node);
            return;
        }
        if (size == MAX_CAPACITY) {
            // Evict the least recently used key if capacity is reached
            evictKey();
        }
        // Add new key-value pair to the cache
        CacheNode newNode = new CacheNode(key, value);
        if (MRUNode == null) {
            // Cache is empty
            MRUNode = LRUNode = newNode;
        } else {
            newNode.next = MRUNode;
            MRUNode.prev = newNode;
            MRUNode = newNode;
        }
        cacheMap.put(key, newNode);
        ++size;
    }
    
    /**
     * Evicts the least recently used key from the cache.
     */
    private void evictKey() {
        CacheNode nodeToRemove = LRUNode;
        if (LRUNode == MRUNode) {
            // Only one node in the cache
            LRUNode = MRUNode = null;
        } else {
            // More than one node in the cache
            LRUNode = LRUNode.prev;
            LRUNode.next = null;
        }
        nodeToRemove.prev = null;
        cacheMap.remove(nodeToRemove.key);
        size = size - 1;
    }

    /**
     * Moves the accessed key to the most recently used position in the cache.
     *
     * @param node The node to be moved.
     */
    private void updateCacheNode(CacheNode node) {
        if (node == MRUNode) {
            return;
        }
        if (node == LRUNode) {
            // Node is the least recently used
            LRUNode = LRUNode.prev;
            LRUNode.next = null;
        } else {
            // Node is in the middle of the cache
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = MRUNode.prev;
        node.next = MRUNode;
        MRUNode.prev = node;
        MRUNode = node;
    }
    
    /**
     * Retrieves the value associated with the given key from the cache.
     * If the key is not present in the cache, returns -1.
     *
     * @param key The key to be retrieved.
     * @return The value associated with the given key, or -1 if not found.
     */
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        updateCacheNode(cacheMap.get(key));
        return cacheMap.get(key).value;
    }
}
