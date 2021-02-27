package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.mapper.CashierMapper;
import cj.netos.fission.model.Cashier;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.math.BigDecimal;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierService")
public class CashierService implements ICashierService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.CashierMapper")
    CashierMapper cashierMapper;

    @CjTransaction
    @Override
    public Cashier getCashier(String unionid) {
        Cashier cashier = cashierMapper.selectByPrimaryKey(unionid);
        if (cashier == null) {
            cashier = new Cashier();
            cashier.setPerson(unionid);
            cashier.setDayAmount(0L);
            cashier.setState(0);
            cashier.setType(0);
            cashier.setCacAverage(30L);
            cashier.setAmplitudeFactor(new BigDecimal("1.6"));
            cashier.setClosedCause(null);
            cashierMapper.insert(cashier);
        }
        return cashier;
    }
}
