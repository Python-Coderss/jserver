package img;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;

public class Tiles extends Applet {
	static int n = 5;
	GridLayout l;
	public Tiles() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}
	public void init() {
		l = new GridLayout(n,n);
		setLayout(l);
		
	}
	public void paint(Graphics g) {
		int k = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				k = i*n+ j;
				if (k!=0)add(new CB(""+k));
			}
		}
		add(new CB(""+(k+1)));
		//n++;
		super.paint(g);
	}

}
