package controller;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.Eleitor;
import model.ServicoEntityManager;
import model.Voto;
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
        	sc.getRequestDispatcher("/html/votacao.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			
		}
		
		VotoDAOImpl sVoto = new VotoDAOImpl();
		
		Integer numero_candidato = Integer.parseInt(req.getParameter("voto"));
		Eleitor eleitor = (Eleitor)req.getSession().getAttribute("eleitorLogado"); 
		
		ServletContext sc = req.getServletContext();
		if (eleitor.getLiberado() == 1) {
			// String titulo = e.getTitulo();
			
			Candidato c = new Candidato();
			//c.setNome("Lula");
			//c.setNumero(numero_candidato);
			Voto v = new Voto();
			//v.setId(0);
			v.setCandidato(numero_candidato);
			
			sVoto.computaVoto(v);

			//ServicoVotoImpl sVoto = new ServicoVotoImpl(entityManager);
		}
		
		
	}

}
