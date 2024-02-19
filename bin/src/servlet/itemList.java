package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Itemlists_dao;
import model.Item;
import model.createRequest;

/**
 * Servlet implementation class ItemList
 */
@WebServlet("/ItemList")
public class itemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Itemlists_dao dao = new Itemlists_dao();
		List<Item> list =  dao.get();

		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String listJson = mapper.writeValueAsString(list);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charaset=UTF-8");
			response.getWriter().write(listJson);
			System.out.println(listJson);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		// request body を全部読み込む
		BufferedReader br = new BufferedReader( request.getReader() );
		String jsonText = "";
		System.out.println(jsonText);
		String temp;
		while ((temp = br.readLine()) != null) {
			System.out.println(temp);
			jsonText += temp;
		System.out.println(temp);
		};
      	jsonText = URLDecoder.decode( jsonText, "UTF-8" );
      	
		
      	//. JSON オブジェクトに変換
      	ObjectMapper mapper = new ObjectMapper();
      	System.out.println(temp);
      	System.out.println("mapper:" + mapper);
      	createRequest req = mapper.readValue(jsonText, createRequest.class);
      	System.out.println(req.getPrice());
      	System.out.println(mapper);
      	System.out.println( jsonText );
      	Itemlists_dao dao = new Itemlists_dao();
      	System.out.println(jsonText);
//      	System.out.println(temp);
      	// DAOを使って登録
      	System.out.println(req.getProduct_name());
      	dao.create(req);
      	

	}


}
