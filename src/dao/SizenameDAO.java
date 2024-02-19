
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SizenameDAO {
	
	/**
	 * ビデオテーブルのデータをすべて取得するメソッド
	 * @return ビデオデータのリスト
	 */
	public List<Sizename> get() {
		List<Sizename> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM videos";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			while(rs.next()) {
				Sizename sizename = rs2model(rs);
				list.add(sizename);
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
	public Sizename find(int id) {
		Sizename sizename = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM videos WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				sizename = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  sizename;
	}
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private Sizename rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
		int product_id = rs.getInt("product_id");
		String sizename = rs.getString("sizename");
		Date created_at = rs.getDate("created_at");
		Date updated_at = rs.getDate("updated_at");
		

		return new Sizename(id,product_id, created_at, updated_at);
	}
}
