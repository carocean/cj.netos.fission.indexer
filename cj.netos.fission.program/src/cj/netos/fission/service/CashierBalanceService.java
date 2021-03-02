package cj.netos.fission.service;

import cj.netos.fission.ICashierBalanceService;
import cj.netos.fission.mapper.CashierBalanceMapper;
import cj.netos.fission.model.CashierBalance;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierBalanceService")
public class CashierBalanceService implements ICashierBalanceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.CashierBalanceMapper")
    CashierBalanceMapper cashierBalanceMapper;
    @CjTransaction
    @Override
    public List<String> pagePersonByCashierOpening(int limit, int skip) {
        List<CashierBalance> balances=cashierBalanceMapper.page(0,limit,skip);
        List<String> list = new ArrayList<>();
        for (CashierBalance balance : balances) {
            list.add(balance.getPerson());
        }
        return list;
    }
    @CjTransaction
    @Override
    public CashierBalance getBalance(String unionid) {
        CashierBalance balance= cashierBalanceMapper.selectByPrimaryKey(unionid);
        if (balance == null) {
            balance=new  CashierBalance();
            balance.setPerson(unionid);
            balance.setBalance(0L);
        }
        return balance;
    }
}
