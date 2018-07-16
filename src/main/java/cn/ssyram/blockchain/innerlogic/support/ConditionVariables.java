package cn.ssyram.blockchain.innerlogic.support;

/**
 * 全域使用的辅助状态变量
 */
public class ConditionVariables {
    public static boolean calculating = false;
    /**
     * 表征正在计算中时的linker数量
     */
    public static int linkerAmountWhenCalculating = 0;
}
