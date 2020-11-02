package tpenney.services;

public class StockServiceException extends Exception {

    public StockServiceException(String message){
        super(message);
    }

    public StockServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
