package cn.jbit.student.entity;

import java.util.Date;

public class Result {
	
	private int id;
	
	private String studentNo;
	
	private int Score;
	
	private Date ExamDate;
	
	private double avgScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public Date getExamDate() {
		return ExamDate;
	}

	public void setExamDate(Date examDate) {
		ExamDate = examDate;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
}
