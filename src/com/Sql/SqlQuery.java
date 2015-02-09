package com.Sql;

import java.util.ArrayList;
import java.util.List;

import com.Action.TeacherORLeaderAction;
import com.Bean.FileClass;
import com.Bean.Files;
import com.Bean.GdPic;
import com.Bean.Link;
import com.Bean.Log;
import com.Bean.News;
import com.Bean.PicSlider;
import com.Bean.SecFirst;
import com.Bean.SecSec;
import com.Bean.Section;
import com.Bean.TeaLea;
import com.Bean.User;

public class SqlQuery {

	/**
	 * 得到LogList 登录列表
	 * **/
	public static List<Log> getLogList(int begin, int num) {
		int listLength = SqlCount.countAll("loginlog");
		Log log[] = new Log[listLength];
		List<Log> list = new ArrayList<Log>();
		int templogID, tempID, i = 0;
		String tempDate, tempUsername, loginIP;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String temp_query = "select * from loginlog order by loginTime DESC limit "
					+ begin + "," + num;
			// System.out.println(temp_query);
			db.query(temp_query);
			while (db.next()) {
				templogID = db.getIntValueByString("logID");
				tempID = db.getIntValueByString("adminID");
				tempDate = db.getValue("loginTime");
				tempUsername = db.getValue("adminName");
				loginIP = db.getValue("loginIP");
				log[i] = new Log();
				log[i].setLogID(templogID);
				log[i].setUserID(tempID);
				log[i].setLogTime(tempDate);
				log[i].setUserName(tempUsername);
				log[i].setLoginIP(loginIP);
				list.add(log[i]);
			}
		}
		db.closeAll();
		return list;
	}

	/** 资源 **/

	// 得到文件列表
	public static List<Files> getFileList(int start, int num) {
		// int arraylength = end - start;

		int fileID;
		String fileName, fileInfo, up_Date, author, classify;
		int downTimes;
		int listLength = SqlCount.countAll("file");
		List<Files> listFile = new ArrayList<Files>();// 公告列表
		Files hw[] = new Files[listLength];
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check = "select * from file order by up_Date desc  limit "
					+ start + "," + num + " ";
			db.query(check);
			while (db.next()) {
				fileID = db.getIntValue(1);
				downTimes = db.getIntValue(6);
				fileName = db.getValue("fileName");
				fileInfo = db.getValue("fileInfo");
				up_Date = db.getValue("up_Date");
				author = db.getValue("author");
				classify = db.getValue("classify");
				// 将实例对象加入到list中去
				hw[i] = new Files();
				hw[i].setFileID(fileID);
				hw[i].setDownTimes(downTimes);
				hw[i].setFileName(fileName);
				hw[i].setFileInfo(fileInfo);
				hw[i].setUp_Date(up_Date);
				hw[i].setAuthor(author);
				hw[i].setClassify(classify);
				listFile.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listFile;
	}

	// 得到资源分类
	public static List<FileClass> getFileClass() {
		List<FileClass> list_class = new ArrayList<FileClass>();
		int tempID;
		String tempName;
		int listLength = SqlCount.countAll("fileclass");
		FileClass fc[] = new FileClass[listLength];
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String query = "select * from fileclass";
			db.query(query);
			while (db.next()) {
				tempID = db.getIntValueByString("id");
				tempName = db.getValue("name");
				fc[i] = new FileClass();
				fc[i].setId(tempID);
				fc[i].setName(tempName);
				list_class.add(fc[i]);
			}

		}
		db.closeAll();
		return list_class;
	}

	public static boolean isExist(String table, String col, String content) {

		boolean isExist = false;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String q = "select * from " + table + " where " + col + " = '"
					+ content + "'";
			// System.out.println(q);
			if (db.next())
				isExist = true;
			else
				isExist = false;

			// System.out.println(isExist);
		}
		db.closeAll();
		return isExist;
	}

	/**
	 * 得到导航图片列表
	 * **/
	public static List<PicSlider> getPicSliderList() {
		List<PicSlider> list = new ArrayList<PicSlider>();

		int num = SqlQueryMax.queryNum("picslider");
		PicSlider[] ps = new PicSlider[num];
		SqlConnect db = new SqlConnect();
		int i = 0;

		int newsID, picID, picOrder;
		String picLocation, picName, href, newsTitle;
		if (db.createConnection()) {
			String q = "select * from picslider order by picOrder";
			// System.out.println(q);
			db.query(q);
			while (db.next()) {
				picOrder = db.getIntValueByString("picOrder");
				newsID = db.getIntValueByString("newsID");
				picID = db.getIntValueByString("picID");
				picLocation = db.getValue("picLocation");
				picName = db.getValue("picName");
				href = db.getValue("href");
				newsTitle = db.getValue("newsTitle");
				ps[i] = new PicSlider();
				ps[i].setHref(href);
				ps[i].setPicName(picName);
				ps[i].setPicLocation(picLocation);
				ps[i].setPicID(picID);
				ps[i].setNewsID(newsID);
				ps[i].setNewsTitle(newsTitle);
				ps[i].setPicOrder(picOrder);

				list.add(ps[i]);
				i++;
			}
		}
		db.closeAll();
		return list;
	}

	/**
	 * 得到Userlist
	 * **/
	public static List<User> getUserList() {
		int listLength = SqlCount.countAll("adminuser");
		User user[] = new User[listLength];
		List<User> list = new ArrayList<User>();

		int adminID, authority, firstID, i = 0;
		String adminName, password, signDate, firstName;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String temp_query = "select * from adminuser";
			db.query(temp_query);
			while (db.next()) {
				adminID = db.getIntValueByString("adminID");
				authority = db.getIntValueByString("authority");
				signDate = db.getValue("signDate");
				adminName = db.getValue("adminName");
				password = db.getValue("password");
				// firstID = db.getIntValueByString("firstID");
				// firstName = db.getValue("firstName");
				user[i] = new User();
				user[i].setAdminID(adminID);
				user[i].setAdminName(adminName);
				user[i].setAuthority(authority);
				// user[i].setFirstID(firstID);
				// user[i].setFirstName(firstName);
				user[i].setPassword(password);
				user[i].setSignDate(signDate);
				list.add(user[i]);
				i++;
			}
		}
		db.closeAll();
		return list;
	}

	/**
	 * 
	 * 在table表中检查lie值value是否存在
	 * **/
	public static int CheckExist(String table, String lie, String value) {
		int flag = -1;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String temp = "select * from " + table + " where " + lie + "='"
					+ value + "'";
			db.query(temp);
			if (db.next()) {
				// System.out.println("存在");
				flag = 1;
			} else {
				// System.out.println("不存在");
				flag = 0;
			}
		}
		db.closeAll();
		return flag;
	}

	/**
	 * 用户登录
	 * **/
	public static String userLogin(String username, String password) {
		SqlConnect db = new SqlConnect();

		String result = null;
		if (db.createConnection()) {
			String temp_psw;
			String query = "select * from adminUser where adminName='"
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

	/**
	 * 用户登录信息查询
	 * **/

	public static User UserDetail() {

		int adminID, authority, firstID;
		String adminName, password, signDate, firstName;

		SqlConnect db = new SqlConnect();
		User user = new User();
		if (db.createConnection()) {
			String q = "select * from link";
			db.query(q);
			while (db.next()) {
			}
		}
		return user;
	}

	/**
	 * 得到快速链接列表
	 * **/

	public static List<Link> getLinkList() {
		int webID, visitTimes, linkOrder;
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
				linkOrder = db.getIntValueByString("linkOrder");
				webID = db.getIntValueByString("webID");
				visitTimes = db.getIntValueByString("visitTimes");
				webName = db.getValue("webName");
				webAddr = db.getValue("webAddr");

				link[i] = new Link();
				link[i].setWebAddr(webAddr);
				link[i].setVisitTimes(visitTimes);
				link[i].setWebID(webID);
				link[i].setWebName(webName);
				link[i].setLinkOrder(linkOrder);
				l.add(link[i]);
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
			String q = "select * from secondSec";
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
			String q = "select * from section where isFirst='N' order by secIDforSub";
			db.query(q);
			while (db.next()) {
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
				showUL = db.getValue("showUL");

				// System.out.println(showUL);
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
	 *            type为2时，只读取section表中列为location为center的行（应该只有一行，用于显示在右侧边栏）
	 * **/

	public static List<Section> getSectionList(int type) {

		int secID, navOrder, conOrder;
		String secName, secLocate, subNavName, isFirst, isNav, isContent, showUL;

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
				q = "select * from section  where isNav='Y' and isFirst='Y' ORDER BY navOrder";
			else if (type == 1)
				q = "select * from section where isFirst='Y' ORDER BY navOrder";
			else if (type == 2)
				q = "select * from section where secLocate='center' and isFirst='Y' and isNav='N' ORDER BY navOrder";
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
				showUL = db.getValue("showUL");

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
				s[i].setShowUL(showUL);
				l.add(s[i]);
				i++;
			}
		}
		return l;
	}

	/**
	 * OLD 得到第一导航列表
	 * 
	 * @param type
	 *            为0时将排除不是导航的模块 为1时选取所有的模块
	 * **/

	public static List<SecFirst> getFirstSecList(int type) {
		String firstSectionName, isNav, isContent, secLocate;
		int orders, firstID;
		int n = 0;
		if (type == 0)
			n = SqlQueryMax.queryNumByLie("firstSec", "isNav", "yes");
		else if (type == 1)
			n = SqlQueryMax.queryNum("firstSec");
		// System.out.println("共有这么些导航：" + n);
		SecFirst s[] = new SecFirst[n];
		List<SecFirst> l = new ArrayList<SecFirst>();
		int i = 0;
		String q = null;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {

			if (type == 0)
				q = "select * from firstSec where isNav='yes'";
			else if (type == 1)
				q = "select * from firstSec";
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

	// 得到新闻列表
	public static List<News> getNewsList(int start, int num, int firstCatID) {
		// int arraylength = end - start;

		int listLength = SqlCount.countAll("news");
		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[listLength];

		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, modAuthor, modDate, secSecName, isChecked, secFirstName, isTop;
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check;
			check = "select * from news  order by newsID desc limit "
					+ start + "," + num;
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

				hw[i] = new News();
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
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * 根据
	 * 
	 * @param content
	 *            依据内容
	 * 
	 *            table表名 lie_target需要获取内容的目标列 lie依据列 content依据列的内容
	 * 
	 * **/
	public static String getTarget(String table, String lie_target, String lie,
			String content) {
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

	// 得到新闻列表
	public static List<Integer> getNewsDelete(String lie, int firstCatID) {
		// int arraylength = end - start;
		List<Integer> listNews = new ArrayList<Integer>();// 公告列表
		int newsID;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check;
			check = "select * from news where " + lie + "=" + firstCatID;
			// System.out.println(check);
			db.query(check);
			while (db.next()) {
				newsID = db.getIntValueByString("newsID");

				listNews.add(newsID);
			}
		}
		db.closeAll();
		return listNews;
	}

	// 通过搜索关键字得到新闻列表
	public static List<News> getNewsListBySearch(int start, int num,
			String keyWords) {
		// int arraylength = end - start;

		int listLength = SqlCount.countAll("news");

		int newsID, readTimes, secSecID, secFirstID;
		String newsTitle, newsContent, author, subDate, modAuthor, modDate, secSecName, isChecked, secFirstName, isTop;

		List<News> listNews = new ArrayList<News>();// 公告列表
		News hw[] = new News[listLength];
		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String check;
			check = "select * from news  where notSee=0 and newsTitle LIKE "
					+ "'%" + keyWords + "%' order by subDate desc  limit "
					+ start + "," + num + " ";
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

				hw[i] = new News();
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
				listNews.add(hw[i]);
				i++;
			}
		}
		db.closeAll();
		return listNews;
	}

	/**
	 * type=0,默认全输出 type=2;输出领导
	 * **/
	public static List<TeacherORLeaderAction> getTLList(int type) {
		// TODO Auto-generated method stub
		List<TeacherORLeaderAction> list = new ArrayList<TeacherORLeaderAction>();
		int num = SqlCount.countAll("teacherLeader");
		// System.out.println("共有这么多个：" + num);
		TeacherORLeaderAction tl[] = new TeacherORLeaderAction[num];
		String tlName;
		int tlID, tlType, tlOrder, i = 0;
		SqlConnect db = new SqlConnect();
		String sql = null;
		if (db.createConnection()) {
			if (type == 0)
				sql = "select * from teacherLeader order by tlType";
			else if (type == 1) {
				sql = "select * from teacherLeader where tlType=1 order by tlType";
			} else if (type == 2) {
				sql = "select * from teacherLeader where tlType=2 order by tlType";
			}
			db.query(sql);
			while (db.next()) {
				tlOrder = db.getIntValueByString("tlOrder");
				tlID = db.getIntValueByString("tlID");
				tlName = db.getValue("tlName");
				tlType = db.getIntValueByString("tlType");

				tl[i] = new TeacherORLeaderAction();
				tl[i].setTlName(tlName);
				tl[i].setTlOrder(tlOrder);
				tl[i].setTlType(tlType);
				tl[i].setTlID(tlID);
				list.add(tl[i]);
				i++;
			}
		}
		return list;
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
				// tl[i].setTeaLeaBelong(teaLeaBelong);
				tl[i].setTlID(tlID);
				tl[i].setTlName(tlName);
				list.add(tl[i]);

				i++;
			}
		}
		return list;
	}

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

	public static int[] getnewsIDMod(int type, int secID) {
		// TODO Auto-generated method stub
		int num = 0;
		if (type == 1) {
			// 被修改的第一导航名称下有多少新闻
			num = SqlQueryMax.queryNumByLie("news", "secFirstID",
					String.valueOf(secID));
		} else {
			// 被修改的第一导航名称下有多少新闻
			num = SqlQueryMax.queryNumByLie("news", "secSecID",
					String.valueOf(secID));
		}
		int newsID[] = new int[num];
		int id, i = 0;
		SqlConnect db = new SqlConnect();
		String sql = null;
		if (db.createConnection()) {
			if (type == 1)
				sql = "select * from news where secFirstID=" + secID;
			else
				sql = "select * from news where secSecID=" + secID;
			
	//		System.out.println(sql);
			db.query(sql);
			while (db.next()) {
				id = db.getIntValueByString("newsID");
				newsID[i] = id;
				i++;
			}
		}
		return newsID;
	}
}
