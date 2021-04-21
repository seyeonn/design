package com.company.design.facade;

public class Main {
    public static void main(String[] args) {

        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisConnect();
        writer.fileDisConnect();
        ftpClient.disConnect();

        System.out.println("-----------------------------");

        //앞서 코딩했던 것과 같이 각각의 객체에 의존하는 것보다 객체 하나가 생성되어 이 facade 객체를 통해 간단하게 제공한다.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }
}
