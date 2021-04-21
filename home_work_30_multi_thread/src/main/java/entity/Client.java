package entity;

public class Client {
    private Card card;

    public synchronized String getClient() {
        return "Eugene";
    }

    public synchronized String getCard() {
        return card.getNumber();
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

