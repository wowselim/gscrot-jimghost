package co.selim.gscrot.jimghost;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class JavaImageHost {

	public static String upload(BufferedImage image) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		byte[] bImage = baos.toByteArray();

		return upload(bImage);
	}

	public static String upload(byte[] b) throws Exception {
		HttpResponse response = HttpRequest.post("http://localhost:1337/img/upload")
				.body(Base64.getEncoder().encodeToString(b)).send();

		return response.bodyText();
	}
}
