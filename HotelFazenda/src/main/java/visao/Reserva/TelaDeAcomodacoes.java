package visao.Reserva;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.CurrentFunc;
import modelo.Funcionarios;
import net.miginfocom.swing.MigLayout;
import utils.DefaultModal;
import visao.Conta;
import visao.Home;
import visao.Login;
import visao.Atividade.TelaAtividades;
import visao.Funcionario.AdminFuncionarios;
import visao.Hospede.TelaDeHospedes;
import visao.Quarto.Quartos2;
import visao.Servico.TelaServicos;

public class TelaDeAcomodacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JPanel BarraLateral;
	protected JPanel BarraSuperior;
	protected JPanel BarraInferior;
	protected JPanel Principal;
	Funcionarios Func = CurrentFunc.getInstance().getLoggedInFuncionario();

	public TelaDeAcomodacoes() {
		setTitle("Tela de Acomodações");

		screen();

		JPanel Principal = new JPanel();
		Principal.setBackground(new Color(250, 250, 250));
		Principal.setLayout(new MigLayout("", "[420.00px:n][177.00px:n,grow][50px:n]",
				"[44px][14px][14px][-1.00][392.00px][97.00,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Acomodações");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		Principal.add(lblNewLabel_1, "cell 0 0,alignx left,aligny top");

		JLabel lblNewLabel_7 = new JLabel("Descubra nossas acomodações feitas sob medida para o seu conforto, ");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Principal.add(lblNewLabel_7, "cell 0 1,alignx left,aligny top");

		JLabel lblNewLabel_9 = new JLabel(
				"proporcionando ambientes aconchegantes e climatizados para que você desfrute de momentos relaxantes.");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Principal.add(lblNewLabel_9, "cell 0 2,alignx left,aligny top");

		JPanel panel_8 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};
		Principal.add(panel_8, "cell 0 4,grow");
		panel_8.setLayout(new MigLayout("", "[640px]", "[422px][25px][14px]"));

		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(1);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();
			}
		});

		panel_8.add(panel_11, "cell 0 0,grow");
		panel_11.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/11.png")));
		lblNewLabel_8.setBounds(27, -42, 870, 389);
		panel_11.add(lblNewLabel_8);

		JLabel lblQuartoSimples = new JLabel("");
		lblQuartoSimples.setBounds(7, 7, 626, 408);
		lblQuartoSimples.setHorizontalAlignment(SwingConstants.LEFT);

		panel_11.add(lblQuartoSimples);

		JLabel lblNewLabel_16 = new JLabel("Apartamento Standard");
		lblNewLabel_16.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_8.add(lblNewLabel_16, "cell 0 1,alignx left,aligny top");

		JLabel lblNewLabel_10 = new JLabel(
				"2-4 hóspedes · TV · ar-condicionado · 2 cama solteiro · 1 camas casal · 1 banheiro");
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_8.add(lblNewLabel_10, "cell 0 2,alignx left,aligny top");

		JPanel panel_9 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};

		Principal.add(panel_9, "cell 1 4,grow");
		panel_9.setLayout(new MigLayout("", "[641px]", "[422px][25px][14px]"));

		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(2);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();
			}
		});
		panel_9.add(panel_12, "cell 0 0,grow");
		panel_12.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/12.png")));
		lblNewLabel_11.setBounds(32, 0, 631, 304);
		panel_12.add(lblNewLabel_11);

		JLabel lblQuartoMediano = new JLabel("");
		lblQuartoMediano.setBounds(7, 7, 426, 323);

		panel_12.add(lblQuartoMediano);

		JLabel lblNewLabel_17 = new JLabel("Apartamento Master");
		lblNewLabel_17.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_9.add(lblNewLabel_17, "cell 0 1,alignx left,aligny top");

		JLabel lblNewLabel_12 = new JLabel(
				"2-6 hóspedes · TV · Frigobar · ar-condicionado · 2 cama solteiro · 2 camas casal · 2 banheiros");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_9.add(lblNewLabel_12, "cell 0 2,alignx left,aligny top");

		JPanel panel_10 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};

		Principal.add(panel_10, "cell 2 4,grow");
		panel_10.setLayout(new MigLayout("", "[641px]", "[422px][25px][14px]"));

		JPanel panel_13 = new JPanel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(3);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();

			}
		});
		panel_10.add(panel_13, "cell 0 0,grow");
		panel_13.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/13.png")));
		lblNewLabel_13.setBounds(25, -5, 641, 315);
		panel_13.add(lblNewLabel_13);

		JLabel lblQuartoBom = new JLabel("");
		lblQuartoBom.setBounds(7, 7, 627, 408);
		lblQuartoBom.setHorizontalAlignment(SwingConstants.LEFT);
		panel_13.add(lblQuartoBom);

		JLabel lblNewLabel_18 = new JLabel("Apartamento Deluxe");
		lblNewLabel_18.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_10.add(lblNewLabel_18, "cell 0 1,growx,aligny top");

		JLabel lblNewLabel_14 = new JLabel(
				"4-8 hóspedes · Banheira · TV · Frigobar · ar-condicionado · 4 camas solteiro · 2 camas casal · 3 banheiros");
		lblNewLabel_14.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_10.add(lblNewLabel_14, "cell 0 2,alignx left,aligny top");

		JPanel panel_7 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};
		Principal.add(panel_7, "cell 0 5,grow");
		panel_7.setLayout(new MigLayout("", "[608px]", "[356px][]"));

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(4);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();
			}
		});

		panel_7.add(panel, "cell 0 0,grow");
		panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/14.png")));
		lblNewLabel_6.setBounds(26, -42, 648, 364);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_20 = new JLabel("Apartamento Premium");
		lblNewLabel_20.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_7.add(lblNewLabel_20, "flowy,cell 0 1,aligny bottom");

		JLabel lblNewLabel_21 = new JLabel(
				"2-6 hóspedes . TV . Frigobar . Ar-condicionado\r\n . 2 cama casal . 2 cama solteiro . 2 banheiro");
		lblNewLabel_21.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_7.add(lblNewLabel_21, "cell 0 1");

		JPanel panel_6 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};
		Principal.add(panel_6, "cell 1 5,grow");
		panel_6.setLayout(new MigLayout("", "[grow]", "[grow][][]"));

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(5);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();
			}
		});
		panel_6.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(null);

		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(30, 0, 621, 281);
		lblNewLabel_22.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/15.png")));
		panel_1.add(lblNewLabel_22);

		JLabel lblNewLabel_23 = new JLabel("Apartamento Executivo");
		lblNewLabel_23.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_6.add(lblNewLabel_23, "cell 0 1");

		JLabel lblNewLabel_24 = new JLabel(
				"2-3 hóspedes . TV . Frigobar . Ar-condicionado\r\n . 1 cama solteiro\n . 1 banheiro ");
		lblNewLabel_24.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_6.add(lblNewLabel_24, "cell 0 2");

		JPanel panel_5 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
				g2d.dispose();
			}
		};
		Principal.add(panel_5, "cell 2 5,grow");
		panel_5.setLayout(new MigLayout("", "[grow]", "[grow][][]"));

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeQuartos telaDeQuartos = new TelaDeQuartos(6);
				telaDeQuartos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaDeQuartos.setVisible(true);
				dispose();
			}
		});
		panel_5.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(null);

		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon(TelaDeAcomodacoes.class.getResource("/visao/16.png")));
		lblNewLabel_25.setBounds(22, -38, 621, 346);
		panel_2.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("Apartamento Luxuoso");
		lblNewLabel_26.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		panel_5.add(lblNewLabel_26, "cell 0 1");

		JLabel lblNewLabel_27 = new JLabel(
				"1-3 hóspedes . TV . Frigobar . Ar-condicionado\r\n . 1 cama casal . 1 cama solteiro . 1 banheiro");
		lblNewLabel_27.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_5.add(lblNewLabel_27, "cell 0 2");
		contentPane.add(Principal, "cell 1 1,grow");

	}

	public void screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2218, 875);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("insets 0, gap 0", "[200px:1064px:200][grow]",
				"[73:69px:73,grow,center][560px,grow][52px]"));

		DefaultModal BarraLateral = new DefaultModal();
		BarraLateral.setBackground(new Color(255, 255, 255));
		contentPane.add(BarraLateral, "cell 0 1 1 2,grow");
		BarraLateral.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_10);
		panel_10.setLayout(new MigLayout("", "[93px]", "[32px,grow]"));

		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		panel_10.add(lblHome, "cell 0 0,alignx left,aligny center");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home TelaHome = new Home();
				TelaHome.setVisible(true);
				TelaHome.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();
			}
		});
		lblHome.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblHome.setBackground(new Color(0, 204, 0));
		lblHome.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Home.jpg")));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_9);
		panel_9.setLayout(new MigLayout("", "[138px,grow]", "[32px,grow]"));

		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setHorizontalAlignment(SwingConstants.LEFT);
		panel_9.add(lblAtividades, "cell 0 0,alignx left,aligny center");
		lblAtividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAtividades TelaAtiv = new TelaAtividades();
				TelaAtiv.setVisible(true);
				TelaAtiv.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();
			}
		});
		lblAtividades.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblAtividades.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Atividades.jpg")));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_7);
		panel_7.setLayout(new MigLayout("", "[120px,grow]", "[32px,grow]"));

		JLabel lblQuartos = new JLabel("Reservas");
		lblQuartos.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(lblQuartos, "cell 0 0,alignx left,aligny center");
		lblQuartos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeAcomodacoes TelaAco = new TelaDeAcomodacoes();
				TelaAco.setVisible(true);
				TelaAco.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();
			}
		});
		lblQuartos.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblQuartos.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/reserva.png")));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_8);
		panel_8.setLayout(new MigLayout("", "[115px,grow]", "[32px,grow]"));

		JLabel lblServicos = new JLabel("Serviços");
		lblServicos.setHorizontalAlignment(SwingConstants.LEFT);
		panel_8.add(lblServicos, "cell 0 0,alignx left,aligny center");
		lblServicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaServicos TelaServ = new TelaServicos();
				TelaServ.setVisible(true);
				TelaServ.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();
			}
		});
		lblServicos.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblServicos.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Servicos.jpg")));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_6);
		panel_6.setLayout(new MigLayout("", "[112px,grow]", "[32px,grow]"));

		JLabel lblNewLabel_19 = new JLabel("Quartos");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblNewLabel_19, "cell 0 0,alignx left,aligny center");
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Quartos2 q2 = new Quartos2();
				q2.setVisible(true);
				q2.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();

			}
		});
		lblNewLabel_19.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Quartos.jpg")));
		lblNewLabel_19.setFont(new Font("Segoe UI", Font.PLAIN, 25));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_5);
		panel_5.setLayout(new MigLayout("", "[123px,grow]", "[32px,grow]"));

		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblHospede, "cell 0 0,alignx left,aligny center");
		lblHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeHospedes Chama = new TelaDeHospedes();
				Chama.setVisible(true);
				Chama.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();

			}
		});
		lblHospede.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblHospede.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Hospede.jpg")));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[163px,grow,fill]", "[32px,grow,fill]"));

		JLabel lblNewLabel_15 = new JLabel("Funcionários");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel_15, "cell 0 0,alignx left,aligny center");
		lblNewLabel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminFuncionarios TelaAdm = new AdminFuncionarios();
				TelaAdm.setVisible(true);
				TelaAdm.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();

			}
		});
		lblNewLabel_15.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/funcionarios.png")));
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.PLAIN, 25));

		JLabel label = new JLabel("");
		BarraLateral.add(label);

		JLabel lblNewLabel_3 = new JLabel("");
		BarraLateral.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		BarraLateral.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("");
		BarraLateral.add(lblNewLabel);

		JLabel label_1 = new JLabel("");
		BarraLateral.add(label_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		BarraLateral.add(panel);
		panel.setLayout(new MigLayout("", "[][167.00,grow,center]", "[32.00,grow,center]"));

		JLabel lblNewLabel_5 = new JLabel("Sair");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login novoLogin = new Login();
				novoLogin.setLocationRelativeTo(null);
				novoLogin.setVisible(true);
				dispose();

			}
		});
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/Sair.png")));
		panel.add(lblNewLabel_5, "cell 0 0 2 1,alignx center,aligny center");

		JPanel BarraSuperior = new JPanel();
		BarraSuperior.setBackground(new Color(203, 167, 58));

		contentPane.add(BarraSuperior, "cell 0 0 2 1,grow");
		BarraSuperior
				.setLayout(new MigLayout("", "[200:209.00px:200][grow,center][50:40px:50,right]", "[29.00px,center]"));
		ImageIcon logoIcon = new ImageIcon(Quartos2.class.getResource("/visao/logoMedia.png"));

		Image logoImage = logoIcon.getImage().getScaledInstance(190, 55, Image.SCALE_SMOOTH); // Ajuste o tamanho
																								// conforme necessário
		logoIcon = new ImageIcon(logoImage);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(203, 167, 58));
		BarraSuperior.add(panel_4, "cell 0 0,alignx left,aligny center");
		panel_4.setLayout(new MigLayout("", "[251.00px]", "[15][25]"));

		JLabel lblNewLabel_1 = new JLabel("Bem-Vindo(a),");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_4.add(lblNewLabel_1, "cell 0 0,alignx left,aligny bottom");

		JLabel lblNome = new JLabel(Func.getNome());
		lblNome.setForeground(new Color(255, 255, 255));
		panel_4.add(lblNome, "cell 0 1,alignx left,aligny top");
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		BarraSuperior.add(panel_11, "flowx,cell 1 0");
		JLabel lblLogo = new JLabel("");
		lblLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblLogo);
		lblLogo.setIcon(logoIcon);
		panel_11.setBackground(new Color(203, 167, 58));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(203, 167, 58));
		BarraSuperior.add(panel_2, "cell 1 0,alignx center,aligny center");
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		BarraSuperior.add(lblNewLabel_2, "cell 2 0,alignx center");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Conta telaConta = new Conta();
				telaConta.setVisible(true);
				telaConta.setExtendedState(JFrame.MAXIMIZED_BOTH);

				dispose();
			}
		});

		ImageIcon contaIcon = new ImageIcon(Quartos2.class.getResource("/visao/contaAppBar.png"));
		Image contaImage = contaIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Ajuste o tamanho
																								// conforme necessário
		contaIcon = new ImageIcon(contaImage);
		lblNewLabel_2.setIcon(contaIcon);
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
		lblInstagram.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop()
							.browse(new URL("https://www.instagram.com/stellar_.hotel?igsh=bDl2dmkwY2MzNHFy").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(lblInstagram, "cell 0 0");
		lblInstagram.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/instagram.png")));

		JLabel lblTwitter = new JLabel("");
		lblTwitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop()
							.browse(new URL("https://x.com/Stellar1933323?t=sMKnmdFjz2z29kZNNmOY3g&s=09").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(lblTwitter, "cell 3 0");
		lblTwitter.setIcon(new ImageIcon(Quartos2.class.getResource("/visao/twitter.jpg")));
	}
}
