import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns=("/exemplo_01"))
public class ExemploServlet extends HttpServlet{
	@Override
	public void doGet( HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			pw.write("Build com gradle funcionou");
		}catch(Exception e) {
			System.out.println("Erro ao dar build com gradle");
		}
	}
}