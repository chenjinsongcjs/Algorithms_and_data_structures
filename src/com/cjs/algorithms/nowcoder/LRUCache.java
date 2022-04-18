package com.cjs.algorithms.nowcoder;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 使用LinkedHashMap实现 最近最少使用缓存
 */
public class LRUCache<K,V> implements Iterable<K>{
    private int size;//缓存的大小
    //记录
    private LinkedHashMap<K,V> cache;
    public LRUCache(int size){
        cache = new LinkedHashMap<>(size);
        this.size = size;
    }
    //获取缓存数据
    public V get(K key){
        if (!cache.containsKey(key))
            return null;
        V ret = cache.get(key);
        //更新缓存位置
        cache.remove(key);
        cache.put(key,ret);
        return ret;
    }
    //添加缓存数据
    public void add(K key,V value){
        //存在缓存，更新数据和位置
        if (cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
            return;
        }
        //缓存满
        if (cache.size() == size){
            Iterator<Map.Entry<K, V>> iterator =
                    cache.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.add("1","A");
        cache.add("2","B");
        cache.add("3","C");
        cache.get("1");
        cache.add("4","D");
        cache.add("5","E");

        for (String s : cache) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<Map.Entry<K, V>> iterator = cache.entrySet().iterator();
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public K next() {
                return iterator.next().getKey();
            }
        };
    }
}
