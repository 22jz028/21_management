package dao;
/* 中略 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.History;
import model.stateRequest;

public class Purchasehistorys_dao {
	
	/**
	 * ItemListテーブルのデータをすべて取得するメソッド
	 * @return ItemListデータのリスト
	 */
	public List<History> get() {
		List<History> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "select purchasehistory.id, items.product_name, purchasehistory.item_number, purchasehistory.created_at, purchasehistory.updated_at, purchasehistory.user_id, purchasehistory.state from purchasehistory inner join items on purchasehistory.product_id = items.id";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			while(rs.next()) {
				History history = rs2model(rs);
				list.add(history);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * ItemListテーブルの中から、主キーが id であるレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したItemListデータ。なければnull
	 */
	public History find(int id) {
		History history = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "select purchasehistory.id, items.product_name, purchasehistory.item_number, purchasehistory.created_at, purchasehistory.updated_at, purchasehistory.user_id, purchasehistory.state from purchasehistory inner join items on purchasehistory.product_id = items.id  WHERE purchasehistory.id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				history = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  history;
	}
	
	public boolean state(stateRequest req) {
		int ret = -1;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()){
			String sql = "UPDATE Purchasehistory SET state = ? where id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, req.getState());
			stmt.setInt(2, req.getId());

			ret = stmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			}
			return ret > 0;
		}
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private History rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
		String product_name = rs.getString("product_name");
		int item_number = rs.getInt("item_number");
		Date created_at = rs.getDate("created_at");
		Date updated_at = rs.getDate("updated_at");
		int user_id = rs.getInt("user_id");
		String state = rs.getString("state");
		

		return new History(id, product_name, item_number, created_at, updated_at, user_id, state);
	}
}
