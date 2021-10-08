package com.douzone.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

import util.SimpleConnectionProvider;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("a");
		if (action == null || action.isEmpty())
			action = "list";

		String viewsPath = "/WEB-INF/views/";
		String forwardingPath = "";
		EmaillistDao dao = new EmaillistDao(new SimpleConnectionProvider());

		switch (action) {
		case "list":
			List<EmaillistVo> emails = dao.findAll();
			request.setAttribute("emails", emails);
			forwardingPath = "index.jsp";
			break;
		case "addform":
			forwardingPath = "form.jsp";
			break;
		case "add":
			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(request.getParameter("fn"));
			vo.setLastName(request.getParameter("ln"));
			vo.setEmail(request.getParameter("email"));
			dao.insert(vo);
			
			response.sendRedirect(request.getContextPath() + "/el?a=list");
			return;
		}

		request.getRequestDispatcher(viewsPath + forwardingPath).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
