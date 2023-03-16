package cadastro.simples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelUsuario;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JTextField textFieldUsuario;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;
    private JButton buttonEnviar;

    public CadastroUsuario() {
        super("Cadastro de Usuário");

        // Configura a janela
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cria os componentes
        labelUsuario = new JLabel("Usuário:");
        labelEmail = new JLabel("E-mail:");
        labelSenha = new JLabel("Senha:");
        textFieldUsuario = new JTextField(20);
        textFieldEmail = new JTextField(20);
        passwordFieldSenha = new JPasswordField(20);
        buttonEnviar = new JButton("Enviar");

        // Define o layout
        setLayout(new GridBagLayout());

        // Define as restrições de layout
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Adiciona os componentes
        c.gridx = 0;
        c.gridy = 0;
        add(labelUsuario, c);

        c.gridx = 1;
        c.gridy = 0;
        add(textFieldUsuario, c);

        c.gridx = 0;
        c.gridy = 1;
        add(labelEmail, c);

        c.gridx = 1;
        c.gridy = 1;
        add(textFieldEmail, c);

        c.gridx = 0;
        c.gridy = 2;
        add(labelSenha, c);

        c.gridx = 1;
        c.gridy = 2;
        add(passwordFieldSenha, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.CENTER;
        add(buttonEnviar, c);

        // Adiciona o ouvinte de eventos para o botão
        buttonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe uma mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
            }
        });
    }

    public static void main(String[] args) {
        // Cria a janela
        CadastroUsuario janela = new CadastroUsuario();

        // Exibe a janela
        janela.setVisible(true);
    }
}



