package cn.jbit.student.dao;

import java.util.List;

import cn.jbit.student.entity.Result;
import cn.jbit.student.entity.Student;

public interface ResultDao {
	void select();
	
	void gyn(String name);
	
	void update(Result rs);

}
