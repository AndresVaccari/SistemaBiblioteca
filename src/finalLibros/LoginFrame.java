package finalLibros;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton login, invitado;
	private JTextField user;
	private JPasswordField password;
	private JLabel userLabel, passLabel;
	private JPanel loginPanel, userPanel, passPanel, buttonPanel;
	private boolean encontrado;
	private User users[];
	private static boolean sesion;
	
	private User usuarioEnc;
	
	public LoginFrame() {

		super("Biblioteca");
		
		users = new User[3];
		users[0] = new User("admin", "admin", true);
		users[1] = new User("user1", "user1", false);
		users[2] = new User("user2", "user2", false);
		
		sesion = false;
		encontrado = false;
		
		userLabel = new JLabel("Ingrese usuario");
		passLabel = new JLabel("Ingrese contrase�a");
		login = new JButton("Continuar");
		login.addActionListener(loginListener);
		invitado = new JButton("Invitado");
		invitado.addActionListener(loginListener);
		user = new JTextField(20);
		password = new JPasswordField(20);
		
		
		userPanel = new JPanel();
		userPanel.add(userLabel);
		userPanel.add(user);
		
		passPanel = new JPanel();
		passPanel.add(passLabel);
		passPanel.add(password);
		
		buttonPanel = new JPanel();
		buttonPanel.add(login);
		buttonPanel.add(invitado);
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(3,1));
		loginPanel.add(userPanel);
		loginPanel.add(passPanel);
		loginPanel.add(buttonPanel);
		
		add(loginPanel);
		setVisible(true);
		Dimension size = new Dimension(300,200);
		Dimension pos = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int x = (int) ((pos.getWidth() - size.getWidth()) / 2);
	    int y = (int) ((pos.getHeight() - size.getHeight()) / 2);
	    setLocation(x, y);
		setSize(size);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	ActionListener loginListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (User usuario : users) {
				AbstractButton boton = (AbstractButton) e.getSource();
				if (boton.getText().equals("Invitado")) {
					usuarioEnc = new User("invitado", "invitado", false);
					encontrado = true;
				} else if (usuario.getUser().equals(user.getText()) && usuario.getPassword().equals(String.valueOf(password.getPassword()))) {
					encontrado = true;
					usuarioEnc = usuario;
					break;
				}
			}
			Mensaje(encontrado);
			
		}
	};
	
	private void Mensaje(boolean enc) {
		if (enc) {
			if (sesion) {
				JOptionPane.showMessageDialog(this, "Ya hay una sesion iniciada", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				@SuppressWarnings("unused")
				LibrosFrame librosFrame = new LibrosFrame(usuarioEnc);
				sesion = true;
				user.setText("");
				password.setText("");
				setVisible(false);
			}
			encontrado = false;
		} else {
			JOptionPane.showMessageDialog(this, "Usuario o contrase�a incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void setSesion(boolean s) {
		sesion = s;
	}
	
}
