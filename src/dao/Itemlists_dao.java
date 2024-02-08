package dao;
/* 中略 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Item;
import model.createRequest;
import model.deletRequest;
import model.stockRequest;
import model.updateRequest;

public class Itemlists_dao {
	
	/**
	 * ItemListテーブルのデータをすべて取得するメソッド
	 * @return ItemListデータのリスト
	 */
	public List<Item> get() {
		List<Item> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM Items ORDER BY id ASC";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			while(rs.next()) {
				Item itemlist = rs2model(rs);
				list.add(itemlist);
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
	public Item find(int id) {
		Item item = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM Items WHERE ID = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				 item = rs2model(rs);
				 System.out.println("できた");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  item;
	}
	
	
	
	public boolean create(createRequest item) {
		int ret = -1;	
		System.out.println();
		System.out.println("できた");
		// できるなら存在確認
		

		// DBにデータを追加
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "INSERT INTO items (product_name, price, description, stock, created_at, updated_at, image, material, sizename, category) VALUES (?, ?, ?, ?, sysdate, sysdate, ?, ?, ?, ?)";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, item.getProduct_name());
			stmt.setInt(2, item.getPrice());
			stmt.setString(3, item.getDescription());
			stmt.setInt(4, item.getStock());
			stmt.setString(5, item.getImage());
			stmt.setString(6, item.getMaterial());
			stmt.setString(7, item.getSizename());
			stmt.setString(8, item.getCategory());
			System.out.println("できた");
			ret = stmt.executeUpdate();
			System.out.println("できた");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ret > 0;
	}

	public boolean update(updateRequest list){
		int ret = -1;

		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()){
			String sql = "UPDATE items SET product_name = ?, price = ?, description = ?, image = ?, material = ?, sizename = ?, updated_at = sysdate where id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, list.getProduct_name());
			stmt.setInt(2, list.getPrice());
			stmt.setString(3, list.getDescription());
			stmt.setString(4, list.getImage());
			stmt.setString(5, list.getMaterial());
			stmt.setString(6, list.getSizename());
			stmt.setInt(7, list.getId());

			ret = stmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			}
			return ret > 0;

	}
	
	public boolean stockupdate(stockRequest req){
		int ret = -1;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()){
			String sql = "UPDATE items SET stock = ? where id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, req.getStock());
			stmt.setInt(2, req.getId());

			ret = stmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			}
			return ret > 0;
		}
	
	public boolean delet(deletRequest req){
		int ret = -1;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()){
			String sql = "DELETE FROM items  where id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, req.getId());
			
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
	private Item rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
		String product_name = rs.getString("product_name");
		int price = rs.getInt("price");
		String description = rs.getString("description");
		int stock = rs.getInt("stock");
		Date created_at = rs.getDate("created_at");
		Date updated_at = rs.getDate("updated_at");
		String image = rs.getString("image");
		String material = rs.getString("material");
		String sizename = rs.getString("sizename");
		
		

		return new Item(id, product_name, price, description, stock, created_at, updated_at, image, material, sizename);
	}


}
