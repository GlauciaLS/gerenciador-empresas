package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 0;
	
	static {
		Empresa empresa = new Empresa(chaveSequencial++, "Alura");		
		Empresa empresa2 = new Empresa(chaveSequencial++, "Caelum");		
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		lista.removeIf(empresa -> empresa.getId() == id);		
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		Optional<Empresa> empresaBuscada = lista.stream().filter(empresa -> empresa.getId() == id).findFirst();
		return empresaBuscada.isPresent() ? empresaBuscada.get() : null;
	}

	public void alteraEmpresa(Integer idEmpresa, String nomeEmpresa, Date dataAberturaEmpresa) {
		Empresa empresa = buscaEmpresaPeloId(idEmpresa);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaEmpresa);
	}

}
