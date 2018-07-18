package cn.ssyram.blockchain.innerlogic.entity;

import cn.ssyram.blockchain.innerlogic.operator.BlockChainOperator;
import cn.ssyram.blockchain.innerlogic.operator.Miner;
import cn.ssyram.blockchain.innerlogic.support.ChainType;
import cn.ssyram.blockchain.innerlogic.support.GlobalInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BufferBlock extends Block{
    private byte[] raw_this_hash;

    public BufferBlock(ChainType type,
                       String timeStamp,
                       String this_hash,
                       String previous_hash,
                       List<BlockData> dataList,
                       String address)
    {
        super(type, timeStamp, this_hash, previous_hash, dataList, address);
    }

    public byte[] getRaw_this_hash() {
        if (raw_this_hash == null)
            raw_this_hash = new byte[256];
        return raw_this_hash;
    }

    public void setRaw_this_hash(byte[] raw_this_hash) {
        this.raw_this_hash = raw_this_hash;
    }

    public BufferBlock(ChainType type) {
        super();
        this.type = type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public void setTimeStamp(String timeStamp) {
        this.time_stamp = timeStamp;
    }

    public void setThis_hash(String this_hash) {
        this.this_hash = this_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public void setDataList(List<BlockData> dataList) {
        this.dataList = dataList;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Block getBlock() {
//        setThis_hash(Miner.bytesToHexString(getRaw_this_hash()));
//        List<BlockData> dl = getDataList();
//        for (BlockData data:dl)
//            data.setBlock_hash(getThis_hash());
        return new Block(
                getType(),
                format.format(Calendar.getInstance().getTime()),
                getThis_hash(),
                (String) BlockChainOperator.getLatestMainBlockInfo(getType()).get("this_hash"),
                getDataList(),
                GlobalInfo.SELF_ADDRESS
        );
    }
}
