package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Itemlists_dao;
import model.stockRequest;

/**
 * Servlet implementation class ItemList
 */
@WebServlet("/stoc")
public class stoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ItemDAO dao = new ItemDAO(); 
//		Item item = dao.find(/* 商品ID */);
//		if (/*えらー*/) {
//			
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		// request body を全部読み込む
		BufferedReader br = new BufferedReader( request.getReader() );
		String jsonText = "";
		String temp;
		while ((temp = br.readLine()) != null) {
			jsonText += temp;
		};
      	jsonText = URLDecoder.decode( jsonText, "UTF-8" );
      	System.out.println( jsonText );
		
      	//. JSON オブジェクトに変換
      	ObjectMapper mapper = new ObjectMapper();
      	stockRequest req = mapper.readValue(jsonText, stockRequest.class);
      	
      	Itemlists_dao dao = new Itemlists_dao();
      	// DAOを使って登録
		dao.stockupdate(req);
	}

}
