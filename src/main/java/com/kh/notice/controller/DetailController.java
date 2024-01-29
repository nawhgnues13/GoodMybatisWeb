package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/detail.do")
public class DetailController extends HttpServlet {

	private static final long serialVersionUID = 1070927730385852372L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// /notice/detail.do?noticeNo=445
		String noticeNo = request.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(Integer.parseInt(noticeNo));
		if (notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "No Data Found");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}
}
