package cn.ssyram.blockchain.innerlogic.entity;

import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Block implements Serializable {
    private String toStringBuffer;
    protected ChainType type;
    //Calendar.getInstance().toString();
    protected String time_stamp;
    protected String this_hash;
    protected String address;
    protected String previous_hash;
    protected List<BlockData> dataList;
    protected long nonce;

    protected Block() {}

    public long getNonce() {
        return nonce;
    }

    /**
     * 只有確定nonce的時候才改，每次改都會清空toStringBuffer
     */
    public void setNonce(long nonce) {
        toStringBuffer = null;
        this.nonce = nonce;
    }

    public Block(ChainType type,
                 String time_stamp,
                 String this_hash,
                 String previous_hash,
                 List<BlockData> dataList,
                 String address)
    {
        this.type = type;
        if (time_stamp != null)
            this.time_stamp = time_stamp;
        else
            time_stamp = Calendar.getInstance().toString();
        this.this_hash = this_hash;
        this.previous_hash = previous_hash;
        this.dataList = dataList;
        this.address = address;
    }

    public void setThis_hash(String this_hash) {
        this.this_hash = this_hash;
    }

    public ChainType getType() {
        return type;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public String getThis_hash() {
        return this_hash;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public List<BlockData> getDataList() {
        if (dataList == null)
            dataList = new ArrayList<>();
        return dataList;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        if (toStringBuffer != null)
            return toStringBuffer;
        StringBuilder builder = new StringBuilder(
                "block:"
        );
        builder.append("type: ").append(getType()).append(", ")
                .append("previous_hash").append(getPrevious_hash()).append(", ")
                .append("time_stamp: ").append(getTime_stamp()).append(", ")
                .append("address: ").append(getAddress()).append(", ")
                .append("data: [");

        for (BlockData data:getDataList())
            builder.append("{").append(data.toString()).append("}, ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        toStringBuffer = builder.toString();
        return toStringBuffer;
    }
}
