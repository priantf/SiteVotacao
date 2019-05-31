package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.CandidatoDAOImpl;
import model.Eleitor;
import model.EleitorDAOImpl;
import model.VotoDAOImpl;

@WebServlet(name = "ValidarVotacao.action", urlPatterns = {"/ValidarVotacao.action"})
public class ValidarVotacao extends HttpServlet{
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        try{
        	Eleitor eleitor = (Eleitor)req.getSession().getAttribute("eleitorLogado"); 
        	if (eleitor.getLiberado() == 1) {
        		System.out.println("LIBERADOOO" + eleitor.getLiberado());
        	}
        	sc.getRequestDispatcher("/html/votacao_validar.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			
		}
		CandidatoDAOImpl cdao = new CandidatoDAOImpl();
		Integer numero_candidato = Integer.parseInt(req.getParameter("voto"));
		Candidato c = cdao.buscar(numero_candidato);
		req.getSession().setAttribute("candidato", c);
		
		ServletContext sc = req.getServletContext();
		
		try {
			sc.getRequestDispatcher("/html/votacao_concluir.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
