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
 * Servlet implementation class PlaneServlet
 */
@WebServlet("/PlaneServlet")
public class PlaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PLANE?useUnicode=true&characterEncoding=utf-8", "root", "12345678");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
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
		out.write("\r\n");
		out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
		out.write("<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n");
		out.write("<link rel=\"stylesheet\" href=\"./css/bootstrap-combined.min.css\">\r\n");
		out.write("<script src=\"./js/jquery-2.0.0.min.js\"></script>\r\n");
		out.write("<script src=\"./js/jquery-ui.js\"></script>\r\n");
		out.write("<script src=\"./js/bootstrap.min.js\"></script>\r\n");
		out.write("<script type=\"text/javascript\">\r\n");
		out.write("function post(URL, PARAMS) {\r\n");
		out.write("\t $.ajax({\r\n");
		out.write("         \"type\" : 'post',\r\n");
		out.write("         \"url\" : URL,\r\n");
		out.write("         \"dataType\" : \"json\",\r\n");
		out.write("         \"data\" : PARAMS,\r\n");
		out.write("         \"success\" : function(resp) {\r\n");
		out.write("         },\r\n");
		out.write("         \"error\":function(emsg){\r\n");
		out.write("         }\r\n");
		out.write("     });\r\n");
		out.write("\t \r\n");
		out.write("\t}\r\n");
		out.write("function del(id){\r\n");
		out.write("\tpost('./data.jsp',{type:0,id:id});\r\n");
		out.write("\t$(\"#\"+id).hide();\r\n");
		out.write("\t\r\n");
		out.write("}\r\n");
		out.write("</script>\r\n");
		out.write("<title>鐣欒█鏉�</title>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<div class=\"container-fluid\">\r\n");
		out.write("\t\t<div class=\"row-fluid\">\r\n");
		out.write("\t\t\r\n");
		out.write("\t\t\t<!--  12绛夊垎 2:6:4 -->\r\n");
		out.write("\t\t\t<div class=\"span12\">\r\n");
		out.write("\t\t\t\t<div class=\"row-fluid\">\r\n");
		out.write("\t\t\t\t\t<!-- left -->\r\n");
		out.write("\t\t\t\t\t<div class=\"span2\"></div>\r\n");
		out.write("\t\t\t\t\t<!-- center -->\r\n");
		out.write("\t\t\t\t\t<div class=\"span6\">\r\n");
		out.write("\t\t\t\t\t\t<!-- 鏍囬 -->\r\n");
		out.write("\t\t\t\t\t\t<div class=\"page-header\">\r\n");
		out.write("\t\t\t\t\t\t\t<h1>\r\n");
		out.write("\t\t\t\t\t\t\t\t");

		String type = request.getParameter("username");
		int p = Integer.parseInt(request.getParameter("p"));
		out.println(type);

		out.write("<small>鐨勭暀瑷�鏉�</small>\r\n");
		out.write("\t\t\t\t\t\t\t</h1>\r\n");
		out.write("\t\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t\t<!-- 鍐呭 -->\r\n");
		out.write("\t\t\t\t\t\t<div class=\"list-group\">\r\n");
		out.write("\t\t\t\t\t\t\t");

		try {
			PreparedStatement ps = con.prepareStatement("SELECT count(*)  FROM data WHERE touser=\'" + type + "\';");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			int pages = 0, max = 8;
			pages = count / max + 1;
			if (count % max == 0) {
				pages--;
			}
			// out.println("SELECT * FROM data WHERE touser=\'" + type + "\'
			// limit "+(p-1)*max+","+max+";");
			ps = con.prepareStatement("SELECT *  FROM data WHERE touser=\'" + type + "\'   order by id desc limit "
					+ (p - 1) * max + "," + max + " ;");
			rs = ps.executeQuery();
			String last = "";
			while (rs.next()) {
				String fromuser = rs.getString("fromuser");
				String commit = rs.getString("commit");
				if (!fromuser.equals(last)) {

					out.write("\r\n");
					out.write("\r\n");
					out.write("\t\t\t\t\t\t\t<a rel=\"nofollow\" href=\"./chat.jsp?username=");
					out.println(type);
					out.write("&touser=");
					out.println(fromuser);
					out.write("\" class=\"list-group-item active\"> \r\n");
					out.write("\t\t\t\t\t\t\t");

					out.println(fromuser);

					out.write("\r\n");
					out.write("\t\t\t\t\t\t\t</a>\r\n");
					out.write("\t\t\t\t\t\t\t");

					last = fromuser;
				}

				out.write("\r\n");
				out.write("\t\t\t\t\t\t\t<div id=\"");
				out.print(rs.getInt("id"));
				out.write("\" class=\"list-group-item\">\r\n");
				out.write("\t\t\t\t\t\t\t\t<p class=\"list-group-item-text\">\r\n");
				out.write("\t\t\t\t\t\t\t\t\t");

				out.println(commit);

				out.write("\r\n");
				out.write("\t\t\t\t\t\t\t\t <button onclick=\"del(");
				out.println(rs.getInt("id"));
				out.write(")\" type=\"button\" class=\"btn btn-danger  btn-sm right nofollow\">鍒犻櫎</button>\r\n");
				out.write("\t\t\t\t\t\t\t\t</p>\r\n");
				out.write("\t\t\t\t\t\t\t</div>\r\n");
				out.write("\t\t\t\t\t\t\t");

			}

			out.write("\r\n");
			out.write("\t\t\t\t\t\t\t\r\n");
			out.write("\t\t\t\t\t\t\t<!--\r\n");
			out.write("\t\t\t\t\t\t\t<div class=\"list-group-item\">\r\n");
			out.write("\t\t\t\t\t\t\t\t<span class=\"badge\">14</span>甯姪\r\n");
			out.write("\t\t\t\t\t\t\t</div>\r\n");
			out.write("\t\t\t\t\t\t\t<a rel=\"nofollow\" class=\"list-group-item active\"><span\r\n");
			out.write("\t\t\t\t\t\t\t\tclass=\"badge\">14</span>甯姪</a>\r\n");
			out.write("\t\t\t\t\t\t\t-->\r\n");
			out.write("\t\t\t\t\t\t</div>\r\n");
			out.write("\t\t\t\t\t\t<div class=\"pagination nofollow\">\r\n");
			out.write("\t\t\t\t\t\t\t<ul>\r\n");
			out.write("\t\t\t\t\t\t\t\t");
			if (p != 1) {
				out.write("\r\n");
				out.write("\t\t\t\t\t\t\t\t<li><a rel=\"nofollow\" href=\"./plane.jsp?username=");
				out.print(type);
				out.write('&');
				out.write('p');
				out.write('=');
				out.print(p - 1);
				out.write("\">涓婁竴椤�</a></li>\r\n");
				out.write("\t\t\t\t\t\t\t\t");
			}
			out.write("\r\n");
			out.write("\t\t\t\t\t\t\t\t\r\n");
			out.write("\t\t\t\t\t\t\t\t");
			for (int i = 1; i <= pages; i++) {
				out.write("\r\n");
				out.write("\t\t\t\t\t\t\t\t<li><a rel=\"nofollow\" href=\"./plane.jsp?username=");
				out.print(type);
				out.write('&');
				out.write('p');
				out.write('=');
				out.print(i);
				out.write('"');
				out.write('>');
				out.print(i);
				out.write("</a></li>\r\n");
				out.write("\t\t\t\t\t\t\t\t");
			}
			out.write("\r\n");
			out.write("\t\t\t\t\t\t\t\t\r\n");
			out.write("\t\t\t\t\t\t\t\t");
			if (p != pages && pages > 1) {
				out.write("\r\n");
				out.write("\t\t\t\t\t\t\t\t<li><a rel=\"nofollow\" href=\"./plane.jsp?username=");
				out.print(type);
				out.write('&');
				out.write('p');
				out.write('=');
				out.print(p + 1);
				out.write("\">涓嬩竴椤�</a></li>\r\n");
				out.write("\t\t\t\t\t\t\t\t");
			}
			out.write("\r\n");
			out.write("\t\t\t\t\t\t\t</ul>\r\n");
			out.write("\t\t\t\t\t\t</div>\r\n");
			out.write("\t\t\t\t\t</div>\r\n");
			out.write("\t\t\t\t\t<!-- RIGHT -->\r\n");
			out.write("\t\t\t\t\t<div class=\"span4\">\r\n");
			out.write("\t\t\t\t\t<br>\r\n");
			out.write("\t\t\t\t\t\t<form class=\"form-search\" action=\"./chat.jsp\">\r\n");
			out.write("\t\t\t\t\t\t\t<input class=\"input-medium search-query\" type=\"text\" name=\"touser\" />\r\n");
			out.write("\t\t\t\t\t\t\t<input class=\"hide input-medium search-query\" value=\"");
			out.println(type);
			out.write("\" type=\"text\" name=\"username\" />\r\n");
			out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn\">闂��</button>\r\n");
			out.write("\t\t\t\t\t\t</form>\r\n");
			out.write("\t\t\t\t\t<br>\r\n");
			out.write("\t\t\t\t\t <a  href=\"./mange.jsp?username=");
			out.print(type);
			out.write(
					"&p=1\" ><button type=\"button\" class=\"btn btn-primary  btn-sm right nofollow\">绠＄悊</button>\r\n");
			out.write("\t\t\t\t\t</a>\r\n");
			out.write("\t\t\t\t\t</div>\r\n");
			out.write("\t\t\t\t</div>\r\n");
			out.write("\t\t\t</div>\r\n");
			out.write("\t\t</div>\r\n");
			out.write("\t</div>\r\n");
			out.write("</body>\r\n");
			out.write("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.write(e.getMessage());
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
