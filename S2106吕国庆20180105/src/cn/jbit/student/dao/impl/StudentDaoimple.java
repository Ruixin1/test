package cn.jbit.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.student.dao.BaseDao;
import cn.jbit.student.dao.StudentDao;
import cn.jbit.student.entity.Student;


public class StudentDaoimple extends BaseDao implements StudentDao{

	public List<Student> print() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT StudentNo,LoginPwd,StudentName,Sex,Phone FROM student";
		ResultSet rs = null;

		try {
			rs = this.exceuteQeury(sql, null);
			while(rs.next()){
				Student stu = new Student();
				stu.setStudentNo(rs.getString("StudentNo"));
				stu.setLoginPwd(rs.getString("LoginPwd"));
				stu.setStudentName(rs.getString("StudentName"));
				stu.setSex(rs.getString("Sex"));
				stu.setPhone(rs.getString("Phone"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn,null, rs);
		}
		return list;
	}




}
