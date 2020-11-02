package tpenney.services;

import tpenney.model.StockQuote;
import tpenney.util.Interval;

import java.util.Calendar;
import java.util.List;

public interface StockService {
    StockQuote getQuote(String symbol) throws StockServiceException;

    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException;

}
