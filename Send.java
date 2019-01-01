
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * 发送端
 * 从控制台获取消息
 * 释放资源
 * 重写Run
 * 
 * */


public class Send implements Runnable{
	
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	
	public Send(Socket client,String name) {
		this.client = client;
		console = new BufferedReader(new InputStreamReader(System.in));
		this.isRunning = true;
		this.name = name;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			//发送名称
			send(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.release();
		}
	}
	
	//从控制台获取消息
	private String getStrFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	//发送消息
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("---client------");
			release();
		}
	}
	
	//释放资源
	private void release() {
		this.isRunning = false;
		ChatUtils.close(dos,client);
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg = getStrFromConsole();
			if(!msg.equals("")) {
				send(msg);
			}
		}
	}
		
}
	
