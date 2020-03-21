package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {
    private int port;
    private String host;

    public RpcNetTransport(int port, String host) {
        this.port = port;
        this.host = host;
    }
    public Object send(RpcRequest request){
        Socket socket = null;
        Object result = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            // 建立连接
            socket = new Socket(host,port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            // 序列化
            outputStream.writeObject(request);
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
