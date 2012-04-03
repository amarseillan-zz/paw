package services;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import exceptions.DuplicatedUsernameException;

public class addUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String lastName  = req.getParameter("lastName");
		String email  = req.getParameter("email");
		String number = req.getParameter("number");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try{
		User user = new User(name, lastName, email, number, username, password);
		}catch(DuplicatedUsernameException e){
			e.printStackTrace();
		}
	}

//not in use here but probably will be useful for password encryption somewhere else ;) We should not store the password without encryption
	public static String md5(String input) throws NoSuchAlgorithmException {
		String result = input;
		if(input != null) {
			MessageDigest md = MessageDigest.getInstance("MD5"); //or "SHA-1"
			md.update(input.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			result = hash.toString(16);
			while(result.length() < 32) {
				result = "0" + result;
			}
		}
		return result;
	}
}

