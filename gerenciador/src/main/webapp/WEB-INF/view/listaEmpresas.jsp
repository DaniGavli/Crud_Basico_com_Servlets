<%@ page import="java.util.List,gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
//scriptlet
//String nomeEmpresa = (String)request.getAttribute("empresa");
//System.out.println(nomeEmpresa);
%>

<html><body>
	<a href="/gerenciador/entrada?acao=NovaEmpresaForm">Cadastrar Nova Empresa </a><br>
	<c:import url="logout-parcial.jsp" />
	

    Usuario Logado: ${usuarioLogado.login }
    <br>
    <br>
    <br>

    <c:if test="${not empty empresa}">
        Empresa ${empresa} cadastrada com sucesso!
    </c:if>

Lista de Empresas: <br/>

<ul>
   <c:forEach items="${empresas }" var="empresa">
   
   	<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></li>
  <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">edita</a>
  <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remove</a>
    
   </c:forEach>
</ul>

<ul>
    <%
        List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
         for (Empresa empresa : lista) { 
    %>
        <li><%= empresa.getNome() %></li>
    <%
        }
    %>
    </ul>

</body></html>