package co.selim.gscrot.jimghost;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Properties;

import javax.imageio.ImageIO;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class JavaImageHost {
	private static Properties HOST_PROPERTIES = new Properties();
	static {
		try {
			HOST_PROPERTIES.load(new FileInputStream(new File("gscrot-jimghost.cfg")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String upload(BufferedImage image) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		byte[] bImage = baos.toByteArray();

		return upload(bImage);
	}

	public static String upload(byte[] b) throws Exception {
		HttpResponse response = HttpRequest.post(HOST_PROPERTIES.getProperty("url"))
				.body(Base64.getEncoder().encodeToString(b)).send();

		return response.bodyText();
	}
}
