package img;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

public class CB extends Button {
	Image img;
	public CB() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public CB(String label) throws HeadlessException {
		super(label);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics gr) {
		Dimension d = getSize();
		int a = -2147483648;
		int w = d.width-20;
		int h = d.height-20;
		int i = 0;
		int pixels[] = new int[w * h];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x<w; x++) {
				a++;
				int r = (x^y+a)&0xff;
				int g = (x*2^y*2+a)&0xff;
				int b = (x*4^y*4+a)&0xff;
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		gr.drawImage(img, 10, 10, this);
		super.paint(gr);
	}
}
