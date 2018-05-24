package com.sg.powerball.data;

import com.sg.powerball.model.Purchase;

public interface LotteryPurchaseDao {
    
    public Purchase customerPurchase(Purchase purchase);
    
    public Purchase findPurchaseById (int id);
    
    public Purchase findPurchaseByLastName (String name);
    
}
