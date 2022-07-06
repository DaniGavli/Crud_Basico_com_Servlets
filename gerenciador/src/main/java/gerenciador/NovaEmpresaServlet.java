package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doGet - o doPost para nao receber parametros
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura= null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura= sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
			
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//https://cursos.alura.com.br/forum/topico-qual-seria-a-maior-diferenca-na-pratica-entre-o-redirect-e-o-forward-217711
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");	
		//chamar o jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");	
		//request.setAttribute("empresa", empresa.getNome());
		//rd.forward(request, response);
		
		/*
		 * mandei o codigo para novaEmpresaCriada.jsp
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + nomeEmpresa + " Cadastrada com sucesso!</body></html>");
	*/
	}

}
