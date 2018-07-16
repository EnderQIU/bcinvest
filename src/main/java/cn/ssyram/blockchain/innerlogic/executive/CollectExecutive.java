package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;

import cn.ssyram.blockchain.innerlogic.support.LockInstances;

public class CollectExecutive extends BaseService {
    private CollectDTO dto;
    public CollectExecutive(CollectDTO dto) {
        this.dto = dto;
    }

    public int execute() {
        synchronized (LockInstances.tempblocks.get(dto.getType().toString())) {
        }
        return 0;
    }
}
