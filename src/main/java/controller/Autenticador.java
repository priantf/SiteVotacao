package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Eleitor;
import model.EleitorDAOImpl;


@WebServlet(name = "Autenticador.action", urlPatterns = {"/Autenticador.action"})
public class Autenticador extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}
		
		String tituloEleitor = req.getParameter("nomeUsuario");
		String senha = req.getParameter("senha");
		
		EleitorDAOImpl sEleitor = new EleitorDAOImpl();
        Eleitor uBD = sEleitor.findByTitulo(tituloEleitor);  
        
		ServletContext sc = req.getServletContext();
        if (uBD!= null && uBD.getSenha().equals(senha)){
            try{
                req.getSession().setAttribute("eleitorLogado",uBD);
                sc.getRequestDispatcher("/html/home.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/html/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }
		
	}// doPost
}// Autenticador.java
