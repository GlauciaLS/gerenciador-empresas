package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaEmpresa = request.getParameter("dataAbertura");
		
		Date dataFormatada;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatada = simpleDateFormat.parse(dataAberturaEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
			
		Banco banco = new Banco();
		banco.alteraEmpresa(idEmpresa, nomeEmpresa, dataFormatada);		
		
		response.sendRedirect("listaEmpresas");	
	}

}
