package com.Sql;

public class SqlDelete {

	public static void delete(String table, String lie, int id) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String del = "delete from " + table + " where " + lie + " = " + id;
		//	System.out.println(del);
			db.delete(del);
			db.closeAll();
		}
	}
}
