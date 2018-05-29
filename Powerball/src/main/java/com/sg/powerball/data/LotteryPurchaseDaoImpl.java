package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LotteryPurchaseDaoImpl implements LotteryPurchaseDao {

    @Autowired
    private JdbcTemplate jt;

    List<Purchase> oneCorrectNumber = new ArrayList<>();
    List<Purchase> twoCorrectNumber = new ArrayList<>();
    List<Purchase> threeCorrectNumber = new ArrayList<>();
    List<Purchase> fourCorrectNumber = new ArrayList<>();
    List<Purchase> fiveCorrectNumber = new ArrayList<>();
    List<Purchase> sixCorrectNumber = new ArrayList<>();

    @Override
    public List<Purchase> getWinners(LottoNumber num, LocalDate drawingdate) {

        List<Purchase> tickets = jt.query(
                "SELECT * FROM purchase;",
                new purchaseMapper());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(num.getNum1());
        numbers.add(num.getNum2());
        numbers.add(num.getNum3());
        numbers.add(num.getNum4());
        numbers.add(num.getNum5());
        numbers.add(num.getNum6());

        for (Purchase p : tickets) {
            List<Integer> ticketNumbers = new ArrayList<>();
            ticketNumbers.add(p.getNum1());
            ticketNumbers.add(p.getNum2());
            ticketNumbers.add(p.getNum3());
            ticketNumbers.add(p.getNum4());
            ticketNumbers.add(p.getNum5());
            ticketNumbers.add(p.getNum6());

            int matchingNumbers = getMatchingNumbers(ticketNumbers, numbers);
            addToWinners(matchingNumbers, p);
            System.out.println("matching numbers " + matchingNumbers);
        }
        List<Purchase> winningTickets = getWinners();
        System.out.println("winningTickets: " + winningTickets);
        System.out.println("tickets: " + tickets);
        System.out.println("one number " + oneCorrectNumber);
        System.out.println("two number " + twoCorrectNumber);
        System.out.println("three number " + threeCorrectNumber);
        return winningTickets;
    }

    private int getMatchingNumbers(List<Integer> ticketNumbers, List<Integer> powerballNumbers) {
        int matchingNumbers = 0;
        for (int num : ticketNumbers) {
            for (int powernum : powerballNumbers) {
                if (num == powernum) {
                    matchingNumbers++;
                }
            }
        }
        return matchingNumbers;
    }

    private void addToWinners(int matchingNumbers, Purchase p) {

        switch (matchingNumbers) {
            case 1:
                oneCorrectNumber.add(p);
                break;
            case 2:
                twoCorrectNumber.add(p);
                break;
            case 3:
                threeCorrectNumber.add(p);
                break;
            case 4:
                fourCorrectNumber.add(p);
                break;
            case 5:
                fiveCorrectNumber.add(p);
                break;
            case 6:
                sixCorrectNumber.add(p);
                break;
        }
    }

    private List<Purchase> getWinners() {
        
        List<Purchase> winners;
        if (sixCorrectNumber.toArray().length > 0) {
            winners = sixCorrectNumber;
            this.emptyArrays();
            return winners;
        } else if (fiveCorrectNumber.toArray().length > 0) {
            winners = fiveCorrectNumber;
            this.emptyArrays();
            return winners;
        } else if (fourCorrectNumber.toArray().length > 0) {
            winners = fiveCorrectNumber;
            this.emptyArrays();
            return winners;
        } else if (threeCorrectNumber.toArray().length > 0) {
            winners = threeCorrectNumber;
            this.emptyArrays();
            return winners;
        } else if (twoCorrectNumber.toArray().length > 0) {
            winners = twoCorrectNumber;
            this.emptyArrays();
            return winners;
        } else if (oneCorrectNumber.toArray().length > 0) {
            winners = oneCorrectNumber;
            this.emptyArrays();
            return winners;
        } else {
            return null;
        }

    }
    
     private void emptyArrays() {
        oneCorrectNumber.clear();
        twoCorrectNumber.clear();
        threeCorrectNumber.clear();
        fourCorrectNumber.clear();
        fiveCorrectNumber.clear();
        sixCorrectNumber.clear();
    }

    @Override
    public Purchase customerPurchase(Purchase purchase) {
        jt.update(
                "INSERT INTO purchase (firstname, lastname, email, state, num1, num2, num3, num4, num5, num6, quickpick) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                purchase.getFirstname(),
                purchase.getLastname(),
                purchase.getEmail(),
                purchase.getState(),
                purchase.getNum1(),
                purchase.getNum2(),
                purchase.getNum3(),
                purchase.getNum4(),
                purchase.getNum5(),
                purchase.getNum6(),
                purchase.isQuickpick()
        );

        int id = jt.queryForObject("select LAST_INSERT_ID()", Integer.class);

        purchase.setId(id);
        return purchase;
    }

    @Override
    public List<Purchase> findTicket(String lastname, String state) {
        return jt.query(
                "SELECT * FROM purchase WHERE lastname = ? AND state =?",
                new purchaseMapper(), lastname, state);
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
            p.setQuickpick(rs.getBoolean("quickpick"));
            p.setTicketstatus(rs.getBoolean("ticketstatus"));
            return p;
        }

    }

}
