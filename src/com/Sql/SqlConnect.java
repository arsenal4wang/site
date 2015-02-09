package com.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SqlConnect {

	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	public String errorMsg = "";

	/**
	 * 连接数据库
	 */
	public boolean createConnection() {
		boolean b = false;
		Properties properties = new Properties();

		try {
			properties.load(this.getClass().getResourceAsStream(
					"/db.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		// System.out.println(url);
		// System.out.println(username);
		// System.out.println(password);
		// System.out.println(driver);

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 更新数据库
	 * 
	 * @param sql
	 *            更新的 sql语句
	 * @return 更新是否成功
	 */
	public boolean update(String sql) {
		boolean b = false;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 执行查询，将查询的结果集给resultmentSet。
	 * 
	 * @param sql
	 *            查询的 sql语句
	 */
	public void query(String sql) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检测结果集是否为空
	 * 
	 * @return true为存在记录
	 */
	public boolean next() {
		boolean b = false;
		try {
			if (resultSet.next())
				b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 获得结果集中当前行columnLabel的记录
	 * 
	 * @param i
	 * @return 值记录
	 */
	public String getValue(String i) {
		String value = null;
		try {
			if (resultSet != null)
				value = resultSet.getString(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getIntValueByString(String lie) {
		int value = 0;
		String temp;
		try {
			if (resultSet != null) {
				temp = resultSet.getString(lie);
				value = Integer.parseInt(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getIntValue(int i) {
		int value = 0;
		try {
			if (resultSet != null)
				value = resultSet.getInt(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// 删除
	public void delete(String sql) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加数据
	public void add(String sql) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接对象
	 */
	public void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库对象
	 */
	public void closeStatement() {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭结果集
	 */
	public void closeResultSet() {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据连接对象，数据库对象和数据结果集对象。
	 */
	public void closeAll() {
		// System.out.println("closeAll.."+connection.hashCode());
		closeResultSet();
		closeStatement();
		closeConnection();
	}

	/**
	 * 测试该类函数。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String temp;
			System.out.println("已经连接");
			String query = "select * from user";
			db.query(query);
			while (db.next()) {
				temp = db.getValue("username");
				System.out.println(temp);
			}
		}
		db.closeConnection();
	}
}