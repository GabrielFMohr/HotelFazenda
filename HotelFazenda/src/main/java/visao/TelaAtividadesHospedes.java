package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controle.Arredondar.RoundedBorder;
import controle.Atividades.AtividadesDAO;
import controle.AtividadesHospedes.AtividadesHospedesDAO;
import controle.Hospede.HospedeDAO;
import modelo.Atividades;
import modelo.AtividadesHospedes;
import modelo.Funcionarios;
import modelo.Hospedes;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaAtividadesHospedes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<AtividadesHospedes> ListaatividadesHospedes;
	private JComboBox<Atividades> comboBox;
	private JTextField textField;

	public TelaAtividadesHospedes(Funcionarios Func, ArrayList<Atividades> ListaAtividades) {
	    setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
setLocationRelativeTo(null);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2d.dispose();
            }
        };
		ListaatividadesHospedes = new ArrayList<AtividadesHospedes>();

 	 
	 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 643, 670);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome da Atividade");
		lblNewLabel.setBounds(24, 13, 201, 31);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 120, 590, 543);
		panel.add(scrollPane);

		// Configurar o modelo da tabela
		model = new DefaultTableModel(new Object[][] {}, new String[] { "Atividade", "Hospede" });
		table = new JTable(model);
		scrollPane.setViewportView(table);

		// Configurar o modelo do JComboBox e o renderizador
		DefaultComboBoxModel<Atividades> comboBoxModel = new DefaultComboBoxModel<>();
		for (Atividades atividade : ListaAtividades) {
			comboBoxModel.addElement(atividade);
		}

		comboBox = new JComboBox<>(comboBoxModel);
		comboBox.setBounds(250, 22, 300, 22); // Ajuste o tamanho conforme necessário
		panel.add(comboBox);

		// Defina um renderizador personalizado para mostrar apenas o atributo desejado
		comboBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Atividades) {
					Atividades atividade = (Atividades) value;
					setText(atividade.getNomeAtividade()); // Substitua por qualquer método que retorne o atributo
															// desejado
				}
				return component;
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setBounds(24, 69, 76, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                String documento = textField.getText();
                HospedeDAO daoHospede = HospedeDAO.getInstancia();
                AtividadesHospedesDAO daoAtividadesHospedes = AtividadesHospedesDAO.getInstancia();
                AtividadesHospedes atividadesHospedes = new AtividadesHospedes();

                Hospedes hospede = daoHospede.buscarHospedePorCPF(documento);
                if (hospede == null) {
                    JOptionPane.showMessageDialog(null, "CPF não encontrado.");
                    return;
                }

                Atividades ativ = (Atividades) comboBox.getSelectedItem();
                if (ativ == null) {
                    JOptionPane.showMessageDialog(null, "Nenhuma atividade selecionada.");
                    return;
                }

                int capacidade = ativ.getCapacidade();
                int countHospedes = daoAtividadesHospedes.contarHospedesNaAtividade(ativ.getIdAtividade());

                if (countHospedes >= capacidade) {
                    JOptionPane.showMessageDialog(null, "Capacidade máxima atingida para esta atividade.");
                    return;
                }

                atividadesHospedes.setHospede(hospede);
                atividadesHospedes.setAtividade(ativ);
                daoAtividadesHospedes.InserirAtividadesHospedes(atividadesHospedes);
                atualizarJTable();
				}
							
		});
		btnAdicionar.setBounds(250, 65, 89, 23);
		panel.add(btnAdicionar);
		
		textField = new JTextField();
		textField.setBounds(94, 66, 131, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AtividadesHospedesDAO DAO = AtividadesHospedesDAO.getInstancia();				
				int linha = table.getSelectedRow();				
				AtividadesHospedes ativ = new AtividadesHospedes();
				
				if(linha>=0) {
					ativ = ListaatividadesHospedes.get(linha);
					DAO.RemoverAtividadeHospede(ativ.getIdHospedeAtividade());
					atualizarJTable();					
				}
				
				
			}
		});
		btnNewButton.setBounds(360, 65, 89, 23);
		panel.add(btnNewButton);

		// Atualizar a tabela
		atualizarJTable();
	}

	protected void atualizarJTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpar linhas existentes

		AtividadesHospedesDAO hospedesatividadesDAO = AtividadesHospedesDAO.getInstancia();
		ListaatividadesHospedes = hospedesatividadesDAO.ListarAtividadesHospedes();

		for (AtividadesHospedes p : ListaatividadesHospedes) {
			model.addRow(new Object[] {p.getAtividade().getNomeAtividade(), p.getHospede().getNome() });
		}
	}
}