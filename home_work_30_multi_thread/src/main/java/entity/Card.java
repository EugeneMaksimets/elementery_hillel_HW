package entity;

public class Card {
    private Client client;

    public synchronized String getNumber() {
        return "100010001";
    }

    public synchronized String getClient() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return client.getClient();
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

