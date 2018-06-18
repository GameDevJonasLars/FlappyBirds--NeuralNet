package com.engine;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.gui.Objekte;
import com.tools.ResourceLoader;

public class Controller extends Objekte {
	public static JFrame frame;
	public Controller(String path) {
		frame = new Frame();
		try {
			frame.setIconImage(ImageIO.read(ResourceLoader.load(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(jpMainMenu);
		frame.repaint();
		frame.validate();
	}

}
