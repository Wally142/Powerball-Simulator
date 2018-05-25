package com.sg.powerball.data;

import com.sg.powerball.model.Purchase;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LotteryPurchaseDaoImpl implements LotteryPurchaseDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Purchase customerPurchase(Purchase purchase) {
        jt.update(
                "INSERT INTO purchase (firstname, lastname, email, state, num1, num2, num3, num4, num5, num6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                purchase.getFirstname(),
                purchase.getLastname(),
                purchase.getEmail(),
                purchase.getState(),
                purchase.getNum1(),
                purchase.getNum2(),
                purchase.getNum3(),
                purchase.getNum4(),
                purchase.getNum5(),
                purchase.getNum6()
        );

        int id = jt.queryForObject("select LAST_INSERT_ID()", Integer.class);

        purchase.setId(id);
        return purchase;
    }

    @Override
    public Purchase findTicket(String lastname, String state) {
        return jt.queryForObject(
                    "SELECT * FROM purchase WHERE lastname = ? AND state =?",
                    new purchaseMapper(),lastname,state);
    }
    
     private static final class purchaseMapper implements RowMapper<Purchase> {

        @Override
        public Purchase mapRow(ResultSet rs, int i) throws SQLException {
            Purchase p = new Purchase();
            p.setId(rs.getInt("id"));
            p.setFirstname(rs.getString("firstname"));
            p.setLastname(rs.getString("lastname"));
            p.setEmail(rs.getString("email"));
            p.setState(rs.getString("state"));
            p.setNum1(rs.getInt("num1"));
            p.setNum2(rs.getInt("num2"));
            p.setNum3(rs.getInt("num3"));
            p.setNum4(rs.getInt("num4"));
            p.setNum5(rs.getInt("num5"));
            p.setNum6(rs.getInt("num6"));
            return p;
        }

    }

}
