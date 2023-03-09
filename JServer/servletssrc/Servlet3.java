
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
		int itemp = url.compareTo("/micro ");
		//System.out.println("Itemp3: " +itemp);
		
		boolean temp = itemp  == 0;
		//System.out.println("Returning3: " + temp);
		return temp;
		
	}

	@Override
	public void service(InputStream in, OutputStream o, String Path, String[] headers, String ip, String body) {
		//System.out.println("Servlet Served");
		PrintStream out = new PrintStream(o);
		out.println("Hello world");
		
		SerialPort[] ports = SerialPort.getCommPorts();
		
		SerialPort microbit = ports[0];
		
		for (SerialPort port: ports) {
			out.println("System port name : " + port.getSystemPortName() + "<br>");
			out.println("Descriptive port name : " + port.getDescriptivePortName() + "<br>");
			out.println("Port description : " + port.getPortDescription() + "<br>");
			out.println("is microbit : " + port.getPortDescription().equals("mbed Serial Port") + "<br>");
			microbit = port;
		}
		microbit.setBaudRate(9600);
		microbit.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING, 1000, 1000);
		if (microbit.openPort(500)) {
		InputStream inm = microbit.getInputStreamWithSuppressedTimeoutExceptions();
		
		OutputStream oum = microbit.getOutputStream();
		
		
		
		try {
			oum.write('\n');
			
			
			
			
			while(microbit.bytesAvailable() < 1) ;
			
			
				int i = inm.read();
		        while (!((i == '/') || (i == -1))) {
		        	o.write(i);
		        	while(microbit.bytesAvailable() < 1) ;
		        	i =  inm.read();
		        	
		        }
		         
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		microbit.closePort();
		
		} else out.println("Could not open port in valid config");
		out.println("Servlet Specifaction Version: " + servletSpec + "<br>Server Version: " + version + "<br>Request ip: " + ip + "<br>JserialCommVersion: " + SerialPort.getVersion());
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
