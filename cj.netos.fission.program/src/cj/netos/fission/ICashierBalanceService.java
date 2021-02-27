package cj.netos.fission;

import cj.netos.fission.model.CashierBalance;

import java.util.List;

public interface ICashierBalanceService {
    /**
     * 列出正在营业且出纳台有钱的用户标识
     * @param limit
     * @param skip
     * @return
     */
    List<String> pagePersonByCashierOpening(int limit, int skip);

    CashierBalance getBalance(String unionid);

}
