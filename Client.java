
/*
* 使用多线程
* 在线聊天室 客户端 一个客户可以正常收发多条信息
*
*/
import java.io.*;
import java.net.*;
import java.net.UnknownHostException;



public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("-----Client-----");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name = br.readLine();
        //1.建立连接，使用Socket创建客户端+服务的地址和端口
        System.out.print("输入服务器的地址:>");
        String host = br.readLine();            //输入服务器地址
        System.out.print("输入服务器的端口:>");
        String Port = br.readLine();            //输入服务器端口
        int port = Integer.parseInt(Port);          
        Socket client = new Socket(host,port);
        System.out.println("登陆成功，服务器为:"+host+"；端口为:"+port);
        //2.客户端发送消息
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();
    }
}