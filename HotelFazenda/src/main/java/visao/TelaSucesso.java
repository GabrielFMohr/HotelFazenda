package visao;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSucesso extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaSucesso frame = new TelaSucesso();
                    frame.setVisible(true);
                 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaSucesso() {
    
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(351, 216);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2d.dispose();
            }
        };
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(new MigLayout("", "[458.00px]", "[120.00px][24.00px][47.00px]"));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaErro.class.getResource("/visao/sucesso.png")));
        contentPane.add(lblNewLabel, "cell 0 0,alignx center,aligny center");

        JLabel lblNewLabel_1 = new JLabel("Tudo Certo!");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        contentPane.add(lblNewLabel_1, "cell 0 1,alignx center,aligny top");

        JLabel lblNewLabel_2 = new JLabel("A operação foi concluída com sucesso.");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_2, "cell 0 2,alignx center,aligny top");
    	animarTela();
    }

    // Método para animar a tela
    public void animarTela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - getWidth();
        int y = screenSize.height - getHeight();

        // Define um Timer para animar o movimento da tela para cima em 3 segundos
        Timer subirTimer = new Timer(10, new ActionListener() {
            int dy = screenSize.height;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dy > y) {
                    setLocation(x, dy);
                    dy -= 6; // Velocidade da animação
                } else {
                    ((Timer) e.getSource()).stop();
                    // Após 2 segundos, inicia a animação de descida
                    Timer descerTimer = new Timer(10, new ActionListener() {
                        int dy = getLocation().y;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (dy < screenSize.height) {
                                setLocation(x, dy);
                                dy += 20; // Velocidade da animação
                            } else {
                                ((Timer) e.getSource()).stop();
                                dispose(); // Fecha a janela após a animação de descida
                            }
                        }
                    });
                    descerTimer.setInitialDelay(2000); // Espera 2 segundos antes de iniciar a animação de descida
                    descerTimer.start();
                }
            }
        });
        subirTimer.setInitialDelay(0); // Começa a animação assim que a tela é iniciada
        subirTimer.start();
    }
}