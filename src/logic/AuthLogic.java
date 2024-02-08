package logic;

import dao.Management_userDAO;
import model.Management_user;

/**
 * ログイン・ログアウト処理を行うクラス
 * @author d.sugawara
 *
 */
public class AuthLogic {
	/**
	 * ログイン処理を行う
	 * @param email
	 * @param password
	 * @return 成功時はログインしたユーザ、失敗時はnull
	 */
	public Management_user login(String user_name, String passward) {
		Management_userDAO dao = new Management_userDAO();
		Management_user user = dao.findByEmail(user_name);
//		System.out.println(user.getPassward());
//		System.out.println(passward);
		if ((user != null) && passward.equals(user.getPassward())) {
			System.out.println("ok");
			return user;
			
		}
//		System.out.println(user.getPassward());
		System.out.println("だめ");
		return null;
		
	}
	}
	
	/**
	 * ログアウト処理を行う
	 * @return なし
	 */
//	public void logout(HttpSession session) {
//		if (isLoggedIn(session)) {
//			session.removeAttribute("loginUser");
//		}
//	}
//	
//	/**
//	 * ログイン状態を確認する
//	 * @param session
//	 * @return ログインしていれば true、していなければ false
//	 */
//	public boolean isLoggedIn(HttpSession session) {
//		return session.getAttribute("loginUser") != null;
//	}

