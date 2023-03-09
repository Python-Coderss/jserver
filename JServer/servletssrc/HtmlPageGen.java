import java.io.PrintStream;

public class HtmlPageGen {

	private PrintStream out;
	public HtmlPageGen(PrintStream out, String title, String body) {
		// TODO Auto-generated constructor stub
		
		this.out = out;
		so("!DOCTYPE html");
		to("html", 
				t("head", 
						t("title", 
								title)) +
				t("body", body));
		
		
		
	}
	public static class Input {
		public String label;
		public String type;
		public String value;
		public Input(String l, String t, String v) {
			label = l;
			type = t;
			value = v;
		}
	}
	
    // t = new tag
    // Parameters
    // b = inner html
	// n = name of tag
    public void to(String n, String b) {
    	so(n);
    	oo(b);
    	so("/" + n);
    }
    public String t(String n, String b) {
    	String r = "";
    	r += s(n);
    	r += o(b);
    	r += s("/" + n);
    	return r;
    }
    // s = new start tag
    // Parameters
    // b = name of tag
    public void so(String b) {
    	lo("<" + b + ">");
    }
    public String s(String b) {
    	return l("<" + b + ">");
    }
    // o = print
    // Parameters
    // o = string to print
    public void oo(String o) {
    	out.print(o);
    }
    public String o(String o) {
    	return o;
    }
    // l = print line
    // Parameters
    // o = string to print
    public void lo(String o) {
    	out.println(o);
    }
    public String l(String o) {
    	return o + "\n";
    }
    
}
