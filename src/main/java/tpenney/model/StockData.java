package tpenney.model;

import java.text.SimpleDateFormat;

public abstract class StockData {

    protected SimpleDateFormat simpleDateFormat;

    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public StockData(){
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

}
