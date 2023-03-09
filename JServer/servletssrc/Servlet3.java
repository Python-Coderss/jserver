
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.fazecast.jSerialComm.*;


import jserver.Config;
import jserver.Servlet;

public class Servlet3 implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4655131077907368936L;
	private String version;
	private double servletSpec;

	

	@Override
	public void init(Config c) {
		version = c.getServerVersion();
		servletSpec = c.servletSpec();
		//System.out.println("ServletInit");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean serv(String url) {
		// TODO Auto-generated method stub
		//System.out.println("resv3: " + url);
		int itemp = url.compareTo("/set ");
		//System.out.println("Itemp3: " +itemp);
		
		boolean temp = itemp  == 0;
		//System.out.println("Returning3: " + temp);
		return temp;
		
	}
	public String t(String n, String b) {
    	String r = "";
    	r += s(n);
    	r += o(b);
    	r += s("/" + n);
    	return r;
    }
	public String t(String n, String b, String attr) {
    	String r = "";
    	r += s(n + attr);
    	r += o(b);
    	r += s("/" + n);
    	return r;
    }
	public String s(String b) {
    	return l("<" + b + ">");
    }
	public String o(String o) {
    	return o;
    }
	public String l(String o) {
    	return o + "\n";
    }
	public String Form(HtmlPageGen.Input... data) {
		String res = "";
		for (HtmlPageGen.Input i : data) {
			res += t("label", i.label);
			res += t("input", "", " type=\"" + i.type + "\" value=\"" + i.value + "\"");
		}
		return t("form", res);
	}
	@Override
	public void service(InputStream in, OutputStream o, String Path, String[] headers, String ip, String body) {
		//System.out.println("Servlet Served");
		PrintStream out = new PrintStream(o);
		new HtmlPageGen(out, "Set", t("h1", "Set Schedule") +
				Form(new HtmlPageGen.Input(t("h1", "Schedule"), "text", ""), new HtmlPageGen.Input(t("h1", "Submit"), "submit", "")) + t("h1", "Servlet Specifaction Version: " + 
						servletSpec + "<br>Server Version: " + 
						version + "<br>Request ip: " + 
						ip + "<br>JserialCommVersion: " + 
						SerialPort.getVersion())
				);
		
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Serial!!!!";
	}



	

	
    

	public Servlet3() {
		// TODO Auto-generated constructor stub
		
	}

}
