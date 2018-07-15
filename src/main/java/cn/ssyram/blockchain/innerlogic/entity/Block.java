package cn.ssyram.blockchain.innerlogic.entity;

import cn.ssyram.blockchain.innerlogic.support.ChainType;
import com.sun.istack.internal.NotNull;

import java.util.Calendar;
import java.util.List;

public class Block {
    protected ChainType type;
    //Calendar.getInstance().toString();
    protected String timeStamp;
    protected String this_hash;
    protected String previous_hash;
    protected List<BlockData> dataList;

    protected Block() {}

    public Block(@NotNull ChainType type,
                 String timeStamp,
                 @NotNull String this_hash,
                 @NotNull String previous_hash,
                 @NotNull List<BlockData> dataList)
    {
        this.type = type;
        if (timeStamp != null)
            this.timeStamp = timeStamp;
        else
            timeStamp = Calendar.getInstance().toString();
        this.this_hash = this_hash;
        this.previous_hash = previous_hash;
        this.dataList = dataList;
    }

    public ChainType getType() {
        return type;
    }

    public String getTimeStamp() {
        return timeStamp;
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
}
