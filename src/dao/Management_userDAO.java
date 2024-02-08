package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Management_user;

public class Management_userDAO {
	
	/**
	 * ビデオテーブルのデータをすべて取得するメソッド
	 * @return ビデオデータのリスト
	 */
	public List<Management_user> get() {
		List<Management_user> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM management_user";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			while(rs.next()) {
				Management_user management_user  =  rs2model(rs);
				list.add(management_user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * ビデオテーブルの中から、主キーが id であるレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したビデオデータ。なければnull
	 */
	public Management_user find(int id) {
		Management_user users = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM management_user WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				users = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  users;
	}
	
	/**
	 * テーブルの中から、指定された名前を持つレコードを返すメソッド
	 * @param name 名前
	 * @return 発見したデータ。なければnull
	 */
	public Management_user findByEmail(String user_name) {
		System.out.println("来た");
		Management_user user = null;
		DBManager manager = DBManager.getInstance();
		System.out.println("来た");
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM management_user WHERE user_name = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			System.out.println("kita");
			stmt.setString(1, user_name);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				user = rs2model(rs);
				System.out.println(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("来た");
		return  user;
	}
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private Management_user rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
		String user_name = rs.getString("user_name");
		String passward = rs.getString("passward");
//		Date created_at = rs.getCreated_at("created_at");
		
		return new Management_user(id, user_name, passward);
	}
}
