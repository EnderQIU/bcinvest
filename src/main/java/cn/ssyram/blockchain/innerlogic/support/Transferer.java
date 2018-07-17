package cn.ssyram.blockchain.innerlogic.support;

import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;

import java.io.Serializable;
import java.util.ArrayList;

public class Transferer {
    public static void send(Serializable ser) {
        if (ser instanceof Block)
            blockSend(ser);
        else if (ser instanceof ArrayList)
            //内容是BlockData
            dataSend(ser);
    }

    private static void dataSend(Serializable ser) {
    }

    private static void blockSend(Serializable ser) {
    }
//    public static Serializable receive() {
//    }
}
