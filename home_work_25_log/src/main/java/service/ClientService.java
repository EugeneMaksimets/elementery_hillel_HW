package service;

import dao.ClientDao;
import entity.Client;
import org.apache.log4j.Logger;


public class ClientService {
    Logger logger = Logger.getLogger(ClientService.class);
    ClientDao clientDao = new ClientDao();

    public void save(Client client) {
        logger.debug(client.toString());
        clientDao.save(client);
    }

    public void delete(Client client) {
        logger.debug(client.toString());
        clientDao.delete(client);
    }

    public void update(Client client) {
        logger.debug(client.toString());
        clientDao.update(client);
    }

    public Client getById(int id) {
        logger.debug(String.format("client.getById {id = %d}", id));
        return clientDao.getById(id);
    }

    public Client getByPhone(long phone) {
        logger.debug(String.format("client.getByPhone {phone = %d}", phone));
        return clientDao.getByPhone(phone);
    }
}
