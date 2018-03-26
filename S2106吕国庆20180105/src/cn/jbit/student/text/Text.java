package cn.jbit.student.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.jbit.student.dao.ResultDao;
import cn.jbit.student.dao.StudentDao;
import cn.jbit.student.dao.impl.ResultDaoimple;
import cn.jbit.student.dao.impl.StudentDaoimple;
import cn.jbit.student.entity.Result;
import cn.jbit.student.entity.Student;



public class Text {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		System.out.println("选择你要查询的功能");
		System.out.println("1.查询所有学生的姓名和总成绩");
		System.out.println("2.查询出所有学生的信息并打印出来");
		System.out.println("3.查找学生姓名为郭亚斌的学生的最近一次考试的日期");
		System.out.println("4.查询所有学生的平均分");
		int num = sc.nextInt();
		switch(num){
		case 1:
			ResultDao rs = new ResultDaoimple();
			rs.select();
			break;
		case 2:
			StudentDao studao = new StudentDaoimple();
			list = studao.print();
			for (int i = 0; i < list.size(); i++) {
				Student stu =list.get(i);
				System.out.println(stu.getStudentNo()+"\t"+stu.getLoginPwd()+"\t"+stu.getStudentName()+"\t"+stu.getSex()+"\t"+stu.getPhone());
			}
			break;
		case 3:
			ResultDao rss = new ResultDaoimple();
			String name = "郭亚斌";
			rss.gyn(name);
			break;
		case 4:
			Result rs1 = new Result();
			ResultDao rsss = new ResultDaoimple();
			rsss.update(rs1);
			break;
		}
	}

}
