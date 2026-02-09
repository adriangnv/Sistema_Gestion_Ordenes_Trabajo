/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MtoDiaCliente.java
 *
 * Created on 29-sep-2011, 21:15:09
 */
package Presentacion;

import Datos.CiudadDAO;
import Datos.ClienteDAO;
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Password;
import Modelo.Valida;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Gisela
 */
public class MtoDiaCliente extends java.awt.Dialog {

    List<Cliente> clientes;
    List<Ciudad> ciudades;
    int indice;
    boolean nuevocliente;
    boolean habilitaclick;
    Cliente cliente;

    /** Creates new form MtoDiaCliente */
    public MtoDiaCliente(java.awt.Frame parent) {
        super(parent, "CLIENTES", true);
        this.constructorInicial();
    }

    public MtoDiaCliente(Dialog parent) {
        super(parent, "CLIENTES", true);
        this.constructorInicial();
    }
    
    private void constructorInicial(){
        initComponents();
        this.setLocation(300, 200);
        this.setSize(600, 500);
        this.cargarTabla();
        this.listarJcombo();
        this.cargarTexto(0);
        this.setResizable(false);
        this.btnGrabar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.jButton1.setEnabled(false);
        cliente = new Cliente();
        indice = 0;
        AutoCompleteDecorator.decorate(jComboBox1);
        this.btnNuevo.requestFocus(); 
        }

    private void cargarTexto(int indice) {

        if (clientes.size() > 0) {
            cliente = clientes.get(indice);
            this.txtCodigo.setText(Integer.toString(cliente.getIdCliente()));
            this.txtNombre.setText(cliente.getNombre());
            this.txtApellido.setText(cliente.getApellido());
            this.txtDni.setText(cliente.getDni());
            this.txtDireccion.setText(cliente.getDireccion());
            this.txtTelefono.setText(cliente.getTelefono());
            this.txtCelular.setText(cliente.getCelular());
            this.txtPassword.setText(cliente.getPassword());
            this.txtMail.setText(cliente.getMail());
            this.txtResponsable.setText(cliente.getResponsable());
            this.jComboBox1.setSelectedIndex(clientes.get(indice).getCiudad().getIdCiudad() - 1);
        } else {

            limpiarCajasTexto();
            this.btnEditar.setEnabled(false);
            this.btnGrabar.setEnabled(false);
            this.btnCancelar.setEnabled(false);
        }
    }

