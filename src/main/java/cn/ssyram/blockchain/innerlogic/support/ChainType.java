package cn.ssyram.blockchain.innerlogic.support;

import com.bcgenerator.tables.CreditChain;
import com.generator.Tables;

import java.io.Serializable;

public enum ChainType implements Serializable {
    credit, guaranty;

    public String getChainTableName() {
        return toString() + "_chain";
    }
    public String getDataTableName() {
        return toString() + "_data";
    }

    /**
     * 这个视图记录的是当前主链的所有有用信息
     */
    public String getMainChainViewName() {
        return toString() + "_main_chain_view";
    }

    public String getMostFrontMainBlockInfoViewName() {
        return toString() + "_most_front_block_info";
    }
}
