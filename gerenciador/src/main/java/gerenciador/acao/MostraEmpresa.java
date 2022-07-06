package gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Mostrando dados da Empresa");
		
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);

	Banco banco = new Banco();
	
	Empresa empresa = banco.buscaEmpresaPeloId(id);
	
	System.out.println(empresa.getNome());
	
	//leva alguma coisa, os dados da empresa
   request.setAttribute("empresa", empresa);
   
	//o caminho
  return "forward:formAlteraEmpresa.jsp";	
   //leva a requisicao e leva a resposta
   //rd.forward(request, response);
	}

}
