package jserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServletInvoker {
	InputStream in;
	OutputStream out;
	String[] headers;
	
	void serv(Servlet servlet404, String path, String ip, InputStream i, OutputStream o, String[] arr, String body) {
		in = i;
		out = o;
		headers = arr;
		PrintWriter pout = new PrintWriter(out);
        
        
        
        pout.print("HTTP/1.1 200 OK\n");
        pout.print("Content-Type: text/html; charset=utf-8\n");
        pout.print("Date: Tue, 25 Oct 2016 08:17:59 GMT\n");
        pout.print("\n");
        pout.flush();
        //System.out.println("Sent Response path: " + path);
        
		servlet404.service(in, out, path, headers, ip, body);
	}
}
