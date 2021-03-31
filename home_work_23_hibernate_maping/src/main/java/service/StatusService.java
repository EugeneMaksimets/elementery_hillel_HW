package service;

import dao.StatusDao;
import entity.Status;

public class StatusService {
    public void save(Status status) {
        StatusDao statusDao = new StatusDao();
        statusDao.save(status);
    }
}
