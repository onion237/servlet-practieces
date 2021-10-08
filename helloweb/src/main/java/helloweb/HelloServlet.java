package helloweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameterMap().forEach((key, value) -> {
			System.out.println(key);
			Arrays.stream(value).forEach(System.out::println);
		});

		response.setContentType("text/html; charset=utf-8");

		PrintWriter pw = response.getWriter();
		pw.print("<h1>Hello World</ht>");
	}

}
