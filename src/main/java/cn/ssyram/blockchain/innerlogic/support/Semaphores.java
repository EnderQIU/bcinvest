package cn.ssyram.blockchain.innerlogic.support;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class Semaphores {
    public static Map<ChainType, Semaphore> blockchains = new HashMap<>();
    static {
        for (ChainType type:ChainType.values())
            blockchains.put(type, new Semaphore(1));
    }
}
