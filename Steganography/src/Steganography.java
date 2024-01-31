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
		Picture copy3 = revealPicture(copy2);
		copy3.explore(); 
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
	/**
	 * Sets the highest two bits of each pixel’s colors
	 * to the lowest two bits of each pixel’s color o s
	*/
	public static Picture revealPicture(Picture hidden)
	{
		Picture copy = new Picture(hidden);
		Pixel[][] pixels = copy.getPixels2D();
		Pixel[][] source = hidden.getPixels2D();
		for (int r = 0; r < pixels.length; r++){
			for (int c = 0; c < pixels[0].length; c++) {

				Color col = source[r][c].getColor();
				pixels[r][c].setRed((pixels[r][c].getRed()/64)*64 + (col.getRed()/4));
				pixels[r][c].setGreen((pixels[r][c].getGreen()/64)*64 + (col.getGreen()/4));
				pixels[r][c].setBlue((pixels[r][c].getBlue()/64)*64 + (col.getBlue()/4));
		
			}
		}
	return copy;
	}
	
	/**
	 * Determines whether secret can be hidden in source, which is
	 * true if source and secret are the same dimensions.
	 * @param source is not null
	 * @param secret is not null
	 * @return true if secret can be hidden in source, false otherwise.
	 */
	public static boolean canHide(Picture source, Picture secret) {
		if ((source.getWidth()== secret.getWidth()) && (source.getHeight() == secret.getHeight())){
			return true;
		}
		return false;
	}
	/**
	 * Creates a new Picture with data from secret hidden in data from source
	 * @param source is not null
	 * @param secret is not null
	 * @return combined Picture with secret hidden in source
	 * precondition: source is same width and height as secret
	 */
	public static Picture hidePicture(Picture source, Picture secret) {
		if (canHide(source, secret)) {
			
		}
	}
}

