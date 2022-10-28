/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        // create instance of bitmap
        if (args.length > 0) {
            String file = args[0];
            BitMap bitMapImage = new BitMap("src/main/resources/" + args[0], "src/main/resources/" + args[1]);
            bitMapImage.transform();
            // transform image

            if (args[2].equals("grayscale")) {
                bitMapImage.transformGrayScale();
            }

            // write
            bitMapImage.write();
        }
    }
}
