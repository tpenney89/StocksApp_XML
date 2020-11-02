package tpenney.model;

import java.math.BigDecimal;
import java.util.Date;


public class StockQuote {
    private BigDecimal price;
    private Date date;
    private String symbol;

    public StockQuote(BigDecimal price, Date date, String symbol){
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public String getSymbol() {
        return symbol;
    }

    /*@Override
    public String toString() {
        String dateString = simpleDateFormat.format(date);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }*/
}
