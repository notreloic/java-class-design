package com.DB.util;

import com.DB.connect.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class Html_DBO {
	private static Connection conn=null;
	private static ResultSet res=null;
	private static PreparedStatement pstmt=null;
	/**
	 * @author caohan
	 * @param String:title-html页面文章标题
	 * @return String:html文件所在相对路径
	 */
	public static String getHtmlAddr(String title) {
		boolean flag=false;
		String addr="";
		try {
			conn=(Connection) DB_connect.getconn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String query_sql="SELECT * FROM article WHERE title=?";
		try {
			pstmt=conn.prepareStatement(query_sql);
			pstmt.setString(1, title);
			res=pstmt.executeQuery();
			while (res.next()) {
				addr=res.getString("content");
				flag=true;
			}
		} catch (Exception e) {
			if (flag==false) {
				System.err.println("数据库中没有该title");
			}
			e.printStackTrace();
		}finally {
			DB_close.queryClose(pstmt, res, conn);
		}
		return addr;
	}
}
