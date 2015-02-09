package com.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	private String fileName;// 要下载的文件名

	HttpServletRequest request;

	static int flag = -1;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String downMysqlFiles() {
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {

		String path = ServletActionContext.getServletContext().getRealPath(
				"/uploadFiles/" + fileName);
		System.out.println("execute..." + path);
		File file = new File(path);

		if (file.exists()) {
			System.out.println("execute...文件存在");
			return SUCCESS;
		} else {
			System.out.println("execute...不存在");
			return ERROR;
		}
	}

	// 下载备份的mysql文件
	public InputStream getDownloadMysql() {
		request = ServletActionContext.getRequest();// 获取request对象 ;
		String path = request.getSession().getServletContext().getRealPath("/");

		InputStream is = null;
		try {
			is = new FileInputStream(path + "MySqlFiles/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	// 下载文件
	public InputStream getDownloadFile() {
		request = ServletActionContext.getRequest();// 获取request对象 ;
		String path = request.getSession().getServletContext().getRealPath("/");
		InputStream is = null;
	//	System.out.println("getDownloadFile......." + fileName);
		try {
			is = new FileInputStream(path + "uploadFiles/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	public void setFileName(String fileName) {
	//	System.out.println("setFileName....." + fileName);
		try {// 解决中文文件名问题
			this.fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	//	this.fileName = fileName;
	}

	public String getFileName() {
		String name = "";
		try {// 解决下载文件中文文件名问题
			if (isIE())
				name = new String(fileName.getBytes("GBK"), "ISO8859-1");
			else
				name = new String(fileName.getBytes("utf8"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	//	System.out.println("getFileName..fileName..." + fileName);
	//	System.out.println("getFileName..name..." + name);
		return name;
	}

	// 判断是不是IE浏览器。。。IE你也太奇葩了。
	public static boolean isIE() {
		return ServletActionContext.getRequest().getHeader("USER-AGENT")
				.toLowerCase().indexOf("msie") > 0 ? true : false;
	}
}