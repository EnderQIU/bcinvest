package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;

import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.LockInstances;

import java.util.List;

public class CollectExecutive extends BaseService {
    private CollectDTO dto;
    public CollectExecutive(CollectDTO dto) {
        this.dto = dto;
    }

    public int execute() {
        synchronized (LockInstances.tempblocks.get(dto.getType().toString())) {
            CurrentBlocks.getCurrentBlockFor(dto.getType())
                    .getDataList().addAll(dto.getBlockDataList());

         return dto.getBlockDataList().size();
        }
    }
}
