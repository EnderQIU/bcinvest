package cn.ssyram.blockchain.innerlogic.operator;

import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.entity.BufferBlock;
import cn.ssyram.blockchain.innerlogic.support.GlobalInfo;
import cn.ssyram.blockchain.innerlogic.test.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Miner {
    /**
     * 加密需要的字符串
     *
     * @param s 需要被加密的字符串
     * @return 一个加密后的256位byte[]数组
     */
    public static String encode(String s) {
        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(s.getBytes("UTF-8"));
            return bytesToHexString(digest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);

            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private long nonce = 0;

    public static String getRealThis_Hash(Block block) {
        return encode(block.getNonce() + block.toString());
    }

    public void getNewThis_Hash(Block block) {
            block.setThis_hash(encode(
                    (++nonce) + block.toString()
            ));
    }

    public boolean hasValidThis_Hash(Block block) {
//        List l = DatabaseOperator.SELECT(
//                "SELECT * FROM " + block.getType().getChainTableName()
//                + " WHERE this_hash = '" + block.getThis_hash()
//                + "'"
//        );
//        if (l.size() != 0)
//            return false;
        if (BlockOperator.hasValidThis_Hash(block)) {
            Logger.log("chain of type " + block.getType() + "get potential block, for " + nonce + " calculating times.");
            block.setNonce(nonce);
            return true;
        }
        return false;
//        for (int i = 0; i < GlobalInfo.DIFFICULTY; ++i)
//            if (block.getRaw_this_hash()[i] != 0)
//                return false;
//        return true;
    }

    public void turnBlockReadyToSend(BufferBlock block) {
        block.setThis_hash(bytesToHexString(block.getRaw_this_hash()));
        block.setRaw_this_hash(null);
    }
}
