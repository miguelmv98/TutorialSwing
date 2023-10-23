package tutorial;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class VentanaPrincipal {

	private JFrame frmFichaClientesSeguros;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JLabel lblBarraEstado;
	private JLabel lblFoto;
	private JButton btnAnimado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmFichaClientesSeguros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFichaClientesSeguros = new JFrame();
		frmFichaClientesSeguros.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/pictures/iconoTitulo.gif")));
		frmFichaClientesSeguros.setResizable(false);
		frmFichaClientesSeguros.setTitle("Ficha de asegurados");
		frmFichaClientesSeguros.setBounds(100, 100, 420, 300);
		frmFichaClientesSeguros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tbBarraHerramientas = new JToolBar();
		frmFichaClientesSeguros.getContentPane().add(tbBarraHerramientas, BorderLayout.NORTH);
		
		JButton btnGuardar = new JButton();
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGuardarMouseClicked(e);
			}
		});
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/pictures/save.gif")));
		tbBarraHerramientas.add(btnGuardar);
		
		lblBarraEstado = new JLabel("Bienvenido a mi primera aplicación...");
		frmFichaClientesSeguros.getContentPane().add(lblBarraEstado, BorderLayout.SOUTH);
		
		JPanel pnlPanelFicha = new JPanel();
		frmFichaClientesSeguros.getContentPane().add(pnlPanelFicha, BorderLayout.CENTER);
		pnlPanelFicha.setLayout(null);
		
		JPanel pnlFoto = new JPanel();
		pnlFoto.setBorder(new TitledBorder(null, "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlFoto.setBounds(35, 75, 100, 100);
		pnlPanelFicha.add(pnlFoto);
		
		lblFoto = new JLabel();
		pnlFoto.add(lblFoto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(170, 85, 60, 15);
		pnlPanelFicha.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(170, 110, 60,15);
		pnlPanelFicha.add(lblApellidos);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(170,135, 60, 15);
		pnlPanelFicha.add(lblProvincia);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(240, 85, 150, 20);
		pnlPanelFicha.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(240, 110, 150, 20);
		pnlPanelFicha.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JComboBox cbProvincias = new JComboBox();
		cbProvincias.setModel(new DefaultComboBoxModel(new String[] {"Cantabria", "Vizcaya", "Burgos", "Asturias", "Palencia"}));
		cbProvincias.setBounds(240, 135, 150, 20);
		pnlPanelFicha.add(cbProvincias);
		
		JButton btnCargarFoto = new JButton("Cargar foto...");
		btnCargarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fcAbrir = new JFileChooser();
				int valorDevuelto = fcAbrir.showOpenDialog(null);
				//Recoger el nombre del fichero seleccionado por el usuario
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				lblFoto.setIcon(new ImageIcon(file.getAbsolutePath()));
				//En este punto la aplicación se debería encargar de
				//realizar la operación sobre el fichero
				System.out.println("Fichero seleccionado: " + file.getName());
				}
			}
		});
		btnCargarFoto.setBounds(25, 180, 120, 20);
		pnlPanelFicha.add(btnCargarFoto);
		
		JButton btnGuardarBot = new JButton("Guardar");
		btnGuardarBot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGuardarMouseClicked(e);
			}
		});
		btnGuardarBot.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/pictures/save.gif")));
		btnGuardarBot.setBounds(175, 180, 100, 20);
		pnlPanelFicha.add(btnGuardarBot);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); //Cierra la aplicación
			}
		});
		btnSalir.setBounds(285, 180, 100, 20);
		pnlPanelFicha.add(btnSalir);
		
		btnAnimado = new JButton();
		btnAnimado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnimadoMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAnimadoMouseExited(e);
			}
		});
		btnAnimado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/pictures/imagen1.gif")));
		btnAnimado.setBounds(0, 0, 65, 65);
		pnlPanelFicha.add(btnAnimado);
	}
	
	private void btnGuardarMouseClicked(MouseEvent e) 
	{
		lblBarraEstado.setText("Ficha guardada.");
	}
	
	private void btnAnimadoMouseEntered(MouseEvent e) 
	{
		System.out.println("btnAnimado.mouseEntered, event="+e);
		btnAnimado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/pictures/imagen2.gif")));
	}
	
	private void btnAnimadoMouseExited(MouseEvent e) 
	{
		System.out.println("btnAnimado.mouseExited, event="+e);
		btnAnimado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/pictures/imagen1.gif")));
	}
}
