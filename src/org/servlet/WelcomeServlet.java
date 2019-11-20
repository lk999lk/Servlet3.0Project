package org.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/WelcomeServlet", loadOnStartup=1, initParams = {@WebInitParam(name="servletparaname3.0", value="servletparavalue3.0")})
public class WelcomeServlet extends HttpServlet {
       
	@Override
	public void init() throws ServletException {
		System.out.println("init3.0...");
		String name = getInitParameter("servletparaname3.0");
		System.out.println("当前servlet的初始化参数servletparaname3.0值为： " + name);
		
		//获取当前web容器的初始化参数
		ServletContext servletContext = getServletContext();
		String globalValue = servletContext.getInitParameter("globalParam");
		System.out.println("当前web容器的参数globalParam的值是： " + globalValue);
	}
	@Override
	public void destroy() {
		System.out.println("destroy3.0...");
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet 3.0...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
