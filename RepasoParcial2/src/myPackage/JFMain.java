package myPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.awt.EventQueue;
import java.awt.event.*;

public class JFMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDNI;
	private JTable table;
	private String[] nombreColumnas = { "Nombre", "Apellido", "DNI" };
	private int row = -1;
	private Set<Cliente> setClientes = new HashSet<Cliente>();

	private Map<Integer, Cliente> mapClientes = new HashMap<Integer, Cliente>();

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMain frame = new JFMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNombre = new JTextField();
		tfNombre.setBounds(190, 11, 133, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfApellido = new JTextField();
		tfApellido.setBounds(190, 42, 133, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);

		tfDNI = new JTextField();
		tfDNI.setBounds(190, 74, 133, 20);
		contentPane.add(tfDNI);
		tfDNI.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(89, 14, 92, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setBounds(89, 45, 92, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setBounds(89, 77, 92, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 495, 176);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				if(row != -1) {
					tfNombre.setText((String)table.getValueAt(row, 0));
					tfApellido.setText((String) table.getValueAt(row, 1));
					tfDNI.setText((String)table.getValueAt(row, 2));	
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, }, nombreColumnas));
										
												JButton btnAdd = new JButton("Agregar");
												btnAdd.setBounds(10, 292, 71, 23);
												contentPane.add(btnAdd);
												
														JButton btnBaja = new JButton("Baja");
														btnBaja.setBounds(146, 292, 78, 23);
														contentPane.add(btnBaja);
														
																JButton btnModif = new JButton("Modif");
																btnModif.setBounds(289, 292, 78, 23);
																contentPane.add(btnModif);
																
																		JButton btnSalir = new JButton("Salir");
																		btnSalir.setBounds(432, 292, 71, 23);
																		contentPane.add(btnSalir);
																		btnSalir.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				dispose();
																			}
																		});
																btnModif.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		if(row != -1) {
																			String nombreString = (String)table.getValueAt(row, 0);
																			String apellidoString = (String)table.getValueAt(row, 1);
																			String dniString = (String)table.getValueAt(row, 2);
																			Cliente unCliente = new Cliente(tfNombre.getText(),tfApellido.getText(),Integer.parseInt(tfDNI.getText()));
																			listaClientes.addAll(setClientes);
																			listaClientes.sort(null);
																			Cliente buscarCliente = new Cliente(nombreString, apellidoString, Integer.parseInt(dniString));
																			int pos = Collections.binarySearch(listaClientes, buscarCliente);
																			if(pos >= 0) {
																				listaClientes.set(pos, unCliente);
																				setClientes.clear();
																				setClientes.addAll(listaClientes);
																				ActualizarTabla();
																				ClearTextFields();
																			}
																		}
																	}
																});
														btnBaja.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																if(row != -1) {
																	Cliente unCliente = new Cliente(tfNombre.getText(), tfApellido.getText(),
																			Integer.parseInt(tfDNI.getText()));
																	setClientes.remove(unCliente);
																	ActualizarTabla();
																	ClearTextFields();
																}
															}
														});
												btnAdd.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															Cliente unCliente = new Cliente(tfNombre.getText(), tfApellido.getText(),
																	Integer.parseInt(tfDNI.getText()));
															ClearTextFields();
															setClientes.add(unCliente);
															ActualizarTabla();

														} catch (Exception e2) {
															// TODO: handle exception
															e2.printStackTrace();
														}
													}
												});
	}

	private void ClearTextFields() {
		tfNombre.setText(null);
		tfApellido.setText(null);
		tfDNI.setText(null);
	}

	private void ActualizarTabla() {
		DefaultTableModel unModel = new DefaultTableModel(nombreColumnas, 0);
		for (Cliente unCliente : setClientes) {
			unModel.addRow(unCliente.getDataRow());
		}
		table.setModel(unModel);
	}
}
