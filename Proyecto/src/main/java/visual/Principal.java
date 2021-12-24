package visual;

import java.awt.event.KeyEvent;
import objetos.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Medico;
import objetos.Asignados;

/**
 *
 * @author kevin
 */
public class Principal extends javax.swing.JFrame {

//Objetos y atributos para el registro de Pacientes y Medico
    private ArrayList<Paciente> lista = new ArrayList<>();  //Lista de objetos paciente
    private ArrayList<Medico> lista2 = new ArrayList<>();   //LIsta de objetos medico
    private ArrayList<Asignados> asignados = new ArrayList<>();

    private Paciente p;     //Instancia del objeto Paciente
    private Medico m;       //Instancia del objeto Medico
    private Asignados a;
//Atributos para el proceso de pacientes
    private String nCedula;
    private String paterno;
    private String materno;
    private String nombre; //Variable de uso general
    private String genero; //Variable de uso general
    private String fechaNacimiento;
    private String ubicacionInter;
//Atributos para el proceso de medico
    private String carnet;
    private String hospitalDeTrabajo;
    private String horario;
//Atributos propios de la clase JFrame para el funcionamiento del programa
    private boolean res;
    private DefaultTableModel modelo;   //Instancia del modelo de la tabla
    private String asignar;
    private String asignar2;
    private String name;
    private String name2;
    
    public Principal() {
        initComponents();
        //Ajustes de ventana para la opcion de paciente
        Form_agregar.pack();//se muestra la ventana en el tamaño dado
        Form_agregar.setLocationRelativeTo(null);//se centra la ventana en pantalla

        Form_lista.pack();
        Form_lista.setLocationRelativeTo(null);
        
        //Ajustes de ventana para opcion de medico
        Form_añadir.pack();
        Form_añadir.setLocationRelativeTo(null);
        
        Form_listar.pack();
        Form_listar.setLocationRelativeTo(null);
        
        //Ajustes de ventana para opcion Asignar
        Asignar.pack();
        Asignar.setLocationRelativeTo(null);
        
        //Ajustes de ventana para opcion Listado del hospital
        form_liistadoHospital.pack();
        form_liistadoHospital.setLocationRelativeTo(null);
    }

//metodos para la busqueda de Paciente
    public void habilitarCampos1() {
        cedulatxt.setEnabled(true);    //Deshabilita la entrada para obtener la cedula
        busquedaBt.setEnabled(true);   //Deshabilita el boton para buscar cedula
        paternotxt.setEnabled(true);    //Habilita la entrada de obtencion del dato Apellido paterno
        maternotxt.setEnabled(true);    //Habilita la entrada de obtencion del dato Apellido materno
        nombretxt.setEnabled(true);     //Habilita la entrada de obtencion del dato nombre
        generosItem.setEnabled(true);   //Habilita la obtencion del item genero
        fechatxt.setEnabled(true);      //Habilita la entrada de obtencion del dato Fecha de Nacimiento
        hospitaltxt.setEnabled(true);   //Habilita la entrada de obtencion del dato Hospital
        guardarBt.setEnabled(true);    //Deshabilita el boton Registrar
        limpiarBt.setEnabled(true);     //Habilita el boton de Limpiar los datos
        nombretxt.requestFocus();

    }

    public void habilitarCampos2() {
        cedulatxt.setEnabled(true);
        busquedaBt.setEnabled(true);
        paternotxt.setEnabled(true);
        maternotxt.setEnabled(true);
        nombretxt.setEnabled(true);
        generosItem.setEnabled(true);
        fechatxt.setEnabled(true);
        hospitaltxt.setEnabled(true);
        guardarBt.setEnabled(true);
        limpiarBt.setEnabled(true);
        nombretxt.requestFocus();

    }

    public void habilitarCampos3() {
        cedulatxt.setEnabled(true);
        busquedaBt.setEnabled(true);
        paternotxt.setEnabled(true);
        maternotxt.setEnabled(true);
        nombretxt.setEnabled(true);
        generosItem.setEnabled(true);
        fechatxt.setEnabled(true);
        hospitaltxt.setEnabled(true);
        guardarBt.setEnabled(true);
        limpiarBt.setEnabled(true);
        nombretxt.requestFocus();

    }
/*
    Metodos para el proceso de Registro, Listado de medicos, pacientes y Pacientes asignados
    */
    
//Metodo de Pacientes 
    public void ListarPacientes() {
        modelo = (DefaultTableModel) tablaLista.getModel();

        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
            System.out.println("Fila " + i + " borrada y lista actualizada");
        }

