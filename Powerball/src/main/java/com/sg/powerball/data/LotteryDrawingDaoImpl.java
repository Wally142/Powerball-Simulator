package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
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
    public LottoNumber getNumbers(LocalDate drawingdate) {
        return jt.queryForObject(
                "SELECT * FROM drawing where drawingdate = ?;",
                new NumberMapper(), drawingdate);
    }

    @Override
    public LottoNumber storeNumbers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
