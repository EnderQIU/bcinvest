package cn.ssyram.blockchain.innerlogic.entity;

import cn.ssyram.blockchain.innerlogic.support.ChainType;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Block implements Serializable {
    protected ChainType type;
    //Calendar.getInstance().toString();
    protected String time_stamp;
    protected String this_hash;
    protected String address;
    protected String previous_hash;
    protected List<BlockData> dataList;

    protected Block() {}

    public Block(@NotNull ChainType type,
                 String time_stamp,
                 @NotNull String this_hash,
                 @NotNull String previous_hash,
                 @NotNull List<BlockData> dataList)
    {
        this.type = type;
        if (time_stamp != null)
            this.time_stamp = time_stamp;
        else
            time_stamp = Calendar.getInstance().toString();
        this.this_hash = this_hash;
        this.previous_hash = previous_hash;
        this.dataList = dataList;
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
        return dataList;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(
                "block:"
        );
        builder.append("type: ").append(getType()).append(", ")
                .append("previous_hash").append(getPrevious_hash()).append(", ")
                .append("this_hash: ").append(getThis_hash()).append(", ")
                .append("time_stamp: ").append(getTime_stamp()).append(", ")
                .append("address: ").append(getAddress()).append(", ")
                .append("data: [");

        for (BlockData data:getDataList())
            builder.append("{").append(data.toString()).append("}, ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}
