import java.io.IOException;
/**
 * This class is a driver function to run and create objects of
 * the Pixel, ImageProcessor, and Pic classes. It takes input
 * arguments in order to edit pictures.
 * @author Kristen McClelland
 *         GTID: 902944956
 * Collaboration statement: I worked on the homework assignment alone,
 * using only course materials.
 * @version 1.0
 */
public class Photoslop {
    /**
     * This is the driver method for the Photoslop class that calls
     * upon Pixel, ImageProcessor, and Pic classes.
     * @param args Args takes in line commands from the user in order
     * to determine what files to manipulate and what manipulations
     * to make.
     */
    public static void main(String... args) throws IOException {
        Pic image;
        ImageProcessor editor;

        if (args.length < 3) {
            printUsage();
            System.exit(0);
        }
        try {
            //your code here
            //hint the base pic for use with the image processor is in args[1]

            if (args[0].equals("-g")) {
                //greyscale mode
                image = new Pic(args[1]);
                editor = new ImageProcessor(image);
                Pic greyEdit = editor.greyscale();
                //remember to save greyEdit to args[2]
                greyEdit.save(args[2]);
            } else if (args[0].equals("-i")) {
                //invert mode
                image = new Pic(args[1]);
                editor = new ImageProcessor(image);
                Pic invertEdit = editor.invert();
                // remember to save invertEdit to args[2]
                invertEdit.save(args[2]);
            } else if (args[0].equals("-c")) {
                //use this as your chroma key to match the greenscreen
                //in the lego guy image
                Pixel chromaKey = new Pixel(26, 185, 19, 1);
                Pic foregroundPic = new Pic(args[1]);
                ImageProcessor foreEditor = new ImageProcessor(foregroundPic);
                Pic backgroundPic = new Pic(args[2]);
                //Your code here to apply the chroma key transformation
                //It's up to you what you want the rgb deltas (thresholds) to be
                //I used something like 20, 40, 20
                Pic transparentFG = foreEditor.chroma(chromaKey, 20, 40, 20);
                editor = new ImageProcessor(transparentFG);
                //Your code here to apply the background (args[2])
                Pic replaced = editor.background(backgroundPic);
                //Finally, save replaced to args[3]
                replaced.save(args[3]);
            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Greyscale mode: ");
        System.out.println("java Photoslop -g imageFile outputFileName");
        System.out.println("");
        System.out.println("Invert mode: ");
        System.out.println("java Photoslop -i imageFile outputFileName");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java Photoslop -c imageFile backgroundFile"
            + " outputFileName");
    }
}