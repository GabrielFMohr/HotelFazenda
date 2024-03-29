package controle.HospedagemQuartos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;
import controle.HospedagemQuartos.HospedagemQuartoDAO;
import modelo.HospedagemQuartos;
import modelo.Hospedagens;
import modelo.Hospedes;
import modelo.Quartos;

public class HospedagemQuartoDAO implements IHospedagemQuartosDAO {

	private static HospedagemQuartoDAO instancia;

	private HospedagemQuartoDAO() {
	} // construtor privado

	/**
	 * Metodo singleton
	 * 
	 * @return conexao
	 */

	public static HospedagemQuartoDAO getConexao() {
		if (instancia == null) {
			instancia = new HospedagemQuartoDAO();
		}

		return instancia;
	}

	@Override
	public int InserirHospedagemQuartos(HospedagemQuartos Hosp) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO HospedagemQuartos (IdQuarto, IdHospedagem,IdHospede) VALUES (?, ?,?)";
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		int ChavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, Hosp.getQuarto().getIdQuarto());
			ps.setInt(2, Hosp.getHospedagem().getIdHospedagem());
			ps.setInt(3, Hosp.getHospede().getIdHospede());

			int result = ps.executeUpdate();
			if (result == 0) {
				throw new SQLException("Não foi possível inserir na tabela!");
			} else {
				ResultSet Rs = ps.getGeneratedKeys();
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
	public ArrayList<HospedagemQuartos> ListarHospedagemQuartos() {
		// TODO Auto-generated method stub

		ArrayList<HospedagemQuartos> Lista = new ArrayList<HospedagemQuartos>();

		String SQL = "SELECT * FROM HospedagensQuartos";

		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				HospedagemQuartos HospedagemQuartos = new HospedagemQuartos();

				Integer IdHospedagemQuarto = rs.getInt("IdHospedagemQuarto");

				// tem que preencher os atributos desses 3 objetos
				Quartos Quarto = new Quartos();

				Quarto.setMaxPessoas(rs.getInt("MaxPessoas"));
				Quarto.setTipoCama(rs.getString("TipoCama"));
				Quarto.setManutencao(rs.getString("Manutenção"));
				Quarto.setFrigobar(rs.getBoolean("Frigobar"));
				Quarto.setArCondicionado(rs.getBoolean("ArCondicionado"));
				Quarto.setBanheira(rs.getBoolean("Banheira"));
				Quarto.setTV(rs.getBoolean("TV"));
				Quarto.setPrecoDiaria(rs.getFloat("PrecoDiaria"));
				Quarto.setIdQuarto(rs.getInt("IdQuarto"));

				Hospedagens Hosp = new Hospedagens();

				Hosp.setCheckin(rs.getDate("Checkin"));
				Hosp.setCheckout(rs.getDate("Checkout"));
				Hosp.setPrecoTotal(rs.getFloat("PrecoTotal"));
				Hosp.setIdHospedagem(rs.getInt("IdHospedagem"));

				Hosp.setHospde(null);

				Hospedes Hospede = new Hospedes();

				Hospede.setNome(rs.getString("Nome"));
				Hospede.setCPF(rs.getString("CPF"));
				Hospede.setSobrenome(rs.getString("Sobrenome"));
				Hospede.setDataNasc(rs.getDate("data_nasc"));
				Hospede.setNacionalidade(rs.getString("Nacionalidade"));
				Hospede.setPronome(rs.getString("Pronome"));
				Hospede.setEmail(rs.getString("Email"));
				Hospede.setDataNasc(rs.getDate("DataNasc"));

				Hospede.setUsuario(null);

				HospedagemQuartos.setIdHospedagemQuarto(IdHospedagemQuarto);
				HospedagemQuartos.setQuarto(Quarto);
				HospedagemQuartos.setHospedagem(Hosp);
				HospedagemQuartos.setHospede(Hospede);

				Lista.add(HospedagemQuartos);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Lista;
	}

	@Override
	public boolean AtualizarHospedagemQuartos(HospedagemQuartos Hosp) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE HospedagensQuartos SET IdQuarto = ?, IdHospedagem = ?, IdHospede = ? Where IdHospedagemQuarto = ?";

		Conexao con = Conexao.getConexao();// instanciando
		Connection conBD = con.Conectar();// cria ponte de conexao

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, Hosp.getQuarto().getIdQuarto());
			ps.setInt(2, Hosp.getHospedagem().getIdHospedagem());
			ps.setInt(3, Hosp.getHospede().getIdHospede());
			ps.setInt(4, Hosp.getIdHospedagemQuarto());
			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean RemoverHospedagemQuartos(HospedagemQuartos Hosp) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM HospedagensQuartos WHERE IdHospede=?";

		Conexao con = Conexao.getConexao(); // instanciando
		Connection conBD = con.Conectar(); // cria "ponte"

		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, Hosp.getHospede().getIdHospede());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public HospedagemQuartos BuscarHospedagemQuartosPorNumero(int Num) {
		// TODO Auto-generated method stub
		HospedagemQuartos HospQuar = null;
		String SQL = "Select * from HospedagensQuartos where IdQuarto = ?";
		Conexao con = Conexao.getConexao();
		Connection conBD = con.Conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, Num);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				HospQuar = new HospedagemQuartos();

				HospQuar.setIdHospedagemQuarto(rs.getInt("IdHospedagemQuarto"));

				HospQuar.setHospede(null);
				HospQuar.setHospedagem(null);
				HospQuar.setQuarto(null);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.FecharConexao();
		}

		return HospQuar;
	}

}
