package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.dto.QueryDTO;
import cn.ssyram.blockchain.innerlogic.support.LockInstances;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

public class QueryExecutive extends BaseService{
    QueryDTO dto;
    List<Map<String, Object>> result;
    public QueryExecutive(QueryDTO dto) {
        this.dto = dto;
    }

    public List<Map<String, Object>> execute() {
        synchronized (LockInstances.databaseLocks.get(dto.getType().toString())) {
            return mapper.SELECT(dto.getQuerySentence());
        }
    }
}
