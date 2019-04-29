package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voto;


@WebServlet("/votacao_controller")
public class VotacaoController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Voto v = new Voto();
		String titulo = req.getParameter("titulo");
		v.setTitulo(titulo);
		res.setContentType("application/json");
		PrintWriter escritorResposta = res.getWriter();
		escritorResposta.write(v.paraJSONString());
		escritorResposta.close();
	}
	

}
