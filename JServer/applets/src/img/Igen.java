package img;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;

@SuppressWarnings({ "serial", "removal" })
public class Igen extends Applet {
	Image img;
	
	
	public void paint(Graphics2D gp) {
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
		
		gp.drawImage(img, 0, 0, this);
		//System.out.println("Paint(Graphics gp)");
	}
	
}
