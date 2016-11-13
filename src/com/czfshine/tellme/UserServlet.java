package com.czfshine.tellme;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */ 
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PLANE?useUnicode=true&characterEncoding=utf-8", "root", "12345678");
			// PreparedStatement ps = con.prepareStatement("SELECT * FROM data
			// WHERE touser=\'" + type + "\';");
			// ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = con.prepareStatement("select max(id) from user;");
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int maxid = rs1.getInt(1);

			// out.println("select * from data where username='"+username+"';");
			ps1 = con.prepareStatement("select * from user where username='" + username + "';");
			rs1 = ps1.executeQuery();
			if (rs1.next()) {// ç¨æ·å­å¨
				String salt = rs1.getString("salt");
				String m = rs1.getString("md5");
				MessageDigest tmd5 = MessageDigest.getInstance("md5");
				String pmd5 = "";
				byte[] by = tmd5.digest((password + salt).getBytes());
				for (int i = 0; i < by.length; i++) {
					pmd5 += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00).substring(6);
				}

				if (pmd5.equals(m)) {
					out.println("{error:3,url:'./plane.jsp?username=" + username + "&p=1'}");
				} else {
					out.println("{error:4}");
				}

			} else {
				String datetime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(Calendar.getInstance().getTime());
				MessageDigest md5 = MessageDigest.getInstance("md5");
				String salt = "";
				byte[] by = md5.digest(datetime.getBytes());
				for (int i = 0; i < by.length; i++) {
					salt += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00).substring(6);
				}

				MessageDigest tmd5 = MessageDigest.getInstance("md5");
				String pmd5 = "";
				by = tmd5.digest((password + salt).getBytes());
				for (int i = 0; i < by.length; i++) {
					pmd5 += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00).substring(6);
				}

				ps1 = con.prepareStatement("INSERT INTO `plane`.`user` (`id`, `username`, `salt`, `md5`) VALUES ("
						+ (maxid + 1) + ", '" + username + "', '" + salt + "', '" + pmd5 + "');");
				Boolean rs2 = ps1.execute();
				if (rs2) {
					out.println("{error:2}");
				} else {
					out.println("{error:0}");
				}
			}

			out.write('\r');
			out.write('\n');
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
