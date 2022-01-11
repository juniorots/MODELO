package com.modelo.service;

import java.util.List;

import com.modelo.LivroException;
import com.modelo.model.Livro;

public interface LivroService {
	public boolean salvarLivro(Livro livro) throws LivroException;
	
	public List<Livro> listarLivros() throws LivroException;
}
