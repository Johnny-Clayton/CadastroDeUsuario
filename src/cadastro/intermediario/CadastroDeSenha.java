package cadastro.intermediario;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class CadastroDeSenha extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel lblPassword;
    protected JPasswordField txtPassword;
    private JButton btnCadastrar;

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$";

    public CadastroDeSenha(String senha) {
        super("Cadastro de senha");

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 2, 10, 10));

        lblPassword = new JLabel("Senha (8-20 caracteres, números e símbolos):");
        container.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setText(senha);
        container.add(txtPassword);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarSenha();
            }
        });
        container.add(btnCadastrar);

        setSize(400, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected void cadastrarSenha() {
        char[] password = txtPassword.getPassword();
        String passwordStr = new String(password);

        if (verificaSenha(passwordStr)) {
            JOptionPane.showMessageDialog(this, "Senha cadastrada com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Senha inválida. A senha deve ter entre 8 e 20 caracteres, números e símbolos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    protected static boolean verificaSenha(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        return pattern.matcher(password).matches();
    }
}
