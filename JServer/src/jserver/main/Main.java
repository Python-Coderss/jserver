package jserver.main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;
import jserver.Server;
import jserver.Servlet404;
import jserver.rescources.Igen;
public class Main {
	private  String pathpp;
    public int sc = 0;
    public static Main inst;
    int sc2 = 0;
    // ImageProvider provider;
     Servlet404 servlet404;
    
	 Igen applet;
	public  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public  String installdir = "";
	private  Server s;
	private boolean flag;

	
	
	
	public void stop() {
		flag = false;
	}
	public void main() {
		flag = true;
		//provider = new GenericImageProvider();
	    
	    
	    
	    
	    
//		System.out.println("Install dir: ");
//		installdir = in.readLine();
        installdir = "C:\\xampp\\tomcat\\webapps\\java\\JServer";
		servlet404 = new Servlet404();
		//System.setOut(temp);
		//System.setErr(temp);
		
		//System.setOut(reftotemp.thisobj.thisobj.obj);
		//System.setErr(reftotemp.thisobj.obj);
		applet = new Igen();
		applet.init();
		applet.start();
		
		
		
		
		
		
		
		
        ServerSocket server = null;
		try {
			server = new ServerSocket(9000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Listening for connection on port 9000 ....");
        s = Server.NewServer();
        s.dir = installdir;
        s.fs = System.getProperty("file.separator");
        //All this stuff with arrays is for performance only
        RequestHandler handler = new RequestHandler(server, s);
        Thread t = new Thread(handler);
        
        t.start();
        String str = "";
        while (flag);
		handler.run = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        applet.stop();
        applet.destroy();
	}
	public static void main(String[] args) {
		
        inst = new Main();
        inst.main();
			
    }
    
	 private class RequestHandler implements Runnable {
    	Server s;
		ServerSocket server;
		boolean run = true;
		RequestHandler(ServerSocket ss, Server s) {
    		server = ss;
    		this.s = s;
    	}

		@Override
		public void run() {
			while (run) {
			
			try {
				Socket req = server.accept();
				Thread t = new Thread(() -> {
					try {
						serv(s, req);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
			}
			
		}
		
		
    }
	
    private  void serv(Server s, Socket clientSocket) throws IOException {
    	
        
        InputStream in = clientSocket.getInputStream();
		InputStreamReader isr 
      =  new InputStreamReader(in );
        BufferedReader reader = new BufferedReader(isr);
        String path = null;
        ArrayList<String> arr = new ArrayList<String>();
        //code to read and print headers
        String headerLine = reader.readLine();
        arr.add(headerLine);
        String line = headerLine;
        
            while (headerLine == null ||(headerLine.length() != 0)){
                //System.out.println(headerLine);
                arr.add(headerLine);
                headerLine = reader.readLine();
            }
        String[] ar = new String[arr.size()];
        ar = arr.toArray(ar);
        //code to read the post payload data
        StringBuilder payload = new StringBuilder();
                while(reader.ready()){
                    payload.append((char) reader.read());
                    }
        //System.out.println("Payload data is: "+payload.toString());
        
        int pathlen = line.length() - 12;
		char[] arrr = new char[pathlen];
		line.getChars(4, pathlen + 4, arrr, 0);
		String rt = line.substring(0, 4);
		path = new String(arrr);

		//System.out.println("Request type: " + rt);
		//System.out.println("Path: " + path);
		pathpp = path;
        
        OutputStream out = clientSocket.getOutputStream();
        //System.out.println(pathpp);
        //System.out.println("Start");
        if (pathpp.equals("/favicon.ico "))
        {
        	
        	PrintStream pout = new PrintStream(out);
            
        	pout.print("HTTP/1.1 200 OK\n");
            pout.print("Content-Type: image/png; charset=utf-8\n");
            pout.print("Date: Tue, 25 Oct 2016 08:17:59 GMT\n");
            pout.print("\n");
        	try {
        		int r = Igen.ra.nextInt(10);
        		int width = 250 + r;
                int height = 250 + r;
                
                //System.out.println("Serving Favicon.ico width: " + width + " height: " + height);
                // Constructs a BufferedImage of one of the predefined image types.
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         
                // Create a graphics which can be used to draw into the buffered image
                Graphics2D g2d = bufferedImage.createGraphics();
         
                
        		
        		applet.setSize(width, height);
        		applet.paint(g2d, Igen.ra.nextInt(Igen.modeCount));
                
         
                // Disposes of this graphics context and releases any system resources that it is using. 
                g2d.dispose();
         
                // Save as PNG
                
                ImageIO.write(bufferedImage, "png", pout);
                
        	} catch (Throwable t) {
        		t.printStackTrace(System.out);
        		StackTraceElement[] stack = t.getCause().getStackTrace();
        		Throwable e = t.getCause();
				System.out.println(e);
				for (StackTraceElement el : stack) {
					System.out.println(el);
				}
				
        	}
            
            
            
        } else if (pathpp.contains("favicon.ico")) {
        	
        	PrintStream pout = new PrintStream(out);
            
        	pout.print("HTTP/1.1 200 OK\n");
            pout.print("Content-Type: image/png; charset=utf-8\n");
            pout.print("Date: Tue, 25 Oct 2016 08:17:59 GMT\n");
            pout.print("\n");
        	try {
        		String[] a = pathpp.substring(1, pathpp.length() - 1).split(",");
        		int width = Integer.parseInt(a[1]);
                int height = Integer.parseInt(a[2]);
                
                //print.println("Serving Favicon.ico width: " + width + " height: " + height);
                // Constructs a BufferedImage of one of the predefined image types.
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         
                // Create a graphics which can be used to draw into the buffered image
                Graphics2D g2d = bufferedImage.createGraphics();
         
                
        		FileOutputStream o = new  FileOutputStream(new File(s.dir  + s.fs + "img" + s.fs +  pathpp.substring(0, pathpp.length() - 1) + ".png"));
        		applet.setSize(width, height);
        		applet.paint(g2d, Integer.parseInt(a[3]));
                
         
                // Disposes of this graphics context and releases any system resources that it is using. 
                g2d.dispose();
         
                // Save as PNG
                
                ImageIO.write(bufferedImage, "png", pout);
                ImageIO.write(bufferedImage, "png", o);
                o.close();
                
        	} catch (Throwable t) {
        		t.printStackTrace(System.out);
        		StackTraceElement[] stack = t.getCause().getStackTrace();
        		Throwable e = t.getCause();
				System.out.println(e);
				for (StackTraceElement el : stack) {
					System.out.println(el);
				}
				
        	}
        } else {
		s.serv(servlet404, pathpp, clientSocket.getInetAddress().toString(), in, out, ar, payload.toString());
		}
		in.close();
		out.close();
		clientSocket.close();
		sc2 = sc2 + 1;
		sc = sc2 / 2;
		
    }

	
}