package cn.ssyram.blockchain.interfaces;

import java.util.List;
import java.util.Map;

interface BlockChain {

    List<Map<String, Object>> query(String id);
}
