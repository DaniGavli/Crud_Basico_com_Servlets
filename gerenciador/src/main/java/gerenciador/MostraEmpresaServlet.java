package gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;


//@WebServlet("/mostraEmpresas")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
	
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		System.out.println(empresa.getNome());
		
		//leva alguma coisa, os dados da empresa
	   request.setAttribute("empresa", empresa);
	   
		//o caminho
	   RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");	
	   //leva a requisicao e leva a resposta
	   rd.forward(request, response);
	
	}

}
