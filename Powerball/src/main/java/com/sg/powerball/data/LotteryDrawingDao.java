package com.sg.powerball.data;

import java.util.List;

public interface LotteryDrawingDao {
    
    public List<Number> getNumbers();
    
    public List<Number> storeNumbers();
    
}
