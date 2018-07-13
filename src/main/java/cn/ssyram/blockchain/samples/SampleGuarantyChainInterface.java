package cn.ssyram.blockchain.samples;

import cn.ssyram.blockchain.interfaces.GuarantyChain;

import java.util.List;
import java.util.Map;

/*说明：
 * 这是一个接口指定例子
 * 接口指定的目的是把所希望的区块链输入输出指定出来
 * 接口名称应该命名为：
 *    <随意起的名字，为了不混乱可以用自己的名字拼音或英文名><指定使用链>ChainInterface
 *    <指定使用链>：Guaranty/Credit两种之一，分别表示抵押物/信用链
 *
 * 然后需要继承相应的链——GuarantyChain或者CreditChain。
 */
public interface SampleGuarantyChainInterface extends GuarantyChain {

    //规定查询的结果一律为List<Map<String, Object>>
    //规定查询一律以query开头
    //在方法注释中声明好所需要的东西

    //规定：  增加、   删除、   更改
    //分别为 insert, delete, update 开头
    //返回值一律为int，表示受影响的结果量，一般只要检查是不是0——即没有修改任何值

    //在IDEA打/**然后换行下面的内容自动会出来
    //然后填就好
    /**
     * 描述一下这个方法
     * @param source 描述这个参数做什么
     * @param sourceInt 也描述这个参数做什么
     * @return 这里描述一下所希望的返回值是怎么样的
     */
    List<Map<String, Object>> querySample(String source, int sourceInt);

    int insertSample();

    //功能描述例子
    /**
     * 查询所需要的抵押物的状态
     * @param guarantyId 所需抵押物的id号
     * @return 一个Map
     *   "Condition": 状态
     *       状态 分为："mortgageable", "appliedButUnchecked", "mortgaging", "overdue", "null"
     *       分别表示：     可抵押，          申请未确认，          申请已确认，  过期未还款，  下链。
     */
    List<Map<String, Object>> queryGuarantyCondition(String guarantyId);
}
