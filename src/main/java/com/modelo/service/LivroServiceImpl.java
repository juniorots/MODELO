package com.modelo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.LivroException;
import com.modelo.dao.Conectar;
import com.modelo.model.Livro;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;

public class LivroServiceImpl implements LivroService {

	private final String SALVAR = "INSERT INTO livro (nome, ano) VALUES (?, ?)";
	private final String LISTAR = "SELECT * FROM livro";
//	private final String ATUALIZAR = "UPDATE livro SET nome = ?, ano = ? WHERE livro_id = ?";
//	private final String EXCLUIR = "DELETE FROM livro WHERE livro_id = ?";
	
	@Override
	public boolean salvarLivro(Livro livro) throws LivroException {
		boolean retorno = false;
		try {
			PreparedStatement ps = Conectar.getConnection().prepareStatement(SALVAR);
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAno());
			if (ps.executeUpdate() > 0) retorno = true;
			ps.close();
			Conectar.getConnection().close();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return retorno;
	}

	@Override
	public List<Livro> listarLivros() throws LivroException {
		List<Livro> tmp = new ArrayList<>();
		try {
			Statement s = Conectar.getConnection().createStatement();
			ResultSet rs = s.executeQuery(LISTAR);
			while (rs.next()) {
				Livro l = new Livro();
				l.setAno(rs.getString("ano"));
				l.setNome(rs.getString("nome"));
				tmp.add(l);
			}
			s.close();
			rs.close();
			Conectar.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return tmp;		
	}

}
