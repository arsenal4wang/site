package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面
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
public class CheckLoginFilter implements Filter {
	protected FilterConfig filterConfig = null;
	private String redirectURL = null;
	private List notCheckURLList = new ArrayList();
	private String sessionKey = null;

	@Override
	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String adminName = String.valueOf(session.getAttribute("adminName"));

		// System.out.println("" + adminName.length());
		// System.out.println("servlet拦截器中.." + adminName);

		// 根路径
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
	//	System.out.println(basePath);

		String request_uri = request.getRequestURI();// 得到用户请求的URI
		int p = request_uri.lastIndexOf(".");
		int length = request_uri.length();
		String uri = request_uri.substring(p + 1, length);// URI后缀
	//	System.out.println(uri);

		if (adminName.equals("null")) {
			if (uri.equals("jsp")) {
				request.getRequestDispatcher("../../logout.action")
						.forward(request, response);
			} else {
				request.getRequestDispatcher("logout.action").forward(request,
						response);
			}
			return;
		} else {
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		notCheckURLList.clear();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		redirectURL = "logout.action";
		sessionKey = "";
	}
}
