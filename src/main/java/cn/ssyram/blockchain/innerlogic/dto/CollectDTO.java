package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 本质上是一个带上type用于寻找合适区块的BlockData
 */
public class CollectDTO implements Serializable {
    private String address;
    private ChainType type;
    private ArrayList<BlockData> blockDataList;

    public CollectDTO() {}

    /**
     * 放入一条信息生成一个只含有一条信息的信息盒包装
     */
    public CollectDTO(ChainType type, BlockData data) {
        this.type = type;
        blockDataList = new ArrayList<>(1);
        blockDataList.add(data);
    }

    public ChainType getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public ArrayList<BlockData> getBlockDataList() {
        return blockDataList;
    }

    public void setBlockDataList(ArrayList<BlockData> blockDataList) {
        this.blockDataList = blockDataList;
    }
}
