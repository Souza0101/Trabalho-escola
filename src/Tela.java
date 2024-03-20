import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    JTextField areadenoome;
    JPasswordField areadesenha;
    JButton fim;
    String nome = "  ";
    String senha;
    ImageIcon icon;

    public Tela() {
        super("Tela de login");
        JPanel painel = new JPanel(null);

        icon = new ImageIcon(getClass().getResource("logopedro.png"));
        JLabel label = new JLabel(icon);
        label.setBounds(150, 25, 190, 200);

        JLabel nomeusuario = new JLabel("Nome");
        nomeusuario.setBounds(100, 200, 50, 20);

        areadenoome = new JTextField(21);
        areadenoome.setBounds(80, 250, 200, 30);

        JLabel senhausuario = new JLabel("Senha");
        senhausuario.setBounds(100, 280, 50, 20); // Changed position

        areadesenha = new JPasswordField(21);
        areadesenha.setBounds(80, 310, 200, 30); // Changed position

        fim = new JButton("Finalizar");
        fim.setBounds(120, 390, 100, 40);

        painel.add(label);
        painel.add(nomeusuario);
        painel.add(areadenoome);
        painel.add(senhausuario);
        painel.add(areadesenha);
        painel.add(fim);
        add(painel);

        buttonHandler handler = new buttonHandler();
        areadenoome.addActionListener(handler);
        areadesenha.addActionListener(handler);
        fim.addActionListener(handler);
    }

    private class buttonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fim) {
                nome = areadenoome.getText();
                senha = new String(areadesenha.getPassword());
                JOptionPane.showMessageDialog(
                        null,
                        "Nome: " + nome + "\nSenha: " + senha
                );
            }
        }
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(400, 500);
        tela.setVisible(true);
    }
}
