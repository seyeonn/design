package com.company.design.facade;

public class SftpClient {

    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    //객체를 한 번 감싸므로서 의존성을 sftpClient가 다 가져간다.
    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    //이 4가지 값만 받아도 객체를 이용할 수 있도록 오버로을 시켜 주었다.
    public SftpClient(String host, int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    //새로운 인터페이스 제공
    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect() {
        writer.fileDisConnect();
        reader.fileDisConnect();
        ftp.disConnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}