    private void listarJcombo() {

        try {
            ciudades = new ArrayList<Ciudad>(new CiudadDAO().buscarTodo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        jComboBox1.setModel(new ListComboBoxModel(ciudades));


    }

    private void cargarTabla() {
        ModeloTabla tabla = new ModeloTabla();
        try {
            clientes = new ArrayList<Cliente>(new ClienteDAO().buscarTodo());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        tabla.addColumn("Id Cliente");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Direccion");
        tabla.addColumn("Ciudad");
        tabla.addColumn("Responsable");
        tabla.setRowCount(clientes.size());

        int i = 0;
        for (Cliente cli : clientes) {
            tabla.setValueAt(cli.getIdCliente(), i, 0);
            tabla.setValueAt(cli.getNombre(), i, 1);
            tabla.setValueAt(cli.getApellido(), i, 2);
            tabla.setValueAt(cli.getDireccion(), i, 3);
            tabla.setValueAt(cli.getCiudad().getCiudad(), i, 4);
            tabla.setValueAt(cli.getResponsable(), i, 5);
            i++;
        }
        this.jTable1.setModel(tabla);

    }

    public void limpiarCajasTexto() {

        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtDni.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
        this.txtCelular.setText("");
        this.txtPassword.setText("");
        this.txtMail.setText("");
        this.txtResponsable.setText("");
        this.jComboBox1.setSelectedIndex(-1);

    }

    private void habilitaCajasTexto(boolean hab) {

        this.txtNombre.setEnabled(hab);
        this.txtApellido.setEnabled(hab);
        this.txtDni.setEnabled(hab);
        this.txtDireccion.setEnabled(hab);
        this.txtTelefono.setEnabled(hab);
        this.txtCelular.setEnabled(hab);
        this.txtMail.setEnabled(hab);
        this.txtResponsable.setEnabled(hab);
        this.jComboBox1.setEnabled(hab);

    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtResponsable = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnGrabar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE CLIENTES"));

        txtCodigo.setText("jTextField1");
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.setEnabled(false);

        txtNombre.setText("jTextField2");
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre.setEnabled(false);
        txtNombre.setNextFocusableComponent(txtApellido);

        txtApellido.setText("jTextField3");
        txtApellido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtApellido.setEnabled(false);
        txtApellido.setNextFocusableComponent(txtDni);

        txtDni.setText("jTextField4");
        txtDni.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDni.setEnabled(false);
        txtDni.setNextFocusableComponent(txtDireccion);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Dni:");

        txtDireccion.setText("jTextField5");
        txtDireccion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDireccion.setEnabled(false);
        txtDireccion.setNextFocusableComponent(jComboBox1);

        txtTelefono.setText("jTextField6");
        txtTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefono.setEnabled(false);
        txtTelefono.setNextFocusableComponent(txtCelular);

        txtCelular.setText("jTextField7");
        txtCelular.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCelular.setEnabled(false);
        txtCelular.setNextFocusableComponent(txtPassword);

        txtPassword.setText("jTextField8");
        txtPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPassword.setEnabled(false);
        txtPassword.setNextFocusableComponent(txtMail);

        txtMail.setText("jTextField9");
        txtMail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMail.setEnabled(false);
        txtMail.setNextFocusableComponent(txtResponsable);

        txtResponsable.setText("jTextField10");
        txtResponsable.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtResponsable.setEnabled(false);
        txtResponsable.setNextFocusableComponent(btnNuevo);

        jLabel5.setText("Direccion:");

        jLabel6.setText("Ciudad:");

        jLabel7.setText("Telefono:");

        jLabel8.setText("Password:");

        jLabel9.setText("Mail:");

        jLabel10.setText("Responsable:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setEnabled(false);
        jComboBox1.setNextFocusableComponent(jButton1);
        jComboBox1.setRequestFocusEnabled(false);

        jLabel11.setText("Celular:");

        jButton1.setText("...");
        jButton1.setEnabled(false);
        jButton1.setNextFocusableComponent(txtTelefono);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMail, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 197, Short.MAX_VALUE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        /*                       */
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("OPERACIONES:"));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/componente_agregar.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setNextFocusableComponent(btnEditar);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/consultar.gif"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setNextFocusableComponent(btnGrabar);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/guardar.gif"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setNextFocusableComponent(btnCancelar);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/cancelar.gif"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setNextFocusableComponent(txtNombre);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        ClienteDAO ncliente = new ClienteDAO();
        Valida validar = new Valida();

        if (nuevocliente == true) {

            if (validar.isCampoVacio(txtNombre.getText())) {
                JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                txtNombre.requestFocus();
            } else {
                if (validar.isCampoVacio(txtApellido.getText())) {
                    JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                    txtApellido.requestFocus();
                } else {
                    if (validar.isCampoVacio(txtDni.getText())) {
                        JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                        txtDni.requestFocus();
                    } else {
                        if (validar.isCampoVacio(txtDireccion.getText())) {
                            JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                            txtDireccion.requestFocus();
                        } else {

                            if (jComboBox1.getSelectedIndex() == -1) {
                                JOptionPane.showMessageDialog(null, "¡Selecciones un item!","Error" , JOptionPane.ERROR_MESSAGE);
                                jComboBox1.showPopup();

                            } else {

                                if (validar.isCampoVacio(txtTelefono.getText())) {
                                    JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                    txtTelefono.requestFocus();
                                } else {

                                    if (validar.isCampoVacio(txtCelular.getText())) {
                                        JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                        txtCelular.requestFocus();
                                    } else {
                                        if (validar.isCampoVacio(txtMail.getText())) {
                                            JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                            txtMail.requestFocus();
                                        } else {
                                            if (validar.isCampoVacio(txtResponsable.getText())) {
                                                JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                                txtResponsable.requestFocus();
                                            } else {

                                                cliente.setNombre(this.txtNombre.getText());
                                                cliente.setApellido((this.txtApellido.getText()));
                                                cliente.setDni((this.txtDni.getText()));
                                                cliente.setDireccion((this.txtDireccion.getText()));
                                                cliente.setCiudad((Ciudad) this.jComboBox1.getSelectedItem());
                                                cliente.setTelefono((this.txtTelefono.getText()));
                                                cliente.setCelular((this.txtCelular.getText()));
                                                String inpass = this.txtNombre.getText().substring(0, 1) + this.txtApellido.getText().substring(0, 1);
                                                cliente.setPassword(inpass.toLowerCase() + new Password().generar());
                                                cliente.setMail((this.txtMail.getText()));
                                                cliente.setResponsable(this.txtResponsable.getText());

                                                try {
                                                    ncliente.agregar(cliente);
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(MtoDiaCiudad1_2.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                this.cargarTabla();
                                                indice = (ciudades.size() - 1);
                                                this.cargarTexto(indice);
                                                this.btnNuevo.setEnabled(true);
                                                this.btnEditar.setEnabled(true);
                                                this.btnGrabar.setEnabled(false);
                                                this.btnCancelar.setEnabled(false);
                                                this.jComboBox1.setEnabled(false);
                                                this.jTable1.setEnabled(true);
                                                habilitaclick = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {

            cliente = clientes.get(indice);

            if (validar.isCampoVacio(txtNombre.getText())) {
                JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                txtNombre.requestFocus();
            } else {
                if (validar.isCampoVacio(txtApellido.getText())) {
                    JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                    txtApellido.requestFocus();
                } else {
                    if (validar.isCampoVacio(txtDni.getText())) {
                        JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                        txtDni.requestFocus();
                    } else {
                        if (validar.isCampoVacio(txtDireccion.getText())) {
                            JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                            txtDireccion.requestFocus();
                        } else {

                            if (jComboBox1.getSelectedIndex() == -1) {
                                JOptionPane.showMessageDialog(null, "¡Selecciones un item!","Error" , JOptionPane.ERROR_MESSAGE);
                                jComboBox1.showPopup();

                            } else {

                                if (validar.isCampoVacio(txtTelefono.getText())) {
                                    JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                    txtTelefono.requestFocus();
                                } else {

                                    if (validar.isCampoVacio(txtCelular.getText())) {
                                        JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                        txtCelular.requestFocus();
                                    } else {
                                        if (validar.isCampoVacio(txtMail.getText())) {
                                            JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                            txtMail.requestFocus();
                                        } else {
                                            if (validar.isCampoVacio(txtResponsable.getText())) {
                                                JOptionPane.showMessageDialog(null,"¡Faltan Completar Datos!","Error" , JOptionPane.ERROR_MESSAGE);
                                                txtResponsable.requestFocus();
                                            } else {

                                                cliente.setIdCliente(Integer.parseInt(this.txtCodigo.getText()));
                                                cliente.setNombre(this.txtNombre.getText());
                                                cliente.setApellido((this.txtApellido.getText()));
                                                cliente.setDni((this.txtDni.getText()));
                                                cliente.setDireccion((this.txtDireccion.getText()));
                                                cliente.setTelefono((this.txtTelefono.getText()));
                                                cliente.setCelular((this.txtCelular.getText()));                                                          
                                                cliente.setMail((this.txtMail.getText()));
                                                cliente.setResponsable(this.txtResponsable.getText());
                                                cliente.setCiudad((Ciudad) this.jComboBox1.getSelectedItem());

                                                try {
                                                    ncliente.actualizar(cliente);
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(MtoDiaCiudad1_2.class.getName()).log(Level.SEVERE, null, ex);
                                                }

                                                this.cargarTabla();
                                                this.cargarTexto(indice);

                                                this.btnNuevo.setEnabled(true);
                                                this.btnEditar.setEnabled(true);
                                                this.btnGrabar.setEnabled(false);
                                                this.btnCancelar.setEnabled(false);
                                                this.jComboBox1.setEnabled(false);
                                                habilitaCajasTexto(false);
                                                this.jTable1.setEnabled(true);
                                                habilitaclick = false;
    }//GEN-LAST:event_btnGrabarActionPerformed
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        limpiarCajasTexto();
        nuevocliente = true;
        this.listarJcombo();
        habilitaCajasTexto(true);
        this.jComboBox1.setSelectedIndex(-1);
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnGrabar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.jButton1.setEnabled(true);
        this.txtNombre.requestFocus();
        this.jTable1.setEnabled(false);
        habilitaclick = true;
        
        
}//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (clientes.size() > 0) {

            if (nuevocliente == true) {
                this.listarJcombo();
                this.cargarTexto(indice);
                this.jComboBox1.setEnabled(false);
                this.btnNuevo.setEnabled(true);
                this.btnCancelar.setEnabled(false);
                this.btnGrabar.setEnabled(false);
                if (ciudades.size() > 0) {
                    this.btnEditar.setEnabled(true);
                } else {
                    this.btnEditar.setEnabled(false);
                }
            } else {

                this.cargarTexto(indice);
                this.jComboBox1.setEnabled(false);
                this.btnNuevo.setEnabled(true);
                this.btnEditar.setEnabled(true);
                this.btnGrabar.setEnabled(false);
                this.btnCancelar.setEnabled(false);
            }
        } else {
            limpiarCajasTexto();
            this.btnEditar.setEnabled(true);
            this.btnGrabar.setEnabled(false);
            this.btnCancelar.setEnabled(false);
            this.jComboBox1.setEnabled(false);
        }
        habilitaCajasTexto(false);
        this.jButton1.setEnabled(false);
        this.jTable1.setEnabled(true);
        habilitaclick = false;
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        nuevocliente = false;
        this.btnNuevo.setEnabled(false);
        this.btnGrabar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.jButton1.setEnabled(true);
        habilitaCajasTexto(true);
        this.jTable1.setEnabled(false);
        this.txtNombre.requestFocus();
        habilitaclick = true;
}//GEN-LAST:event_btnEditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if(habilitaclick==true){
           
       }else{
        indice = this.jTable1.getSelectedRow();
        cliente = clientes.get(indice);
        this.cargarTexto(indice);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MtoDiaCiudad1_2 nuevaCiu = new MtoDiaCiudad1_2(this);
        nuevaCiu.setVisible(true);
        this.listarJcombo();
        this.jComboBox1.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        Character caracter = new Character(evt.getKeyChar());
        Valida valida = new Valida();

        if (!valida.isNumero(caracter)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MtoDiaCliente dialog = new MtoDiaCliente(new java.awt.Frame());
                //MtoDiaCliente dialog = new MtoDiaCliente(new JDialog());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnGrabar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
