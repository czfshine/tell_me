package com.czfshine.tellme;

import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.setContentType("text/html; charset=utf-8");
		// request.setContentType("text/html,charset=utf-8");
		PrintWriter out = response.getWriter();

		out.write("\r\n");
		out.write(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
		out.write("\r\n");
		out.write("<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n");
		out.write("<script src=\"./js/jquery-2.0.0.min.js\"></script>\r\n");
		out.write("<script src=\"./js/jquery-ui.js\"></script>\r\n");
		out.write("<script type=\"text/javascript\">\r\n");
		out.write("function ajaxSubmit(frm, fn) {\r\n");
		out.write("    var dataPara = getFormJson(frm);\r\n");
		out.write("    //console.log(frm);\r\n");
		out.write("    $.ajax({\r\n");
		out.write("        url: frm.action,\r\n");
		out.write("        type: frm.method,\r\n");
		out.write("        data: dataPara,\r\n");
		out.write("        success: fn\r\n");
		out.write("    });\r\n");
		out.write("}\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("function getFormJson(frm) {\r\n");
		out.write("    var o = {};\r\n");
		out.write("    var a = $(frm).serializeArray();\r\n");
		out.write("    $.each(a, function () {\r\n");
		out.write("        if (o[this.name] !== undefined) {\r\n");
		out.write("            if (!o[this.name].push) {\r\n");
		out.write("                o[this.name] = [o[this.name]];\r\n");
		out.write("            }\r\n");
		out.write("            o[this.name].push(this.value || '');\r\n");
		out.write("        } else {\r\n");
		out.write("            o[this.name] = this.value || '';\r\n");
		out.write("        }\r\n");
		out.write("    });\r\n");
		out.write("\r\n");
		out.write("    return o;\r\n");
		out.write("}\r\n");
		out.write("\r\n");
		out.write("$(document).ready(function(){\r\n");
		out.write("    $('.form-horizontal').bind('submit', function(event){\r\n");
		out.write("    \tevent.preventDefault();\r\n");
		out.write("    \t//console.log(event.type);\r\n");
		out.write("        ajaxSubmit(this, function(data){\r\n");
		out.write("        \t\r\n");
		out.write("        \tvar json = eval('(' + data + ')');\r\n");
		out.write("        \tif(json.error==3){\r\n");
		out.write("        \t\twindow.location.href=json.url;\r\n");
		out.write("        \t}\r\n");
		out.write("        \tif(json.error==4){\r\n");
		out.write("        \t\talert(\"注册成功\")\r\n");
		out.write("        \t}\r\n");
		out.write("        \tif(json.error==0){\r\n");
		out.write("        \t\talert(\"密码错误\")\r\n");
		out.write("        \t}\r\n");
		out.write("        \t\r\n");
		out.write("        });\r\n");
		out.write("        return false;\r\n");
		out.write("    });\r\n");
		out.write("});\r\n");
		out.write("\r\n");
		out.write("</script>\r\n");
		out.write("\r\n");
		out.write("<title>留言</title>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<div class=\"container-fluid\">\r\n");
		out.write("\t\t<div class=\"row-fluid\">\r\n");
		out.write("\t\t\t<div class=\"span12\">\r\n");
		out.write("\t\t\t\t<h3>请登录</h3>\r\n");
		out.write("\t\t\t\t<form class=\"form-horizontal\" method=\"post\" action=\"./user.jsp\">\r\n");
		out.write("\t\t\t\t\t<div class=\"control-group\">\r\n");
		out.write("\t\t\t\t\t\t<label class=\"control-label\" for=\"inputEmail\">用户名</label>\r\n");
		out.write("\t\t\t\t\t\t<div class=\"controls\">\r\n");
		out.write("\t\t\t\t\t\t\t<input id=\"inputEmail\" type=\"text\"  name=\"username\" />\r\n");
		out.write("\t\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t<div class=\"control-group\">\r\n");
		out.write("\t\t\t\t\t\t<label class=\"control-label\" for=\"inputPassword\">密码</label>\r\n");
		out.write("\t\t\t\t\t\t<div class=\"controls\">\r\n");
		out.write("\t\t\t\t\t\t\t<input id=\"inputPassword\" type=\"password\" name=\"password\" />\r\n");
		out.write("\t\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t<input class=\"hide input-medium search-query\"\r\n");
		out.write("\t\t\t\t\t\ttype=\"text\" value=\"1\" name=\"p\" />\r\n");
		out.write("\t\t\t\t\t<div class=\"control-group\">\r\n");
		out.write("\t\t\t\t\t\t<div class=\"controls\">\r\n");
		out.write("\t\t\t\t\t\t\t<label class=\"checkbox\">\r\n");
		out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" />\r\n");
		out.write("\t\t\t\t\t\t\t\t记住我</label>\r\n");
		out.write("\t\t\t\t\t\t\t<button type=\"login\" class=\"btn\">登陆或注册</button>\r\n");
		out.write(
				"\t\t\t\t\t\t\t<!--<button type=\"signin\" class=\"btn\" formaction=\"./user.jsp\">3</button>-->\r\n");
		out.write("\t\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t\t</div>\r\n");
		out.write("\t\t\t\t</form>\r\n");
		out.write("\t\t\t</div>\r\n");
		out.write("\r\n");
		out.write("\t\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>");
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
