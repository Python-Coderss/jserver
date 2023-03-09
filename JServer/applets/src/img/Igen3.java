package img;



import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class Igen3 extends Applet {
	Image img;
	int a=1;
	byte s1=0;
	public void start() {
		Dimension d = getSize();
		a = -2147483648;
		int w = 1;
		int h = d.height;
		int i = 0;
		int pixels[] = new int[f((int) d.getWidth()) *8 *8];
		for (int y = 0; y < h; y++) {
			if (w < d.width) w++;
			for (int x = 0; x<w; x++) {
				int r;
				int g;
				int b;
				

				r = ((x^y) + a)&0xff;
				g = ((x*2^y*2) + a)&0xff;
				b = ((x*4^y*4) + a)&0xff;
				a++;
				if (s1 == 0) {
					s1 = 1;
				} else if (s1 == 1) {
					s1 = 2;
				} else {
					s1 = 0;
				}
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		
		
	}
	public void paint(Graphics g) {
		
		g.drawImage(img, 0, 0, this);
	}
	private int f(int f) {
		int result = 1;
		
		for (int i = 1; i<=f; i++) { result = i + result; System.out.println("i: " + i); System.out.println("result: " + result);} System.out.println(result);
		return result;
		
	}
}

