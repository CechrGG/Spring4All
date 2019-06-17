/**
 * @Title: SocketTest.java
 * @Package: review.network
 * @Description: TODO
 *
 */
package review.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Leslie
 * @version 创建时间：2019年6月17日
 *
 */
public class SocketTest {
	
	public void init() {
		Server server = new Server(9999);
		server.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Client client = new Client("127.0.0.1", 9999);
		new Thread(client).start();
	}
	
	@Test
	public void socketTest() {
		new SocketTest().init();
	}
	
	private class Server extends Thread {
		private String name = "服务器";
		private int port = 9999;
		
		public Server(int port) {
			this.port = port;
		}
		
		@Override
		public void run() {
			
			try {
				ServerSocket server = new ServerSocket(port);
				System.out.println("Server " + name + " is Listening on port:" + port);
				
				Socket socket = server.accept();
				System.out.println("Connection is established!");
				
				InputStream inputStream = socket.getInputStream();
				OutputStream outStream = socket.getOutputStream();
				
				byte[] buff = new byte[1024];
				int len;
				StringBuilder strBuilder = new StringBuilder();
				while((len = inputStream.read(buff)) > 0) {
					strBuilder.append(new String(buff, 0, len, "UTF-8"));
				}
				System.out.println("Server " + name + " get a message from client: " + strBuilder);
				outStream.write("Ok! Client I get the message.".getBytes("UTF-8"));
				
				inputStream.close();
				outStream.close();
				socket.close();
				server.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private class Client implements Runnable {
		
		private String name = "客户端";
		private String host = "127.0.0.1";
		private int port = 9999;
		
		public Client(String host, int port) {
			this.host = host;
			this.port = port;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Socket socket =  new Socket(host, port);
				System.out.println("Hello! Server I'm " + name);
				OutputStream outStream = socket.getOutputStream();
				InputStream inputStream = socket.getInputStream();
//				Scanner scanner = new Scanner(System.in);
//				while(scanner.hasNextLine()) {
//					String message = scanner.nextLine();
//					if(message.equalsIgnoreCase("quit")) {
//						System.out.println("I give you some message");
//						break;
//					} else {
//						outStream.write(message.getBytes("UTF-8"));
//					}
//				}
				String message = "fjoajvajjaljff乖乖adlf";
				outStream.write(message.getBytes("UTF-8"));
				System.out.println("I give you some message: " + message);
				socket.shutdownOutput();
				
				byte[] buff = new byte[1024];
				int len;
				StringBuilder strBuilder = new StringBuilder();
				while((len = inputStream.read(buff)) > 0) {
					strBuilder.append(new String(buff, 0, len, "UTF-8"));
				}
				System.out.println("I get message from server:" + strBuilder);
				
				inputStream.close();
				outStream.close();
				socket.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
