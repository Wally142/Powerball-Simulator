package com.sg.powerball.data;

import com.sg.powerball.model.Purchase;

public interface LotteryPurchaseDao {

    public Purchase customerPurchase(Purchase purchase);

    public Purchase findTicket(String lastname, String state);

}
