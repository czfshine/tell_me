package com.czfshine.tellme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("<!-- head -->\r\n");
		out.write(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
		out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
		out.write("<title>留言</title>\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\" />\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/default.css\">\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
		out.write("\thref=\"fonts/font-awesome-4.3.0/css/font-awesome.min.css\" />\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
		out.write("\thref=\"fonts/vicons/vicons-font.css\" />\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\" />\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/chat.css\" />\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");

		String user = request.getParameter("username");
		String touser = request.getParameter("touser");

		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<div class=\"htmleaf-container\">\r\n");
		out.write("\t\t<div class=\"content\">\r\n");
		out.write("\t\t\t<div class=\"chat-window\">\r\n");
		out.write("\t\t\t\t<div class=\"chat-messages\">\r\n");
		out.write("\t\t\t\t\t<ol class=\"chat-messages-list\">\r\n");
		out.write("\t\t\t\t\t\t");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PLANE?useUnicode=true&characterEncoding=utf-8", "root", "12345678");
			PreparedStatement ps = con.prepareStatement("SELECT *  FROM data WHERE touser=\'" + user
					+ "\' AND fromuser=\'" + touser + "\' OR touser=\'" + touser + "\' AND fromuser=\'" + user + "\';");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String fromuser = rs.getString("fromuser");
				String commit = rs.getString("commit");
				String tousers = rs.getString("touser");
				;

				if (!fromuser.equals(user)) {

					out.write("\r\n");
					out.write("\r\n");
					out.write("\t\t\t\t\t\t<li class=\"chat-message chat-message-friend\">\r\n");
					out.write("\t\t\t\t\t\t\t<div class=\"chat-message-bubble\">\r\n");
					out.write("\t\t\t\t\t\t\t\t");

					out.println(commit);

					out.write("\r\n");
					out.write("\t\t\t\t\t\t\t</div>\r\n");
					out.write("\t\t\t\t\t\t</li>\r\n");
					out.write("\t\t\t\t\t\t");

				} else {

					out.write("\r\n");
					out.write("\r\n");
					out.write("\t\t\t\t\t\t<li class=\"chat-message chat-message-self\">\r\n");
					out.write("\t\t\t\t\t\t\t<div class=\"chat-message-bubble\">\r\n");
					out.write("\t\t\t\t\t\t\t\t");

					out.println(commit);

					out.write("\r\n");
					out.write("\t\t\t\t\t\t\t</div>\r\n");
					out.write("\t\t\t\t\t\t</li>\r\n");
					out.write("\t\t\t\t\t\t");

				}
			}
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.write("\r\n");
		out.write("\t\t\t\t\t</ol>\r\n");
		out.write("\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t<div class=\"chat-input-bar\">\r\n");
		out.write("\t\t\t\t\t<div class=\"chat-info-container\"></div>\r\n");
		out.write("\t\t\t\t\t<div class=\"chat-effect-container\">\r\n");
		out.write("\t\t\t\t\t\t<div class=\"chat-effect-bar\"></div>\r\n");
		out.write("\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t<div class=\"chat-input-wrapper\">\r\n");
		out.write("\t\t\t\t\t\t<button class=\"chat-input-tool\" onclick=\"window.history.back(); \">\r\n");
		out.write("\t\t\t\t\t\t\t<i class=\"icon icon-backward\"></i>\r\n");
		out.write("\t\t\t\t\t\t</button>\r\n");
		out.write("\t\t\t\t\t\t<div class=\"chat-input\" contenteditable></div>\r\n");
		out.write("\t\t\t\t\t\t<button class=\"chat-send\">\r\n");
		out.write("\t\t\t\t\t\t\t<i class=\"fa fa-paper-plane\"></i>\r\n");
		out.write("\t\t\t\t\t\t</button>\r\n");
		out.write("\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t</div>\r\n");
		out.write("\t\t\t</div>\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div class=\"username\" id=\"");
		out.print(user);
		out.write("\"></div>\r\n");
		out.write("\t<div class=\"tousername\" id=\"");
		out.print(touser);
		out.write("\"></div>\r\n");
		out.write("\t<script src=\"js/jquery.min.js\"></script>\r\n");
		out.write("\t<script src=\"js/TweenMax.min.js\"></script>\r\n");
		out.write("\t<script src=\"js/chat.js\"></script>\r\n");
		out.write("\t<script type=\"text/javascript\">\r\n");
		out.write("\t\t\r\n");
		out.write("\t</script>\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
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
