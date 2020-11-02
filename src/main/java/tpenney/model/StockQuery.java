package tpenney.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import javax.validation.constraints.NotNull;

import java.text.ParseException;
import java.util.Calendar;

@Immutable
public class StockQuery extends StockData {
    private final String symbol;
    private final Calendar from;
    private final Calendar until;

    public StockQuery(@NotNull String symbol, @NotNull String from, @NotNull String until) throws ParseException {
        super();
        this.symbol = symbol;
        this.from = Calendar.getInstance();
        this.until = Calendar.getInstance();
        this.from.setTime(simpleDateFormat.parse(from));
        this.until.setTime(simpleDateFormat.parse(until));
    }

    public String getSymbol(){
        return symbol;
    }

    public Calendar getFrom() {
        return from;
    }

    public Calendar getUntil() {
        return until;
    }
}
