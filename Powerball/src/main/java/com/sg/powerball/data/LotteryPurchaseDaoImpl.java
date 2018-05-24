
package com.sg.powerball.data;

import com.sg.powerball.model.Purchase;
import org.springframework.stereotype.Component;


@Component
public class LotteryPurchaseDaoImpl implements LotteryPurchaseDao {

    @Override
    public Purchase customerPurchase(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase findPurchaseById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase findPurchaseByLastName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
