/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tablas;

import com.mycompany.universidad_laura.conexion.Conexion;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author laura
 */
/**/public class Tabla_Universidad extends javax.swing.JFrame {

        private Conexion miConexion; // importar    
        
        
        
//Combo de Metodo (declaramos)
private javax.swing.JComboBox<String> comboBoxMetodoPago;

private Connection conn; 
    /**
     * Creates new form Tabla_Universidad
     */
        //CoNSTRUCTOR
     public Tabla_Universidad() {
        initComponents();
        
        
         // Agrega un listener para manejar el clic en la tabla
        Tabla_Universidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }

            private void tablaMouseClicked(MouseEvent evt) {
                
            }
        });

        // CONEXION
        miConexion = new Conexion();


         
    // Agregar opciones al JComboBox de Categoría en el constructor
    Categoria_.setModel(new DefaultComboBoxModel<>(new String[]{"Alumno", "Profesor", "Docente", "Ex-alumno", "Tutores"}));

    
    // Initialize comboBoxMetodoPago
        comboBoxMetodoPago = new JComboBox<>();
        
    // Inicializa el JComboBox con las opciones de método de pago
    this.comboBoxMetodoPago.setModel(new DefaultComboBoxModel<>(new String[]{"Efectivo", "Deposito", "Transferencia, Banco"}));
    comboBoxMetodoPago.addItem("Efectivo");
    comboBoxMetodoPago.addItem("Deposito");
    comboBoxMetodoPago.addItem(" Transferencia");
    comboBoxMetodoPago.addItem(" Banco");

    cargarDatosIniciales();
        // Cargar datos iniciales al abrir la ventana
        cargarDatosIniciales();
    }
     
     
     
      private void cargarDatosIniciales() {
        try {
            String consulta = "SELECT * FROM Donadores";
            ResultSet resultado = miConexion.ejecutarConsultaSQL(consulta);

            // Lógica para cargar los datos en la tabla
            DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
            while (resultado.next()) {
                // Aquí debes ajustar según la estructura de tu tabla
                String nombre = resultado.getString("nombre");
                String idDonador = resultado.getString("ID_donador");
                String direccion = resultado.getString("direccion");
                String fecha = resultado.getString("fecha");
                String metodoPago = resultado.getString("metodo_pago");
                String categoria = resultado.getString("categoria");

                model.addRow(new Object[]{nombre, idDonador, direccion, fecha, metodoPago, categoria});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cargar datos iniciales");
        }
    }
      
      //ID DONADOR VERIFICAR QUE SEA NUM
      private boolean esIdNumerico(String idDonador) {
    try {
        // Intenta convertir el ID a un valor numérico
        Integer.parseInt(idDonador);
        // Si tiene éxito, devuelve true
        return true;
    } catch (NumberFormatException e) {
        // Si hay una excepción, significa que el ID no es un valor numérico
        return false;
    }
}
      
      //NOMBRE 
      private boolean esNombreValido(String nombre) {
    // Define una expresión regular que acepta solo letras y acentos
    String regex = "^[\\p{L}]+$";
    return nombre.matches(regex);
    //matches verifica si conicide con la expresion 
}

    
    //MODIFICAR, LIMPIAR CAMPOS 
     private void limpiarCampos() {
        btn_Nombre_A.setText("");
        btn_ID_Donador_.setText("");
        btn_Direccion_.setText("");
        btn_Fecha_.setText("");
//        Altas_btn_Metodo_Pago.setText("");
//        btn_CategoriaA_.setText("");
     }
     
     
   
     
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Menu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ID_Donador_ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_Direccion_ = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Fecha_ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Universidad = new javax.swing.JTable();
        btn_Modificar_ = new javax.swing.JButton();
        btn_Agregar_ = new javax.swing.JButton();
        btn_Eliminar_ = new javax.swing.JButton();
        btn_Consultar_ = new javax.swing.JButton();
        btn_Nombre_A = new javax.swing.JTextField();
        btn_Limpiar = new javax.swing.JButton();
        Metodo_P_ = new javax.swing.JComboBox<>();
        Categoria_ = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabla Donadores");

        jLabel2.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Universidad");

        btn_Menu.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Menu.setForeground(new java.awt.Color(153, 102, 255));
        btn_Menu.setText("Menú");
        btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Menu)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btn_Menu)))
                .addGap(103, 103, 103))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Donador");

        btn_ID_Donador_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ID_Donador_ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección");

        btn_Direccion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Direccion_ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha");

        btn_Fecha_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Fecha_ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Método de pago");

        jLabel9.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Categoría");

        Tabla_Universidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "ID_Donador", "Dirección", "Fecha", "Metodo Pago", "Categoría"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Universidad);
        Tabla_Universidad.getAccessibleContext().setAccessibleName("");

        btn_Modificar_.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Modificar_.setForeground(new java.awt.Color(153, 102, 255));
        btn_Modificar_.setText("Modificar");
        btn_Modificar_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_Modificar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modificar_ActionPerformed(evt);
            }
        });

        btn_Agregar_.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Agregar_.setForeground(new java.awt.Color(153, 102, 255));
        btn_Agregar_.setText("Agregar");
        btn_Agregar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Agregar_ActionPerformed(evt);
            }
        });

        btn_Eliminar_.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Eliminar_.setForeground(new java.awt.Color(153, 102, 255));
        btn_Eliminar_.setText("Eliminar");
        btn_Eliminar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eliminar_ActionPerformed(evt);
            }
        });

        btn_Consultar_.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Consultar_.setForeground(new java.awt.Color(153, 102, 255));
        btn_Consultar_.setText("Consultar");
        btn_Consultar_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_Consultar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Consultar_ActionPerformed(evt);
            }
        });

        btn_Nombre_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nombre_AActionPerformed(evt);
            }
        });

        btn_Limpiar.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Limpiar.setForeground(new java.awt.Color(153, 102, 255));
        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        Metodo_P_.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Banco", "Deposito", "Transferencia" }));
        Metodo_P_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Metodo_P_ActionPerformed(evt);
            }
        });

        Categoria_.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alumno", "Profesor", "Docente", "Ex-alumno", "Tutores" }));
        Categoria_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Categoria_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Categoria_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Metodo_P_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_Nombre_A, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Direccion_, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(btn_ID_Donador_, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btn_Fecha_, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_Agregar_, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Eliminar_, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_Consultar_, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(btn_Modificar_, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(btn_ID_Donador_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Consultar_)
                            .addComponent(btn_Modificar_))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Nombre_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Direccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Agregar_)
                                    .addComponent(btn_Eliminar_))))))
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Fecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Limpiar))
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Metodo_P_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Categoria_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_Nombre_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nombre_AActionPerformed
        // TODO add your handling code here:
     
        // Obtiene el texto ingresado en la caja de texto
    String nombre = btn_Nombre_A.getText().trim();

    // Verifica si el nombre es válido
    if (esNombreValido(nombre)) {
        // Si es válido, agrega el nombre a la tabla
        DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
        model.addRow(new Object[]{nombre, "", "", "", ""}); // Añade el nombre a la primera columna

        // Limpia el campo de texto después de agregar el nombre
        btn_Nombre_A.setText("");
    } else {
        // Si no es válido, mostrar un mensaje de error o tomar otras medidas
        System.out.println("Nombre no válido. Por favor, ingrese solo letras y acentos.");
        }
        
    }//GEN-LAST:event_btn_Nombre_AActionPerformed

    private void btn_ID_Donador_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ID_Donador_ActionPerformed
        // TODO add your handling code here:

    // Obtiene el texto ingresado en la caja de texto
    String idDonador = btn_ID_Donador_.getText().trim();

    // Verifica si el ID del donador es numérico
    if (!esIdNumerico(idDonador)) {
        // Si no es válido, mostrar un mensaje de error y salir
        JOptionPane.showMessageDialog(this, "ID de Donador no válido. Por favor, ingrese solo números.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verifica si el ID ya está en la tabla
    if (esIdRepetido(idDonador)) {
        // Si está repetido, mostrar un mensaje de error y salir
        JOptionPane.showMessageDialog(this, "El ID de Donador ya está en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Si es válido y no está repetido, agrega el ID a la tabla
    DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
    model.addRow(new Object[]{"", idDonador, "", "", ""}); // Añade el ID a la segunda columna

    // Limpia el campo de texto después de agregar el ID
    btn_ID_Donador_.setText("");
}

// Método para verificar si un ID ya está en la tabla
private boolean esIdRepetido(String nuevoId) {
    DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
    int rowCount = model.getRowCount();

    for (int i = 0; i < rowCount; i++) {
        String idEnTabla = model.getValueAt(i, 1) == null ? "" : model.getValueAt(i, 1).toString();

        // Verifica si el nuevo ID ya está en la tabla
        if (idEnTabla.equals(nuevoId)) {
            return true;
        }
    }

    // Si no se encuentra el ID en la tabla, devuelve falso
    return false;
    }//GEN-LAST:event_btn_ID_Donador_ActionPerformed

    private void btn_Direccion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Direccion_ActionPerformed
        // TODO add your handling code here:

         // Obtiene el texto ingresado en la caja de texto
    String direccion = btn_Direccion_.getText().trim();

    // Define una expresión regular que permite letras, números y acentos
    String regex = "^[\\p{L}0-9]+$";

    // Verifica si la dirección cumple con la expresión regular
    if (direccion.matches(regex)) {
        // Si es válida, agrega la dirección a la tabla
        DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
        model.addRow(new Object[]{"", "", direccion, "", ""}); // Añade la dirección a la tercera columna

          // Limpia el campo de texto después de agregar el nombre
        btn_Direccion_.setText("");
    } else {
        // Si no es válida, puedes mostrar un mensaje de error o tomar alguna otra acción
        System.out.println("Dirección no válida. Por favor, ingrese solo letras, números y acentos.");
    }
        
    }//GEN-LAST:event_btn_Direccion_ActionPerformed

    private void btn_Fecha_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Fecha_ActionPerformed
        // TODO add your handling code here:
 
    // Obtiene el texto ingresado en la caja de texto
    String fechaString = btn_Fecha_.getText().trim();

    // Define una expresión regular para validar el formato "00/00/0000"
    String formatoFecha = "^\\d{2}/\\d{2}/\\d{4}$";

    // Verifica si la fecha cumple con el formato
    if (fechaString.matches(formatoFecha)) {
        // Si es válida, convierte la cadena a un objeto de tipo Date
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = formatoEntrada.parse(fechaString);

            // Convierte la fecha de nuevo a una cadena en el formato deseado
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoSalida.format(fecha);

            // Agrega la fecha formateada a la tabla
            DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
            model.addRow(new Object[]{"", "", "", fechaFormateada, ""}); // Añade la fecha a la cuarta columna

            // Limpia el campo de texto después de agregar la fecha
            btn_Fecha_.setText("");
            // También puedes realizar otras acciones aquí, si es necesario
        } catch (ParseException ex) {
            // Maneja la excepción si hay un problema al convertir la fecha
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Si no es válida, muestra un mensaje de error o toma alguna otra acción
        JOptionPane.showMessageDialog(null, "Fecha no válida. Por favor, ingrese en el formato DD/MM/YYYY.", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_btn_Fecha_ActionPerformed

    private void btn_Modificar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modificar_ActionPerformed
       // TODO add your handling code here:
  // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = Tabla_Universidad.getSelectedRow();
    
    // Verificar si hay una fila seleccionada
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el ID original
    String idDonadorActual = Tabla_Universidad.getValueAt(filaSeleccionada, 1).toString();

    // Obtener los nuevos valores desde los campos de texto u otros componentes
    String nuevoNombre = btn_Nombre_A.getText().trim();
    String nuevoIdDonador = btn_ID_Donador_.getText().trim();
    String nuevaDireccion = btn_Direccion_.getText().trim();
    String nuevaFechaTexto = btn_Fecha_.getText().trim();

    // Verificar si hay elementos seleccionados en los JComboBox
    String nuevoMetodoPago = (Metodo_P_.getSelectedItem() != null) ? Metodo_P_.getSelectedItem().toString().trim() : "";
    String nuevaCategoria = (Categoria_.getSelectedItem() != null) ? Categoria_.getSelectedItem().toString().trim() : "";

    // Validar si algún campo obligatorio está vacío
    if (nuevoNombre.isEmpty() || nuevoIdDonador.isEmpty() || nuevaDireccion.isEmpty() || nuevaFechaTexto.isEmpty() || nuevoMetodoPago.isEmpty() || nuevaCategoria.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar el formato de la fecha
    DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatterSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    try {
        // Intentar parsear la fecha
        LocalDate nuevaFecha = LocalDate.parse(nuevaFechaTexto, formatterEntrada);
        String nuevaFechaFormateada = formatterSalida.format(nuevaFecha);

        // Construir la instrucción SQL de actualización
        String instruccionSQL = "UPDATE Donadores SET nombre = ?, ID_donador = ?, direccion = ?, fecha = ?, metodo_pago = ?, categoria = ? WHERE ID_donador = ?";

        // Crear la conexión
        miConexion = new Conexion();

        try (PreparedStatement pstmt = miConexion.prepareStatement(instruccionSQL)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoIdDonador);
            pstmt.setString(3, nuevaDireccion);
            pstmt.setString(4, nuevaFechaFormateada);
            pstmt.setString(5, nuevoMetodoPago);
            pstmt.setString(6, nuevaCategoria);
            pstmt.setString(7, idDonadorActual); // Usar el ID original en la cláusula WHERE

            // Ejecutar la instrucción SQL
            int filasAfectadas = pstmt.executeUpdate();

            // Realizar commit
            boolean commitExitoso = miConexion.commit();

            // Mostrar mensaje según el resultado de la actualización y el commit
            if (filasAfectadas > 0 && commitExitoso) {
                JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Actualizar la fila en la tabla con los nuevos valores
                DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
                model.setValueAt(nuevoNombre, filaSeleccionada, 0);
                model.setValueAt(nuevoIdDonador, filaSeleccionada, 1);
                model.setValueAt(nuevaDireccion, filaSeleccionada, 2);
                model.setValueAt(nuevaFechaFormateada, filaSeleccionada, 3);
                model.setValueAt(nuevoMetodoPago, filaSeleccionada, 4);
                model.setValueAt(nuevaCategoria, filaSeleccionada, 5);

                // Limpiar los campos después de la actualización
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Manejar la violación de restricción de integridad (ID duplicado)
            JOptionPane.showMessageDialog(this, "El ID ya existe en la base de datos. Por favor, elija otro ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método para evitar la actualización después de la excepción
        } catch (DateTimeParseException e) {
            // Manejar error de formato de fecha
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al ejecutar la instrucción SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar la conexión
            miConexion.cerrarConexion();
        }
    } catch (DateTimeParseException e) {
        // Manejar error de formato de fecha
        JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
     }  
    }//GEN-LAST:event_btn_Modificar_ActionPerformed

    private void btn_Agregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Agregar_ActionPerformed
       // TODO add your handling code here:
    String nombreText = btn_Nombre_A.getText().trim();
    String idDonadorText = btn_ID_Donador_.getText().trim();
    String direccionText = btn_Direccion_.getText().trim();
    String fechaText = btn_Fecha_.getText().trim();
    String metodoPagoText = Metodo_P_.getSelectedItem().toString().trim();
    String categoriaText = Categoria_.getSelectedItem().toString().trim();
   
    String fechaMySQLFormat = formatFechaMySQL(fechaText);

    // Verificar si algún campo obligatorio está vacío
    if (nombreText.isEmpty() || idDonadorText.isEmpty() || direccionText.isEmpty() || fechaMySQLFormat == null) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Construir la instrucción SQL de inserción
    String instruccionSQL = "INSERT INTO Donadores (nombre, ID_donador, direccion, fecha, metodo_pago, categoria) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    // Crear la conexión
    miConexion = new Conexion();

    try (PreparedStatement pstmt = miConexion.prepareStatement(instruccionSQL)) {
        pstmt.setString(1, nombreText);
        pstmt.setString(2, idDonadorText);
        pstmt.setString(3, direccionText);
        pstmt.setString(4, fechaMySQLFormat);
        pstmt.setString(5, metodoPagoText);
        pstmt.setString(6, categoriaText);

        // Ejecutar la instrucción SQL
        int filasAfectadas = pstmt.executeUpdate();

        // Realizar commit
        boolean commitExitoso = miConexion.commit();

        // Mostrar mensaje según el resultado de la inserción y el commit
       if (filasAfectadas > 0 && commitExitoso) {
    JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Actualizar la tabla después de una inserción exitosa
    DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
    model.addRow(new Object[]{nombreText, idDonadorText, direccionText, fechaMySQLFormat, metodoPagoText, categoriaText});

    // Limpiar los campos después de la inserción
    btn_Nombre_A.setText("");
    btn_ID_Donador_.setText("");
    btn_Direccion_.setText("");
    btn_Fecha_.setText("");
    Metodo_P_.setSelectedItem(null);  // Limpiar selección
    Categoria_.setSelectedItem(null);  // Limpiar selección
} else {
    JOptionPane.showMessageDialog(this, "Error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
}
    } catch (SQLIntegrityConstraintViolationException e) {
        // Manejar la violación de restricción de integridad (ID duplicado)
        JOptionPane.showMessageDialog(this, "El ID ya existe en la base de datos. Por favor, elija otro ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Salir del método para evitar la inserción después de la excepción
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al ejecutar la instrucción SQL", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Limpiar campos después de agregar
        limpiarCampos();

        // Cerrar la conexión
        miConexion.cerrarConexion();
    }
}

// Método para formatear la fecha al formato de MySQL ("YYYY-MM-DD")
private String formatFechaMySQL(String fecha) {
    try {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = formatoEntrada.parse(fecha);
        return formatoSalida.format(fechaDate);
    } catch (ParseException ex) {
        // Manejar la excepción, por ejemplo, mostrar un mensaje de error
        System.out.println("Error al formatear la fecha: " + ex.getMessage());
        return null;
    }

    }//GEN-LAST:event_btn_Agregar_ActionPerformed


    private void btn_Eliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eliminar_ActionPerformed
        // TODO add your handling code here:
    
         // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = Tabla_Universidad.getSelectedRow();

    // Verificar si se ha seleccionado alguna fila
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el ID o algún identificador único de la fila seleccionada
    String idDonadorAEliminar = Tabla_Universidad.getValueAt(filaSeleccionada, 1).toString();

    // Construir la instrucción SQL para eliminar
    String instruccionSQLEliminar = "DELETE FROM Donadores WHERE ID_donador = ?";

    try (PreparedStatement pstmt = miConexion.prepareStatement(instruccionSQLEliminar)) {
        pstmt.setString(1, idDonadorAEliminar);

        // Ejecutar la instrucción SQL
        int filasAfectadas = pstmt.executeUpdate();

        // Realizar commit
        boolean commitExitoso = miConexion.commit();

        // Mostrar mensaje según el resultado de la eliminación y el commit
        if (filasAfectadas > 0 && commitExitoso) {
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Eliminar la fila de la tabla
            DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
            model.removeRow(filaSeleccionada);

            // Actualizar la tabla después de una eliminación exitosa
            model.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al ejecutar la instrucción SQL", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Cerrar la conexión
        miConexion.cerrarConexion();
       } 
    }//GEN-LAST:event_btn_Eliminar_ActionPerformed

    private void btn_Consultar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Consultar_ActionPerformed
                // TODO add your handling code here:

// Mostrar un cuadro de diálogo para seleccionar el campo de búsqueda
    String[] opcionesCampos = {"Nombre", "ID Donador", "Dirección", "Fecha", "Método de Pago", "Categoría"};
    String campoSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el campo por el cual desea buscar:",
            "Selección de Campo",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcionesCampos,
            opcionesCampos[0]);

    if (campoSeleccionado != null) {
        // Obtener el valor del campo que se ingresará en la caja de texto
        String valorCampoConsulta = JOptionPane.showInputDialog("Ingrese el valor del campo " + campoSeleccionado + " que desea consultar:");

        // Verificar si se ingresó un valor
        if (valorCampoConsulta != null && !valorCampoConsulta.isEmpty()) {
            String consultaSQL = "SELECT * FROM Donadores WHERE " + obtenerNombreCampoSQL(campoSeleccionado) + " = ?";

            try (PreparedStatement pstmt = miConexion.prepareStatement(consultaSQL)) {
                // Utilizar el operador de igualdad (=) en lugar de LIKE para hacer la búsqueda más específica
                pstmt.setString(1, valorCampoConsulta);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Si se encontraron resultados, mostrarlos en la tabla
                    DefaultTableModel model = (DefaultTableModel) Tabla_Universidad.getModel();
                    model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

                    do {
                        Object[] row = {
                                rs.getString("nombre"),
                                rs.getString("ID_donador"),
                                rs.getString("direccion"),
                                rs.getString("fecha"),
                                rs.getString("metodo_pago"),
                                rs.getString("categoria")
                        };
                        model.addRow(row);
                    } while (rs.next());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros con el valor proporcionado en el campo " + campoSeleccionado + ".", "Consulta", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                miConexion.cerrarConexion();
            }
        }
    }
}

// Método para obtener el nombre del campo en la base de datos
private String obtenerNombreCampoSQL(String campoInterfaz) {
    switch (campoInterfaz) {
        case "Nombre":
            return "nombre";
        case "ID Donador":
            return "ID_donador";
        case "Dirección":
            return "direccion";
        case "Fecha":
            return "fecha";
        case "Método de Pago":
            return "metodo_pago";
        case "Categoría":
            return "categoria";
        default:
            return "";
        }

    }//GEN-LAST:event_btn_Consultar_ActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        // TODO add your handling code here:
        
        // Llamar al método para limpiar los campos
    limpiarCampos();
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void Metodo_P_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Metodo_P_ActionPerformed
        // TODO add your handling code here:
 
            // Obtiene el método de pago seleccionado
    Object selectedItem = comboBoxMetodoPago.getSelectedItem();

    // Verifica si el método de pago no es nulo y realiza las acciones necesarias
    if (selectedItem != null) {
        String metodoPago = selectedItem.toString();


        // Limpia la selección del JComboBox después de agregar el método de pago
        comboBoxMetodoPago.setSelectedIndex(-1);
    } else {
        // Si el método de pago es nulo, muestra un mensaje de error o toma alguna otra acción
        System.out.println("Seleccione un método de pago válido.");
       }
    }//GEN-LAST:event_Metodo_P_ActionPerformed

    private void Categoria_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Categoria_ActionPerformed
        // TODO add your handling code here:
        
         // Obtiene la categoría seleccionada
    String categoriaSeleccionada = (String) Categoria_.getSelectedItem();

    // Verifica si la categoría no es nula y realiza las acciones necesarias
    if (categoriaSeleccionada != null) {
        // Realiza las acciones necesarias, como agregar a la base de datos, etc.
        // Aquí deberías incluir tu lógica para agregar la categoría a la base de datos.

        // Puedes imprimir el valor seleccionado como verificación
        System.out.println("Categoría seleccionada: " + categoriaSeleccionada);
    } else {
        // Si la categoría es nula, muestra un mensaje de error o toma alguna otra acción
        System.out.println("Seleccione una categoría válida.");
       }

    }//GEN-LAST:event_Categoria_ActionPerformed

    private void btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuActionPerformed
        // TODO add your handling code here:
        Menu ventanaMenu = new Menu();

        // Mostrar la ventana Menu
        ventanaMenu.setVisible(true);

        // Cerrar la ventana actual (Tabla_Universidad)
        this.dispose();

    }//GEN-LAST:event_btn_MenuActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Universidad().setVisible(true);
            
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Categoria_;
    private javax.swing.JComboBox<String> Metodo_P_;
    private javax.swing.JTable Tabla_Universidad;
    private javax.swing.JButton btn_Agregar_;
    private javax.swing.JButton btn_Consultar_;
    private javax.swing.JTextField btn_Direccion_;
    private javax.swing.JButton btn_Eliminar_;
    private javax.swing.JTextField btn_Fecha_;
    private javax.swing.JTextField btn_ID_Donador_;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Menu;
    private javax.swing.JButton btn_Modificar_;
    private javax.swing.JTextField btn_Nombre_A;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    // End of variables declaration//GEN-END:variables

    //modifica COMBO
    private static class tuPanel {

        private static void add(JComboBox<String> comboBoxMetodoPago) {
        }

        public tuPanel() {
        }
    }

    private static class EliminarListener {

        public EliminarListener() {
        }
    }

}

 
