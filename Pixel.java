/**
 * This class represents a Pixel object.
 * @author Kristen McClelland
 * @version 1.0
 */
public class Pixel {
    // private variables
    private int red, green, blue, alpha;

    /**
     * Default constructor with no parameters
     * Pixel should be set to pure white with no
     * transparency
     */
    public Pixel() {
        this.red = 255;
        this.green = 255;
        this.blue = 255;
        this.alpha = 255;
    }
    /**
     * Constructor that takes in 4 parameters to create
     * a Pixel object
     * @param r bit value for red
     * @param g bit value for green
     * @param b bit value for blue
     * @param a bit value for alpha (transparency)
     */
    public Pixel(int r, int g, int b, int a) {
        if (r > 255) {
            this.red = 255;
        } else if (r < 0) {
            this.red = 0;
        } else {
            this.red = r;
        }
        if (g > 255) {
            this.green = 255;
        } else if (g < 0) {
            this.green = 0;
        } else {
            this.green = g;
        }
        if (b > 255) {
            this.blue = 255;
        } else if (b < 0) {
            this.blue = 0;
        } else {
            this.blue = b;
        }
        if (a > 255) {
            this.alpha = 255;
        } else if (a < 0) {
            this.alpha = 0;
        } else {
            this.alpha = a;
        }
    }

    /**
     * This method returns the current Red value
     * @return int for the red value of this pixel
     */
    public int getRed() {
        return this.red;
    }

    /**
     * This method returns the current Green value
     * @return int for the green value of this pixel
     */
    public int getGreen() {
        return this.green;
    }

    /**
     * This method returns the current Blue value
     * @return int for the blue value of this pixel
     */
    public int getBlue() {
        return this.blue;
    }

    /**
     * This method returns the current Alpha value
     * @return int for the alpha value of this pixel
     */
    public int getAlpha() {
        return this.alpha;
    }

    /**
     * This method provides a way to change the Red value
     * of this Pixel
     * @param r Red value to change to
     */
    public void setRed(int r) {
        if (r > 255) {
            this.red = 255;
        } else if (r < 0) {
            this.red = 0;
        } else {
            this.red = r;
        }
    }

    /**
     * This method provides a way to change the Green value
     * of this Pixel
     * @param g Green value to change to
     */
    public void setGreen(int g) {
        if (g > 255) {
            this.green = 255;
        } else if (g < 0) {
            this.green = 0;
        } else {
            this.green = g;
        }
    }

    /**
     * This method provides a way to change the Blue value
     * of this Pixel
     * @param b Blue value to change to
     */
    public void setBlue(int b) {
        if (b > 255) {
            this.blue = 255;
        } else if (b < 0) {
            this.blue = 0;
        } else {
            this.blue = b;
        }
    }

    /**
     * This method provides a way to change the Alpha value
     * of this Pixel
     * @param a Red value to change to
     */
    public void setAlpha(int a) {
        if (a > 255) {
            this.alpha = 255;
        } else if (a < 0) {
            this.alpha = 0;
        } else {
            this.alpha = a;
        }
    }
}