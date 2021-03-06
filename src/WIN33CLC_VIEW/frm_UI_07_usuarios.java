package WIN33CLC_VIEW;

import WIN30CLC_DAO.DaoException;
import WIN31CLC_DTO.User;
import WIN32CLC_CTR.CTR_01_Auth;
import static WIN_2020_UTILS.Validators.inputStringIngresado;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import rojerusan.RSNotifyFade;

public class frm_UI_07_usuarios extends javax.swing.JPanel {

    private CTR_01_Auth CTR_01_Auth_ctr;

    public frm_UI_07_usuarios() {
        initComponents();

        setBackground(new Color(255, 255, 255, 1));

        p1.setColorPrimario(new Color(255, 255, 255, 200));
        p1.setColorSecundario(new Color(255, 255, 255, 200));
        LoadData();
        Limpiar();
        btn_cancelar_cambios.setEnabled(false);
        btn_modificar_especialista.setEnabled(false);
        btn_guardar_especialista.setEnabled(false);
        CTR_01_Auth_ctr = new CTR_01_Auth();
    }

    public void LoadData() {
        try {
            CTR_01_Auth ctr = new CTR_01_Auth();
            this.tablePatients.setModel(ctr.ListUser());
            this.tablePatients.getSelectionModel().addListSelectionListener(e -> {
                boolean seleccionValid = (tablePatients.getSelectedRow() != -1);
                //btnEdit.setEnabled(seleccionValid);
                //btnDelete.setEnabled(seleccionValid);
            });
        } catch (DaoException ex) {
            // Logger.getLogger(frm_02_Patient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //   Logger.getLogger(frm_02_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.tablePatients.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        this.tablePatients.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablePatients.rowAtPoint(e.getPoint());
                int columna = tablePatients.columnAtPoint(e.getPoint());

                System.out.println("click");
                setEditable(true);

                if (tablePatients.getModel().getColumnClass(columna).equals(JButton.class)) {
                    try {
                        System.out.println(tablePatients.getModel().getValueAt(fila, 0));
                        long id = (long) tablePatients.getModel().getValueAt(fila, 0);
                        CTR_01_Auth_ctr.DeleteUser(id);
                        System.out.println("eliminado por el botton");
                        tablePatients.setModel(CTR_01_Auth_ctr.ListUser());
                        //      setEditable(false);
                    } catch (SQLException ex) {
                        // Logger.getLogger(frm_02_Patient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DaoException ex) {
                        //Logger.getLogger(frm_02_Patient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!tablePatients.getModel().getColumnClass(0).equals(JButton.class)) {
                    //System.out.println(tablePatients.getModel().getValueAt(fila, 0)); 
                    setId((long) tablePatients.getModel().getValueAt(fila, 0));

                }

            }

        });

    }

    private User getUserSelected() throws SQLException, DaoException {
        CTR_01_Auth ctr = new CTR_01_Auth();
        int id = (int) tablePatients.getValueAt(tablePatients.getSelectedRow(), 0);
        return ctr.SelectUser(id);
    }
    public void mensaje() throws DaoException, SQLException {
        tablePatients.setModel(CTR_01_Auth_ctr.ListUser());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menu_salir1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chk_admin = new RSMaterialComponent.RSCheckBoxMaterial();
        chk_recepcionista = new RSMaterialComponent.RSCheckBoxMaterial();
        txt_user = new rscomponentshade.RSFormatFieldShade();
        txt_pass = new rscomponentshade.RSPassFieldShade();
        menu_salir3 = new RSMaterialComponent.RSPanelMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePatients = new rojerusan.RSTableMetro();
        p1 = new RSMaterialComponent.RSPanelBorderGradient();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_nuevo_especialista = new newscomponents.RSButtonFlat_new();
        btn_guardar_especialista = new newscomponents.RSButtonFlat_new();
        btn_modificar_especialista = new newscomponents.RSButtonFlat_new();
        btn_cancelar_cambios = new newscomponents.RSButtonFlat_new();

        menu_salir1.setBackground(new java.awt.Color(255, 255, 255));
        menu_salir1.setBgShade(new java.awt.Color(204, 204, 204));
        menu_salir1.setPreferredSize(new java.awt.Dimension(90, 62));
        menu_salir1.setRound(40);

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("USUARIO");

        jLabel11.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("CONTRASEÑA");

        buttonGroup1.add(chk_admin);
        chk_admin.setForeground(new java.awt.Color(51, 51, 51));
        chk_admin.setText("Administrador");
        chk_admin.setColorCheck(new java.awt.Color(0, 112, 192));
        chk_admin.setColorUnCheck(new java.awt.Color(0, 112, 192));
        chk_admin.setFocusPainted(false);
        chk_admin.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N

        buttonGroup1.add(chk_recepcionista);
        chk_recepcionista.setForeground(new java.awt.Color(51, 51, 51));
        chk_recepcionista.setText("Recepcionista");
        chk_recepcionista.setColorCheck(new java.awt.Color(0, 112, 192));
        chk_recepcionista.setColorUnCheck(new java.awt.Color(0, 112, 192));
        chk_recepcionista.setFocusPainted(false);
        chk_recepcionista.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        chk_recepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_recepcionistaActionPerformed(evt);
            }
        });

        txt_user.setBackground(new java.awt.Color(246, 247, 251));
        txt_user.setBgShade(new java.awt.Color(255, 255, 255));
        txt_user.setBgShadeHover(new java.awt.Color(204, 204, 204));
        txt_user.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        txt_user.setIntensity(0);
        txt_user.setPhColor(new java.awt.Color(255, 255, 255));
        txt_user.setPixels(0);
        txt_user.setPlaceholder("");
        txt_user.setRound(40);

        txt_pass.setBackground(new java.awt.Color(247, 248, 251));
        txt_pass.setForeground(new java.awt.Color(51, 51, 51));
        txt_pass.setBgShade(new java.awt.Color(255, 255, 255));
        txt_pass.setBgShadeHover(new java.awt.Color(255, 255, 255));
        txt_pass.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_pass.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_pass.setPixels(0);
        txt_pass.setPlaceholder("");
        txt_pass.setRound(40);

        javax.swing.GroupLayout menu_salir1Layout = new javax.swing.GroupLayout(menu_salir1);
        menu_salir1.setLayout(menu_salir1Layout);
        menu_salir1Layout.setHorizontalGroup(
            menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_salir1Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_recepcionista, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        menu_salir1Layout.setVerticalGroup(
            menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_salir1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(menu_salir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_recepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        menu_salir3.setBackground(new java.awt.Color(255, 255, 255));
        menu_salir3.setBgShade(new java.awt.Color(204, 204, 204));
        menu_salir3.setPreferredSize(new java.awt.Dimension(90, 62));
        menu_salir3.setRound(40);

        tablePatients.setForeground(new java.awt.Color(74, 74, 74));
        tablePatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePatients.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tablePatients.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        tablePatients.setColorFilasForeground2(new java.awt.Color(74, 74, 74));
        tablePatients.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tablePatients.setFuenteFilas(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tablePatients.setFuenteFilasSelect(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tablePatients.setFuenteHead(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        tablePatients.setGridColor(new java.awt.Color(153, 153, 153));
        tablePatients.setGrosorBordeFilas(0);
        tablePatients.setGrosorBordeHead(0);
        tablePatients.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablePatients);

        javax.swing.GroupLayout menu_salir3Layout = new javax.swing.GroupLayout(menu_salir3);
        menu_salir3.setLayout(menu_salir3Layout);
        menu_salir3Layout.setHorizontalGroup(
            menu_salir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_salir3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        menu_salir3Layout.setVerticalGroup(
            menu_salir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_salir3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        p1.setBackground(new java.awt.Color(204, 204, 204));
        p1.setBgShade(new java.awt.Color(255, 255, 255));
        p1.setColorPrimario(new java.awt.Color(200, 232, 250));
        p1.setColorSecundario(new java.awt.Color(200, 232, 250));
        p1.setGradiente(RSMaterialComponent.RSPanelBorderGradient.Gradiente.HORIZONTAL);
        p1.setRound(40);
        p1.setWidthBorder(0);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES_UI/icons8-usuario-masculino-en-círculo-100.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 42)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Usuarios");

        btn_nuevo_especialista.setBackground(new java.awt.Color(139, 198, 255));
        btn_nuevo_especialista.setForeground(new java.awt.Color(51, 51, 51));
        btn_nuevo_especialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES_UI/icons8-añadir-usuario-masculino-24.png"))); // NOI18N
        btn_nuevo_especialista.setText("Nuevo Usuario");
        btn_nuevo_especialista.setBorderPainted(false);
        btn_nuevo_especialista.setContentAreaFilled(true);
        btn_nuevo_especialista.setCornerRound(45);
        btn_nuevo_especialista.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_nuevo_especialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_especialistaActionPerformed(evt);
            }
        });

        btn_guardar_especialista.setBackground(new java.awt.Color(139, 198, 255));
        btn_guardar_especialista.setForeground(new java.awt.Color(51, 51, 51));
        btn_guardar_especialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES_UI/icons8-guardar-24.png"))); // NOI18N
        btn_guardar_especialista.setText("Guardar Usuario");
        btn_guardar_especialista.setBorderPainted(false);
        btn_guardar_especialista.setContentAreaFilled(true);
        btn_guardar_especialista.setCornerRound(45);
        btn_guardar_especialista.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_guardar_especialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_especialistaActionPerformed(evt);
            }
        });

        btn_modificar_especialista.setBackground(new java.awt.Color(139, 198, 255));
        btn_modificar_especialista.setForeground(new java.awt.Color(51, 51, 51));
        btn_modificar_especialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES_UI/icons8-editar-usuario-masculino-24.png"))); // NOI18N
        btn_modificar_especialista.setText("Modificar Usuario");
        btn_modificar_especialista.setBorderPainted(false);
        btn_modificar_especialista.setContentAreaFilled(true);
        btn_modificar_especialista.setCornerRound(45);
        btn_modificar_especialista.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_modificar_especialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_especialistaActionPerformed(evt);
            }
        });

        btn_cancelar_cambios.setBackground(new java.awt.Color(139, 198, 255));
        btn_cancelar_cambios.setForeground(new java.awt.Color(51, 51, 51));
        btn_cancelar_cambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES_UI/cancelar.png"))); // NOI18N
        btn_cancelar_cambios.setText("Cancelar Cambios");
        btn_cancelar_cambios.setBorderPainted(false);
        btn_cancelar_cambios.setContentAreaFilled(true);
        btn_cancelar_cambios.setCornerRound(45);
        btn_cancelar_cambios.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_cancelar_cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_cambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_cancelar_cambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_nuevo_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_modificar_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_guardar_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(40, 40, 40))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(81, 81, 81)))))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_nuevo_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_guardar_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_modificar_especialista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_cancelar_cambios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu_salir3, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addComponent(menu_salir1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(menu_salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(menu_salir3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chk_recepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_recepcionistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_recepcionistaActionPerformed

    private void btn_nuevo_especialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_especialistaActionPerformed
        //    Limpiar();
        txt_user.setEnabled(true);
        txt_pass.setEnabled(true);
        chk_admin.setEnabled(true);
        chk_recepcionista.setEnabled(true);
        chk_admin.setSelected(false);
        chk_recepcionista.setSelected(false);
        btn_cancelar_cambios.setEnabled(true);
        btn_guardar_especialista.setEnabled(true);
    }//GEN-LAST:event_btn_nuevo_especialistaActionPerformed

    private void btn_guardar_especialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_especialistaActionPerformed
        String msg = "";
        int focus = 0;
        if (!inputStringIngresado(txt_user.getText())) {
            msg = msg + "Ingrese Un Usuario \n";
            focus = 0;
        } else if (!inputStringIngresado(txt_pass.getText())) {
            msg = msg + "Ingrese Una Contraseña\n";
            focus = 1;
        }

        try {
            if (msg.length() > 0) {
                JOptionPane.showMessageDialog(null, msg,
                        "Dental SyS", JOptionPane.ERROR_MESSAGE);
                switch (focus) {
                    case 0:
                        txt_user.requestFocus();
                        break;
                    case 1:
                        txt_pass.requestFocus();
                        break;
                    default:
                        break;
                }
            } else {
                String admin = "";

                User User_e = new User();
                User_e.setUsername(txt_user.getText());
                User_e.setPassword(txt_pass.getText());
                if (chk_admin.isSelected() == true) {
                    admin = "1";
                } else if (chk_recepcionista.isSelected() == true) {
                    admin = "2";
                }
                User_e.setRole(admin);
                User_e.setStatus(true);
                CTR_01_Auth ctrp = new CTR_01_Auth();

                if (id > 0) {
                    //modificar
                    User_e.setId(id);
                    ctrp.UpdateUser(User_e);
                    btn_cancelar_cambios.setEnabled(false);
                    btn_guardar_especialista.setEnabled(false);
                    btn_nuevo_especialista.setEnabled(true);
                    Limpiar();
                    dto = new User();
                    id = 0;
                    //frm_02_Patient frame = (frm_02_Patient) this.getTopLevelAncestor();
                    //frame.mensaje();
                    mensaje();
                } else {
                    // insertar
                    if (User_e.getId() == 0) {
                        User_e = ctrp.InsertUser(User_e);
                        btn_cancelar_cambios.setEnabled(false);
                        btn_guardar_especialista.setEnabled(false);
                        Limpiar();
                        // frm_02_Patient frame = (frm_02_Patient) this.getTopLevelAncestor();
                        // frame.mensaje();
                        mensaje();
                        new rojerusan.RSNotifyFade("DentalSys", "Se registro correctamente al Usuario en el sistema.", 7,
                                RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                    } else {

                        new rojerusan.RSNotifyFade("DentalSys", "No se guardaron los datos! \n Intente nuevamente", 7,
                                RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
                    }
                }

            }
        } catch (SQLException ex) {
            // Logger.getLogger(frm_02_register_patient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DaoException ex) {
            //Logger.getLogger(frm_02_register_patient.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardar_especialistaActionPerformed
    public void Limpiar() {
        txt_pass.setText("");
        txt_user.setText("");

        txt_user.requestFocus();

        txt_user.setEnabled(false);
        txt_pass.setEnabled(false);
        chk_admin.setEnabled(false);
        chk_recepcionista.setEnabled(false);
        chk_admin.setSelected(false);
        chk_recepcionista.setSelected(false);
       buttonGroup1.clearSelection();
    }
    private void btn_modificar_especialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_especialistaActionPerformed
        try {
            User dto = new User();

            dto = CTR_01_Auth_ctr.SelectUser(this.id);

            btn_modificar_especialista.setEnabled(false);
            btn_nuevo_especialista.setEnabled(false);
            btn_cancelar_cambios.setEnabled(true);
            btn_guardar_especialista.setEnabled(true);
            txt_user.setText(dto.getUsername());
            txt_pass.setText(dto.getUsername());
            txt_user.setEnabled(true);
            txt_pass.setEnabled(true);

            if (dto.getRole().equals("1")) {
                chk_admin.setSelected(true);

            } else if (dto.getRole().equals("2")) {
                chk_recepcionista.setSelected(true);
            }

            chk_admin.setEnabled(true);
            chk_recepcionista.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(frm_02_Patient_Detail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DaoException ex) {
            Logger.getLogger(frm_02_Patient_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_modificar_especialistaActionPerformed

    private void btn_cancelar_cambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_cambiosActionPerformed
        Limpiar();
        // dto = new Patient();

        id = 0;
        btn_cancelar_cambios.setEnabled(false);
        btn_modificar_especialista.setEnabled(false);
        btn_guardar_especialista.setEnabled(false);
    }//GEN-LAST:event_btn_cancelar_cambiosActionPerformed
    private boolean editable;
    private User dto;

    public User getDto() {
        return dto;
    }

    public void setDto(User dto) {
        this.dto = dto;
    }

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        btn_modificar_especialista.setEnabled(editable);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonFlat_new btn_cancelar_cambios;
    private newscomponents.RSButtonFlat_new btn_guardar_especialista;
    private newscomponents.RSButtonFlat_new btn_modificar_especialista;
    private newscomponents.RSButtonFlat_new btn_nuevo_especialista;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSCheckBoxMaterial chk_admin;
    private RSMaterialComponent.RSCheckBoxMaterial chk_recepcionista;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSPanelMaterial menu_salir1;
    private RSMaterialComponent.RSPanelMaterial menu_salir3;
    private RSMaterialComponent.RSPanelBorderGradient p1;
    private rojerusan.RSTableMetro tablePatients;
    private rscomponentshade.RSPassFieldShade txt_pass;
    private rscomponentshade.RSFormatFieldShade txt_user;
    // End of variables declaration//GEN-END:variables

}
