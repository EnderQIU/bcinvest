package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.entity.BufferBlock;
import cn.ssyram.blockchain.innerlogic.operator.BlockOperator;
import cn.ssyram.blockchain.innerlogic.support.LockInstances;
import cn.ssyram.blockchain.innerlogic.support.Transferer;

import java.util.ArrayList;
import java.util.List;

public class CollectExecutive {
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
//            CurrentBlocks.getCurrentBlockFor(dto.getType())
//                    .getDataList().addAll(dto.getBlockDataLst());
            //插入注意顺序，否则hash可能不同
            List<BlockData> dataList = CurrentBlocks.getCurrentBlockFor(dto.getType()).getDataList();
            for (BlockData data:dto.getBlockDataList()) {
                for (int i = 0; i < dataList.size(); ++i)
                    if (data.getId().compareTo(dataList.get(i).getId()) < 0) {
                        dataList.add(i, data);
                        break;
                    }
                dataList.add(data);
            }
        }
        Transferer.send(dto);
        return dto.getBlockDataList().size();
    }
}
