/**
 * This class represents an ImageProcessor object that edits
 * Pics
 * @author Kristen McClelland
 * @version 1.0
 */
public class ImageProcessor {
    private Pic original;

    /**
     * Creates an ImageProcessor object unique to the fed in
     * Pic. Does not ever edit this object but has methods to
     * edit Pics and return the newly edited ones
     * @param toUse Pic that this ImageProcessor is based on
     */
    public ImageProcessor(Pic toUse) {
        original = toUse.deepCopy();
    }

    /**
     * Sets Pixels that fit a certain tolerance range of color
     * to transparent by setting alpha to 0
     * @param key determines which Pixels should be transparent
     * @param dr tolerance range for Red
     * @param dg tolerance range for Green
     * @param db tolerance range for Blue
     * @return returns the modified Pic with appropriate
     * transparent Pixels
     */
    public Pic chroma(Pixel key, int dr, int dg, int db) {
        Pic chromaPic = original.deepCopy();
        Pixel[][] array = chromaPic.getPixels();
        int height = chromaPic.getHeight();
        int width = chromaPic.getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Pixel x = array[h][w];
                int redDiff = Math.abs(x.getRed() - key.getRed());
                int greenDiff = Math.abs(x.getGreen() - key.getGreen());
                int blueDiff = Math.abs(x.getBlue() - key.getBlue());
                if (redDiff < dr && greenDiff < dg && blueDiff < db) {
                    x.setAlpha(0);
                }
            }
        }
        return chromaPic;
    }

    /**
     * This method replaces the background of a image with another one
     * by determining where the background is transparent
     * @param bg the picture to replace the background of the picture
     * in the ImageProcessor
     * @return modified Pic with replaced background
     */
    public Pic background(Pic bg) {
        Pic foregroundPic = original.deepCopy();
        Pixel[][] array = foregroundPic.getPixels();
        Pixel[][] bgArray = bg.getPixels();
        int height = foregroundPic.getHeight();
        int width = foregroundPic.getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Pixel x = array[h][w];
                if (x.getAlpha() == 0) {
                    x.setRed(bgArray[h][w].getRed());
                    x.setGreen(bgArray[h][w].getGreen());
                    x.setBlue(bgArray[h][w].getBlue());
                    x.setAlpha(bgArray[h][w].getAlpha());
                }
            }
        }
        return foregroundPic;
    }

    /**
     * This method returns a greyscaled Pic
     * @return returns a grey-scaled Pic
     */
    public Pic greyscale() {
        Pic grey = original.deepCopy();
        Pixel[][] array = grey.getPixels();
        int height = grey.getHeight();
        int width = grey.getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Pixel x = array[h][w];
                int red = x.getRed();
                int green = x.getGreen();
                int blue = x.getBlue();
                int average = (red + green + blue) / 3;
                x.setRed(average);
                x.setGreen(average);
                x.setBlue(average);
            }
        }
        return grey;
    }

    /**
     * This method returns a Pic with all of the colors
     * inverted
     * @return returns a grey-scaled Pic
     */
    public Pic invert() {
        Pic inverted = original.deepCopy();
        Pixel[][] array = inverted.getPixels();
        int height = inverted.getHeight();
        int width = inverted.getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Pixel x = array[h][w];
                int red = x.getRed();
                int green = x.getGreen();
                int blue = x.getBlue();
                x.setRed(255 - red);
                x.setGreen(255 - green);
                x.setBlue(255 - blue);
            }
        }
        return inverted;
    }
}