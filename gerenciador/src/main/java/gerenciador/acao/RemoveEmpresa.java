package gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Acao Remove Empresa");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		//response.sendRedirect("entrada?acao=ListaEmpresas");
		
	return "redirect:entrada?acao=ListaEmpresas";
	}
	
	

}
