package cn.ssyram.blockchain.innerlogic.support;

import java.util.HashMap;
import java.util.Map;

/**
 * 代表过程中要用到的辅助锁对象
 */
public class LockInstances {
    public static Map<String, Object> databaseLocks = new HashMap<>();
    public static Object tempblock = new Object();
    static {
        for (ChainType type:ChainType.values())
            databaseLocks.put(type.toString(), new Object());
    }
}
