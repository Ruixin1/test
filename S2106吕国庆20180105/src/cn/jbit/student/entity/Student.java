package cn.jbit.student.entity;

public class Student {
	private String StudentNo;
	
	private String LoginPwd;
	
	private String StudentName;
	
	private String Sex;
	
	private String Phone;

	public String getStudentNo() {
		return StudentNo;
	}

	public void setStudentNo(String studentNo) {
		StudentNo = studentNo;
	}

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

}
