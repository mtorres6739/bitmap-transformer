package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitMap {

    // create instance of variable

    BufferedImage pixelImage;

    String readPath;
    String writePath;

    // create constructor

    public BitMap(String readPath, String writePath) {
        this.readPath = readPath;
        this.writePath = writePath;
    }

    public void transform() throws IOException {
        File file = new File(readPath);
        this.pixelImage = ImageIO.read(file);
    }


    // create instance of method

    public void write(String writePath) throws IOException {
        File file = new File(writePath);
        ImageIO.write(this.pixelImage, "bmp", file);
    }


    // transforms to gray scale

    public void transformGrayScale() {
        for (int i = 0; i < this.pixelImage.getWidth(); i++) {
            for (int j = 0; j < this.pixelImage.getHeight(); j++) {
                //getting RGB color on each pixel
                Color c = new Color(this.pixelImage.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                // turning color to grayscale
                int gr = (r + g + b) / 3;

                //create gray color
                Color grayColor = new Color(gr, gr, gr, a);
                this.pixelImage.setRGB(i, j, grayColor.getRGB());
            }
        }
    }
}
