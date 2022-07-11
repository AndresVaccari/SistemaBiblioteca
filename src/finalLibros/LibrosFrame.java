package finalLibros;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class LibrosFrame extends JFrame implements WindowListener {
	
	private static final long serialVersionUID = 1L;
	private JButton[] botones;
	private JLabel usuario;
	private JPanel botonesPanel, clPanel, panelListado, panelReserva, panelModificar, panelAgregar, panelEliminar, ultimoPanel;
	private CardLayout cl;
	private User usuarioEnc;
	
	public LibrosFrame(User usuarioEnc) {
		
		botones = new JButton[6];
		
		
		this.usuarioEnc = usuarioEnc;
		
		usuario = new JLabel(usuarioEnc.getUser());
		botones[0] = new JButton("Listado");
		botones[1] = new JButton("Reservar");
		botones[2] = new JButton("Modificar");
		botones[3] = new JButton("Agregar");
		botones[4] = new JButton("Eliminar");
		botones[5] = new JButton("Cerrar sesion");
		
		clPanel = new JPanel();
		cl = new CardLayout();
		clPanel.setLayout(cl);
		
		botonesPanel = new JPanel();
		botonesPanel.add(usuario);
		for (int i = 0; i < botones.length - 1; i++) {
			botones[i].setVisible(false);
			botones[i].setPreferredSize(new Dimension(140,50));
			botones[i].setName(Integer.toString(i));
			botones[i].addActionListener(cambiarPaneles);
			botonesPanel.add(botones[i]);
		}
		
		botones[5].addActionListener(cambiarPaneles);
		botones[5].setPreferredSize(new Dimension(140,50));
		botones[5].setName("5");
		botonesPanel.add(botones[5]);
		
		JSplitPane splitV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitV.setEnabled(false);
		splitV.setDividerLocation(150);
		splitV.add(botonesPanel);
		splitV.add(clPanel);
		add(splitV);
		
		if (usuarioEnc.getAdmin()) {
			panelListado = new PanelListaAdmin();
			ultimoPanel = panelListado;
		} else 
		{
			panelListado = new PanelLista();
			ultimoPanel = panelListado;
		}
		
		if (usuarioEnc.getUser().equals("invitado")) {
			clPanel.add(new JScrollPane(panelListado), "0");
			botones[0].setVisible(true);
			botones[5].setText("Salir");
		} else if (usuarioEnc.getAdmin()){
			clPanel.add(new JScrollPane(panelListado), "0");
			botones[0].setVisible(true);
			botones[2].setVisible(true);
			botones[3].setVisible(true);
			botones[4].setVisible(true);
		} else {
			clPanel.add(new JScrollPane(panelListado), "0");
			botones[0].setVisible(true);
			botones[1].setVisible(true);
		}
		
		cl.show(clPanel, "0");
		
		Dimension size = new Dimension(800,600);
		Dimension pos = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int x = (int) ((pos.getWidth() - size.getWidth()) / 2);
	    int y = (int) ((pos.getHeight() - size.getHeight()) / 2);
	    setLocation(x, y);
		setSize(size);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setResizable(false);
		setVisible(true);
	}
	
	ActionListener cambiarPaneles = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton boton = (AbstractButton) e.getSource();
			switch (Integer.parseInt(boton.getName())) {
			case 0:
				ultimoPanel.removeAll();
				if (usuarioEnc.getAdmin()) {
					panelListado = new PanelListaAdmin();
					ultimoPanel = panelListado;
					clPanel.add(new JScrollPane(panelListado), "0");
					cl.show(clPanel, "0");
				} else {
					panelListado = new PanelLista();
					ultimoPanel = panelListado;
					clPanel.add(new JScrollPane(panelListado), "0");
					cl.show(clPanel, "0");
				}
				break;
			case 1:
				ultimoPanel.removeAll();
				panelReserva = new PanelReserva(usuarioEnc);
				ultimoPanel = panelReserva;
				clPanel.add(panelReserva, "1");
				cl.show(clPanel, "1");
				break;
			case 2:
				ultimoPanel.removeAll();
				panelModificar = new PanelModificar();
				ultimoPanel = panelModificar;
				clPanel.add(panelModificar, "2");
				cl.show(clPanel, "2");
				break;
			case 3:
				ultimoPanel.removeAll();
				panelAgregar = new PanelAgregar();
				ultimoPanel = panelAgregar;
				clPanel.add(panelAgregar, "3");
				cl.show(clPanel, "3");
				break;
			case 4:
				ultimoPanel.removeAll();
				panelEliminar = new PanelEliminar();
				ultimoPanel = panelEliminar;
				clPanel.add(panelEliminar, "4");
				cl.show(clPanel, "4");
				break;
			case 5:
				logout();
				break;

			}			
		}
	};
	
	private void logout() {
		int op = JOptionPane.showConfirmDialog(this, "�Esta seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			LoginFrame.setSesion(false);
			FinalMain.loginSetVisible();
			dispose();
		}
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		logout();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
