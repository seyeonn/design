package com.company.design.aop;

import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        AtomicLong start = new AtomicLong();    //시간 체크를 위한 객체
        AtomicLong end = new AtomicLong();      //동시성 문제로 인하여 AtomicLong 사용

        IBrowser aopBrowser = new AopBrowser("www.naver.com", () -> {
            System.out.println("before");
            start.set(System.currentTimeMillis());
        }, () -> {                                  //람다식 표현
            long now = System.currentTimeMillis();
            end.set(now - start.get());
        });

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());   //cache를 활용하므로 0초가 나온다.
    }
}
