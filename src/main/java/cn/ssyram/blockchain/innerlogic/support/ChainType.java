package cn.ssyram.blockchain.innerlogic.support;

public enum ChainType {
    credit, guaranty;

    public String getChainTableName() {
        return toString() + "_chain";
    }
    public String getDataTableName() {
        return toString() + "_data";
    }
}
