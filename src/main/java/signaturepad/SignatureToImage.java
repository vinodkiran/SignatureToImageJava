package signaturepad;

import com.google.gson.Gson;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *	Signature to Image: A supplemental script for Signature Pad that
 *	generates an image of the signature’s JSON output server-side using Java.
 *
 *	@project	signaturetoimage
 *	@author		Vinod Kiran (vinodkiran@usa.net)
 *	@link		http://github.com/vinodkiran/SignatureToImageJava
 *	@version	1.0.0
 */
public class SignatureToImage {

    public static BufferedImage convertJsonToImage(String jsonString){
        Gson gson = new Gson();
        SignatureLine[] signatureLines = gson.fromJson(jsonString, SignatureLine[].class);
        BufferedImage offscreenImage = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = offscreenImage.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0,0,200,50);
        g2.setPaint(Color.black);
        for (SignatureLine line : signatureLines ) {
            g2.drawLine(line.lx, line.ly, line.mx, line.my);
        }
        return offscreenImage;
    }
}
