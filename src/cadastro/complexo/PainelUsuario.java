package cadastro.complexo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelUsuario extends JFrame {

	private static final long serialVersionUID = 2L;
	private JLabel usernameLabel, passwordLabel, emailLabel;
    private JButton voltarButton, alterarButton;

    public PainelUsuario(String username, String password, String email) {
        // Configurações do JFrame
        setTitle("Painel do Usuário");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Centraliza o JFrame na tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        // Criação dos componentes da interface
        usernameLabel = new JLabel("Usuário: " + username);
        passwordLabel = new JLabel("Senha: " + password);
        emailLabel = new JLabel("Email: " + email);
        voltarButton = new JButton("Voltar");
        alterarButton = new JButton("Alterar");

        // Configurações dos componentes da interface
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        voltarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        alterarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        alterarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        alterarButton.setBackground(new Color(59, 89, 182));
        alterarButton.setForeground(Color.WHITE);
        
     // Adiciona a ação ao botão
        alterarButton.addActionListener(e -> {
            // Cria uma nova instância do AlterarCadastro e exibe-a
            AlterarCadastro alterarCadastro = new AlterarCadastro(Main.userMap.get(username), Main.userMap.get(password), Main.userMap.get(email));
            alterarCadastro.setVisible(true);
        });

        voltarButton.setBackground(new Color(59, 89, 182));
        voltarButton.setForeground(Color.WHITE);

        // Adiciona a ação ao botão
        voltarButton.addActionListener(e -> dispose());

        // Adiciona os componentes à JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //ajustar
        panel.add(usernameLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(passwordLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(emailLabel);
        panel.add(Box.createVerticalStrut(10));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(voltarButton);
        buttonPanel.add(alterarButton);
        panel.add(buttonPanel);

        // Adiciona a JPanel ao JFrame
        add(panel);

        // Configurações adicionais do JFrame
        getContentPane().setBackground(new Color(242, 242, 242));
        setResizable(false);
        setVisible(true);
    }

}
