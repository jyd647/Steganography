import java.awt.Color;
public class Steganography {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture beach = new Picture ("beach.jpg");
		beach.explore();
		Picture copy = testClearLow(beach);
		copy.explore();
		Picture beach2 = new Picture ("beach.jpg");
		beach2.explore();
		Picture copy2 = testSetLow(beach2, Color.PINK);
		copy2.explore(); 
	}
	public static void clearLow( Pixel p )
		{
		p.setRed((p.getRed()/4)*4);
		p.setGreen((p.getGreen()/4)*4);
		p.setBlue((p.getBlue()/4)*4);
		}

	public static Picture testClearLow(Picture p)
	{
		for (int r = 0; r < p.getWidth(); r++) {
			for (int c = 0; c < p.getHeight(); c++) {
				clearLow(p.getPixel(r, c));
			}
		}
		return p;
	}
	/**
	* Set the lower 2 bits in a pixel to the highest 2 bits in c
	*/
	public static void setLow (Pixel p, Color c)
	{
	clearLow(p);
	p.setRed(p.getRed()+ (c.getRed()/64));
	p.setGreen(p.getGreen()+ (c.getGreen()/64));
	p.setBlue(p.getBlue()+ (c.getBlue()/64));
	}
	public static Picture testSetLow(Picture p, Color co)
	{
		for (int r = 0; r < p.getWidth(); r++) {
			for (int c = 0; c < p.getHeight(); c++) {
				setLow(p.getPixel(r, c), co);
			}
		}
		return p;
	}
	
}

