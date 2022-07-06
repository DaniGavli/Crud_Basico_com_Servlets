package gerenciador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
   
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
	}
	
	@Override
	public void destroy() {
		//Filter.super.destroy();
	}

	
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse)  servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "gerenciador.acao."+ paramAcao;

		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);//c arrega a classe com o nome da string
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
		}
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
		rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		
		}
}
		
	}
	
	
	