        for (int i = 0; i < lista.size(); i++) {
            p = lista.get(i);
            modelo.addRow(new Object[]{
                p.getnCedula(),
                p.getPaterno(),
                p.getMaterno(),
                p.getNombre(),
                p.getGenero(),
                p.getFechaNacimiento(),
                p.getUbicacionInter()
            });//Añade los atributos almacenados al modelo de la tabla
        }
    }
    
    public void ListarMedicos() {
        modelo = (DefaultTableModel) tb_listar.getModel();

        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
            System.out.println("Fila " + i + " borrada y lista actualizada");
        }

        for (int i = 0; i < lista2.size(); i++) {
            m = lista2.get(i);
            modelo.addRow(new Object[]{
                m.getCarnet(),
                m.getNombrem(),
                m.getGenero(),
                m.getHorario(),
                m.getHospitalDeTrabajo()
            });//Añade los atributos almacenados al modelo de la tabla
        }
    }
//Metodo para Listado del hospital   
    public void Asignados() {
        modelo = (DefaultTableModel) tb_asignados.getModel();
        
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
            System.out.println("Fila " + i + " borrada y lista actualizada");
        }

        for (int i = 0; i < asignados.size(); i++) {
            a = asignados.get(i);
            modelo.addRow(new Object[]{
                a.getCedula(),
                a.getNombreP(),
                a.getNombreM(),
                a.getSala()
            });//Añade los atributos almacenados al modelo de la tabla
        }
       
    }
  
//Metodo de Pacientes
    public void estadisticasPaciente() {
        int total = 0, fem = 0, mas = 0;
        for (int i = 0; i < lista.size(); i++) {
            p = lista.get(i);
            if (p.getGenero().equalsIgnoreCase("Masculino")) {
                mas++;
            } else {
                fem++;
            }
        }
        total = fem + mas;
        registradosLb.setText(Integer.toString(total));
        femLb.setText(Integer.toString(fem));
        maleLb.setText(Integer.toString(mas));
    }
    
