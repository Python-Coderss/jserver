import java.io.*;


import jserver.Config;
import jserver.Servlet;
import jserver.main.Main;

public class Servlet6 implements Servlet {
	

	
		String filename;
		/**
		 * 
		 */
		private static final long serialVersionUID = -4655131077907368936L;
		@Override
		public void init(Config c) {
			c.getServerVersion();
			c.servletSpec();
			//System.out.println("ServletInit");
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean serv(String url) {
			// TODO Auto-generated method stub
			
			return url.trim().startsWith("/upload?");
			
		}
		

		@Override
		public void service(InputStream INotUsed, OutputStream o, String path, String[] headers, String ip, String body) {
			PrintStream out = new PrintStream(o);
			if (body.length() != 0 )try {
			String bound = null;
			
			for (String header : headers) {
				
				int ind = header.indexOf("boundary=");
				
				if (ind != -1) {
					ind +="boundary=".length();
					bound = header.substring(ind);
				}
			}
			
			String[] Parts = body.split(bound);
			Parts[Parts.length - 1] = (Parts[Parts.length - 1]).split(bound, 0)[0];
			String temp = "";
			for (String part : Parts) {
				temp += part;
			}
			Parts = temp.split("--");
			for (String part : Parts) {
				////System.out.println("Part:" + part);
			}
			String[] parts = {Parts[1], Parts[2]};
			
			String fileContent = parts[0].split("\r\n", 5)[4];
			String filePath = parts[1].split("\r\n\r\n")[1].trim();
			////System.out.println("Path:" + filePath);
			////System.out.println("Content:" + fileContent);
			FileOutputStream foe = new  FileOutputStream(Main.inst.installdir + "/htdocs" + filePath);
			PrintStream fout = new PrintStream(foe);
			fout.print(fileContent);
			
			
			fout.close();
			String uri = "http://10.0.0.142:9000/static" + filePath;
			out.println("Now Availible at: <a href=\"" + uri + "\">" + uri + "</a>");
			//System.out.println("done");
			} catch (Throwable e) {
				e.printStackTrace();
				Main.inst.stop();
			}
		}

		@Override
		public String GetName() {
			// TODO Auto-generated method stub
			return "Upload handler";
		}

	

	public Servlet6() {
		// TODO Auto-generated constructor stub
	}

}
