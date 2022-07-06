package gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.acao.Acao;
import gerenciador.acao.AlteraEmpresas;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresa;
import gerenciador.acao.NovaEmpresa;
import gerenciador.acao.NovaEmpresaForm;
import gerenciador.acao.RemoveEmpresa;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "gerenciador.acao."+ paramAcao;

		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome da string
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
		}
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
		rd.forward(request, response);
		//return ;
		}else {
			response.sendRedirect(tipoEndereco[1]);
			//return ;
		}
}
	
	/*
	HttpSession sessao = request.getSession();
    boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
    boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
    if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
        response.sendRedirect("entrada?acao=LoginForm");
        return;
    }
*/	
	
	//String paramAcao = request.getParameter("acao");
		
	/*	
		//paramAcao.executa(request, response);
		String nome = null;
		if(paramAcao.equals("ListaEmpresas")) {    
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
		
		}else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("AlteraEmpresas")) {
			AlteraEmpresas acao = new AlteraEmpresas();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
			
	   }else if(paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);
	}
		*/
		

}
