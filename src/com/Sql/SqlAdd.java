package com.Sql;

import com.Sql.SqlConnect;

public class SqlAdd {

	/**
	 * 用于只添加一列内容
	 * 
	 * 首先用于添加导航模块 后来用于添加资源分类因为ID自增
	 * **/
	public static void addContent(String table, String lie, String name) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String add = "insert into " + table + "(" + lie + ")values('"
					+ name + "')";
			// System.out.println(add);
			db.add(add);
			db.closeAll();
		}
	}

	/** 添加文件 **/
	public boolean SQLadd(int id, String name, String fileInfo, String up_date,
			String author, String classfiy) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sqladd = "insert into file(fileID,fileName,fileInfo,up_Date,author,classify) values('"
					+ id
					+ "','"
					+ name
					+ "','"
					+ fileInfo
					+ "','"
					+ up_date
					+ "','" + author + "','" + classfiy + "')";
			// System.out.println(sqladd);
			db.add(sqladd);
			db.closeAll();
			return true;
		} else {
			db.closeAll();
			return false;
		}
	}

	/**
	 * 第二种添加轮播图片
	 * **/
	public static void addPicSlider2(String picLocation, String picName,
			String href, int order) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String add = "insert into picslider (picLocation,picName, newsID,newsTitle,href,picOrder)values('"
					+ picLocation
					+ "','"
					+ picName
					+ "','-1','#','"
					+ href
					+ "'," + order + ")";
			// System.out.println(add);
			db.add(add);
			db.closeAll();
		}
	}

	/**
	 * 添加新闻时，添加轮播图片
	 * **/

	public static void addPicSlider(String location, String picName,
			int newsID, String newsTitle, int order) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String add = "insert into picslider (picLocation,picName,isChecked, newsID,newsTitle,picOrder,href)values('"
					+ location
					+ "','"
					+ picName
					+ "','0','"
					+ newsID
					+ "','"
					+ newsTitle + "'," + order + ",'#')";
			// System.out.println(add);
			db.add(add);
			db.closeAll();
		}
	}

	/**
	 * 添加用户
	 * 
	 * **/
	public static void addUser(String adminName, String password,
			String signDate, int authority) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String add = "insert into adminuser(adminName, password,signDate,authority)values('"
					+ adminName
					+ "','"
					+ password
					+ "','"
					+ signDate
					+ "',"
					+ authority + ")";
			// System.out.println(add);
			db.add(add);
			db.closeAll();
		}
	}

	/**
	 * 添加登录日志
	 * 
	 * **/

	public static void addLoginLog(int adminID, String adminName,
			String loginTime, String loginIP) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String a = "insert into loginlog (adminID,adminName,loginTime,loginIP)values("
					+ adminID
					+ ",'"
					+ adminName
					+ "','"
					+ loginTime
					+ "','"
					+ loginIP + "')";
			// System.out.println(a);
			db.add(a);
		}
		db.closeAll();
	}

	/**
	 * 添加快速链接
	 * 
	 * **/

	public static void addLink(String webName, String webAddr, int linkOrder) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String a = "insert into link (webName,webAddr,visitTimes,linkOrder)values('"
					+ webName
					+ "','"
					+ webAddr
					+ "',"
					+ 0
					+ ","
					+ linkOrder
					+ ")";
			// System.out.println(a);
			db.add(a);
		}
		db.closeAll();
	}

	/**
	 * 添加第二模块导航
	 * 
	 * **/

	public static void addSecSec(int firstID, int orders, String secName,
			String firstName) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String a = "insert into secondSec (firstID, orders,secName,firstName)values("
					+ firstID
					+ ","
					+ orders
					+ ",'"
					+ secName
					+ "','"
					+ firstName + "')";
			// System.out.println(a);
			db.add(a);
		}
		db.closeAll();
	}

	/**
	 * 新 添加第一模块导航 type为1,一级导航，为2，二级导航
	 * **/

	public static void addSecFirstNew(String isNav, String isFirst,
			String showUL, String isContent, int navOrder, int conOrder,
			String secName, String secLocate, String subNavName, int secID,
			int type) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			if (type == 1) {
				String a = "insert into section (isNav,secIDforSub,showUL,isFirst, isContent,navOrder,conOrder,secName,secLocate)values('"
						+ isNav
						+ "',"
						+ 0
						+ ",'"
						+ showUL
						+ "','"
						+ isFirst
						+ "','"
						+ isContent
						+ "',"
						+ navOrder
						+ ","
						+ conOrder
						+ ",'" + secName + "','" + secLocate + "')";
				// System.out.println("1" + a);
				db.add(a);
			} else if (type == 2) {
				String a = "insert into section (isNav,secIDforSub,showUL,secName,isFirst, isContent,navOrder,conOrder,subNavName,secLocate)values('"
						+ isNav
						+ "',"
						+ secID
						+ ",'"
						+ showUL
						+ "','"
						+ secName
						+ "','"
						+ isFirst
						+ "','"
						+ isContent
						+ "',"
						+ navOrder
						+ ","
						+ conOrder
						+ ",'"
						+ subNavName
						+ "','"
						+ secLocate + "')";
			//	System.out.println("2" + a);
				db.add(a);
			}
		}
		db.closeAll();
	}

	/**
	 * 添加第一模块导航
	 * 
	 * **/

	public static void addSecFirst(String isNav, String isContent,
			String FirstSectionName, String secLocate, int order) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String a = "insert into firstSec (isNav,isContent, firstSectionName,secLocate,orders)values('"
					+ isNav
					+ "','"
					+ isContent
					+ "','"
					+ FirstSectionName
					+ "','" + secLocate + "'," + order + ")";
			// System.out.println(a);
			db.add(a);
		}
		db.closeAll();
	}

	public static void main(String[] args) {
	}

	public static void addNews(String author, String isTop, String newsContent,
			String newsTitle, String secFirstName, int secFirstID,
			String secSecName, int secSecID, String timeSql, int haveFile) {
		// TODO Auto-generated method stub

		int notSee = Integer.valueOf(SqlQuery.getTarget("section", "showUL",
				"secID", String.valueOf(secSecID)));
		// System.out.println(notSee);
		if (notSee != 1) {
			notSee = 1;
		} else
			notSee = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String a = "insert into news (author,isTop, newsContent,newsTitle,secFirstName,secFirstID,secSecName,secSecID,subDate,readTimes,notSee,haveFile)values('"
					+ author
					+ "','"
					+ isTop
					+ "','"
					+ newsContent
					+ "','"
					+ newsTitle
					+ "','"
					+ secFirstName
					+ "',"
					+ secFirstID
					+ ",'"
					+ secSecName
					+ "',"
					+ secSecID
					+ ",'"
					+ timeSql
					+ "',0," + notSee + "," + haveFile + ")";
			// System.out.println(a);
			db.add(a);
		}
		db.closeAll();
	}

	public static void addfileInNews(String uploadFileName, String newsTitle,
			int tempID) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "insert into fileInNews(newsID,fileName,newsName) values ("
					+ tempID
					+ " ,'"
					+ uploadFileName
					+ "' ,'"
					+ newsTitle
					+ "')";
			// System.out.println(sql);
			db.add(sql);
		}
		db.closeAll();
	}

	public static void tlAdd(String tlName, int tlType, int tlOrder) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "insert into teacherLeader(tlName,tlType,tlOrder) values ('"
					+ tlName + "' ," + tlType + " ," + tlOrder + ")";
			// System.out.println(sql);
			db.add(sql);
		}
		db.closeAll();
	}

	public static void addLeader(String table, int tlID, String tlName,
			String teaLeaName, String teaLeaProfile) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "insert into " + table
					+ "(tlName,tlID,teaLeaName,teaLeaProfile) values ('"
					+ tlName + "' ," + tlID + ",'" + teaLeaName + "','"
					+ teaLeaProfile + "')";
			// System.out.println(sql);
			db.add(sql);
		}
		db.closeAll();
	}

	/**
	 * public static void addColleage(String colleageName) { // TODO
	 * Auto-generated method stub
	 * 
	 * SqlConnect db = new SqlConnect(); if (db.createConnection()) { String sql
	 * = "insert into colleage(colleageName) values ('" + colleageName + "')";
	 * System.out.println(sql); db.add(sql); } db.closeAll(); }
	 **/

	public static void addLogo(String picLocation, int sectionID,
			String subNavName, int secIDforSub, String secName) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "insert into logoRight (picLocation,sectionID,subNavName,secIDforSub,secName) values ('"
					+ picLocation
					+ "' ,"
					+ sectionID
					+ ",'"
					+ subNavName
					+ "'," + secIDforSub + ",'" + secName + "')";
			// System.out.println(sql);
			db.add(sql);
		}
		db.closeAll();
	}

	public static void addGdPic(String picLocation, String href, int picOrder) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "insert into picgd (picLocation,href,picOrder) values ('"
					+ picLocation + "' ,'" + href + "'," + picOrder + ")";
		//	System.out.println(sql);
			db.add(sql);
		}
		db.closeAll();
	}
}
