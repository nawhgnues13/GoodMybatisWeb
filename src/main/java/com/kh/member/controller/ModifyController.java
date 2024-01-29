package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/member/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		MemberService mService = new MemberService();
		if (memberId != null) {
			Member member = mService.selectOneById(memberId);
			if (member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "No Data(member) Found!");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "Login Needed~!~!~!~");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		MemberService mService = new MemberService();
		int result = mService.modifyMember(member);
		if (result > 0) {
			response.sendRedirect("/member/myPage.do");
		} else {
			request.setAttribute("msg", "No Data Found!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
