package cn.ssyram.blockchain.innerlogic.support;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class Semaphores {
    public static Semaphore blockchain = new Semaphore(1);
}
