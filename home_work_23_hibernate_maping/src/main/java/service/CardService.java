package service;

import dao.CardDao;
import entity.Card;

public class CardService {
    public void save(Card card) {
        CardDao cardDao = new CardDao();
        cardDao.save(card);
    }
}
