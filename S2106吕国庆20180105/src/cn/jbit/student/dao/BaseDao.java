package cn.jbit.student.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
	
	
	private static String Driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	
	/**
	 * 静态块加载
	 */
	static{
		init();
	}
	
	/**
	 * 配置properties 文件
	 */
	public static void init(){
		Properties params  = new Properties();
		String configFile = "database.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		
		try {
			params.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("username");
		pwd = params.getProperty("password");
	}
	
	protected Connection conn;
	
	/**
	 * 建立数据库
	 * @return
	 */
	protected Connection getConnection(){
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库!
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	protected void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 新增 修改 删除 数据库方法
	 * @param sql
	 * @param params
	 * @return
	 */
	protected int exceuteUpdate(String sql,Object...params){
		int result = 0;
		conn = this.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(null,pstmt,null);
		}
		return result;
		
	}
	/**
	 * 查询数据库
	 * @param sql
	 * @param params
	 * @return
	 */
	protected ResultSet exceuteQeury(String sql,Object...params){
		conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1,params[i]);
				}
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
