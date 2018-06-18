package com.engine;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerWin implements MouseListener {
	private static boolean bPressed;
	public MouseListenerWin() {
		bPressed = false;
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		bPressed = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		bPressed = false;
		
	}
	
	public Point getMousePos() {
		return getMousePos();
		
	}

	public boolean isbPressed() {

		return bPressed;
	}

	
   
}
