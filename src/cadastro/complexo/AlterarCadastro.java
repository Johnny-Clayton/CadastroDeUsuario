package cadastro.complexo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AlterarCadastro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel usuarioLabel, emailLabel, senhaLabel;
    private JTextField usuarioText, emailText;
    private JPasswordField senhaText;
    private JButton confirmarButton, cancelarButton;
    
    private UserMap userMap = new UserMap();

    private String usuario;
    private String email;
    private String senha;

    public AlterarCadastro(String usuario, String email, String senha) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;

        setTitle("Alterar cadastro");
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        usuarioLabel = new JLabel("Usuário:");
        emailLabel = new JLabel("E-mail:");
        senhaLabel = new JLabel("Senha:");

        usuarioText = new JTextField(usuario, 20);
        emailText = new JTextField(email, 20);
        senhaText = new JPasswordField(senha, 20);

        confirmarButton = new JButton("Confirmar");
        cancelarButton = new JButton("Cancelar");

        confirmarButton.addActionListener(this);
        cancelarButton.addActionListener(this);

        panel.add(usuarioLabel);
        panel.add(usuarioText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(senhaLabel);
        panel.add(senhaText);
        panel.add(confirmarButton);
        panel.add(cancelarButton);

        add(panel);

        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmarButton) {
            String usuarioNovo = usuarioText.getText();
            String emailNovo = emailText.getText();
            String senhaNova = String.valueOf(senhaText.getPassword());

            if (!usuarioNovo.isEmpty() && !emailNovo.isEmpty() && !senhaNova.isEmpty()) {
                // atualiza os dados do usuário
                userMap.remove(usuario);
                userMap.remove(senha);
//                userMap.put(usuarioNovo, senhaNova);
//                userMap.put(senhaNova, emailNovo);

                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.");
                dispose();
                
                new PainelUsuario(usuarioNovo, senhaNova, emailNovo);
                
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
            }
        } else if (e.getSource() == cancelarButton) {
            dispose();
        }
    }
}
        

