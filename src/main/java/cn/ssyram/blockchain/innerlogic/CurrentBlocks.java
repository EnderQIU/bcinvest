package cn.ssyram.blockchain.innerlogic;

import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BufferBlock;
import cn.ssyram.blockchain.innerlogic.support.ChainType;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * 代表当前正在用的缓存区块
 */
public class CurrentBlocks {
    private static Map<String, BufferBlock> blocksMap = new HashMap<>();
    static {
        for (ChainType type:ChainType.values())
            blocksMap.put(type.toString(), new BufferBlock(type));
    }

    /**
     * 替换当前的缓冲区块
     * @param type 缓冲区块类型
     * @return 之前的缓冲区块
     */
    public static BufferBlock replaceCurrentBlockFor(@NotNull ChainType type) {
        return blocksMap.replace(type.toString(), new BufferBlock(type));
    }

    /**
     * 获得当前的缓冲区块
     * @param type 目标缓冲区块所属的类型
     * @return 目标缓冲区块
     */
    public static BufferBlock getCurrentBlockFor(@NotNull ChainType type) {
        return blocksMap.get(type.toString());
    }
}
