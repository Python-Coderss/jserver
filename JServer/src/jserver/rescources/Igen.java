package jserver.rescources;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import java.util.Random;

@SuppressWarnings({ "serial" })
public class Igen extends Applet {
	public static final int seed = 2022;
	public static final int modeCount = 5;
	Image img;
	public static Random ra = new Random(seed);
	//private int r;
	private int a;
	public Igen() {
		super();
		
	}
	public void paint(Graphics g) {
		paint(g, ra.nextInt(modeCount));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics gp, int ra) {
		
		
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		int i = 0;
		int pixels[] = new int[w * h];
		if (ra == 0) {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x<w; x++) {
				int r = (x^y)&0xff;
				int g = (x*2^y*2)&0xff;
				int b = (x*4^y*4)&0xff;
				pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
			}
			
		}
		img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		else if (ra == 1) {
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
				
				
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		} else if (ra == 2) {
			
			
			for (int y = 0; y < h; y++) {
				for (int x = 0; x<w; x++) {
					int r = (/*x^y*/ Igen.ra.nextInt(0xff))&0xff;
					int g = (/*x*2^y*2*/ Igen.ra.nextInt(0xff))&0xff;
					int b = (/*x*4^y*4*/ Igen.ra.nextInt(0xff))&0xff;
					pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
				}
				
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		else if (ra == 3) {
			
			
			for (int y = 0; y < h; y++) {
				for (int x = 0; x<w; x++) {
					int r = (/*x^y*/ Igen.ra.nextInt(0xff))&0xff;
					int g = (/*x*2^y*2*/ Igen.ra.nextInt(0xff))&0xff;
					int b = (/*x*4^y*4*/ Igen.ra.nextInt(0xff))&0xff;
					pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
				}
				
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
			Igen.ra.setSeed(seed);
		} else {
			for (int y = 0; y < h; y++) {
				for (int x = 0; x<w; x++) {
					int lum = ( Math.abs(Igen.ra.nextInt(0xff)))&0xff;
					int r = lum;
					int g = lum;
					int b = lum;
					pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
				}
				
			}
			img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
		}
		
		gp.drawImage(img, 0, 0, this);
		//System.out.println("Paint(Graphics gp)");
	}
	
}
