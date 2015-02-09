package com.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.Action.GetDate;
import com.Bean.FileInNews;
import com.Bean.GdPic;
import com.Bean.Link;
import com.Bean.News;
import com.Bean.PicSlider;
import com.Bean.SecFirst;
import com.Bean.SecSec;
import com.Bean.Section;
import com.Bean.TeaLea;
import com.Bean.TeacherLeader;

public class SqlQuery {

	/**
	 * 获得文章中附件列表
	 * **/
	public static List<FileInNews> getFileInNewsList(int newsID) {
		List<FileInNews> l = new ArrayList<FileInNews>();
		int num = SqlQueryMax.queryNumByLie("fileInNews", "newsID",
				String.valueOf(newsID));
		int i = 0;
		FileInNews fin[] = new FileInNews[num];
		int fileNID;
		String newsName, fileName;

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "select * from fileInNews where newsID=" + newsID;
			db.query(sql);
			while (db.next()) {
				fileNID = db.getIntValueByString("fileNID");
				newsName = db.getValue("newsName");
				fileName = db.getValue("fileName");

				fin[i] = new FileInNews();
				fin[i].setFileName(fileName);
				fin[i].setFileNID(fileNID);
				fin[i].setNewsName(newsName);
				l.add(fin[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 得到导航图片列表
	 * **/
	public static List<PicSlider> getPicSliderList() {
		List<PicSlider> list = new ArrayList<PicSlider>();

		int num;
		int num1 = SqlQueryMax.queryNumByLie("picslider", "isChecked", "1");
		int num2 = SqlQueryMax.queryNumByLie("picslider", "newsID", "-1");
		// System.out.println("num1" + num1);
		// System.out.println("num2" + num2);
		num = num1 + num2;
		PicSlider[] ps = new PicSlider[num];
		// PicSlider[] ps2 = new PicSlider[num2];

		SqlConnect db = new SqlConnect();
		int i = 0;

		int newsID, picID, picOrder;
		String picLocation, picName, href, newsTitle, isChecked;
		if (db.createConnection()) {
			String q = "select * from picslider order by picOrder";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				picOrder = db.getIntValueByString("picOrder");
				isChecked = db.getValue("isChecked");
				newsID = db.getIntValueByString("newsID");
				picID = db.getIntValueByString("picID");
				picLocation = db.getValue("picLocation");
				picName = db.getValue("picName");
				href = db.getValue("href");
				newsTitle = db.getValue("newsTitle");

				// System.out.println("i" + i);
				if (newsID == -1) {
					ps[i] = new PicSlider();
					ps[i].setHref(href);
					ps[i].setPicOrder(picOrder);
					ps[i].setNewsTitle(newsTitle);
					ps[i].setPicID(picID);
					ps[i].setPicLocation(picLocation);
					ps[i].setPicName(picName);
					ps[i].setNewsID(newsID);
					list.add(ps[i]);

				} else if (newsID != -1) {
					if (isChecked.equals("1")) {
						ps[i] = new PicSlider();
						int navID = Integer
								.valueOf(SqlQuery.get_target("news",
										"secFirstID", "newsID",
										String.valueOf(newsID)));
						int secID = Integer.valueOf(SqlQuery.get_target("news",
								"secSecID", "newsID", String.valueOf(newsID)));
						// System.out.println(navID);
						// System.out.println(secID);
						ps[i].setNavID(navID);
						ps[i].setSecID(secID);
						ps[i].setPicLocation(picLocation);
						ps[i].setHref(href);
						ps[i].setPicOrder(picOrder);
						ps[i].setNewsTitle(newsTitle);
						ps[i].setPicID(picID);
						ps[i].setPicName(picName);
						ps[i].setNewsID(newsID);
						list.add(ps[i]);
					}
				}
				i++;
			}
		}

		db.closeAll();
		return list;
	}

	/**
	 * 新 得到第二导航列表
	 * **/

	public static List<Section> getSubSectionList() {
		int secID, navOrder, conOrder, secIDforSub;
		String secName, secLocate, subNavName, isFirst, isNav, isContent, showUL;
		int n = SqlQueryMax.queryNumByLie("section", "isFirst", "N");
		// System.out.println("共有这么些二级导航：" + n);
		Section s[] = new Section[n];
		List<Section> l = new ArrayList<Section>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from section where isFirst='N' order by navOrder";
			db.query(q);
			while (db.next()) {
				showUL = db.getValue("showUL");
				secID = db.getIntValueByString("secID");
				navOrder = db.getIntValueByString("navOrder");
				conOrder = db.getIntValueByString("conOrder");
				secName = db.getValue("secName");
				subNavName = db.getValue("subNavName");
				secLocate = db.getValue("secLocate");
				isNav = db.getValue("isNav");
				isContent = db.getValue("isContent");
				isFirst = db.getValue("isFirst");
				secIDforSub = db.getIntValueByString("secIDforSub");
				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setNavOrder(navOrder);
				s[i].setConOrder(conOrder);
				s[i].setSecName(secName);
				s[i].setSubNavName(subNavName);
				s[i].setSecLocate(secLocate);
				s[i].setIsNav(isNav);
				s[i].setIsContent(isContent);
				s[i].setIsFirst(isFirst);
				s[i].setSecIDforSub(secIDforSub);
				s[i].setShowUL(showUL);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 得到第一导航列表 新
	 * 
	 * @param type
	 *            为0时将排除不是导航的模块 为1时选取所有的模块
	 * **/

	public static List<Section> getSectionList(int type) {

		int secID, navOrder, conOrder;
		String secName, secLocate, subNavName, isFirst, isNav, isContent;

		int n = 0;
		if (type == 0)
			n = SqlQueryMax.queryNumByLie("section", "isNav", "Y");
		else if (type == 1)
			n = SqlQueryMax.queryNum("section");
		else if (type == 2)
			n = SqlQueryMax.queryNumByLie("section", "isNav", "N");
		// System.out.println("共有这么些导航：" + n);
		Section s[] = new Section[n];
		List<Section> l = new ArrayList<Section>();
		int i = 0;
		String q = null;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {

			if (type == 0)
				q = "select * from section where isNav='Y' and isFirst='Y' order by navOrder";
			else if (type == 1)
				q = "select * from section where isFirst='Y' order by navOrder";
			else if (type == 2)
				q = "select * from section where isFirst='Y' and isNav='N' order by navOrder";
			db.query(q);
			while (db.next()) {
				secID = db.getIntValueByString("secID");
				navOrder = db.getIntValueByString("navOrder");
				conOrder = db.getIntValueByString("conOrder");
				secName = db.getValue("secName");
				secLocate = db.getValue("secLocate");
				subNavName = db.getValue("subNavName");
				isFirst = db.getValue("isFirst");
				isNav = db.getValue("isNav");
				isContent = db.getValue("isContent");

				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setNavOrder(navOrder);
				s[i].setConOrder(conOrder);
				s[i].setSecName(secName);
				s[i].setSecLocate(secLocate);
				s[i].setSubNavName(subNavName);
				s[i].setIsFirst(isFirst);
				s[i].setIsNav(isNav);
				s[i].setIsContent(isContent);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 得到新闻列表
	 * 
	 * @param sectionID
	 *            第一导航 版块ID
	 * @param c
	 *            c=1第一导航,c=2第二导航
	 * @throws ParseException
	 * 
	 * **/
	public static List<News> getLatestNewsList() throws ParseException {
		// int arraylength = end - start;

		// int listLength = SqlCount.countAll("news");
		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[15];

		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, modAuthor, modDate, secSecName, isChecked, secFirstName, isTop, titleFake = null, latest;
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check = null;
			check = "select * from news where notSee=0 and isChecked=1 ORDER BY subDate DESC limit 0,9";
			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				modAuthor = db.getValue("modAuthor");
				modDate = db.getValue("modDate");
				secSecName = db.getValue("secSecName");
				isChecked = db.getValue("isChecked");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");
				titleFake = newsTitle;

				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date datePub = sdf.parse(subDate);
				long jg = (dateNow.getTime() - datePub.getTime())
						/ (1000 * 60 * 24 * 60);
				if (jg < 2) {
					latest = "newer";
				} else {
					latest = "older";
				}
				// System.out.println(secFirstID);
				if (newsTitle.length() >= 16) {
					newsTitle = newsTitle.substring(0, 16);
				}
				newsTitle=newsTitle+"...";
				subDate = subDate.substring(0, 10);
				// System.out.println(subDate);
				hw[i] = new News();
				hw[i].setLatest(latest);
				hw[i].setNewsID(newsID);
				hw[i].setReadTimes(readTimes);
				hw[i].setSecSecID(secSecID);
				hw[i].setSecFirstID(secFirstID);
				hw[i].setNewsTitle(newsTitle);
				hw[i].setNewsContent(newsContent);
				hw[i].setAuthor(author);
				hw[i].setSubDate(subDate);
				hw[i].setModAuthor(modAuthor);
				hw[i].setModDate(modDate);
				hw[i].setSecSecName(secSecName);
				hw[i].setIsChecked(isChecked);
				hw[i].setSecFirstName(secFirstName);
				hw[i].setIsTop(isTop);
				hw[i].setTitleFake(titleFake);
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * 得到快速链接列表
	 * **/

	public static List<Link> getLinkList() {
		int webID, visitTimes;
		String webName, webAddr;
		int n = SqlQueryMax.queryNum("link");
		// System.out.println("共有这么些导航：" + n);
		Link link[] = new Link[n];
		List<Link> l = new ArrayList<Link>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from link order by linkOrder";
			db.query(q);
			while (db.next()) {
				webID = db.getIntValueByString("webID");
				visitTimes = db.getIntValueByString("visitTimes");
				webName = db.getValue("webName");
				webAddr = db.getValue("webAddr");

				link[i] = new Link();
				link[i].setWebAddr(webAddr);
				link[i].setVisitTimes(visitTimes);
				link[i].setWebID(webID);
				link[i].setWebName(webName);
				l.add(link[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 查询含有某个关键词的新闻共有多少个
	 * **/
	public static int getNewsListBySearch(String keywords, int secID) {

		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = null;
			if (secID == 0) {
				s = "select count(*) as num from news where newsTitle LIKE  '%"
						+ keywords + "%' order by subDate desc";
			} else {
				s = "select count(*) as num from news where secFirstID="
						+ secID + " and newsTitle LIKE  '%" + keywords
						+ "%' order by subDate desc";
			}
			// System.out.println(s);
			db.query(s);
			while (db.next()) {
				i = db.getIntValueByString("num");
			}
		}
		db.closeAll();
		return i;
	}

	// 通过搜索关键字得到新闻列表
	public static List<News> getNewsListBySearch(int start, int num,
			String keyWords, int secID) {
		// int arraylength = end - start;

		int listLength = SqlCount.countAll("news");
		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, secSecName, secFirstName, isTop, titleFake = null;
		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[listLength];
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check;
			if (secID == 0) {
				check = "select * from news where  notSee=0 and  newsTitle LIKE  '%"
						+ keyWords
						+ "%' order by subDate desc  limit "
						+ start
						+ "," + num;
			} else {
				check = "select * from news where notSee=0 and  secFirstID="
						+ secID + " and newsTitle LIKE  '%" + keyWords
						+ "%' order by subDate desc  limit " + start + ","
						+ num;
			}
			// System.out.println(check);
			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				secSecName = db.getValue("secSecName");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");
				if (newsTitle.length() >= 18) {
					// System.out.println(newsTitle.length());
					titleFake = newsTitle.substring(0, 18);
				}
				subDate = subDate.substring(0, 10);
				// 将实例对象加入到list中去
				hw[i] = new News();
				hw[i] = new News();
				hw[i].setNewsID(newsID);
				hw[i].setReadTimes(readTimes);
				hw[i].setSecSecID(secSecID);
				hw[i].setSecFirstID(secFirstID);
				hw[i].setNewsTitle(newsTitle);
				hw[i].setNewsContent(newsContent);
				hw[i].setAuthor(author);
				hw[i].setSubDate(subDate);
				hw[i].setSecSecName(secSecName);
				hw[i].setSecFirstName(secFirstName);
				hw[i].setIsTop(isTop);
				hw[i].setTitleFake(titleFake);
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * 
	 * **/
	public static News getNews(int ID) {

		News hw = new News();
		SqlConnect db = new SqlConnect();
		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, secSecName, secFirstName, isTop;
		if (db.createConnection()) {
			String check;
			check = "select * from news where newsID=" + ID;

			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				secSecName = db.getValue("secSecName");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");
				// readTimes++;
				subDate = subDate.substring(0, 19);
				hw.setNewsID(newsID);
				hw.setReadTimes(readTimes);
				hw.setSecSecID(secSecID);
				hw.setSecFirstID(secFirstID);
				hw.setNewsTitle(newsTitle);
				hw.setNewsContent(newsContent);
				hw.setAuthor(author);
				hw.setSubDate(subDate);
				hw.setSecSecName(secSecName);
				hw.setSecFirstName(secFirstName);
				hw.setIsTop(isTop);
			}
		}
		db.closeAll();
		return hw;
	}

	/**
	 * 查询某个导航ID下有多少新闻 flag为1时，一级导航 flag为2时，二级导航
	 * **/
	public static int getNewsListNav(int flag, int ID) {

		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = null;
			if (flag == 1)
				s = "select count(*) AS num from news where isChecked=1 and secFirstID="
						+ ID;
			if (flag == 2)
				s = "select count(*) AS num from news where isChecked=1 and secSecID="
						+ ID;
			db.query(s);
			while (db.next()) {
				i = db.getIntValueByString("num");
			}
		}
		db.closeAll();
		return i;

	}

	/**
	 * 二级页面中得到新闻列表。需要只得到前X个，所以重新写函数。
	 * 
	 * @param sectionID
	 *            第一导航 版块ID
	 * @param c
	 *            c=1第一导航,c=2第二导航,c=3为查询第一导航下的置顶消息,c=4为查询第二导航下的置顶消息
	 * 
	 * **/
	public static List<News> getNewsListSub(int sectionID, int c, int start,
			int num) {
		// int arraylength = end - start;

		int listLength = SqlCount.countAll("news");
		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[listLength];

		int newsID, readTimes, secSecID, secFirstID, haveFile;
		String newsTitle, newsContent, author, subDate, modAuthor, modDate, secSecName, isChecked, secFirstName, isTop, titleFake = null;
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check = null;
			if (c == 1) {
				check = "select * from news where notSee=0 and  secFirstID="
						+ sectionID
						+ " and isChecked=1 and isTop='0' ORDER BY subDate DESC LIMIT "
						+ start + "," + num;
			} else if (c == 2) {
				check = "select * from news where notSee=0 and  secSecID="
						+ sectionID
						+ " and isChecked=1 and isTop='0'  ORDER BY subDate DESC LIMIT "
						+ start + "," + num;
			} else if (c == 3) {
				check = "select * from news where notSee=0 and  secFirstID="
						+ sectionID
						+ " and isChecked=1 and isTop='1'  ORDER BY subDate DESC LIMIT "
						+ start + "," + num;
			} else if (c == 4) {
				check = "select * from news where  notSee=0 and secSecID="
						+ sectionID
						+ " and isChecked=1 and isTop='1'  ORDER BY subDate DESC LIMIT "
						+ start + "," + num;
			}
			// System.out.println(check);
			db.query(check);
			while (db.next()) {
				haveFile = db.getIntValueByString("haveFile");
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				modAuthor = db.getValue("modAuthor");
				modDate = db.getValue("modDate");
				secSecName = db.getValue("secSecName");
				isChecked = db.getValue("isChecked");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");
				if (newsTitle.length() >= 18) {
					// System.out.println(newsTitle + "  " +
					// newsTitle.length());
					titleFake = newsTitle.substring(0, 18);
				}
				subDate = subDate.substring(0, 10);
				// System.out.println(subDate);
				hw[i] = new News();
				hw[i].setNewsID(newsID);
				hw[i].setReadTimes(readTimes);
				hw[i].setSecSecID(secSecID);
				hw[i].setSecFirstID(secFirstID);
				hw[i].setNewsTitle(newsTitle);
				hw[i].setNewsContent(newsContent);
				hw[i].setAuthor(author);
				hw[i].setSubDate(subDate);
				hw[i].setSecSecName(secSecName);
				hw[i].setSecFirstName(secFirstName);
				hw[i].setIsTop(isTop);
				hw[i].setTitleFake(titleFake);
				hw[i].setHaveFile(haveFile);
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * 旧
	 * 
	 * 得到第二导航列表
	 * **/

	public static List<SecSec> getSecSecListByFirstID(int firstId) {
		int secID, firstID, orders;
		String secName, firstName;
		int n = SqlQueryMax.queryNumByLie("secondsec", "firstID",
				String.valueOf(firstId));
		// System.out.println("该ID下共有这么些二级导航：" + n);
		SecSec s[] = new SecSec[n];
		List<SecSec> l = new ArrayList<SecSec>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from secondSec where firstID=" + firstId
					+ " order by orders ";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				secID = db.getIntValueByString("secID");
				firstID = db.getIntValueByString("firstID");
				orders = db.getIntValueByString("orders");
				secName = db.getValue("secName");
				firstName = db.getValue("firstName");

				s[i] = new SecSec();
				s[i].setFirstID(firstID);
				s[i].setFirstName(firstName);
				s[i].setOrders(orders);
				s[i].setSecID(secID);
				s[i].setSecName(secName);

				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * @param table
	 *            表名
	 * @param lie_target
	 *            需要获取内容的目标列
	 * @param lie
	 *            根据
	 * @param content
	 *            依据内容
	 * 
	 *            table表名 lie_target需要获取内容的目标列 lie依据列 content依据列的内容
	 * 
	 * **/
	public static String get_target(String table, String lie_target,
			String lie, String content) {
		String temp_post = null;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String query = "select * from " + table + " where " + lie + "='"
					+ content + "'";
			db.query(query);
			// System.out.println(query);
			while (db.next()) {
				temp_post = db.getValue(lie_target);
			}
		}
		db.closeAll();
		return temp_post;
	}

	/**
	 * 
	 * 在页面中的版块
	 * 
	 * 
	 * 加滚动图片之前
	 * **/

	public static List<Section> getContentSectionList(String leftright) {

		int secID, navOrder, conOrder, secIDforSub;
		String secName, secLocate, subNavName, isFirst, isNav, isContent;

		int n = SqlQueryMax.queryNumByLie("section", "isContent", "Y");
		// System.out.println("共有这么些导航：" + n);
		Section s[] = new Section[n];
		List<Section> l = new ArrayList<Section>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q;
			q = "select * from section  where isContent='Y' and secLocate='"
					+ leftright + "'  order by conOrder ";
			db.query(q);
			while (db.next()) {
				isFirst = db.getValue("isFirst");
				secID = db.getIntValueByString("secID");
				secIDforSub = db.getIntValueByString("secIDforSub");
				secName = db.getValue("secName");
				subNavName = db.getValue("subNavName");

				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setSecIDforSub(secIDforSub);
				if (isFirst.equals("N")) {
					s[i].setContentName(subNavName);
				} else {
					s[i].setContentName(secName);
				}
				s[i].setIsFirst(isFirst);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 旧 得到第二导航列表
	 * **/

	public static List<SecSec> getSecSecList() {
		int secID, firstID, orders;
		String secName, firstName;
		int n = SqlQueryMax.queryNum("secondSec");
		// System.out.println("共有这么些导航：" + n);
		SecSec s[] = new SecSec[n];
		List<SecSec> l = new ArrayList<SecSec>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from secondSec order by orders";
			db.query(q);
			while (db.next()) {
				secID = db.getIntValueByString("secID");
				firstID = db.getIntValueByString("firstID");
				orders = db.getIntValueByString("orders");
				secName = db.getValue("secName");
				firstName = db.getValue("firstName");

				s[i] = new SecSec();
				s[i].setFirstID(firstID);
				s[i].setFirstName(firstName);
				s[i].setOrders(orders);
				s[i].setSecID(secID);
				s[i].setSecName(secName);

				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * 旧 得到第一导航列表
	 * **/

	public static List<SecFirst> getFirstSecList() {
		String firstSectionName, isNav, isContent, secLocate;
		int orders, firstID;
		int n = SqlQueryMax.queryNumByLie("firstSec", "isNav", "yes");
		// System.out.println("共有这么些导航：" + n);
		SecFirst s[] = new SecFirst[n];
		List<SecFirst> l = new ArrayList<SecFirst>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from firstSec  where isNav='yes'  order by orders";
			db.query(q);
			while (db.next()) {
				firstID = db.getIntValueByString("firstID");
				orders = db.getIntValueByString("orders");
				firstSectionName = db.getValue("firstSectionName");

				isContent = db.getValue("isContent");
				isNav = db.getValue("isNav");
				secLocate = db.getValue("secLocate");

				s[i] = new SecFirst();
				s[i].setFirstID(firstID);
				s[i].setFirstSectionName(firstSectionName);
				s[i].setOrders(orders);
				s[i].setIsContent(isContent);
				s[i].setIsNav(isNav);
				s[i].setSecLocate(secLocate);

				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	// Login...
	public static String loginAction(String username, String password) {
		SqlConnect db = new SqlConnect();

		String result = null;
		if (db.createConnection()) {
			String temp_psw;
			String query = "select * from adminUser where username='"
					+ username + "'";
			db.query(query);
			if (db.next()) {
				temp_psw = db.getValue("password");
				if (password.equals(temp_psw)) {
					result = "yes";
				} else {
					result = "no";
				}
			} else {
				result = "wa";// WrongAccount
			}
		}
		db.closeAll();
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String temp = "select * from User where username='43'";
			db.query(temp);
			if (db.next()) {
				System.out.println("存在");
			} else {
				System.out.println("不存在");
			}
		}
	}

	/**
	 * 查询哪些版块显示在内容版块中
	 * 
	 * **/
	public static List<Integer> getisContent() {
		List<Integer> list = new ArrayList<Integer>();
		int num = SqlQueryMax.queryNumByLie("section", "isContent", "Y");
		int is[] = new int[num];
		int i = 0, isContent;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "SELECT secID FROM section where isContent='Y'";
			db.query(q);
			while (db.next()) {
				isContent = db.getIntValueByString("secID");
				// System.out.println(isContent);
				list.add(isContent);
			}
		}
		db.closeAll();
		return list;
	}

	/**
	 * 新 查询哪些版块显示在内容版块中
	 * 
	 * **/
	public static List<Section> getisContentSection() {
		List<Section> list = new ArrayList<Section>();
		int num = SqlQueryMax.queryNumByLie("section", "isContent", "Y");
		Section s[] = new Section[num];
		String isFirst;
		int i = 0, isContent, secID, secIDforSub;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "SELECT * FROM section where isContent='Y'";
			db.query(q);
			while (db.next()) {
				secID = db.getIntValueByString("secID");
				secIDforSub = db.getIntValueByString("secIDforSub");
				isFirst = db.getValue("isFirst");

				// System.out.println("secIDforSub " + secIDforSub);
				// System.out.println("isFirst  " + isFirst);

				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setSecIDforSub(secIDforSub);
				s[i].setIsFirst(isFirst);

				list.add(s[i]);
				i++;
			}
		}
		db.closeAll();
		// System.out.println(list.size());
		return list;
	}

	/**
	 * 得到新闻列表
	 * 
	 * @param sectionID
	 *            第一导航 版块ID
	 * @param c
	 *            c=1第一导航,c=2第二导航
	 * @throws ParseException
	 * 
	 * **/
	public static List<News> getNewsList(int sectionID, int c)
			throws ParseException {
		// int arraylength = end - start;

		int listLength = SqlCount.countAll("news");
		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[listLength];

		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, modAuthor, modDate, secSecName, isChecked, secFirstName, isTop, titleFake = null, latest;
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check = null;
			if (c == 1) {
				check = "select * from news where notSee=0 and  secFirstID="
						+ sectionID
						+ " and isChecked=1 ORDER BY subDate DESC limit 0,8";
			} else if (c == 2) {
				check = "select * from news where notSee=0 and  secSecID="
						+ sectionID
						+ " and isChecked=1 ORDER BY subDate DESC limit 0,8";
			}
			// System.out.println(check);
			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				modAuthor = db.getValue("modAuthor");
				modDate = db.getValue("modDate");
				secSecName = db.getValue("secSecName");
				isChecked = db.getValue("isChecked");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");

				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date datePub = sdf.parse(subDate);
				long jg = (dateNow.getTime() - datePub.getTime())
						/ (1000 * 60 * 24 * 60);
				if (jg < 2) {
					latest = "newer";
				} else {
					latest = "older";
				}
				titleFake = newsTitle;
				if (newsTitle.length() >= 16) {
					newsTitle = newsTitle.substring(0, 16);
				}
				subDate = subDate.substring(5, 10);
				// System.out.println(subDate);
				hw[i] = new News();
				hw[i].setLatest(latest);
				hw[i].setNewsID(newsID);
				hw[i].setReadTimes(readTimes);
				hw[i].setSecSecID(secSecID);
				hw[i].setSecFirstID(secFirstID);
				hw[i].setNewsTitle(newsTitle);
				hw[i].setNewsContent(newsContent);
				hw[i].setAuthor(author);
				hw[i].setSubDate(subDate);
				// hw[i].setLatest(dayNum);
				hw[i].setModAuthor(modAuthor);
				hw[i].setModDate(modDate);
				hw[i].setSecSecName(secSecName);
				hw[i].setIsChecked(isChecked);
				hw[i].setSecFirstName(secFirstName);
				hw[i].setIsTop(isTop);
				hw[i].setTitleFake(titleFake);
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * 得到某一级导航ID下的二级导航（显示在侧边栏）
	 * **/
	public static List<Section> getSubSectionListByFirstID(int navID) {
		// TODO Auto-generated method stub

		int secID, navOrder, conOrder, secIDforSub;
		String secName, secLocate, subNavName, isFirst, isNav, isContent, showUL;

		int n = SqlQueryMax.queryNumByLie("section", "secIDforSub",
				String.valueOf(navID));
		// System.out.println("该一级导航ID下共有这么些二级导航：" + n);
		Section s[] = new Section[n];
		List<Section> l = new ArrayList<Section>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from section where secIDforSub=" + navID
					+ " order by navOrder ";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				showUL = db.getValue("showUL");
				secID = db.getIntValueByString("secID");
				navOrder = db.getIntValueByString("navOrder");
				secIDforSub = db.getIntValueByString("secIDforSub");
				secName = db.getValue("secName");
				subNavName = db.getValue("subNavName");
				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setNavOrder(navOrder);
				s[i].setSecIDforSub(secIDforSub);
				s[i].setSecName(secName);
				s[i].setSubNavName(subNavName);
				s[i].setShowUL(showUL);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * @param table
	 *            table:The table you want to query.
	 * @param lie
	 *            This is you want to know.
	 * @param lie_data
	 *            Before your query, you should know this first.
	 * @param lie2
	 *            This is you want to know.
	 * @param lie_data2
	 *            Before your query, you should know this first.
	 * **/
	public static int queryTargetNum(String table, String lie, String lie_data,
			String lie2, String lie_data2) {
		// TODO Auto-generated method stub
		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = "select count(*) AS num from " + table + " where " + lie
					+ "='" + lie_data + "' and " + lie2 + "='" + lie_data2
					+ "'";
			// System.out.println(s);
			db.query(s);
			while (db.next()) {
				i = db.getIntValueByString("num");
			}
		}
		db.closeAll();
		return i;
	}

	/** 获取两个时间间隔 */
	public static long getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);

			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);

			// 这里精确到了秒，我们可以在做差的时候将时间精确到天
		} catch (Exception e) {
		}
		return day;
	}

	// 永远读取最新的消息，即简介
	public static News getIntroduction(int secID) {
		// TODO Auto-generated method stub

		News hw = new News();
		SqlConnect db = new SqlConnect();
		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, secSecName, secFirstName, isTop;
		if (db.createConnection()) {
			String check;
			check = "select * from news where secSecID=" + secID + " limit 0,1";

			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");
				readTimes = db.getIntValueByString("readTimes");
				secSecID = db.getIntValueByString("secSecID");
				secFirstID = db.getIntValueByString("secFirstID");
				newsTitle = db.getValue("newsTitle");
				newsContent = db.getValue("newsContent");
				author = db.getValue("author");
				subDate = db.getValue("subDate");
				secSecName = db.getValue("secSecName");
				secFirstName = db.getValue("secFirstName");
				isTop = db.getValue("isTop");
				// readTimes++;
				subDate = subDate.substring(0, 19);
				hw.setNewsID(newsID);
				hw.setReadTimes(readTimes);
				hw.setSecSecID(secSecID);
				hw.setSecFirstID(secFirstID);
				hw.setNewsTitle(newsTitle);
				hw.setNewsContent(newsContent);
				hw.setAuthor(author);
				hw.setSubDate(subDate);
				hw.setSecSecName(secSecName);
				hw.setSecFirstName(secFirstName);
				hw.setIsTop(isTop);
			}
		}
		db.closeAll();
		return hw;
	}

	public static List<TeacherLeader> getTL(int tltype) {
		// TODO Auto-generated method stub
		List<TeacherLeader> tlList = new ArrayList<TeacherLeader>();
		int i = 0, num;
		num = SqlQueryMax.queryNumByLie("teacherLeader", "tlType",
				String.valueOf(tltype));
		// System.out.println("num" + num);
		TeacherLeader tl[] = new TeacherLeader[num];
		String tlName;
		int tlID;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String s = "select * from teacherLeader where tlType=" + tltype
					+ "  order by tlOrder ";
			db.query(s);
			while (db.next()) {
				tlName = db.getValue("tlName");
				tlID = db.getIntValueByString("tlID");

				tl[i] = new TeacherLeader();
				tl[i].setTlID(tlID);
				tl[i].setTlName(tlName);

				tlList.add(tl[i]);
				i++;
			}
		}
		db.closeAll();
		return tlList;
	}

	public static List<TeaLea> getTeacher_LeaderList(String table) {
		// TODO Auto-generated method stub
		List<TeaLea> list = new ArrayList<TeaLea>();
		int num = SqlCount.countAll(table);
		// System.out.println("共有这么多个：" + num);
		TeaLea tl[] = new TeaLea[num];

		int teaLeaID, tlID;
		String teaLeaName, teaLeaProfile, tlName;

		int i = 0;
		SqlConnect db = new SqlConnect();
		String sql = null;
		if (db.createConnection()) {
			sql = "select * from " + table + " order by teaLeaID";
			db.query(sql);
			while (db.next()) {
				tlID = db.getIntValueByString("tlID");
				teaLeaID = db.getIntValueByString("teaLeaID");
				// teaLeaBelong = db.getIntValueByString("teaLeaBelong");
				teaLeaName = db.getValue("teaLeaName");
				teaLeaProfile = db.getValue("teaLeaProfile");
				tlName = db.getValue("tlName");

				tl[i] = new TeaLea();
				tl[i].setTeaLeaID(teaLeaID);
				tl[i].setTeaLeaName(teaLeaName);
				tl[i].setTeaLeaProfile(teaLeaProfile);
				tl[i].setTlID(tlID);
				tl[i].setTlName(tlName);
				list.add(tl[i]);

				i++;
			}
		}
		return list;
	}

	public static TeaLea getTlInfo(int isTL, int teaLeaID) {
		// TODO Auto-generated method stub

		String table = null;
		TeaLea tl = new TeaLea();
		SqlConnect db = new SqlConnect();

		int tlID;
		String teaLeaName, teaLeaProfile, tlName;

		if (db.createConnection()) {
			String check;
			if (isTL == 1) {
				table = "teacher";
			} else
				table = "leader";
			check = "select * from " + table + " where teaLeaID=" + teaLeaID;
			// System.out.println(check);
			db.query(check);
			while (db.next()) {
				teaLeaProfile = db.getValue("teaLeaProfile");
				tlName = db.getValue("tlName");
				teaLeaName = db.getValue("teaLeaName");
				tlID = db.getIntValueByString("tlID");

				tl.setTeaLeaProfile(teaLeaProfile);
				tl.setTlName(tlName);
				tl.setTeaLeaName(teaLeaName);
				tl.setTlID(tlID);
			}
		}
		db.closeAll();
		return tl;
	}

	// 获取滚动图片
	public static List<GdPic> getGdAddList() {
		// TODO Auto-generated method stub
		List<GdPic> list = new ArrayList<GdPic>();
		int num = SqlCount.countAll("picgd");
		// System.out.println("共有这么多个：" + num);
		GdPic g[] = new GdPic[num];

		int picID, picOrder;
		String href, picLocation;

		int i = 0;
		SqlConnect db = new SqlConnect();
		String sql = null;
		if (db.createConnection()) {
			sql = "select * from picgd order by picOrder";
			db.query(sql);
			while (db.next()) {
				picID = db.getIntValueByString("picID");
				picOrder = db.getIntValueByString("picOrder");
				href = db.getValue("href");
				picLocation = db.getValue("picLocation");

				// System.out.println(href);

				g[i] = new GdPic();
				g[i].setHref(href);
				g[i].setPicID(picID);
				g[i].setPicLocation(picLocation);
				g[i].setPicOrder(picOrder);
				list.add(g[i]);
				i++;
			}
		}
		return list;
	}

	public static List<Section> getSection(int conOrder, String leftright) {
		// TODO Auto-generated method stub

		int secID, navOrder, secIDforSub;
		String secName, secLocate, subNavName, isFirst, isNav, isContent;

		int n = SqlQueryMax.queryNumByLie("section", "isContent", "Y");
		// System.out.println("共有这么些导航：" + n);
		Section s[] = new Section[n];
		List<Section> l = new ArrayList<Section>();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q;
			q = "select * from section  where conOrder="
					+ conOrder + " and isContent='Y' and secLocate='"
					+ leftright + "'  order by conOrder ";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				isFirst = db.getValue("isFirst");
				secID = db.getIntValueByString("secID");
				secIDforSub = db.getIntValueByString("secIDforSub");
				secName = db.getValue("secName");
				subNavName = db.getValue("subNavName");

				// System.out.println(subNavName);
				s[i] = new Section();
				s[i].setSecID(secID);
				s[i].setSecIDforSub(secIDforSub);
				if (isFirst.equals("N")) {
					s[i].setContentName(subNavName);
				} else {
					s[i].setContentName(secName);
				}
				s[i].setIsFirst(isFirst);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	public static Section getSection2() {
		// TODO Auto-generated method stub

		int secID, navOrder, secIDforSub;
		String secName, secLocate, subNavName, isFirst, isNav, isContent;

		// System.out.println("共有这么些导航：" + n);
		Section s = new Section();
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q;
			q = "select * from section  where showUL='2' and isContent='Y' limit 0,1";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				isFirst = db.getValue("isFirst");
				secID = db.getIntValueByString("secID");
				secIDforSub = db.getIntValueByString("secIDforSub");
				secName = db.getValue("secName");
				subNavName = db.getValue("subNavName");

				if (isFirst.equals("N"))
					s.setContentName(subNavName);
				else
					s.setContentName(secName);
				// System.out.println(subNavName);
				s.setSecID(secID);
				s.setSecIDforSub(secIDforSub);
				if (isFirst.equals("N")) {
					s.setContentName(subNavName);
				} else {
					s.setContentName(secName);
				}
				s.setIsFirst(isFirst);
			}
		}
		return s;
	}

	public static String getShortNews(int secID, String isFirst) {
		// TODO Auto-generated method stub
		String n = null;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String s;
			if (isFirst.equals("N"))
				s = "select * from news where secSecID=" + secID + " limit 0,1";
			else
				s = "select * from news where secFirstID=" + secID
						+ " limit 0,1";
			db.query(s);
			while (db.next()) {
				n = db.getValue("newsContent");
				// n = n.substring(0, 20);
			}
		}
	//	System.out.println("n   " + n);
		if (n == null) {
			n="空";
		//	System.out.println("空");
		} else {
			n = eraseP(n);
			if (n.length() > 130)
				n = n.substring(0, 130);
		//	System.out.println("否");
		}
		return n;
	}

	// 清除shortNews里面的代码
	@SuppressWarnings("null")
	public static String eraseP(String text) {
		String str = "";
		int num = 0, check;
		if (text == null) {

		//	System.out.println(text + "   " + text.length());
			check = text.indexOf("<p");

			if (check == 0) {
				num++;
			} else {
				check = 0;
			}

			while (check != -1) {
				check = text.indexOf("<p", check + 1);
				num++;
			}

			num--;
			// System.out.println(num);
			String strArr[] = new String[num];
			int start = 0;
			for (int s = 0; s < num; s++) {
				start = text.indexOf("\">", start);
				int end = text.indexOf("</p>", start);
				strArr[s] = text.substring(start + 2, end);
				start++;
			}

			for (int kk = 0; kk < strArr.length; kk++) {
				str += strArr[kk];
			}
			return str;
		} else
			return str;
	}
}
