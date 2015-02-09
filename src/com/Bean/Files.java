package com.Bean;

public class Files {
	int fileID, downTimes;
	String fileName, fileInfo, up_Date, author, classify;

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}

	public String getUp_Date() {
		return up_Date;
	}

	public void setUp_Date(String up_Date) {
		this.up_Date = up_Date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getDownTimes() {
		return downTimes;
	}

	public void setDownTimes(int downTimes) {
		this.downTimes = downTimes;
	}
}
