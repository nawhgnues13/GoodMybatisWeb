package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;

@WebServlet("/notice/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = -8042103979275805129L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		int result = nService.deleteNotice(Integer.parseInt(noticeNo));
		if (result > 0) {
			resp.sendRedirect("/notice/list.do");
		} else {
			req.setAttribute("msg", "No Data Found");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
