package cn.ssyram.blockchain.innerlogic.support;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * 代表过程中要用到的辅助锁对象
 */
public class LockInstances {
    /**
     * database锁
     * 根据不同类型的名字字符串进行区分
     */
    public final static Map<String, Object> databaseLocks = new HashMap<>();
    /**
     * tempblock锁
     * 根据不同类型的名字字符串进行区分
     */
    public final static Map<String, Object> tempblocks = new HashMap<>();
    static {
        for (ChainType type:ChainType.values()){
            databaseLocks.put(type.toString(), new Object());
            tempblocks.put(type.toString(), new Object());
        }
    }
}
