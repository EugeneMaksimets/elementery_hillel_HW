package service;

import dao.AccountDao;
import entity.Account;
import org.apache.log4j.Logger;

public class AccountService {
    Logger logger = Logger.getLogger(AccountService.class);
    AccountDao accountDao = new AccountDao();

    public void save(Account account) {
        logger.debug(account.toString());
        accountDao.save(account);
    }

    public void delete(Account account) {
        logger.debug(account.toString());
        accountDao.delete(account);
    }

    public void update(Account account) {
        logger.debug(account.toString());
        accountDao.update(account);
    }

    public Account getById(int id) {
        logger.debug(String.format("account.getById {id = %d}", id));
        return accountDao.getById(id);
    }
}
