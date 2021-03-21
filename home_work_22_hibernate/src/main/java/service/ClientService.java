package service;

import dao.ClientDao;
import entity.Client;

import java.util.List;

public class ClientService {
    public void save(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.save(client);
    }

    public void delete(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.delete(client);
    }

    public void update(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.update(client);
    }

    public Client getById(int id) {
        ClientDao clientDao = new ClientDao();
        return clientDao.getById(id);
    }

    public Client getByPhone(long phone) {
        ClientDao clientDao = new ClientDao();
        return clientDao.getByPhone(phone);
    }
}
