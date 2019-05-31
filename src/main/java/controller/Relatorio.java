package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.CandidatoDAOImpl;
import model.Voto;
import model.VotoDAOImpl;

@WebServlet(name = "Relatorio.action", urlPatterns = {"/Relatorio.action"})
public class Relatorio extends HttpServlet{
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
		Map<String,Integer> relatorio = new HashMap<String,Integer>();
		
		CandidatoDAOImpl candDAO = new CandidatoDAOImpl();
		List<Candidato> cands = candDAO.listar();
		
		VotoDAOImpl votoDAO = new VotoDAOImpl();
		for (Candidato candidato : cands) {
			Integer votos = votoDAO.contaVoto(candidato.getNumero());
			//System.out.println("AAAAAAAA"+candidato.getNome());
			relatorio.put(candidato.getNome(), votos);
		}
		
		//for (Map.Entry<String,Integer> pair : relatorio.entrySet()) {
		//	System.out.println(pair.getKey() + " - " + pair.getValue());
		//}
		req.getSession().setAttribute("candidatos", relatorio);
        ServletContext sc = req.getServletContext();
        try{
        	sc.getRequestDispatcher("/html/relatorio.jsp").forward(req, resp);            
        } catch (Exception e){}
    }
}
