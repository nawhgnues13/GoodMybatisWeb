package com.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.member.model.dao.MemberDAO;
import com.kh.member.model.vo.Member;

public class MemberService {

	private SqlSession conn;
	private MemberDAO mDao;

	public MemberService() {
		mDao = new MemberDAO();
		conn = SqlSessionTemplate.getSqlSession();
	}

	public Member selectCheckLogin(Member member) {
		Member mOne = mDao.selectCheckLogin(conn, member);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}

	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		if (result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		return result;
	}

	public int modifyMember(Member member) {
		int result = mDao.updateMember(conn, member);
		if (result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		return result;
	}

	public int deleteMember(String memberId) {
		int result = mDao.deleteMember(conn, memberId);
		if (result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		return result;
	}

}
