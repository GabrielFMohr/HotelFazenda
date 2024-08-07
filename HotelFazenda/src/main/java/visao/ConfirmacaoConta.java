package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Arredondar.RoundedBorder;
import controle.Atualizavel.Atualizavel;
import modelo.Funcionarios;
import net.miginfocom.swing.MigLayout;
import utils.DefaultIconButton;

public class ConfirmacaoConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSenha;
	private Atualizavel atualizavel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConfirmacaoADM frame = new ConfirmacaoADM(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
//	public int ConfirmacaoADM(Funcionarios Func) {
	public ConfirmacaoConta(Funcionarios FuncR, Atualizavel att) {
		setTitle("Confirmação");
		atualizavel = att;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 313);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane
				.setLayout(new MigLayout("", "[36px][36px][36px][36px][36px][36px][36px][36px][36px][36px][36px,grow]",
						"[36px][36px][36px][36px][36px][36px,grow][10px]"));

		JLabel lblNewLabel = new JLabel("Para prosseguir insira sua senha:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		contentPane.add(lblNewLabel, "cell 0 1 11 1,alignx center,growy");

		JLabel lblErro = new JLabel("");
		lblErro.setForeground(new Color(255, 0, 0));
		lblErro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblErro, "cell 3 2 5 1,alignx center,aligny bottom");

		textSenha = new JPasswordField(20);
		textSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSenha.setBorder(new RoundedBorder(Color.black, 10));
				lblErro.setText(null);
			}
		});
		textSenha.setColumns(10);
		textSenha.setBorder(new RoundedBorder(Color.black, 10));
		contentPane.add(textSenha, "cell 0 3 11 1,growx");

		DefaultIconButton btnNewButton = new DefaultIconButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		contentPane.add(btnNewButton, "cell 3 5 3 1,alignx center");
		btnNewButton.setBorder(new RoundedBorder(Color.black, 10));
		btnNewButton.setBackground(new Color(117, 187, 68));

		DefaultIconButton btnNewButton_1 = new DefaultIconButton("Cancelar");
		btnNewButton_1.setBackgroundColor(Color.RED);
		btnNewButton_1.setHoverColor(Color.RED.darker());
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				// return 0;
			}
		});
		contentPane.add(btnNewButton_1, "cell 7 5,alignx right");
		btnNewButton_1.setBorder(new RoundedBorder(Color.black, 10));
		btnNewButton_1.setBackground(new Color(255, 38, 38));

		setLocationRelativeTo(null);
	}
}
