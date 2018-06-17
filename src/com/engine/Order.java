package com.engine;

public class Order {
	private int iOrder;
	private int iForm;
	private int iIndex;

	public Order(int iOrder, int iForm, int iIndex) {
		this.iOrder = iOrder;
		this.iForm = iForm;
		this.iIndex = iIndex;
	}

	public int getiOrder() {
		return iOrder;
	}

	public void setiOrder(int iOrder) {
		this.iOrder = iOrder;
	}

	public int getiForm() {
		return iForm;
	}

	public void setiForm(int iForm) {
		this.iForm = iForm;
	}

	public int getiIndex() {
		return iIndex;
	}

	public void setiIndex(int iIndex) {
		this.iIndex = iIndex;
	}

}
