import java.io.*;


import jserver.Config;
import jserver.Servlet;
import jserver.main.Main;

public class Servlet5 implements Servlet {
	

	

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
			
			return url.trim().equals("/upload");
			
		}
		

		@Override
		public void service(InputStream INotUsed, OutputStream o, String path, String[] headers, String ip, String body) {
			
			path = path.substring(8);
			PrintStream out = new PrintStream(o);
			
			out.print("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta charset=\"UTF-8\">\r\n" + 
					"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"  <title>Document</title>\r\n" + 
					"  <script src=\"	https://unpkg.com/axios@0.24.0/dist/axios.min.js\"></script>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"  <input type=\"file\" id=\"fileInput\">\r\n" +
					"  <input type=\"text\" id=\"TextInput\">\r\n"+
					"  <button id=\"uploadButton\">upload</button>\r\n"
					+ "<p id=\"p\"></p>\r\n" + 
					"  <script>\r\n" + 
					"\r\n" + 
					"    document.getElementById(\"uploadButton\").onclick = () => {\r\n" + 
					"      let fileElement = document.getElementById('fileInput');\r\n" + 
					"      let textElement = document.getElementById('TextInput');\r\n"
					+ "		let out = document.getElementById('p')\r\n" + 
					"\r\n" + 
					"      // check if user had selected a file\r\n" + 
					"      if (fileElement.files.length === 0) {\r\n" + 
					"        alert('please choose a file')\r\n" + 
					"        return\r\n" + 
					"      }\r\n" + 
					"\r\n" + 
					"      let file = fileElement.files[0]\r\n" + 
					"\r\n" + 
					"      let formData = new FormData();\r\n" + 
					"      formData.set('file', file, 'file');\r\n" + 
					"	   formData.set('path', new Blob([textElement.value], {\r\n" + 
					"    type: 'text/plain'\r\n" + 
					"}), 'text')\r\n" + 
					"      axios.post(\"http://localhost:9000/upload?\", formData, {\r\n" + 
					"        onUploadProgress: progressEvent => {\r\n" + 
					"          const percentCompleted = Math.round(\r\n" + 
					"            (progressEvent.loaded * 100) / progressEvent.total\r\n" + 
					"          );\r\n" + 
					"          console.log(`upload process: ${percentCompleted}%`);\r\n" + 
					"        }\r\n" + 
					"      })\r\n" + 
					"        .then(res => {\r\n" + 
					"          console.log(res.data)\r\n" + 
					"          console.log(res.data.url)\r\n"
					+ "out.innerHTML = res.data\r\n" + 
					"        })\r\n" + 
					"    }\r\n" + 
					"\r\n" + 
					"  </script>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>");
		}

		@Override
		public String GetName() {
			// TODO Auto-generated method stub
			return "You need to upload yo files";
		}

	

	public Servlet5() {
		// TODO Auto-generated constructor stub
	}

}
