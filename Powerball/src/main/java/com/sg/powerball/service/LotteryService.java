package com.sg.powerball.service;

import com.sg.powerball.data.LotteryDrawingDao;
import com.sg.powerball.data.LotteryPurchaseDao;
import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LotteryService {

    Random rdm = new Random();

    @Autowired
    private LotteryPurchaseDao purchase;

    @Autowired
    private LotteryDrawingDao drawing;

    public Purchase saveTicket(Purchase p) {

       return purchase.customerPurchase(p);
    }

    public List<Purchase> findTicket(String lastname, String state) {
        return purchase.findTicket(lastname, state);
    }
    
    public List<Purchase> findWinners(LottoNumber num, LocalDate drawingdate) {
        return purchase.getWinners(num, drawingdate);
    }

    public LottoNumber storeNumbers(LottoNumber num, LocalDate drawingdate) {
        return drawing.storeNumbers(num, drawingdate);
    }

    public LottoNumber generateNumbers() {
        LottoNumber quickNum = new LottoNumber();

        int num6 = rdm.nextInt(26) + 1;
        final int[] randomNums = new Random().ints(1, 69).distinct().limit(6).toArray();// found these array methods to get numbers unique

        for (int i = 0; i < randomNums.length; i++) {

            quickNum.setNum1(randomNums[0]);
            quickNum.setNum2(randomNums[1]);
            quickNum.setNum3(randomNums[2]);
            quickNum.setNum4(randomNums[3]);
            quickNum.setNum5(randomNums[4]);
        }

        quickNum.setNum6(num6);

        return quickNum;
    }
}
