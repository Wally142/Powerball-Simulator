package com.sg.powerball.data;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface LotteryDrawingDao {
    
    public LottoNumber storeNumbers(LottoNumber num, LocalDate date);

    }
