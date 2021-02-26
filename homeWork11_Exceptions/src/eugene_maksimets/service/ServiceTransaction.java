package eugene_maksimets.service;

import eugene_maksimets.entity.Client;
import eugene_maksimets.util.Helper;

public class ServiceTransaction {
    public static void transaction(Client client, String id) {
        String getId = client.getId();
        Helper.checkTransaction(getId, id);
    }
}
