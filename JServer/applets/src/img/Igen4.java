package img;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.MemoryImageSource;

public class Igen4 extends Igen {

	public Igen4() {
		
	}
	public void start() {
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		int i = 0;
		int pixels[] = new int[w * h];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x<w; x++) {
				int r = (~(x^y))&0xff;
				int g = (~(x*2^y*2))&0xff;
				int b = (~(x*4^y*4))&0xff;
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
	}
	public void paint(Graphics gp) {
		
		
		gp.drawImage(img, 0, 0, this);
		
	}
}
