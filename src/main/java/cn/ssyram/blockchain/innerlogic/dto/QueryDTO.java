package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.io.Serializable;

public class QueryDTO implements Serializable {
//    //表名
//    private ChainType type;
//    /**
//     * 需要的列名的字符串
//     * 可以表示多个列，用于填充到SELECT子句
//     * 例如：
//     * "*"
//     * "column1, column2"
//     */
//    private String queryColumn;
//    /**
//     * WHERE子句的内容
//     */
//    private String queryCondition;

    private ChainType type;

    private String querySentence;

    public ChainType getType() {
        return type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public QueryDTO(String querySentence) {
        this.querySentence = querySentence;
    }

    public String getQuerySentence() {
        return querySentence;
    }
}
