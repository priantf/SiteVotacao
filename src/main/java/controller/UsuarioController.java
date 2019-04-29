package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet(name = "usuario_controller", urlPatterns = { "/usuario_controller" })
public class UsuarioController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			String titulo = request.getParameter("titulo");
			String senha = request.getParameter("senha");
			
			if (titulo.equals("123451") && senha.equals("admin")) {
				response.sendRedirect("html/home_mesario.html");
			} else if (titulo.equals("123452") && senha.equals("admin")) {
				response.sendRedirect("html/votacao.html");
			} else if (titulo.equals("123453") && senha.equals("admin")) {
				response.sendRedirect("html/home_chefe.html");
			}else {
				response.sendRedirect("/SiteVotacao");
			}

		} catch (Exception e) {

		}
	}

}
