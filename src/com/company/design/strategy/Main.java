package com.company.design.strategy;

public class Main {
    public static void main(String[] args) {
        //사용하기 위한 기본 객체가 존재
        Encoder encoder = new Encoder();

        //base64 전략 생성
        EncodingStrategy base64 = new Base64Strategy();

        //normal 전략 생성
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello Java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}
