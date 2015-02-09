package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.Sql.SqlQuery;
import com.Sql.SqlQueryMax;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 统计访问数据
 * 
 * 
 * 配置参数
 * 
 * 
 * checkSessionKey 需检查的在 Session 中保存的关键字
 * 
 * redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath
 * 
 * notCheckURLList 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath
 * 
 */
public class StatisticFilter implements Filter {
	protected FilterConfig filterConfig = null;
	private String redirectURL = null;
	private List notCheckURLList = new ArrayList();
	private String sessionKey = null;

	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		long statistic = Long.valueOf(SqlQuery.get_target("statistic",
				"visitTimes", "visitID", String.valueOf(1)));

		String request_uri = request.getRequestURI();// 得到用户请求的URI

		int p = request_uri.lastIndexOf(".");
		int length = request_uri.length();

		String uri = request_uri.substring(p + 1, length);
		// 获取访问总数时，用的是action，代码会错误的加一个统计，需要排除这个action
//		 System.out.println("*******************");
//		 System.out.println(request_uri);
//		 System.out.println("*******************");
		int i = request_uri.lastIndexOf("/");
		String pc = null;
		pc = request_uri.substring(i + 1);
	//	System.out.println(pc);
		if (uri.equals("jpg") == false && uri.equals("js") == false
				&& uri.equals("gif") == false && uri.equals("css") == false) {
			
			if (pc.equals(null) == false
					&& pc.equals("getStastic.action") == false) {
				statistic++;
				SqlUpdate.update("statistic", "visitID", 1, "visitTimes",
						String.valueOf(statistic));
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		notCheckURLList.clear();
	}

	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
		String uri = request.getServletPath()
				+ (request.getPathInfo() == null ? "" : request.getPathInfo());
		return notCheckURLList.contains(uri);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		redirectURL = "logout.action";
		sessionKey = "";
		String notCheckURLListStr = "Login.jsp";
	}
}
