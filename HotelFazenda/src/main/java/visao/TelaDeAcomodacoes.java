package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class TelaDeAcomodacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaDeAcomodacoes frame = new TelaDeAcomodacoes();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// abre a tela em full screen
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeAcomodacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[200px:200px:200px][830.00,grow]", "[40px:49.00px:40px][571.00,grow,fill][60px:60px:60px]"));

		JPanel BarraLateral = new JPanel();
		BarraLateral.setBackground(new Color(255, 255, 255));
		contentPane.add(BarraLateral, "cell 0 1 1 2,grow");
		BarraLateral.setLayout(new MigLayout("", "[131px,grow]",
				"[20px:20px:20px][40px][40px][40px][40px][40px][251.00,grow][98.00]"));

		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblHome.setBackground(new Color(0, 204, 0));
		lblHome.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Home.jpg")));
		BarraLateral.add(lblHome, "cell 0 1,grow");

		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblHospede.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Hospede.jpg")));
		BarraLateral.add(lblHospede, "cell 0 2,grow");

		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblAtividades.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Atividades.jpg")));
		BarraLateral.add(lblAtividades, "cell 0 3,grow");

		JLabel lblQuartos = new JLabel("Quartos");
		lblQuartos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblQuartos.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Quartos.jpg")));
		BarraLateral.add(lblQuartos, "cell 0 4,grow");

		JLabel lblServicos = new JLabel("Serviços");
		lblServicos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblServicos.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Servicos.jpg")));
		BarraLateral.add(lblServicos, "cell 0 5,grow");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel, "cell 0 7,growx,aligny baseline");
		panel.setLayout(new MigLayout("", "[][]", "[][30.00][29.00][32.00]"));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Avatar.jpg")));
		panel.add(lblNewLabel_4, "cell 0 0 1 3,alignx center");

		JLabel lblNewLabel_2 = new JLabel("Erik Roncaglio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_2, "cell 1 1,aligny bottom");

		JLabel lblNewLabel_3 = new JLabel("erikroncaglio@gmail.com");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(lblNewLabel_3, "cell 1 2,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Sair");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Sair.png")));
		panel.add(lblNewLabel_5, "cell 0 3 2 1,alignx center,aligny top");

		JPanel BarraSuperior = new JPanel();
		BarraSuperior.setBackground(new Color(255, 255, 255));
		contentPane.add(BarraSuperior, "cell 0 0 2 1,grow");
		BarraSuperior.setLayout(new MigLayout("",
				"[40px:54.00px:40px][150.00][300px:360.00px:300px][grow][40px:40px:40px,right]", "[29.00px]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		BarraSuperior.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 33, 31);
		lblNewLabel.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/logo.png")));
		panel_3.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		BarraSuperior.add(panel_4, "cell 2 0,grow");
		panel_4.setLayout(new MigLayout("", "[20px][251.00px]", "[21px]"));

		JLabel lblNewLabel_6 = new JLabel("");
		panel_4.add(lblNewLabel_6, "cell 0 0,alignx left,aligny top");
		lblNewLabel_6.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/search.png")));

		txtPesquisa = new JTextField();
		panel_4.add(txtPesquisa, "cell 1 0,growx,aligny top");
		txtPesquisa.setBackground(new Color(245, 245, 245));
		txtPesquisa.setText("Search");
		txtPesquisa.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		BarraSuperior.add(panel_2, "cell 4 0,grow");

		JLabel lblNewLabel_8 = new JLabel("");
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/SinoNotificacao.jpg")));

		JPanel Principal = new JPanel();
		Principal.setBackground(new Color(250, 250, 250));
		contentPane.add(Principal, "cell 1 1,grow");
		Principal.setLayout(new MigLayout("", "[100px:215.00px,grow][150px:171.00px,grow][180.00,grow]", "[44px][14px][14px][-1.00][237.00,grow][230.00,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Acomodações");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		Principal.add(lblNewLabel_1, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel_7 = new JLabel("Descubra nossas acomodações feitas sob medida para o seu conforto, ");
		Principal.add(lblNewLabel_7, "cell 0 1,alignx left,aligny top");
		
		JLabel lblNewLabel_9 = new JLabel("proporcionando ambientes aconchegantes e climatizados para que você desfrute de momentos relaxantes.");
		Principal.add(lblNewLabel_9, "cell 0 2,alignx left,aligny top");
		
		JPanel panel_8 = new JPanel();
		Principal.add(panel_8, "cell 0 4,grow");
		panel_8.setLayout(new MigLayout("", "[208px,grow]", "[14.00px,grow][-11.00px][8.00][][][][][][][]"));
		
		JPanel panel_11 = new JPanel();
		
		panel_8.add(panel_11, "cell 0 0 1 8,grow");
		panel_11.setLayout(null);
		
		JLabel lblQuartoSimples = new JLabel("");
		lblQuartoSimples.setBounds(0, 0, 281, 164);
		lblQuartoSimples.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/Imagens/QuartoSimples.jpg")));
		panel_11.add(lblQuartoSimples);
		
		JLabel lblNewLabel_16 = new JLabel("Apartamento Standard");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_16, "cell 0 8,growx,aligny top");
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		panel_8.add(lblNewLabel_10, "cell 0 9,alignx left,aligny top");
		
		JPanel panel_9 = new JPanel();
		Principal.add(panel_9, "cell 1 4,grow");
		panel_9.setLayout(new MigLayout("", "[213px,grow]", "[25px,grow][14px][][][][][][][]"));
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12, "cell 0 0 1 7,grow");
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_12.add(lblNewLabel_13);
		
		JLabel lblNewLabel_17 = new JLabel("Apartamento Master");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_17, "cell 0 7,growx,aligny top");
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_9.add(lblNewLabel_12, "cell 0 8,alignx left,aligny top");
		
		JPanel panel_10 = new JPanel();
		Principal.add(panel_10, "cell 2 4,grow");
		panel_10.setLayout(new MigLayout("", "[222px,grow]", "[25px,grow][14px][][][][][][][]"));
		
		JPanel panel_13 = new JPanel();
		panel_10.add(panel_13, "cell 0 0 1 7,grow");
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel_13.add(lblNewLabel_15);
		
		JLabel lblNewLabel_18 = new JLabel("Apartamento Deluxe");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_10.add(lblNewLabel_18, "cell 0 7,growx,aligny top");
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_10.add(lblNewLabel_14, "cell 0 8,alignx left,aligny top");
		
		JPanel panel_7 = new JPanel();
		Principal.add(panel_7, "cell 0 5,grow");
		panel_7.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_6 = new JPanel();
		Principal.add(panel_6, "cell 1 5,grow");
		panel_6.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_5 = new JPanel();
		Principal.add(panel_5, "cell 2 5,grow");
		panel_5.setLayout(new MigLayout("", "[]", "[]"));

		JPanel BarraInferior = new JPanel();
		BarraInferior.setBackground(new Color(255, 255, 255));
		contentPane.add(BarraInferior, "cell 1 2,grow");
		BarraInferior.setLayout(
				new MigLayout("", "[][679.00,grow,center][center][center][center][]", "[42.00,grow,center]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		BarraInferior.add(panel_1, "cell 4 0,grow");
		panel_1.setLayout(new MigLayout("", "[][][][]", "[]"));

		JLabel lblInstagram = new JLabel("");
		panel_1.add(lblInstagram, "cell 0 0");
		lblInstagram.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/instagram.png")));

		JLabel lblFacebook = new JLabel("");
		panel_1.add(lblFacebook, "cell 1 0");
		lblFacebook.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Facebook.jpg")));

		JLabel lblWhatsapp = new JLabel("");
		panel_1.add(lblWhatsapp, "cell 2 0");
		lblWhatsapp.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/Whatsapp.jpg")));

		JLabel lblTwitter = new JLabel("");
		panel_1.add(lblTwitter, "cell 3 0");
		lblTwitter.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/twitter.jpg")));
	}
}
