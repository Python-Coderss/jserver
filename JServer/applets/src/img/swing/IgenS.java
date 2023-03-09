package img.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.io.Serializable;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IgenS extends JFrame implements Serializable {
	Image img;
	
	public void start() {
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		int i = 0;
		int pixels[] = new int[w * h];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x<w; x++) {
				int r = (x^y)&0xff;
				int g = (x*2^y*2)&0xff;
				int b = (x*4^y*4)&0xff;
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		
		
	}
	public IgenS() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public IgenS(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public IgenS(String arg0) throws HeadlessException {
		super(arg0);
		start();
	}

	public IgenS(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		start();
		g.drawImage(img, 0, 0, this);
	}
	public static void main(String[] args) {
		
		IgenS inst = new IgenS("Applet");
		inst.start();
		inst.setSize(1000, 1000);
		inst.setVisible(true);
		
		inst.start();
		
		
	}

}
