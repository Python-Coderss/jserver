import java.io.*;


import jserver.Config;
import jserver.Servlet;
import jserver.main.Main;

public class Servlet4 implements Servlet {
	

	

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
			
			return url.startsWith("/static/");
			
		}
		

		@Override
		public void service(InputStream INotUsed, OutputStream o, String path, String[] headers, String ip, String body) {
			
			path = path.substring(8);
			PrintStream out = new PrintStream(o);
			
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Main.inst.installdir + "/htdocs/" + path)));
				String str = null;
				while((str = in.readLine())!= null){
			         out.println(str);
			      }
				in.close();
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public String GetName() {
			// TODO Auto-generated method stub
			return "Static";
		}

	

	public Servlet4() {
		// TODO Auto-generated constructor stub
	}

}
