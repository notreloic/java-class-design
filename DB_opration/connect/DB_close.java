package com.DB.connect;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DB_close {
	/**
	 * 关闭 添加功能 source DML
	 * 
	 * @param pstmt:preparedStatement conn:Connection
	 */
	public static void addClose(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e_1) {
			e_1.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * close source
	 *关闭查询返回的结果集 
	 * @param 预编译语句pstmt，结果集res，DB连接conn
	 */
	public static void queryClose(PreparedStatement pstmt, ResultSet res, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e_1) {
			e_1.printStackTrace();
		}
		
		try {
			if (res != null)
				res.close();
		} catch (SQLException e_1) {
			e_1.printStackTrace();
		}
		
		try {
			if(conn!=null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
