package finalLibros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonAgregar;
	private JTextField titulo, autor;
	private JLabel lTitulo, lAutor;
	private Libro [] listaLibros;
	
	public PanelAgregar() {
		
		listaLibros = FinalMain.getLibros();
		
		lTitulo = new JLabel("Titulo:");
		lAutor = new JLabel("Autor:");
		
		titulo = new JTextField(55);
		autor = new JTextField(55);
		
		botonAgregar = new JButton("Agregar");
		botonAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				agregarLibro();			
			}
		});
		
		add(lTitulo);
		add(titulo);
		add(lAutor);
		add(autor);
		add(botonAgregar);
		
	}
	
	private void agregarLibro() {
		if (titulo.getText().equals("") || autor.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			boolean duplicado = false;
			for (int i = 0; i < FinalMain.getCantidad(); i++) {
				if (listaLibros[i].getAutor().equals(autor.getText()) && listaLibros[i].getTitulo().equals(titulo.getText())) {
					duplicado = true;
				}
			}
			if (duplicado) {
				JOptionPane.showMessageDialog(this, "Este libro ya ha sido agregado", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int i;
				try {
					for (i = 0; i < listaLibros.length + 1; i++) {
						if (listaLibros[i] == null || listaLibros[i].getTitulo().equals("")) {
							break;
						}
					}
					listaLibros[i] = new Libro(i, titulo.getText(), autor.getText(), true, "");
					FinalMain.calcularCantidad();
					JOptionPane.showMessageDialog(this, "Libro agregado!");
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(this, "No se pueden agregar mas libros");
				}
			}
		}
		
	}
	
}
