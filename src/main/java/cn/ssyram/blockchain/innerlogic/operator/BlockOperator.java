package cn.ssyram.blockchain.innerlogic.operator;

import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.util.List;

import static cn.ssyram.blockchain.innerlogic.GlobalInfo.DIFFICULTY;

public class BlockOperator {
    public static boolean hasValidThis_Hash(Block block) {
        return isValidHash(block.getThis_hash());
    }

//    /**
//     * 将一个hexString转成256位String
//     * @param hexString 64位的hash
//     * @return 目标的256位hash
//     */
//    private static String hex2Byte(String hexString) {
//        if (hexString == null || hexString.length() % 2 != 0) return null;
//
//        String bString = "", tmp;
//        for (int i = 0; i < hexString.length(); i++) {
//            tmp = "0000" + Integer
//                    .toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
//            bString += tmp.substring(tmp.length() - 4);
//        }
//        return bString;
//
//    }

    /**
     * 判断是否合法的 64位hash 串
     *
     * @return 是否合法值
     */
    private static boolean isValidHash(String hash) {
        for (int i = 0; i < DIFFICULTY; ++i)
            if (hash.charAt(i) != '0')
                return false;
        return true;
    }

    private static String beginning;

    /**
     * 表示当前难度下有效的 256位hash 的有效开头
     *
     * @return 有效开头值
     */
    private static String validBeginning() {
        if (beginning.length() != DIFFICULTY)
            beginning = new String(new char[DIFFICULTY]).replace('\0', '0');
        return beginning;
    }

    public static boolean dataListVerify(ChainType type, List<BlockData> dataList) {
        List<BlockData> kl = CurrentBlocks.getCurrentBlockFor(type).getDataList();
        for (BlockData data:dataList)
            for (BlockData kd:kl)
                if (data.getId().equals(kd.getId()))
                    return false;
        return true;
    }
}
