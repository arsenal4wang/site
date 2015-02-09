package com.Action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.Bean.GdPic;
import com.Bean.News;
import com.Bean.PicSlider;
import com.Bean.SecFirst;
import com.Bean.SecSec;
import com.Bean.Section;
import com.Sql.SqlAdd;
import com.Sql.SqlCount;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlQueryMax;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	int newsID;
	String isChecked, isTop;

	int all_num, page, begin_num;
	List<News> list_news = new ArrayList<News>();// 新闻列表
	int secSecID, secFirstID;
	String newsTitle, newsContent, author, subDate, secSecName, secFirstName;
	List<SecFirst> listFirst = new ArrayList<SecFirst>();
	List<SecSec> listSec = new ArrayList<SecSec>();

	List<Section> listSection = new ArrayList<Section>();
	List<Section> listSubSection = new ArrayList<Section>();

	String newsTitleMod, newsContentMod;

	// 搜索
	String keyWords, keyWordsPage2;
	int frompage;
	// 轮播图片
	String picName, picLocation, href, picSlider2;
	int picID, picOrder;
	List<PicSlider> list = new ArrayList<PicSlider>();

	/**
	 * 上传附件***单附件上传
	 * 
	 * // 封装文件标题请求参数的属性 private String title; // 封装上传文件域的属性 private File upload;
	 * // 封装上传文件类型的属性 private String uploadContentType; // 封装上传文件名的属性 private
	 * String uploadFileName; // 直接在struts.xml文件中配置的属性 private String savePath;
	 * 
	 * 
	 * // 接受struts.xml文件配置值的方法 public void setSavePath(String value) {
	 * this.savePath = value; }
	 * 
	 * // 返回上传文件的保存位置 private String getSavePath() throws Exception { return
	 * ServletActionContext.getServletContext().getRealPath(savePath); }
	 * 
	 * // 文件标题的setter和getter方法 public void setTitle(String title) { this.title =
	 * title; }
	 * 
	 * public String getTitle() { return (this.title); }
	 * 
	 * // 上传文件对应文件内容的setter和getter方法 public void setUpload(File upload) {
	 * this.upload = upload; }
	 * 
	 * public File getUpload() { return (this.upload); }
	 * 
	 * // 上传文件的文件类型的setter和getter方法 public void setUploadContentType(String
	 * uploadContentType) { this.uploadContentType = uploadContentType; }
	 * 
	 * public String getUploadContentType() { return (this.uploadContentType); }
	 * 
	 * // 上传文件的文件名的setter和getter方法 public void setUploadFileName(String
	 * uploadFileName) { //System.out.println("uploadFileName" +
	 * uploadFileName); this.uploadFileName = uploadFileName; }
	 * 
	 * public String getUploadFileName() { return (this.uploadFileName); }
	 * 
	 * /***上传附件结束
	 *****/
	// 上传多个文件的集合文本

	// 封装文件标题请求参数的属性
	private String title;

	// 直接在struts.xml文件中配置的属性
	private String savePath;
	private List<File> upload;
	// /多个上传文件的类型集合
	private List<String> uploadContextType;
	// 多个上传文件的文件名集合
	private List<String> uploadFileName;

	public int getFrompage() {
		return frompage;
	}

	public void setFrompage(int frompage) {
		this.frompage = frompage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWordsPage2() {
		return keyWordsPage2;
	}

	public void setKeyWordsPage2(String keyWordsPage2) {
		String temp = null;
		try {
			temp = new String(keyWordsPage2.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.keyWordsPage2 = temp;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	// 返回上传文件的保存位置
	private String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContextType() {
		return uploadContextType;
	}

	public void setUploadContextType(List<String> uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getPicSlider2() {
		return picSlider2;
	}

	public void setPicSlider2(String picSlider2) {
		this.picSlider2 = picSlider2;
	}

	public int getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(int picOrder) {
		this.picOrder = picOrder;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicLocation() {
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getPicID() {
		return picID;
	}

	public void setPicID(int picID) {
		this.picID = picID;
	}

	public List<PicSlider> getList() {
		return list;
	}

	public void setList(List<PicSlider> list) {
		this.list = list;
	}

	public List<Section> getListSection() {
		return listSection;
	}

	public void setListSection(List<Section> listSection) {
		this.listSection = listSection;
	}

	public List<Section> getListSubSection() {
		return listSubSection;
	}

	public void setListSubSection(List<Section> listSubSection) {
		this.listSubSection = listSubSection;
	}

	public String getNewsTitleMod() {
		return newsTitleMod;
	}

	public void setNewsTitleMod(String newsTitleMod) {
		String temp = null;
		try {
			temp = new String(newsTitleMod.getBytes("iso-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.newsTitleMod = temp;
	}

	public String getNewsContentMod() {
		return newsContentMod;
	}

	public void setNewsContentMod(String newsContentMod) {
		String temp = null;
		try {
			temp = new String(newsContentMod.getBytes("iso-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.newsContentMod = temp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBegin_num() {
		return begin_num;
	}

	public void setBegin_num(int begin_num) {
		this.begin_num = begin_num;
	}

	public int getAll_num() {
		return all_num;
	}

	public void setAll_num(int all_num) {
		this.all_num = all_num;
	}

	public List<News> getList_news() {
		return list_news;
	}

	public void setList_news(List<News> list_news) {
		this.list_news = list_news;
	}

	public int getSecSecID() {
		return secSecID;
	}

	public void setSecSecID(int secSecID) {
		this.secSecID = secSecID;
	}

	public int getSecFirstID() {
		return secFirstID;
	}

	public void setSecFirstID(int secFirstID) {
		this.secFirstID = secFirstID;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubDate() {
		return subDate;
	}

	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}

	public String getSecSecName() {
		return secSecName;
	}

	public void setSecSecName(String secSecName) {
		this.secSecName = secSecName;
	}

	public String getSecFirstName() {
		return secFirstName;
	}

	public void setSecFirstName(String secFirstName) {
		this.secFirstName = secFirstName;
	}

	private Map<String, Object> dataMap;

	/**
	 * 构造方法
	 */
	public NewsAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public List<SecFirst> getListFirst() {
		return listFirst;
	}

	public void setListFirst(List<SecFirst> listFirst) {
		this.listFirst = listFirst;
	}

	public List<SecSec> getListSec() {
		return listSec;
	}

	public void setListSec(List<SecSec> listSec) {
		this.listSec = listSec;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String searchNews() {
		// System.out.println(getKeyWords());

		all_num = SqlCount.countSearch(getKeyWords());
		page = judge(all_num, 10);

		if (getBegin_num() >= 10) {
			// System.out.println("getKeyWordsPage2:" + getKeyWordsPage2());
			list_news = SqlQuery.getNewsListBySearch(getBegin_num(), 10,
					getKeyWordsPage2());
			keyWords = getKeyWordsPage2();

			all_num = SqlCount.countSearch(getKeyWordsPage2());
			page = judge(all_num, 10);
		} else {
			if (getFrompage() == 1) {
				// System.out.println("getKeyWordsPage2:" + getKeyWordsPage2());
				list_news = SqlQuery.getNewsListBySearch(getBegin_num(), 10,
						getKeyWordsPage2());
				keyWords = getKeyWordsPage2();

				all_num = SqlCount.countSearch(getKeyWordsPage2());
				page = judge(all_num, 10);
			} else
				list_news = SqlQuery.getNewsListBySearch(getBegin_num(), 10,
						getKeyWords());
		}
		return SUCCESS;
	}

	public String deleteNews() {
		SqlDelete.delete("news", "newsID", getNewsID());
		SqlDelete.delete("fileinnews", "newsID", getNewsID());
		return SUCCESS;
	}

	public String changeIsTop() {
		SqlUpdate.change_status("isTop", getIsTop(), getNewsID());
		return SUCCESS;
	}

	public String changeCheck() {
		SqlUpdate.change_status("isChecked", getIsChecked(), getNewsID());
		// 如果在轮播数据库里也存在 该ID
		if (SqlQuery.CheckExist("picslider", "newsID",
				String.valueOf((getNewsID()))) == 1) {
			SqlUpdate.changePicstatus("isChecked", getIsChecked(), getNewsID());
		}
		// SqlUpdate.change_status("isChecked", getIsChecked(), getNewsID());
		return SUCCESS;
	}

	public String newsmodify() {

		return SUCCESS;
	}

	public String newslist() {
		// 如果不是超级管理员，只显示本部门消息。
		all_num = SqlCount.countAll("news");
		page = judge(all_num);
		list_news.removeAll(list_news);
		list_news = SqlQuery.getNewsList(getBegin_num(), 20, 0);
		System.out.println("&&&&&&&&&"+begin_num);
		return SUCCESS;
	}

	/**
	 * 添加新闻
	 * 
	 * @throws Exception
	 */
	public String newsAdd() throws Exception {
		// System.out.println("newsPublish");
		GetDate gd = new GetDate();
		String timeSql = gd.getDate();
		secSecID = Integer.valueOf(getSecSecName());
		secFirstID = Integer.valueOf(getSecFirstName());

		secSecName = SqlQuery.getTarget("section", "subNavName", "secID",
				String.valueOf(secSecID));
		secFirstName = SqlQuery.getTarget("section", "secName", "secID",
				String.valueOf(secFirstID));

		/** 上传附件 **/
		// System.out.println(getSavePath());
		// System.out.println(getUploadFileName());

		/**
		 * 第一种方法 // 以服务器的文件保存地址和原文件名建立上传文件输出流 FileOutputStream fos = new
		 * FileOutputStream(getSavePath() + "\\" + getUploadFileName()); /**end
		 * of part1
		 **/
		if (getUpload() != null) {
			// 有附件时
			SqlAdd.addNews(getAuthor(), getIsTop(), getNewsContent(),
					getNewsTitle(), secFirstName, secFirstID, secSecName,
					secSecID, timeSql, 1);
			/**
			 * 第一种方法 FileInputStream fis = new FileInputStream(getUpload());
			 * byte[] buffer = new byte[1024]; int len = 0; while ((len =
			 * fis.read(buffer)) > 0) { fos.write(buffer, 0, len); }
			 * fos.close();
			 **/
			/** 第二种上传方法 **/
			for (int i = 0; i < upload.size(); i++) {
				try {
					// System.out.println("getNewsTitle" + getNewsTitle());
					File file = new File(getSavePath());
					// System.out.println(getSavePath());
					FileUtils.copyFile(upload.get(i), new File(file,
							getUploadFileName().get(i)));
					int tempID = SqlQueryMax.query_max("news", "newsID");
					// System.out.println("newsID" + tempID);
					SqlAdd.addfileInNews(getUploadFileName().get(i),
							getNewsTitle(), tempID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			// System.out.println("空");
			// 无附件时
			SqlAdd.addNews(getAuthor(), getIsTop(), getNewsContent(),
					getNewsTitle(), secFirstName, secFirstID, secSecName,
					secSecID, timeSql, 0);

		}

		/** 添加轮播图片 **/

		int x = getPicLocation().lastIndexOf("/");
		if (x != -1) {
			int i = SqlQueryMax.query_max("news", "newsID");
			String s = getPicLocation().substring(x + 1);
			picOrder = SqlQueryMax.query_max("picslider", "picOrder");
			picOrder++;
			SqlAdd.addPicSlider(getPicLocation(), s, i, getNewsTitle(),
					picOrder);
		} else if (getPicSlider2().equals("NoPic") == false) {
			int i = SqlQueryMax.query_max("news", "newsID");
			String s = getPicSlider2().substring(x + 1);
			picOrder = SqlQueryMax.query_max("picslider", "picOrder");
			picOrder++;
			SqlAdd.addPicSlider(getPicLocation(), s, i, getNewsTitle(),
					picOrder);
		}
		return SUCCESS;
	}

	public String getMenu() {
		/*
		 * 在新闻发布页面中生成二级联动菜单
		 */
		/**
		 * 旧 listFirst = SqlQuery.getFirstSecList(1); listSec =
		 * SqlQuery.getSecSecList();
		 * 
		 * dataMap.clear(); dataMap.put("secFirst", listFirst);
		 * dataMap.put("secSec", listSec);
		 **/

		listSection = SqlQuery.getSectionList(1);
		// System.out.println("listSection"+listSection.size());
		listSubSection = SqlQuery.getSubSectionList();
		// System.out.println("listSubSection"+listSubSection.size());
		dataMap.clear();
		dataMap.put("secFirst", listSection);
		dataMap.put("secSec", listSubSection);

		// 放入一个是否操作成功的标识
		dataMap.put("success", true);

		return SUCCESS;
	}

	public String newsMod() {
		newsID = getNewsID();
		newsTitle = SqlQuery.getTarget("news", "newsTitle", "newsID",
				String.valueOf(newsID));
		newsContent = SqlQuery.getTarget("news", "newsContent", "newsID",
				String.valueOf(newsID));
		return SUCCESS;
	}

	public String newsUpdate() {
		GetDate gd = new GetDate();
		String timeSql = gd.getDate();

		SqlUpdate.updateNews(getAuthor(), getIsTop(), getNewsContent(),
				getNewsTitle(), getSecFirstName(), getSecSecName(),
				getSecFirstID(), getSecSecID(), getNewsID(), timeSql);
		return SUCCESS;
	}

	// 分页函数
	public int judge(int end_num, int eachPageNum) {
		int page_num;
		if (end_num % eachPageNum == 0) {
			page_num = end_num / eachPageNum;
		} else {
			page_num = end_num / eachPageNum + 1;
		}
		return page_num;
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

	public String getPicSliderList() {
		list = SqlQuery.getPicSliderList();
		gdpic = SqlQuery.getGdAddList();
	//	System.out.println(gdpic.size());
		return SUCCESS;
	}

	public String delPicSlider() {
		SqlDelete.delete("picslider", "picID", getPicID());
		return SUCCESS;
	}

	public String picSliderAdd() {

		int x = getPicLocation().lastIndexOf("/");
		String s = getPicLocation().substring(x + 1);
		SqlAdd.addPicSlider2(getPicLocation(), s, getHref(), getPicOrder());

		return SUCCESS;
	}

	public String picGdAdd() {
		SqlAdd.addGdPic(getPicLocation(), getHref(), getPicOrder());
		return SUCCESS;
	}

	public String getGdAddList() {
		// SqlAdd.addGdPic(getPicLocation(), getHref(), getPicOrder());
		
		return SUCCESS;
	}
	public String delGdPic(){
		SqlDelete.delete("picgd", "picID", getPicID());
		return SUCCESS;
	}

	public static void main(String[] args) {

	}

	List<GdPic> gdpic = new ArrayList<GdPic>();

	public List<GdPic> getGdpic() {
		return gdpic;
	}

	public void setGdpic(List<GdPic> gdpic) {
		this.gdpic = gdpic;
	}

}
