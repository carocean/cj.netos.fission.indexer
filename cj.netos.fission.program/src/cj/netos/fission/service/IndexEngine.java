package cj.netos.fission.service;

import cj.netos.fission.IIndexEngine;
import cj.netos.fission.IPersonInfoService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
/*
一次性加载并索引
其后引其变化的情况有：
- 新用户加入
- 用户改了标签（属性、及拉新条件）
- 位置（区域可能也随之变化）
- 余额改变，当由原来小于变为大于平均获客成本*2则索引，反之则移除索引
- 营业状态改变，当由停业变为营业则索引，反之则移除索引
因此，对于引起变化者是明确的，因此不需要全部重建索引，只需要重建受影响用户的索引。由于采用的是mq，所以也不需要在程序中建任务队列，本来mq就是队列

传入的用户修改前与修改后的信息，以移除先前无效的索引，比如用户修改后tag被移除，则应到相应的集合中移除它，因此必须准确传入
 */
@CjService(name = "indexEngine")
public class IndexEngine implements IIndexEngine {
    @CjServiceRef
    IPersonInfoService personInfoService;

    @Override
    public void reindex() throws CircuitException {
        personInfoService.createGeoIndex();
        personInfoService.indexAll();
    }

    @Override
    public void empty() throws CircuitException {
        personInfoService.emptyIndexAll();
    }
}
