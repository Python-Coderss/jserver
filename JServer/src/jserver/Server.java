package jserver;

import java.io.InputStream;
import java.io.OutputStream;

public class Server {
	
	
	
	public String dir;
	public String fs;

	private Server() {
		
		
		
	}
	public static Server NewServer() {
		Server self = new Server();
		
		return self.init();
	}
	private Server init() {
		
		return this;
		
	}
	public void serv(Servlet servlet404, String path, String ip, InputStream i, OutputStream o, String[] arr, String body) {
		ConnectionHandler g = new ConnectionHandler(path, ip, i, o, arr, body);
		g.run(servlet404);
	}
	class ConnectionHandler {
		InputStream in;
		OutputStream out;
		String path;
		String[] headers;
		private String ip;
		private String body;
		public ConnectionHandler(String pa, String ip, InputStream in, OutputStream out, String[] arr, String body) {
			//System.out.println("New ConHan");
			this.out = out;
			this.in = in;
			path = pa;
			headers = arr;
			this.ip = ip;
			this.body = body;
		}
		public void run(Servlet servlet404) {
			ServletInvoker serv = null;
			serv = new ServletInvoker();
			//System.out.println("Run Servlet S");
			if (servlet404.serv(path))
			serv.serv(servlet404, path, ip, in, out, headers, body);
			
			
		}
		
	}
}
