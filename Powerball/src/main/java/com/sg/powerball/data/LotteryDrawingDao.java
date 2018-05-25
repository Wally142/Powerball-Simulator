package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface LotteryDrawingDao {
    
    public LottoNumber getNumbers(LocalDate date);
    
    public LottoNumber storeNumbers();
    
}
