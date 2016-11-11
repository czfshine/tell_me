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

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
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
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("\r\n");

		int type = Integer.parseInt(request.getParameter("type"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PLANE?useUnicode=true&characterEncoding=utf-8", "root", "12345678");
			// PreparedStatement ps = con.prepareStatement("SELECT * FROM data
			// WHERE touser=\'" + type + "\';");
			// ResultSet rs = ps.executeQuery();

			switch (type) {
			case 0:// å é¤
				out.println("DELETE FROM data WHERE id=" + request.getParameter("id") + ";");
				PreparedStatement ps = con
						.prepareStatement("DELETE FROM data WHERE id=" + request.getParameter("id") + ";");
				Boolean rs = ps.execute();
				break;
			case 1:// æå¥

				String fromuser = request.getParameter("fromuser");
				String touser = request.getParameter("touser");
				String commit = request.getParameter("commit");
				out.println("select case when max(id) is null then 1 else max(id)+1 end from data;");
				PreparedStatement ps1 = con.prepareStatement("select max(id) from data;");
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				int maxid = rs1.getInt(1);
				out.print("INSERT INTO `plane`.`data` (`id`, `fromuser`, `touser`, `commit`) VALUES ('" + (maxid + 1)
						+ "', '" + fromuser + "', '" + touser + "', '" + commit + "');");
				ps1 = con.prepareStatement("INSERT INTO `plane`.`data` (`id`, `fromuser`, `touser`, `commit`) VALUES ('"
						+ (maxid + 1) + "', '" + fromuser + "', '" + touser + "', '" + commit + "');");
				Boolean rs2 = ps1.execute();
				break;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
