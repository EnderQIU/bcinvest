package cn.ssyram.blockchain.innerlogic.support;

import com.generator.tables.CreditChain;
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
     * 仅用于添加新块时候的查询
     *
     * 主链信息查询应该用ready_main_chain_view，即当前主链6个块之前的链
     */
    public String getMainChainViewName() {
        return toString() + "_main_chain_view";
    }

    /**
     * 这个视图用于记录基本已经不太可能改变的前6个块之前的主链的信息
     *
     * 所有基于主链的外部信息查询都应该用这个链而不是整条主链进行
     */
    public String getReadyMainChainViewName() {
        return toString() + "_ready_main_chain_view";
    }

    public String getMostFrontMainBlockInfoViewName() {
        return toString() + "_most_front_block_info";
    }
}
