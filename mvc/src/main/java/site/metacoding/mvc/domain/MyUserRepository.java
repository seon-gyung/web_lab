package site.metacoding.mvc.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.mvc.config.DBconn;

// insert, delete, update, select 하는 메서드 만들어서 재사용
public class MyUserRepository {
	
	private Connection conn;
	
	public MyUserRepository() {
		conn = DBconn.getConnection();
	}
	
	// SELECT * FROM myUser
	// 모든 데이터 찾기
	public List<MyUser> selectAll() {
		List<MyUser> myUsers = new ArrayList<>();

		try {
			String sql = "SELECT * FROM myUser";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) { // 한건 밖에 없어서 굳이 while 돌릴 필요가 없다.
                MyUser myUser = new MyUser(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                );
                myUsers.add(myUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return myUsers;
	}
	
	// SELECT * FROM myUser WHERE id = ?
	// 하나의 데이터만 찾기
	public MyUser selectById(int id) {
		MyUser myUser = null;
		
		try {
			String sql = "SELECT * FROM myUser WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){ // 한건밖에 없어서 while 돌릴 필요가 없다
				myUser = new MyUser(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myUser;
	}
	
	// INSERT INTO myUser(id, username, password, email) VALUES(seq_myUser.nextval, ?, ?, ?)
	public int insert(String username, String password, String email) {
		int result = 0;
		
		
		return result;
	}
	
	// DELETE FROM myUser WHERE id = ?
	public int deleteById(int id) {
		int result = 0;
        try {
            String sql = "DELETE FROM myUser WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		return result;
	}
	
	// UPDATE myUser SET username = ?, password = ?, email = ? WHERE id = ?
	public int update(int id, String username, String password, String email) {
		int result = 0;
		
		return result;
	}
	

}
