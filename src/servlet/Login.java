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

import logic.AuthLogic;
import model.Management_user;
import request.management_userRequest;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// すでにログイン済みならビデオ一覧へリダイレクト
//		Management_user loginUser = (Management_user)request.getSession().getAttribute("loginUser");
//		if (loginUser != null) {
//			response.sendRedirect("VideoList");
//		}
//		
//		// フォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
//		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン
		request.setCharacterEncoding( "UTF-8" );
		// request body を全部読み込む
		BufferedReader br = new BufferedReader( request.getReader() );
		String jsonText = "";
		String temp;
		while ((temp = br.readLine()) != null) {
			jsonText += temp;
		System.out.println(jsonText);
		};
      	jsonText = URLDecoder.decode( jsonText, "UTF-8" );
      	System.out.println( jsonText );
		
      	//. JSON オブジェクトに変換
      	ObjectMapper mapper = new ObjectMapper();
      	management_userRequest req = mapper.readValue(jsonText, management_userRequest.class);
		AuthLogic logic = new AuthLogic();
		Management_user user = logic.login(req.getUser_name(), req.getPassward());
		if(user != null) {
			System.out.println("来た");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().println(user.getId());
			System.out.println("通った");
		}else {
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().println("{\"status\":\"login:だめ\"}");
			System.out.println("通った");
			
		 }	
	}
	
	public static void response_result(Management_user user, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		String user_data = "";
	  	try {
	  		user_data = mapper.writeValueAsString(user);
	  		response.getWriter().write(user_data);
	  		response.getWriter().flush();
	  		response.getWriter().close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	  	
	}

}
