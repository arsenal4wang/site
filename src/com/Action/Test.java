package com.Action;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String temp = null;
		try {
			temp = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = temp;
	}

	public String testAction() {
		System.out.println(getName());
		return SUCCESS;
	}
}
