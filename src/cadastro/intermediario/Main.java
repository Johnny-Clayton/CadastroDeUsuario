package cadastro.intermediario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    private JLabel userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton, registerButton;

    // Mapa para armazenar os cadastros de usuários
    private Map<String, String> userMap = new HashMap<>();
    
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // Configurações do JFrame
        setTitle("Sistema de Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza o JFrame na tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        // Criação dos componentes da interface
        userLabel = new JLabel("Usuário:");
        passLabel = new JLabel("Senha:");
        userText = new JTextField(20);
        passText = new JPasswordField(20);
        loginButton = new JButton("Entrar");
        registerButton = new JButton("Cadastrar");

        // Configurações dos componentes da interface
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        loginButton.setBackground(new Color(59, 89, 182));
        loginButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(59, 89, 182));
        registerButton.setForeground(Color.WHITE);

        // Adiciona a ação aos botões
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        // Adiciona os componentes à JPanel
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(loginButton);
        panel.add(registerButton);

        // Adiciona a JPanel ao JFrame
        add(panel);

        // Configurações adicionais do JFrame
        getContentPane().setBackground(new Color(242, 242, 242));
        setResizable(false);
        setVisible(true);
    }

    // Implementação do listener dos botões
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = String.valueOf(passText.getPassword());
            
			String email = userMap.get(password);

            if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
                JOptionPane.showMessageDialog(null, "Bem-vindo, " + username);
                
                new PainelUsuario(username, password, email);
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado ou senha inválida.");
            }
        } else if (e.getSource() == registerButton) {
            String username = JOptionPane.showInputDialog("Digite o usuário:");
            String email = JOptionPane.showInputDialog("Digite o email:");
            
            String password = "";
            do {
                password = JOptionPane.showInputDialog("Digite a senha:");
                
                if (password.length() < 8 || password.length() > 20 || !password.matches(".*[\\d\\W].*")) {
                    JOptionPane.showMessageDialog(null, "A senha deve ter entre 8 e 20 caracteres, números e símbolos.");
                }
            } while (password.length() < 8 || password.length() > 20 || !password.matches(".*[\\d\\W].*"));

            userMap.put(username, password);
            userMap.put(password, email);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
        }
    }

}
