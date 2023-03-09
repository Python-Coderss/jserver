package img;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class Igen2 extends Applet {
	Image img;
	int a=1;
	
	public void start() {
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		int i = 0;
		
		int pixels[] = new int[w * h];
		
		a = -2147483648;
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x<w; x++) {
				int r;
				int g;
				int b;
				

				r = ((x^y) + a)&0xff;
				g = ((x*2^y*2) + a)&0xff;
				b = ((x*4^y*4) + a)&0xff;
				a++;
				
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
			
		}
		
		
	}
	public void paint(Graphics ga) {
		start();
		ga.drawImage(img, 0, 0, this);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
