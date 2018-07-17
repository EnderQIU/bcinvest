package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.operator.BlockOperator;
import cn.ssyram.blockchain.innerlogic.support.LockInstances;
import cn.ssyram.blockchain.innerlogic.support.Transferer;

import java.util.ArrayList;

public class CollectExecutive extends BaseService {
    private CollectDTO dto;
    public CollectExecutive(CollectDTO dto) {
        this.dto = dto;
    }

    public int execute() {
        //看看有没有对同一个id进行操作
        if (!BlockOperator.dataListVerify(dto.getType(), dto.getBlockDataList()))
            return 0;
        //暂时不用管和当前主链的关系，因为当前主链很可能变
        synchronized (LockInstances.tempblocks.get(dto.getType().toString())) {
            CurrentBlocks.getCurrentBlockFor(dto.getType())
                    .getDataList().addAll(dto.getBlockDataList());
        }
        ArrayList<BlockData> dataArrayList = new ArrayList<>(dto.getBlockDataList());
        Transferer.send(dataArrayList);
        return dto.getBlockDataList().size();
    }
}
