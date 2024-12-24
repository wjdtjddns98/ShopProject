package org.example.shop.exeption;


public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message) {
        super(message);
    }

}