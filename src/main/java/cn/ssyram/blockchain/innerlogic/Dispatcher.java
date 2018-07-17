package cn.ssyram.blockchain.innerlogic;

import cn.enderqiu.bcinvestrebuild.util.OutBlockUtil;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.dto.LinkDTO;
import cn.ssyram.blockchain.innerlogic.dto.QueryDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.executive.CollectExecutive;
import cn.ssyram.blockchain.innerlogic.executive.LinkExecutive;
import cn.ssyram.blockchain.innerlogic.executive.QueryExecutive;
import cn.ssyram.blockchain.innerlogic.operator.BlockChainOperator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 静态的分发器
 *
 * 完成：应对外部块连接、信息收集、主链查询 三项工作的外部调用对接
 *
 * 实际功能：管理线程池，对一个调用分发线程进行功能完成。
 */
public class Dispatcher {
    /**
     * 线程池的管理Map，每种功能独立设置线程池，具体的池根据功能名称：
     * link, collect, query
     * 分别表示
     * 连接，  收集，   查询
     */
    private static Map<String, ExecutorService> poolMap = new HashMap<>();
    static{
        poolMap.put("link", Executors.newCachedThreadPool());
    }

    public static void link(LinkDTO dto){
        LinkExecutive executive = new LinkExecutive(dto);
        poolMap.get("link").execute(executive);
    }

    public static int collect(CollectDTO dto) {
        CollectExecutive executive = new CollectExecutive(dto);
        return executive.execute();
    }

    public static List<Map<String, Object>> query(QueryDTO dto) {
        QueryExecutive executive = new QueryExecutive(dto);
        return executive.execute();
    }

    public static void recallBlockInfo(Block block) {
        String targetAddress = (String) BlockChainOperator
                .getLatestReadyMainBlockInfo(block.getType())
                .get("address");
        OutBlockUtil.notifyOutBlock(targetAddress);
    }
}
