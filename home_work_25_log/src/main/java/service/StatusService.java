package service;

import dao.StatusDao;
import entity.Status;
import org.apache.log4j.Logger;

public class StatusService {
    Logger logger = Logger.getLogger(StatusService.class);
    StatusDao statusDao = new StatusDao();

    public void save(Status status) {
        logger.debug(status.toString());
        statusDao.save(status);
    }

    public void delete(Status status) {
        logger.debug(status.toString());
        statusDao.delete(status);
    }

    public void update(Status status) {
        logger.debug(status.toString());
        statusDao.update(status);
    }

    public Status getById(int id) {
        logger.debug(String.format("status.getByID {id = %d}", id));
        return statusDao.getById(id);
    }
}
