package com.tools;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;

final public class ResourceLoader {
	public static InputStream load(String path) {
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if (input == null) {
			input = ResourceLoader.class.getResourceAsStream("/" + path);
		}
		return input;
	}

	public static void assignIcon() {
		java.net.URL iconUrl = ResourceLoader.class.getResource("images.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage(iconUrl);

		}

}
