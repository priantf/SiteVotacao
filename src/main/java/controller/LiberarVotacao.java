package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Eleitor;
import model.EleitorDAOImpl;

@WebServlet(name = "LiberarVotacao.action", urlPatterns = {"/LiberarVotacao.action"})
public class LiberarVotacao extends HttpServlet{
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        try{
        	sc.getRequestDispatcher("/html/liberar_votacao.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			
		}
		EleitorDAOImpl eleitorDao = new EleitorDAOImpl();
		
		String titulo = req.getParameter("titulo");
		ServletContext sc = req.getServletContext();
		try {	
			eleitorDao.liberarVotacao(titulo);
			Eleitor eleitor = eleitorDao.findByTitulo(titulo);
			req.getSession().setAttribute("votacao", eleitor);
			sc.getRequestDispatcher("/html/liberar_votacao.jsp").forward(req, resp); 
		}catch(Exception e) {
			
		}

		
	}

}
