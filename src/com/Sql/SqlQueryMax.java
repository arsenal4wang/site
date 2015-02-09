package com.Sql;

/*
 * 查询最大值
 * */
public class SqlQueryMax {

	/** 查询表table中id列的最大值 **/
	public static int query_max(String table, String id) {
		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = "select  max(" + id + ") from " + table;
			db.query(s);
			while (db.next()) {
				i = db.getIntValue(1);// 第几列
			}
			db.closeAll();
		}
		return i;
	}

	/**
	 * 查询参数表中某个列某个值一共有多少行数据
	 * **/
	public static int queryNumByLie(String table, String lie, String content) {

		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = "select count(*) AS num from " + table + " where " + lie
					+ "='" + content+"'";
			db.query(s);
			while (db.next()) {
				i = db.getIntValueByString("num");
			}
		}
		db.closeAll();
		return i;

	}

	/**
	 * 查询参数表中一共有多少行数据
	 * **/
	public static int queryNum(String table) {

		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = "select count(*) AS num from " + table;
			db.query(s);
			while (db.next()) {
				i = db.getIntValueByString("num");
			}
		}
		db.closeAll();
		return i;

	}

	public static void main(String[] args) {
		SqlConnect db = new SqlConnect();
		int i = 0;
		if (db.createConnection()) {
			String s = "select  max(userID) from  adminUser";
			db.query(s);
			while (db.next()) {
				i = db.getIntValue(1);
				System.out.println(i);
			}
		}
	}
}
