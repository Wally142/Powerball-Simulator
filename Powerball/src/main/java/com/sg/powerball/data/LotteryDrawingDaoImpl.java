package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LotteryDrawingDaoImpl implements LotteryDrawingDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public LottoNumber storeNumbers(LottoNumber num, LocalDate drawingdate) {

        num.setDate(drawingdate);
        jt.update(
                "INSERT INTO drawing (num1, num2, num3, num4, num5, num6, drawingdate) VALUES (?, ?, ?, ?, ?, ?, ?);",
                num.getNum1(),
                num.getNum2(),
                num.getNum3(),
                num.getNum4(),
                num.getNum5(),
                num.getNum6(),
                num.getDate()
        );

        int id = jt.queryForObject("select LAST_INSERT_ID()", Integer.class);

        num.setId(id);
        return num;
    }

    private static final class NumberMapper implements RowMapper<LottoNumber> {

        @Override
        public LottoNumber mapRow(ResultSet rs, int i) throws SQLException {

            LottoNumber n = new LottoNumber();
            n.setId(rs.getInt("id"));
            n.setNum1(rs.getInt("num1"));
            n.setNum2(rs.getInt("num2"));
            n.setNum3(rs.getInt("num3"));
            n.setNum4(rs.getInt("num4"));
            n.setNum5(rs.getInt("num5"));
            n.setNum6(rs.getInt("num6"));
            n.setDate(rs.getDate("drawingdate").toLocalDate());
            return n;
        }
    }
}
