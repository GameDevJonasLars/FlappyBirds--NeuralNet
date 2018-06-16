package com.game;

import java.util.ArrayList;
import java.util.List;

import com.engine.Window;

public class RohrController {
	private List<RohrBlockade> rohre;
	private Window window;
	private int iTime;

	public RohrController(Window window) {
		rohre = new ArrayList<RohrBlockade>();
		this.window = window;
		iTime = 0;
	}

	public void update() {
		iTime++;
		if (rohre.size() == 0) {
			neueRoehre();
		}
		if (iTime > 300) {
			neueRoehre();
			iTime = 0;
		}
		for (RohrBlockade rohrBlockade : rohre) {
			rohrBlockade.update();
			rohrBlockade.collision();
		}
	}

	public void neueRoehre() {
		rohre.add(new RohrBlockade(window, this));
		rohre.get(rohre.size() - 1).init();
		rohre.get(rohre.size() - 1).getNames();
	}

	public void resetList() {
		for (RohrBlockade rohrBlockade : rohre) {
			window.getSprites().get(rohrBlockade.getiRöhreOben()).setbDraw(false);
			window.getSprites().get(rohrBlockade.getiRöhreUnten()).setbDraw(false);
		}
		iTime = 0;
		rohre = new ArrayList<RohrBlockade>();
	}
}
