package cn.jbit.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.student.dao.BaseDao;
import cn.jbit.student.dao.ResultDao;
import cn.jbit.student.entity.Result;
import cn.jbit.student.entity.Student;

public class ResultDaoimple extends BaseDao implements ResultDao{

	public void update(Result rs) {
		int result = 0;
		String sql = "UPDATE result SET score = score+5 WHERE score<20";
		String sql1 ="SELECT AVG(score) FROM result GROUP BY ExamDate HAVING AVG(score)>60";
		result = this.exceuteUpdate(sql);
		if(result<=0){
			ResultSet rs1 = this.exceuteQeury(sql1);
			try {
				while(rs1.next()){
					
					rs.setAvgScore(rs1.getDouble("AVG(score)"));
					System.out.println("平均分为"+rs.getAvgScore());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

	public void select() {
		// TODO Auto-generated method stub
		String sql = "select StudentName ,score FROM result s , student st WHERE s.studentNo = st.StudentNo";
		ResultSet rs = null;
		Student stu = null;
		Result rss = null;
		
		rs = this.exceuteQeury(sql);
		try {
			while(rs.next()){
				stu = new Student();
				rss = new Result();
				stu.setStudentName(rs.getString("StudentName"));
				rss.setScore(rs.getInt("score"));
				if(stu!=null&&rss!=null){
					System.out.println("学生姓名"+stu.getStudentName()+"分数"+rss.getScore());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(conn,null,rs);
		}
	}

	public void gyn(String name ) {
		// TODO Auto-generated method stub
		
		String sql = "select score FROM result  WHERE studentNo =(SELECT StudentNo FROM student WHERE StudentName = ?) AND ExamDate IN (SELECT MAX(ExamDate) FROM result GROUP BY studentNo)";
		ResultSet rs = null;
		Student stu = null;
		Result rss = null;
		
		rs = this.exceuteQeury(sql,name);
		try {
			while(rs.next()){
				rss = new Result();
				rss.setScore(rs.getInt("score"));
				if(rss!=null){
					System.out.println("分数"+rss.getScore());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(conn,null,rs);
		}
		
	}

}
