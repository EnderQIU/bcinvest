package cn.ssyram.blockchain.innerlogic.executive;

import cn.ssyram.blockchain.innerlogic.dto.QueryDTO;
import cn.ssyram.blockchain.innerlogic.DatabaseOperator;
import cn.ssyram.blockchain.innerlogic.support.LockInstances;

import java.util.List;
import java.util.Map;

public class QueryExecutive {
    QueryDTO dto;
    List<Map<String, Object>> result;
    public QueryExecutive(QueryDTO dto) {
        this.dto = dto;
    }

    public List<Map<String, Object>> execute() {
        synchronized (LockInstances.databaseLocks.get(dto.getType().toString())) {
            return DatabaseOperator.SELECT(dto.getQuerySentence());
        }
    }
}
