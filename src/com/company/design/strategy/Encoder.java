package com.company.design.strategy;

public class Encoder {

    private EncodingStrategy encodingStrategy;

    //각각의 전략에 따라서 결과가 달라질 수 있다.
    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }
    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}

