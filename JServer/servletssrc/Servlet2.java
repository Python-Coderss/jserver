import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import jserver.Config;
import jserver.Servlet;
import jserver.main.Main;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class Servlet2 implements Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4613939274415821232L;
	private PyObject obj;
	private PythonInterpreter i;
	public Servlet2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(Config c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		i.cleanup();
		
	}

	@Override
	public boolean serv(String url) {
		return url.startsWith("/python");
	}

	@Override
	public void service(InputStream in, OutputStream o, String path, String[] headers, String ip, String body) {
		i = new PythonInterpreter();
		i.exec("x = ''\n");
		String outs = "";
		if (path.equals("/python ")) {
			i.exec("x = x + \"<html><head><title>Python Test</title></head><body><h1>Root of pyservlets</h1>Request ip: "+ ip +"</body></html>\"");
			obj = i.get("x");
			outs = (String) obj.__tojava__(String.class);
			
			PrintStream out = new PrintStream(o);
			out.println(outs);
			//System.out.println(outs);
			return;
		} else {
			String npath = path.trim();
			npath = npath.substring(7);
			//System.out.println(npath);
			String fp = Main.inst.installdir + "/pyservlets" + npath;
			BufferedReader r = null;
			try {
				r = new BufferedReader(new FileReader(fp));
			} catch (FileNotFoundException e) {
				i.exec("x = x + \"<html><head><title>404 "+npath+"</title></head><body><h1>404 "+npath+"</h1></body></html>\"");
				obj = i.get("x");
				outs = (String) obj.__tojava__(String.class);
				PrintStream out = new PrintStream(o);
				out.println(outs);
				//System.out.println(outs);
				return;
			}
			try {
				do {
					
						String l = r.readLine();
						i.exec(l);
						//System.out.println(l);
				} while (r.ready());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj = i.get("x");
			outs = (String) obj.__tojava__(String.class);
			PrintStream out = new PrintStream(o);
			out.println(outs);
			//System.out.println(outs);
			return;
		}
		
		
		

	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Python Sript Manager";
	}

}
