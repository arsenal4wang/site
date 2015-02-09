package com.Action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.Bean.FileClass;
import com.Bean.Files;
import com.Sql.SqlAdd;
import com.Sql.SqlCount;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlQueryMax;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FilesAction extends ActionSupport {
	// 封装文件标题请求参数的属性

	String fileInfo, author, fileName, classify;
	int begin_num, all_num, fileID, page, fileClassID;
	String fileClassName, fileClassNameMod;// 资源分类,修改
	private Map<String, Object> dataMap;
	List<Files> list = new ArrayList<Files>();// 文件列表
	List<FileClass> list_class = new ArrayList<FileClass>();
	HttpServletRequest request;

	public String getFileClassNameMod() {
		return fileClassNameMod;
	}

	public void setFileClassNameMod(String fileClassNameMod) {
		String temp = null;
		try {
			temp = new String(fileClassNameMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fileClassNameMod = temp;
	}

	public int getFileClassID() {
		return fileClassID;
	}

	public void setFileClassID(int fileClassID) {
		this.fileClassID = fileClassID;
	}

	public String getFileClassName() {
		return fileClassName;
	}

	public void setFileClassName(String fileClassName) {
		this.fileClassName = fileClassName;
	}

	/**
	 * 构造方法
	 */
	public FilesAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<FileClass> getList_class() {
		return list_class;
	}

	public void setList_class(List<FileClass> list_class) {
		this.list_class = list_class;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

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

	public void setFileName(String fileName) {
	//	System.out.println("set  " + fileName);
		/*
		 * try {// 解决中文文件名问题 this.fileName = new
		 * String(fileName.getBytes("ISO-8859-1"), "GBK"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		this.fileName = fileName;
	}

	public String getFileName() {
	//	System.out.println("get  " + fileName);
		// String name = "";
		// try {// 解决下载文件中文文件名问题
		// name = new String(fileName.getBytes("GBK"), "ISO8859-1");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		return fileName;
	}/**/

	public int getAll_num() {
		return all_num;
	}

	public void setAll_num(int all_num) {
		this.all_num = all_num;
	}

	public int getBegin_num() {
		return begin_num;
	}

	public void setBegin_num(int begin_num) {
		this.begin_num = begin_num;
	}

	public List<Files> getList() {
		return list;
	}

	public void setList(List<Files> list) {
		this.list = list;
	}

	public String getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// 封装文件标题请求参数的属性
	private String title;
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 直接在struts.xml文件中配置的属性
	private String savePath;

	// 接受struts.xml文件配置值的方法
	public void setSavePath(String value) {
		this.savePath = value;
	}

	// 返回上传文件的保存位置
	private String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	// 文件标题的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return (this.title);
	}

	// 上传文件对应文件内容的setter和getter方法
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return (this.upload);
	}

	// 上传文件的文件类型的setter和getter方法
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	// 上传文件的文件名的setter和getter方法
	public void setUploadFileName(String uploadFileName) {
		//System.out.println("uploadFileName" + uploadFileName);
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}

	public String deleteFile() throws IOException {
		String id = String.valueOf(getFileID());
		fileName = SqlQuery.getTarget("file", "fileName", "fileID", id);
		// fileName
		String path = ServletActionContext.getServletContext().getRealPath(
				"/uploadFiles");
		File file = new File(path + "/" + fileName);
		// 删除数据库中内容
		if (file.exists()) {
			SqlDelete.delete("file", "fileID", getFileID());
			file.delete();
		} else {
			SqlDelete.delete("file", "fileID", getFileID());
			System.out.print("不存在");
		}
		return SUCCESS;
	}/**/

	// 生成文件列表
	public String filelist() {
		all_num = SqlCount.countAll("file");
		page = judge(all_num);
		list.removeAll(list);
		list = SqlQuery.getFileList(getBegin_num(), 20);
		return SUCCESS;
	}

	// 生成分类的下拉菜单
	public String getClassifyMenu() {
		dataMap.clear();

		JSONArray jsonArray = new JSONArray();

		list_class = SqlQuery.getFileClass();
		// System.out.println("list大小" + list_class.size());
		for (int i = 0; i < list_class.size(); i++) {
			FileClass fc = new FileClass();
			fc = list_class.get(i);
			jsonArray.add(fc);
		}
		dataMap.put("classify_menu", jsonArray);
		// System.out.println("ja输出：    " + jsonArray);
		// System.out.println("dataMap输出：    " + dataMap);

		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		return SUCCESS;
	}

	@SuppressWarnings("resource")
	public String upload() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> session = act.getSession();
		request = ServletActionContext.getRequest();// 获取request对象 ;
		// System.out.println(getClassify());
		// 得到时间
		GetDate gd = new GetDate();
		String timeSql = gd.getDate();
		SqlAdd dataAdd = new SqlAdd();
		// 取得数据库中最大ID
		SqlQueryMax sqm = new SqlQueryMax();
		// 获取最新ID
		int ID = 0;
		ID = SqlQueryMax.query_max("file", "fileID");
		ID++;
		// System.out.println("作者" + getAuthor());
		// 以服务器的文件保存地址和原文件名建立上传文件输出流
//		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
//				+ getUploadFileName());
		
		if (getUpload() != null) {
//			FileInputStream fis = new FileInputStream(getUpload());
//			byte[] buffer = new byte[1024];
//			int len = 0;
//			while ((len = fis.read(buffer)) > 0) {
//				fos.write(buffer, 0, len);
//			}
//			fos.close();
			/**第二种上传的方法**/
		//	System.out.println(getSavePath());
			try {  
			File file=new File(getSavePath());
			FileUtils.copyFile(upload, new File(file, getUploadFileName()));
			} catch (IOException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		    }  
			/**第二种上传结束**/
			// 文件上传完毕后再添加数据库
			// System.out.println(getAuthor());
			dataAdd.SQLadd(ID, getUploadFileName(), getFileInfo(), timeSql,
					getAuthor(), getClassify());
			session.put("error_session", "");
			// System.out.println("不为空");
			return SUCCESS;
		} else {
			request.setAttribute("error", "您没有上传任何文件!!");
			session.put("error_session", "您没有上传任何文件！");
			// System.out.println("为空");
			return ERROR;
		}
	}

	public int judge(int end_num) {
		int page_num;
		if (end_num % 20 == 0) {
			page_num = end_num / 20;
		} else {
			page_num = end_num / 20 + 1;
		}
		return page_num;
	}

	public String deleteBycheckBox() {

		SqlDelete.delete("file", "fileID", getFileID());
		return SUCCESS;
	}

	public String delFileClass() {
		SqlDelete.delete("fileclass", "id", getFileClassID());
		return SUCCESS;
	}

	public String addFileClass() {
		// System.out.println(getFileClassName());
		SqlAdd.addContent("fileclass", "name", getFileClassName());
		return SUCCESS;
	}

	public String getFileClassList() {

		list_class = SqlQuery.getFileClass();
		// System.out.println(list_class.size());
		return SUCCESS;
	}

	public String modFileClassName() {
		System.out.println(getFileClassNameMod());
		fileClassNameMod = getFileClassNameMod();
		fileClassID = getFileClassID();
		return SUCCESS;
	}

	public String updateFileClass() {
		SqlUpdate.update("fileclass", "id", getFileClassID(), "name",
				getFileClassName());
		return SUCCESS;
	}

	public String test() {
		return SUCCESS;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