//Metodo de Medicos
    public void estadisticasMedico() {
        int total = 0, fem = 0, mas = 0;
        for (int i = 0; i < lista2.size(); i++) {
            m = lista2.get(i);
            if (m.getGenero().equalsIgnoreCase("Masculino")) {
                mas++;
            } else {
                fem++;
            }
        }
        total = fem + mas;
        añadidosLb.setText(Integer.toString(total));
        femeninoLb.setText(Integer.toString(fem));
        masculinosLb.setText(Integer.toString(mas));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Form_agregar = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        generosItem = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cedulatxt = new javax.swing.JTextField();
        paternotxt = new javax.swing.JTextField();
        maternotxt = new javax.swing.JTextField();
        fechatxt = new javax.swing.JTextField();
        hospitaltxt = new javax.swing.JTextField();
        nombretxt = new javax.swing.JTextField();
        guardarBt = new javax.swing.JButton();
        limpiarBt = new javax.swing.JButton();
        busquedaBt = new javax.swing.JButton();
        Form_lista = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        registradosLb = new javax.swing.JLabel();
        femLb = new javax.swing.JLabel();
        maleLb = new javax.swing.JLabel();
        Form_añadir = new javax.swing.JFrame();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtcarnet = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        Lsgenero = new javax.swing.JComboBox<>();
        txthorario = new javax.swing.JTextField();
        txthosp = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        Form_listar = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_listar = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        añadidosLb = new javax.swing.JLabel();
        femeninoLb = new javax.swing.JLabel();
        masculinosLb = new javax.swing.JLabel();
        Asignar = new javax.swing.JFrame();
        JLabelCedu = new javax.swing.JLabel();
        txtentradaP = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtentradacar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        nameLb = new javax.swing.JLabel();
        btlim = new javax.swing.JButton();
        form_liistadoHospital = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_asignados = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        Form_agregar.setTitle("Agregar Paciente");
        Form_agregar.setResizable(false);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cédula:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Apellido paterno:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText("Apellido materno:");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Nombre:");

        generosItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        generosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generosItemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel5.setText("Género:");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel7.setText("Hospital:");

        cedulatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulatxtActionPerformed(evt);
            }
        });

        paternotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paternotxtActionPerformed(evt);
            }
        });

        hospitaltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitaltxtActionPerformed(evt);
            }
        });

        guardarBt.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        guardarBt.setText("Registrar");
        guardarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtActionPerformed(evt);
            }
        });

        limpiarBt.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        limpiarBt.setText("Limpiar");
        limpiarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtActionPerformed(evt);
            }
        });

        busquedaBt.setText("Buscar");
        busquedaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Form_agregarLayout = new javax.swing.GroupLayout(Form_agregar.getContentPane());
        Form_agregar.getContentPane().setLayout(Form_agregarLayout);
        Form_agregarLayout.setHorizontalGroup(
            Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_agregarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Form_agregarLayout.createSequentialGroup()
                        .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Form_agregarLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(generosItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Form_agregarLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guardarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hospitaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(limpiarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Form_agregarLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cedulatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(busquedaBt)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form_agregarLayout.createSequentialGroup()
                        .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Form_agregarLayout.createSequentialGroup()
                                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addGroup(Form_agregarLayout.createSequentialGroup()
                                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maternotxt)
                                    .addComponent(nombretxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(paternotxt))))
                        .addGap(102, 102, 102))))
        );
        Form_agregarLayout.setVerticalGroup(
            Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_agregarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(busquedaBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(paternotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maternotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(generosItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Form_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hospitaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(guardarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpiarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        Form_lista.setTitle("Lista de pacientes");
        Form_lista.setResizable(false);

        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Apellido Paterno", "Apellido Materno", "Nombre", "Género", "Fecha Nac.", "Hospital"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLista.getTableHeader().setResizingAllowed(false);
        tablaLista.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaLista);

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel8.setText("Registrados");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel9.setText("Fémeninos");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setText("Másculinos");

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel11.setText(":");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel13.setText(":");

        registradosLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registradosLb.setText("0");
        registradosLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        femLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        femLb.setText("0");
        femLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        maleLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maleLb.setText("0");
        maleLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Form_listaLayout = new javax.swing.GroupLayout(Form_lista.getContentPane());
        Form_lista.getContentPane().setLayout(Form_listaLayout);
        Form_listaLayout.setHorizontalGroup(
            Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_listaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                    .addGroup(Form_listaLayout.createSequentialGroup()
                        .addGroup(Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Form_listaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(femLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(Form_listaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maleLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(Form_listaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registradosLb, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Form_listaLayout.setVerticalGroup(
            Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_listaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(registradosLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(femLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Form_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(maleLb))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Form_añadir.setTitle("Añadir Medicos");
        Form_añadir.setMinimumSize(new java.awt.Dimension(400, 500));
        Form_añadir.setResizable(false);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel14.setText("Nombre");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel15.setText("Genero");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel16.setText("Horario");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel17.setText("Hospital de Trabajo");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel18.setText("Carnet");

        txtcarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarnetActionPerformed(evt);
            }
        });
        txtcarnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcarnetKeyTyped(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        Lsgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        txthosp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthospKeyTyped(evt);
            }
        });

        btnregistrar.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Form_añadirLayout = new javax.swing.GroupLayout(Form_añadir.getContentPane());
        Form_añadir.getContentPane().setLayout(Form_añadirLayout);
        Form_añadirLayout.setHorizontalGroup(
            Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_añadirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Form_añadirLayout.createSequentialGroup()
                        .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lsgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthorario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(Form_añadirLayout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcarnet)
                            .addGap(18, 18, 18)
                            .addComponent(btnbuscar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Form_añadirLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(txthosp, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form_añadirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );
        Form_añadirLayout.setVerticalGroup(
            Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_añadirLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcarnet)
                        .addComponent(btnbuscar)))
                .addGap(18, 18, 18)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnombre))
                .addGap(18, 18, 18)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(Lsgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txthorario))
                .addGap(17, 17, 17)
                .addGroup(Form_añadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txthosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        Form_listar.setTitle("Lista de medicos");
        Form_listar.setMinimumSize(new java.awt.Dimension(1017, 473));
        Form_listar.setResizable(false);

        tb_listar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet", "Nombre", "Genero", "Horario", "Hospital de Trabajo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_listar.getTableHeader().setResizingAllowed(false);
        tb_listar.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tb_listar);

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setText("Añadidos");

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setText("Femeninos");

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setText("Masculinos");

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel22.setText(":");

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel23.setText(":");

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel24.setText(":");

        añadidosLb.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        añadidosLb.setText("0");

        femeninoLb.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        femeninoLb.setText("0");

        masculinosLb.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        masculinosLb.setText("0");

        javax.swing.GroupLayout Form_listarLayout = new javax.swing.GroupLayout(Form_listar.getContentPane());
        Form_listar.getContentPane().setLayout(Form_listarLayout);
        Form_listarLayout.setHorizontalGroup(
            Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form_listarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Form_listarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(añadidosLb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(femeninoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masculinosLb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Form_listarLayout.setVerticalGroup(
            Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_listarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(añadidosLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23)
                    .addComponent(femeninoLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Form_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24)
                    .addComponent(masculinosLb))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Asignar.setTitle("Asignar Pacientes");

        JLabelCedu.setText("Cedula del paciente");

        jLabel25.setText("Carnet del medico");

        jButton2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton2.setText("Asignar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel26.setText("Paciente: ");

        jLabel27.setText("asignado al medico: ");

        btlim.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btlim.setText("Limpiar");
        btlim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AsignarLayout = new javax.swing.GroupLayout(Asignar.getContentPane());
        Asignar.getContentPane().setLayout(AsignarLayout);
        AsignarLayout.setHorizontalGroup(
            AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AsignarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AsignarLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AsignarLayout.createSequentialGroup()
                        .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelCedu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtentradaP))
                        .addGap(56, 56, 56)
                        .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btlim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(txtentradacar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        AsignarLayout.setVerticalGroup(
            AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AsignarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelCedu)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtentradaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtentradacar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btlim)
                .addGap(50, 50, 50)
                .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(nameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        form_liistadoHospital.setTitle("Listado del Hospital");
        form_liistadoHospital.setMinimumSize(new java.awt.Dimension(400, 480));
        form_liistadoHospital.setResizable(false);

        tb_asignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Paciente", "Medico asignado", "Sala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_asignados.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tb_asignados);

        javax.swing.GroupLayout form_liistadoHospitalLayout = new javax.swing.GroupLayout(form_liistadoHospital.getContentPane());
        form_liistadoHospital.getContentPane().setLayout(form_liistadoHospitalLayout);
        form_liistadoHospitalLayout.setHorizontalGroup(
            form_liistadoHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_liistadoHospitalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addContainerGap())
        );
        form_liistadoHospitalLayout.setVerticalGroup(
            form_liistadoHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_liistadoHospitalLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu1.setText("Paciente");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Registrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Lista");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Asignar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Medico");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Añadir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Lista");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Hospital");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Listado del Hospital");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ListarPacientes();
        Form_lista.setVisible(true);
        estadisticasPaciente();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void hospitaltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitaltxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitaltxtActionPerformed

    private void cedulatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulatxtActionPerformed

    private void paternotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paternotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paternotxtActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Evento para mostrar la ventana de Agregar pacientes
        Form_agregar.setVisible(true); //Muestra la ventana en pantalla
        estadisticasPaciente();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void busquedaBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaBtActionPerformed
        // Evento para la busqueda de Pacientes

        if (cedulatxt.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡¡El campo no debe quedar vacio!!", "Error", 2); //Valor de 2 para mostrar un icono de Advertencia
            cedulatxt.setText("");
            cedulatxt.requestFocus(); //Pone el cursor de escritura en el campo de cedula
        } else {
            nCedula = cedulatxt.getText();
            res = false;
            for (int i = 0; i < lista.size(); i++) {
                p = lista.get(i);
                if (nCedula.equalsIgnoreCase(p.getnCedula())) {
                    res = true;
                    habilitarCampos1();
                    paternotxt.setText(p.getPaterno());
                    maternotxt.setText(p.getMaterno());
                    nombretxt.setText(p.getNombre());
                    generosItem.setSelectedItem(p.getGenero());
                    fechatxt.setText(p.getFechaNacimiento());
                    hospitaltxt.setText(p.getUbicacionInter());
                    if (p.getGenero().equalsIgnoreCase("Masculino")) {
                        generosItem.setSelectedItem("Masculino");
                    } else {
                        generosItem.setSelectedItem("Femenino");
                    }
                    javax.swing.JOptionPane.showMessageDialog(null, "Cédula: " + nCedula + " Encontrada", " Mensaje", 1);
                    break;
                }
            }
            if (res == false) {
                javax.swing.JOptionPane.showMessageDialog(null, "Cédula: " + nCedula + "No Encontrada", " Mensaje", 2);
            }
        }
    }//GEN-LAST:event_busquedaBtActionPerformed

    private void guardarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtActionPerformed
        // Evento para el guardado de datos de Pacientes
        if (cedulatxt.getText().trim().isEmpty() || paternotxt.getText().trim().isEmpty() || maternotxt.getText().trim().isEmpty() || nombretxt.getText().trim().isEmpty() || fechatxt.getText().trim().isEmpty() || hospitaltxt.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Hay campos vacios", " Mensaje", 2); //valor de 2 para mostrar icono de advertencia
        } else {
            nCedula = cedulatxt.getText();
            paterno = paternotxt.getText();
            materno = maternotxt.getText();
            nombre = nombretxt.getText();
            genero = generosItem.getSelectedItem().toString();
            fechaNacimiento = fechatxt.getText();
            ubicacionInter = hospitaltxt.getText();
            p = new Paciente(nCedula, paterno, materno, nombre, genero, fechaNacimiento, ubicacionInter);
            lista.add(p);
            System.out.println("Datos almacenados");   //confirmacion en consola
        }
        ListarPacientes();
        estadisticasPaciente();
    }//GEN-LAST:event_guardarBtActionPerformed

    private void generosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generosItemActionPerformed
//         TODO add your handling code here:
    }//GEN-LAST:event_generosItemActionPerformed

    private void limpiarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtActionPerformed
        // Evento para limpiar los campos de ingreso de datos
        cedulatxt.setText("");
        paternotxt.setText("");
        maternotxt.setText("");
        nombretxt.setText("");
        generosItem.setSelectedItem("");
        fechatxt.setText("");
        hospitaltxt.setText("");
        habilitarCampos3();
        estadisticasPaciente();
    }//GEN-LAST:event_limpiarBtActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Form_añadir.setVisible(true); //Muestra la ventana de registro de medicos
        ListarMedicos();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Form_listar.setVisible(true); //Muestra la venta de listado de medicos
        ListarMedicos();
        estadisticasMedico();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txtcarnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcarnetKeyTyped
        if (txtcarnet.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcarnetKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char texto = evt.getKeyChar();
        if (!Character.isLetter(texto) && texto != KeyEvent.VK_SPACE) {
            evt.consume();
        }

        if (txtnombre.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txthospKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthospKeyTyped
        char texto = evt.getKeyChar();
        if (!Character.isLetter(texto) && texto != KeyEvent.VK_SPACE) {
            evt.consume();
        }

        if (txtnombre.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txthospKeyTyped

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // TEvento para guardar datos de tipo Medico
        
        if (txtcarnet.getText().trim().isEmpty() || txtnombre.getText().trim().isEmpty() || txthorario.getText().trim().isEmpty() || txthosp.getText().trim().isEmpty()) {  //verifica si los campos en los cuales se ingresan los datos estan vacios
            javax.swing.JOptionPane.showMessageDialog(null, "Hay campos vacios", " Mensaje", 2); //valor de 2 para mostrar icono de advertencia
        } else {
            carnet = txtcarnet.getText();
            nombre = txtnombre.getText();
            genero = Lsgenero.getSelectedItem().toString();
            horario = txthorario.getText();
            hospitalDeTrabajo = txthosp.getText();
            m = new Medico(carnet, nombre, genero, horario, hospitalDeTrabajo); // Adiciona los datos al objeto Medico 
            lista2.add(m); //Asocia los datos del Objeto Medico y los añade a su respectiva lista 
            System.out.println("Datos almacenados");   //confirmacion en consola
        }
        ListarMedicos();
        estadisticasMedico();
        
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // Evento de busqueda de Medicos
        
         if (txtcarnet.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡¡El campo no debe quedar vacio!!", "Error", 2); //Valor de 2 para mostrar un icono de Advertencia
            txtcarnet.setText(""); //Se le otorga un espacio vacio al campo de ingreso de carnet
            txtcarnet.requestFocus(); //Pone el cursor de escritura en el campo de cedula
        } else {
            carnet = txtcarnet.getText();
            res = false;
            for (int i = 0; i < lista2.size(); i++) {
                m = lista2.get(i);
                if (carnet.equalsIgnoreCase(m.getCarnet())) {
                    res = true;
                    habilitarCampos1();
                    txtnombre.setText(m.getNombrem());
                    Lsgenero.setSelectedItem(m.getGenero());
                    txthorario.setText(m.getHorario());
                    txthosp.setText(m.getHospitalDeTrabajo());
                    if (m.getGenero().equalsIgnoreCase("Másculino")) {
                        Lsgenero.setSelectedItem("Másculino");
                    } else {
                        Lsgenero.setSelectedItem("Femenino");
                    }
                    javax.swing.JOptionPane.showMessageDialog(null, "Carnet: " + carnet + " Encontrada", " Mensaje", 1); //Valor de 1 para mostrar un icono de confirmacion
                    break;
                }
            }
            if (res == false) {
                javax.swing.JOptionPane.showMessageDialog(null, "Carnet: " + carnet + "No Encontrada", " Mensaje", 2);// valor de 2 para mostrar icono de advertencia
            }
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtcarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcarnetActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // Evento para limpiar los campos de Medico
        
        txtcarnet.setText("");
        txtnombre.setText("");
        Lsgenero.setSelectedItem("");
        txthorario.setText("");
        txthosp.setText("");
        ListarMedicos();
        estadisticasMedico();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        asignar = txtentradaP.getText();
        asignar2 = txtentradacar.getText();
        int sala = (int)(Math.random()*20+1);
        
        for (int i = 0; i < lista.size(); i++) {
            p = lista.get(i);
            if(asignar.equalsIgnoreCase(p.getnCedula())){
                nameLb.setText(p.getNombre());
                name = p.getNombre(); 
            }
        }
        for (int i = 0; i < lista2.size(); i++) {
            m = lista2.get(i);
            if(asignar2.equalsIgnoreCase(m.getCarnet())){
                nom.setText(m.getNombrem());
                name2 = m.getNombrem();
            }
        }
        a = new Asignados(asignar, asignar2, name, name2, sala);
        asignados.add(a);
        Asignados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
         Asignar.setVisible(true);
         Asignados();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        form_liistadoHospital.setVisible(true);
        Asignados();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btlimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlimActionPerformed
        // TODO add your handling code here:
        txtentradaP.setText("");
        txtentradacar.setText(" ");
        nameLb.setText("");
        nom.setText(" ");
        Asignados();
    }//GEN-LAST:event_btlimActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Asignar;
    private javax.swing.JFrame Form_agregar;
    private javax.swing.JFrame Form_añadir;
    private javax.swing.JFrame Form_lista;
    private javax.swing.JFrame Form_listar;
    private javax.swing.JLabel JLabelCedu;
    private javax.swing.JComboBox<String> Lsgenero;
    private javax.swing.JLabel añadidosLb;
    private javax.swing.JButton btlim;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton busquedaBt;
    private javax.swing.JTextField cedulatxt;
    private javax.swing.JTextField fechatxt;
    private javax.swing.JLabel femLb;
    private javax.swing.JLabel femeninoLb;
    private javax.swing.JFrame form_liistadoHospital;
    private javax.swing.JComboBox<String> generosItem;
    private javax.swing.JButton guardarBt;
    private javax.swing.JTextField hospitaltxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton limpiarBt;
    private javax.swing.JLabel maleLb;
    private javax.swing.JLabel masculinosLb;
    private javax.swing.JTextField maternotxt;
    private javax.swing.JLabel nameLb;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField paternotxt;
    private javax.swing.JLabel registradosLb;
    private javax.swing.JTable tablaLista;
    private javax.swing.JTable tb_asignados;
    private javax.swing.JTable tb_listar;
    private javax.swing.JTextField txtcarnet;
    private javax.swing.JTextField txtentradaP;
    private javax.swing.JTextField txtentradacar;
    private javax.swing.JTextField txthorario;
    private javax.swing.JTextField txthosp;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
