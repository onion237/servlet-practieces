package com.douzone.emaillist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.emaillist.vo.EmaillistVo;

import util.ConnectionProvider;

public class EmaillistDao {
	private final ConnectionProvider connectionProvider;
	
	public EmaillistDao(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}

	public boolean insert(EmaillistVo emailList) {
		boolean result = false;
		String sql = "insert into emaillist(first_name, last_name, email) values(?,?,?)";
		try(Connection conn = connectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, emailList.getFirstName());
			pstmt.setString(2, emailList.getLastName());
			pstmt.setString(3, emailList.getEmail());
			
			result = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public List<EmaillistVo> findAll(){
		List<EmaillistVo> result = new ArrayList<>();
		String sql = "select no, first_name, last_name, email from emaillist order by no desc";
		try(Connection conn = connectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			try(ResultSet rs = pstmt.executeQuery()){
				EmaillistVo vo = null;
				while(rs.next()) {
					vo = new EmaillistVo();
					vo.setNo(rs.getLong("no"));
					vo.setFirstName(rs.getString("first_name"));
					vo.setLastName(rs.getString("last_name"));
					vo.setEmail(rs.getString("email"));
					
					result.add(vo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
