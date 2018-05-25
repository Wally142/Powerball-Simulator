package com.sg.powerball.service;

import com.sg.powerball.data.LotteryDrawingDao;
import com.sg.powerball.data.LotteryPurchaseDao;
import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LotteryService {

    @Autowired
    private LotteryPurchaseDao purchase;
    
    @Autowired
    private LotteryDrawingDao drawing;
    
    
    public Purchase saveTicket(Purchase p) {
        return purchase.customerPurchase(p);
    }
    
    public Purchase findTicket(String lastname, String state){
       return purchase.findTicket(lastname, state);
    }
    
    public LottoNumber getNumbers(LocalDate drawingdate)  {
        return drawing.getNumbers(drawingdate);
    }
}
