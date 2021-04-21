package com.company.design.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;   // 싱글톤은 자기 자신을 객체로 가지고 있어야 한다.

    private SocketClient() {             // 기본 생성자를 통해서 객체 생성될 수 없도록 기본 생성자를 private으로 막아야 한다.

    }

    public static SocketClient getInstance() {    //static을 통해서 getInstance()메소드 제공해야 한다. static 메소드 이기 때문에 어떤 외부에서도 바로 이 메소드에 접근이 가능하다.
        if(socketClient == null) {           //현재 가지고 있는 객체가 null인지 아닌지 체크
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
