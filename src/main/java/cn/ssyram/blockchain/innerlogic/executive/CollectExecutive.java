package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;

public class CollectExecutive extends BaseService {
    private CollectDTO dto;
    public CollectExecutive(CollectDTO dto) {
        this.dto = dto;
    }

    public int execute() {
    }
}
