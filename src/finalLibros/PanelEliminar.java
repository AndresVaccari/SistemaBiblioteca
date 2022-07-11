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

public class PanelEliminar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel [] libroPanel;
	private JButton [] botones;
	private Libro [] listaLibros;
	
	public PanelEliminar() {
		
		listaLibros = FinalMain.getLibros();
		setLayout(new GridLayout(21,1));
		libroPanel = new JPanel[20];
		botones = new JButton[20];	
		
		setLibros();		
	}
	
	ActionListener presionarEliminar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton boton = (AbstractButton) e.getSource(); 
			eliminarLibro(boton);
		}
	};
	
	private void eliminarLibro(AbstractButton boton) {
		int op = JOptionPane.showConfirmDialog(this, "�Esta seguro que desea eliminar "+ listaLibros[Integer.parseInt(boton.getName())].getTitulo() +"?", "Confirmacion", JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			listaLibros[Integer.parseInt(boton.getName())].setTitulo(""); 
			FinalMain.calcularCantidad();
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
		panelTitulo.add(new JLabel("Eliminar"));
		add(panelTitulo);
		
		int colores = 0;
		for (int i = 0; i < FinalMain.getCantidad(); i++) {
			if (listaLibros[i].isEstado() && !listaLibros[i].getTitulo().equals("")) {
				JLabel numero = new JLabel(Integer.toString(listaLibros[i].getNumeroLibro()));
				JLabel titulo = new JLabel(listaLibros[i].getTitulo());
				JLabel autor = new JLabel(listaLibros[i].getAutor());
				botones[i] = new JButton("Eliminar");
				botones[i].addActionListener(presionarEliminar);
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
