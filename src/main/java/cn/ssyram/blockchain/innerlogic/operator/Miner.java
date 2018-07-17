package cn.ssyram.blockchain.innerlogic.operator;

import cn.ssyram.blockchain.innerlogic.entity.BufferBlock;
import cn.ssyram.blockchain.innerlogic.support.GlobalInfo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Miner {
    /**
     * 加密需要的字符串
     *
     * @param s 需要被加密的字符串
     * @return 一个加密后的256位byte[]数组
     */
    public static byte[] encode(String s) {
        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(s.getBytes("UTF-8"));
            return digest.digest();
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

            stringBuilder.append(i + ":");

            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv + ";");
        }
        return stringBuilder.toString();
    }

    private int nonce = 0;

    public void getNewThis_Hash(BufferBlock block) {
        if (block.getRaw_this_hash() != null)
            block.setRaw_this_hash(encode(
                    (++nonce) + bytesToHexString(block.getRaw_this_hash())
            ));
        else
            //生成第一个raw_hash
            block.setRaw_this_hash(encode(
                    (++nonce) + block.toString()
            ));
    }

    public boolean hasValidThis_Hash(BufferBlock block) {
        for (int i = 0; i < GlobalInfo.DIFFICULTY; ++i)
            if (block.getRaw_this_hash()[i] != 0)
                return false;
        return true;
    }

    public void turnBlockReadyToSend(BufferBlock block) {
        block.setThis_hash(bytesToHexString(block.getRaw_this_hash()));
        block.setRaw_this_hash(null);
    }
}
