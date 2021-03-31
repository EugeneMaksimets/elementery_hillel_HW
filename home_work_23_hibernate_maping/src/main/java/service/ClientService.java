package service;

import dao.ClientDao;
import entity.Client;

public class ClientService {
    public void save(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.save(client);
    }
}
