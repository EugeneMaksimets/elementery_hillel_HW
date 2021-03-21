package service;

import dao.StatusDao;
import entity.Status;

public class StatusService {
    public void save(Status status) {
        StatusDao statusDao = new StatusDao();
        statusDao.save(status);
    }

    public void delete(Status status) {
        StatusDao statusDao = new StatusDao();
        statusDao.delete(status);
    }

    public void update(Status status) {
        StatusDao statusDao = new StatusDao();
        statusDao.update(status);
    }

    public Status getById(int id) {
        StatusDao statusDao = new StatusDao();
        return statusDao.getById(id);
    }
}
