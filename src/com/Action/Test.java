package com.Action;

public class Test {
	String show;

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	int tt;

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String test() {

		if (getShow().equals("a")) {
			tt = 1;
		} else {
			tt = 2;
		}
		return "success";
	}
}
