package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.Eleitor;
import model.EleitorDAOImpl;
import model.VotoDAOImpl;

@WebServlet(name = "Votacao.action", urlPatterns = {"/Votacao.action"})
public class Votacao extends HttpServlet{
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        try{
        	Eleitor eleitor = (Eleitor)req.getSession().getAttribute("eleitorLogado"); 
        	if (eleitor.getLiberado() == 1) {
        		System.out.println("LIBERADOOO" + eleitor.getLiberado());
        	}
        	sc.getRequestDispatcher("/html/votacao_concluir.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			
		}
		
		VotoDAOImpl sVoto = new VotoDAOImpl();
		EleitorDAOImpl eleitorDao = new EleitorDAOImpl();
		
		//Integer numero_candidato = Integer.parseInt(req.getParameter("voto"));
		Candidato c = (Candidato)req.getSession().getAttribute("candidato"); 
		Integer numero_candidato = c.getNumero();
		Eleitor eleitor = (Eleitor)req.getSession().getAttribute("eleitorLogado"); 
		
		if (eleitor.getLiberado() == 1 && eleitor.getJaVotou() == 0) {
			// String titulo = e.getTitulo();
			
			//Candidato c = new Candidato();
			//c.setNome("Lula");
			//c.setNumero(numero_candidato);
			
			sVoto.computaVoto(numero_candidato);
			eleitorDao.jaVotou(eleitor.getTitulo());
			
			req.getSession().setAttribute("votacao_concluida", true);
			//ServicoVotoImpl sVoto = new ServicoVotoImpl(entityManager);
		}
		ServletContext sc = req.getServletContext();
		
		try {
			sc.getRequestDispatcher("/html/voto_concluido.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
