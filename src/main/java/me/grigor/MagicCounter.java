package me.grigor;

import java.util.HashMap;
import java.util.Map;

public class MagicCounter implements Counter {

    private Map<Long, Long> map = new HashMap<>();

    @Override
    public void increment() {
        Long threadId = Thread.currentThread().getId();
        if (!map.containsKey(threadId)) {
            map.put(threadId, 0L);
        }
        Long value = map.get(threadId);
        value++;
        map.put(threadId, value);
    }

    @Override
    public long getValue() {
        long quantity = 0;
        for (Map.Entry<Long, Long> pair : map.entrySet()) {
            quantity += pair.getValue();
        }
        return quantity;
    }
}
