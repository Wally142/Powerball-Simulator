package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.time.LocalDate;
import java.util.List;

public interface LotteryPurchaseDao {

    public Purchase customerPurchase(Purchase purchase);

    public List<Purchase> findTicket(String lastname, String state);
    
    public List<Purchase> getWinners(LottoNumber num, LocalDate drawingdate);

}
