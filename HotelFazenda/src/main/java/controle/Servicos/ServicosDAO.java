package controle.Servicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Servicos;

public class ServicosDAO implements IServicosDAO {

	private static ServicosDAO instancia;

	private ServicosDAO() {

	}

	public static ServicosDAO getInstancia() {
		if (instancia == null) {
			instancia = new ServicosDAO();
		}
		return instancia;
	}

	@Override
	public int inserirServico(Servicos end) {
		String SQL = "INSERT INTO Servicos (PrecoServico, NomeServico, Quantidade) VALUES(?, ?, ?)";
		// TODO Auto-generated method stub
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		int ChavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement Ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);// se for um insert já
																								// conhcendo a chave
																								// primária não
			// adcionar o Statement.RETURN_GENERATED_KEYS
			Ps.setDouble(1, end.getPrecoServico());
			Ps.setString(2, end.getNomeServico());
			Ps.setInt(3, end.getQuantidade());

			int result = Ps.executeUpdate();
			if (result == 0) {
				throw new SQLException("Não foi possível cadastrar o serviço!");
			} else {
				ResultSet Rs = Ps.getGeneratedKeys();
				if (Rs.next()) {
					ChavePrimariaGerada = Rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return ChavePrimariaGerada;
	}

	@Override
	public ArrayList<Servicos> ListarServicos() {
		ArrayList<Servicos> Servico = new ArrayList<Servicos>();
		String SQL = "SELECT * FROM Servicos";
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Servicos Serv = new Servicos("a", 0.1);// tem que ver como vai ficar isso tbm, agr cque tem o construtor

				int IdServico = rs.getInt("IdServico");
				Float PrecoServico = rs.getFloat("PrecoServico");
				String NomeServico = rs.getString("NomeServico");
				Integer Quantidade = rs.getInt("Quantidade");

				Serv.setIdServico(IdServico);
				Serv.setPrecoServico(PrecoServico);
				Serv.setNomeServico(NomeServico);
				Serv.setQuantidade(Quantidade);

				Servico.add(Serv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return Servico;
	}

	/*
	 * Tem que possuir a chave primária(ID,CPF,CEP,etc)
	 * 
	 * Atualiza um registro já existente no banco de dados
	 * 
	 * O objeto passado já deve possuiur os novos valores porém deve possuir a mesma
	 * chave primária do registro que vai ser alteradio
	 * 
	 */
	@Override
	public boolean atualizarServico(Servicos end) {
		// Comando que vai ser executado no sql
		String SQL = "UPDATE Servicos SET Preco=?,NomeServico=? where IdServico=?";

		// abre a conexão e cria a "ponte de conexão" com MYsql
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		boolean retorno = false;

		try {
			PreparedStatement Ps = conBD.prepareStatement(SQL);

			Ps.setDouble(1, end.getPrecoServico());
			Ps.setString(2, end.getNomeServico());
			Ps.setInt(3, end.getIdServico());

			retorno = (Ps.executeUpdate() == 0 ? false : true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return retorno;
	}

	@Override
	public boolean removerServico(Servicos end) {

		String SQL = "Delete from Servicos Where IdServico = ?";
		// Método pra fazer a conexão com o banco
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		int retorno = 0;

		try {
			PreparedStatement Ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			Ps.setInt(1, end.getIdServico());
			retorno = Ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return (retorno == 0 ? false : true);

	}

	@Override
	public boolean limparServicos() {

		String SQL = "Delete from Servicos";
		// Método pra fazer a conexão com o banco
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		int retorno = 0;

		try {
			PreparedStatement Ps = conBD.prepareStatement(SQL);

			retorno = Ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return (retorno == 0 ? false : true);

	}

	@Override
	public Servicos buscarServicoPorNome(String nome) {
		// TODO Auto-generated method stub
		Servicos Serv = null;
		String sql = "Select * from Servicos where NomeServico = ?";
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(sql);

			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Serv = new Servicos(" ", 0.0);

				Serv.setIdServico(rs.getInt("IdServico"));
				Serv.setNomeServico(nome);
				Serv.setPrecoServico(rs.getFloat("PrecoServico"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return Serv;
	}
}
