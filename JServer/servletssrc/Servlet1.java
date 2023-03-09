import java.io.*;
import jserver.*;
import jserver.rescources.Igen;

public class Servlet1 implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4655131077907368936L;
	private String version;
	private double servletSpec;

	public Servlet1() {
		// TODO Auto-generated constructor stub
	}

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
		//System.out.println("resv: " + url);
		int itemp = url.compareTo("/favicons ");
		//System.out.println("Itemp: " +itemp);
		
		boolean temp = itemp  == 0;
		//System.out.println("Returning: " + temp);
		return temp;
		
	}
	

	@Override
	public void service(InputStream in, OutputStream o, String Path, String[] headers, String ip, String body) {
		
		//System.out.println("Favicon Preveiw Served");
		PrintStream out = new PrintStream(o);
		out.println(
				"\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"<style>\r\n" + 
				".islidecontainer {\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".islider {\r\n" + 
				"  -webkit-appearance: none;\r\n" + 
				"  width: 100%;\r\n" + 
				"  height: 25px;\r\n" + 
				"  background: #d3d3d3;\r\n" + 
				"  outline: none;\r\n" + 
				"  opacity: 0.7;\r\n" + 
				"  -webkit-transition: .2s;\r\n" + 
				"  transition: opacity .2s;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				".islider::-webkit-slider-thumb {\r\n" + 
				"  -webkit-appearance: none;\r\n" + 
				"  appearance: none;\r\n" + 
				"  width: 25px;\r\n" + 
				"  height: 25px;\r\n" + 
				"  background: #04AA6D;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".islider::-moz-range-thumb {\r\n" + 
				"  width: 25px;\r\n" + 
				"  height: 25px;\r\n" + 
				"  background: #04AA6D;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"<style>\r\n" + 
				"    tislidecontainer {\r\n" + 
				"      width: 10%;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .islider {\r\n" + 
				"      -webkit-appearance: none;\r\n" + 
				"      width: 10%;\r\n" + 
				"      height: 25px;\r\n" + 
				"      background: #d3d3d3;\r\n" + 
				"      outline: none;\r\n" + 
				"      opacity: 0.7;\r\n" + 
				"      -webkit-transition: .2s;\r\n" + 
				"      transition: opacity .2s;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .islider::-webkit-slider-thumb {\r\n" + 
				"      -webkit-appearance: none;\r\n" + 
				"      appearance: none;\r\n" + 
				"      width: 25px;\r\n" + 
				"      height: 25px;\r\n" + 
				"      background: #04AA6D;\r\n" + 
				"      cursor: pointer;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .islider::-moz-range-thumb {\r\n" + 
				"      width: 25px;\r\n" + 
				"      height: 25px;\r\n" + 
				"      background: #04AA6D;\r\n" + 
				"      cursor: pointer;\r\n" + 
				"    } </style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h1>Image Size</h1>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"islidecontainer\">\r\n" + 
				"  <input type=\"range\" min=\"1\" max=\"1000\" value=\"250\" class=\"islider\" id=\"myRange\">\r\n" + 
				"  <a id=\"demo\"></a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<h1>Image Type</h1>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"tslidecontainer\">\r\n" + 
				"  <input type=\"range\" min=\"0\" max=\"" + (Igen.modeCount - 1) + "\" value=\"0\" class=\"tslider\" id=\"tRange\">\r\n" + 
				"  <a id=\"demo\"></a>\r\n" + 
				"</div>\r\n" + 
				"<h1>Preview: </h1>\r\n" + 
				"<img src=\"http://localhost:9000/favicon.ico,1,1,4\" id=\"img\"/>\r\n" + 
				"\r\n" + 
				"<script>\r\n" + 
				"    var sc = 250;\r\n" + 
				"    var tsc = 0;\r\n" + 
				"var img = document.getElementById(\"img\");\r\n" + 
				"var slider = document.getElementById(\"myRange\");\r\n" + 
				"var ts = document.getElementById(\"tRange\");\r\n" + 
				"var output = document.getElementById(\"demo\");\r\n" + 
				"img.src = \"http://127.0.0.1:9000/favicon.ico,\" + sc + \",\" + sc + \",\" + tsc;\r\n" + 
				"output.innerHTML = \"Generated Favicon Size: \";\r\n" + 
				"\r\n" + 
				"slider.oninput = function() {\r\n" + 
				"    sc = this.value;\r\n" + 
				"  output.href = \"localhost:9000/favicon.ico,\" + sc + \",\" + sc + \",\" + tsc;\r\n" + 
				"  img.src = \"http://localhost:9000/favicon.ico,\" + sc + \",\" + sc + \",\" + tsc;\r\n" + 
				"output.innerHTML = \"Generated Favicon Size: \" + sc + \" Type: \" + tsc;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"ts.oninput = function() {\r\n" + 
				"    tsc = this.value;\r\n" + 
				"  output.href = \"http://localhost:9000/favicon.ico,\" + sc + \",\" + sc + \",\" + tsc;\r\n" + 
				"  img.src = \"http://localhost:9000/favicon.ico,\" + sc + \",\" + sc + \",\" + tsc;\r\n" + 
				"output.innerHTML = \"Generated Favicon Size: \" + sc + \" Type: \" + tsc;\r\n" + 
				"}\r\n" + 
				"</script>\r\n" + 
				"\r\n" + "Servlet Specifaction Version: " + servletSpec + "<br>Server Version: " + version +
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");
		
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Favicon";
	}

}
