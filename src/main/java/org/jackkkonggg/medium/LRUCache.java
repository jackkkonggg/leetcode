package org.jackkkonggg.medium;

import java.util.ArrayDeque;
import java.util.HashMap;

public class LRUCache {
  private final int CACHE_SIZE;
  private final ArrayDeque<Integer> dq;
  private final HashMap<Integer, Integer> hashMap;

  public LRUCache(int capacity) {
    dq = new ArrayDeque<>();
    hashMap = new HashMap<>();
    CACHE_SIZE = capacity;
  }

  public int get(int key) {
    if (hashMap.containsKey(key)) {
      dq.remove(key);
      dq.push(key);
      return hashMap.get(key);
    }

    return -1;
  }

  public void put(int key, int value) {
    // New key not in cache, evict least recently used
    if (!hashMap.containsKey(key)) {
      if (hashMap.size() == CACHE_SIZE) {
        int last = dq.removeLast();
        hashMap.remove(last);
      }
    } else {
      dq.remove(key);
    }

    dq.push(key);
    hashMap.put(key, value);
  }
}
