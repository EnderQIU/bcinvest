package cn.ssyram.blockchain.innerlogic.entity;

import java.io.Serializable;

public class BlockData implements Serializable {
    private String block_hash;
    private String id; //这里的id指的是绑定物的id
    private String variation;
    private String value;
    private String remarks;

    public String getBlock_hash() {
        return block_hash;
    }

    public void setBlock_hash(String block_hash) {
        this.block_hash = block_hash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "block_hash: " + getBlock_hash() + ", "
                + "id: " + getId() + ", "
                + "variation: " + getVariation() + ", "
                + "value: " + getValue() + ", "
                + (getRemarks() == null ? "" : "remarks: " + getRemarks());
    }
}
