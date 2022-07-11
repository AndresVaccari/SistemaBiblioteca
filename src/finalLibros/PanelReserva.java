package finalLibros;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelReserva extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel [] libroPanel;
	private JButton [] botones;
	private User usuarioEnc;
	private Libro [] listaLibros;
	
	public PanelReserva(User usuarioEnc) {
		
		listaLibros = FinalMain.getLibros();
		
		this.usuarioEnc = usuarioEnc;
		setLayout(new GridLayout(21,1));
		libroPanel = new JPanel[20];
		botones = new JButton[20];	
	
		setLibros();		
	}
	
	ActionListener presionarReservar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton boton = (AbstractButton) e.getSource(); 
			alquilar(boton);
		}
	};
	
	private void alquilar(AbstractButton boton) {
		int op = JOptionPane.showConfirmDialog(this, "�Desea reservar " + listaLibros[Integer.parseInt(boton.getName())].getTitulo() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			listaLibros[Integer.parseInt(boton.getName())].setEstado(false); 
			listaLibros[Integer.parseInt(boton.getName())].setReservadoPor(usuarioEnc.getUser()); 
			removeAll();
			setLibros();
			revalidate();
			repaint();
		}
	}
	
	private void setLibros() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new GridLayout(1,4));
		panelTitulo.add(new JLabel("Numero"));
		panelTitulo.add(new JLabel("Titulo"));
		panelTitulo.add(new JLabel("Autor"));
		panelTitulo.add(new JLabel("Reservar"));
		add(panelTitulo);
		
		int colores = 0;
		for (int i = 0; i < FinalMain.getCantidad(); i++) {
			if (listaLibros[i].isEstado() && !listaLibros[i].getTitulo().equals("")) {
				JLabel numero = new JLabel(Integer.toString(listaLibros[i].getNumeroLibro()));
				JLabel titulo = new JLabel(listaLibros[i].getTitulo());
				JLabel autor = new JLabel(listaLibros[i].getAutor());
				botones[i] = new JButton("Reservar");
				botones[i].addActionListener(presionarReservar);
				botones[i].setName(Integer.toString(i));
				libroPanel[i] = new JPanel();
				libroPanel[i].setLayout(new GridLayout(1, 4));
				libroPanel[i].add(numero);
				libroPanel[i].add(titulo);
				libroPanel[i].add(autor);
				libroPanel[i].add(botones[i]);
				libroPanel[i].setBackground(setColor(colores));
				colores++;
				add(libroPanel[i]);
			}
			else {
				continue;
			}
		}
	}
	
	private Color setColor(int nColor) {
		if (nColor % 2 == 0) {
			return Color.LIGHT_GRAY;
		} else {
			return Color.gray;
		}
	}
	
}