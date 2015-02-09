package com.Action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Bean.Log;
import com.Bean.User;
import com.Sql.SqlAdd;
import com.Sql.SqlCount;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 后台用户登录
 * 
 * **/
public class UserAction extends ActionSupport {

	private int adminID, authority, firstID, jibie;
	private String adminName, password, signDate, firstName, adminIDStr;
	private Map<String, Object> dataMap;
	List<User> user_list = new ArrayList<User>();

	List<Log> listLog = new ArrayList<Log>();// 登录列表
	int allnum, page, beginnum;

	/*
	 * // 修改用户权限 public String changeAuthority() {
	 * System.out.println(getAuthority()); System.out.println(getAdminID());
	 * return SUCCESS; }
	 */

	public String logout() {

		ActionContext act = ActionContext.getContext();
		Map<String, Object> session = act.getSession();
		// System.out.println("username..." + username);
		session.remove("authority");
		session.remove("adminName");
		// System.out.println("username..." + username);
		return SUCCESS;
	}

	// 修改自己的密码
	public String changePassword() {
		// int id = Integer.valueOf(SqlQuery.getTarget("adminUser", "userID",
		// "username", getAdminName()));
		// System.out.println(getAdminIDStr());
		SqlUpdate.update("adminUser", "adminID",
				Integer.valueOf(getAdminIDStr()), "password", getPassword());
		return SUCCESS;
	}

	public String getLogList() {
		allnum = SqlCount.countAll("loginlog");
		page = judge(allnum);
//		System.out.println("*******数字为"+beginnum);
		listLog = SqlQuery.getLogList(getBeginnum(), 20);
		return SUCCESS;
	}

	public String getUserList() {
		user_list = SqlQuery.getUserList();
		// System.out.println(user_list.size());
		return SUCCESS;
	}

	public String addUser() {
		GetDate gd = new GetDate();
		String timeSql = gd.getDate();

		String tempFirstName = SqlQuery.getTarget("firstsec",
				"firstSectionName", "firstID", String.valueOf(getFirstID()));// 取得所属部门的ID
		// System.out.println(tempFirstName);
		// SqlAdd.addUser(getAdminName(), getPassword(), timeSql,
		// getAuthority(),
		// tempFirstName, getFirstID());
		SqlAdd.addUser(getAdminName(), getPassword(), timeSql, getAuthority());
		return SUCCESS;
	}

	public String delUser() {
		SqlDelete.delete("adminuser", "adminID", getAdminID());
		return SUCCESS;
	}

	public String checkUserExist() {
		int flag = SqlQuery
				.CheckExist("adminuser", "adminName", getAdminName());
		// System.out.println("flag:" + flag);
		// System.out.println("getAdminName:" + getAdminName());
		if (flag == 1) {
			dataMap.put("success", true);
		} else {
			dataMap.put("success", false);
		}
		return SUCCESS;
	}

	public String adminLogin() throws UnknownHostException {
		String isOK = SqlQuery.userLogin(getAdminName(), getPassword());
		GetDate gd = new GetDate();
		String timeSql = gd.getDate();
		// 保存request信息
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext act = ActionContext.getContext();
		Map<String, Object> session = act.getSession();

		// System.out.println("adminName.." + getAdminName());
		String temp_re;
		if (isOK.equals("yes")) {
			// System.out.println("yes");
			// 得到该用户权限
			authority = Integer.valueOf(SqlQuery.getTarget("adminuser",
					"authority", "adminName", getAdminName()));

			// firstName = SqlQuery.getTarget("adminUser", "firstName",
			// "adminName", getAdminName());// 用户所属部门
			// firstID = Integer.valueOf(SqlQuery.getTarget("adminuser",
			// "firstID", "adminName", getAdminName()));// 用户所属部门的ID
			adminID = Integer.valueOf(SqlQuery.getTarget("adminuser",
					"adminID", "adminName", getAdminName()));// 用户ID

			// System.out.println("adminID登录："+adminID);
			ServletActionContext.getRequest().getSession()
					.setMaxInactiveInterval(3600);// 设置session失效时间，单位为S
		//	jibie = authority;
			if (authority == 0) {
				session.put("jibie", 0);
				session.put("authority", "0");
			} else if (authority == 1) {
				session.put("jibie", 1);
				session.put("authority", "1");
			} else {
				session.put("jibie", 2);
				session.put("authority", "2");
			}
		//	System.out.println(jibie);

			// session.put("firstName", firstName);// 所属部门名称
			// session.put("firstID", firstID);// 所属部门ID
			// System.out.println(getAdminName());
			session.put("adminName", getAdminName());
			session.put("userID", adminID);

			String ip = getIpAddr();

			// 如果是本机登录
			if (ip.equals("0:0:0:0:0:0:0:1")) {
				InetAddress addr = InetAddress.getLocalHost();
				String ipSelf = addr.getHostAddress().toString();
				session.put("LoginIP", ipSelf);
				ip = ipSelf;
			} else {
				session.put("LoginIP", ip);
			}
			SqlAdd.addLoginLog(adminID, getAdminName(), timeSql, ip);
			// System.out.println(ip);
			temp_re = SUCCESS;
		} else if (isOK.equals("no")) {
			request.setAttribute("loginerror", "密码错误");
			temp_re = ERROR;
		} else {
			request.setAttribute("loginerror", "无此用户名");
			temp_re = ERROR;
		}
		return temp_re;
	}

	/**
	 * 登录IP
	 * 
	 * **/
	public static String getIpAddr() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public List<User> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<User> user_list) {
		this.user_list = user_list;
	}

	/**
	 * 构造方法
	 */
	public UserAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getFirstID() {
		return firstID;
	}

	public void setFirstID(int firstID) {
		this.firstID = firstID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Log> getListLog() {
		return listLog;
	}

	public void setListLog(List<Log> listLog) {
		this.listLog = listLog;
	}

	public int getAllnum() {
		return allnum;
	}

	public void setAllnum(int allnum) {
		this.allnum = allnum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginnum() {
		return beginnum;
	}

	public void setBeginnum(int beginnum) {
		this.beginnum = beginnum;
	}

	public String getAdminIDStr() {
		return adminIDStr;
	}

	public void setAdminIDStr(String adminIDStr) {
		this.adminIDStr = adminIDStr;
	}

	public int getJibie() {
		return jibie;
	}

	public void setJibie(int jibie) {
		this.jibie = jibie;
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
}
