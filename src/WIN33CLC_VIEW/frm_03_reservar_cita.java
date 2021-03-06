package WIN33CLC_VIEW;

import WIN30CLC_DAO.DaoException;
import WIN31CLC_DTO.Citas;
import WIN31CLC_DTO.Patient;
import WIN31CLC_DTO.Service;
import WIN31CLC_DTO.Specialist;
import WIN31CLC_DTO.horario_citas;
import WIN32CLC_CTR.CTR_02_Patient;
import WIN32CLC_CTR.CTR_03_Service;
import WIN32CLC_CTR.CTR_04_Specialist;
import WIN32CLC_CTR.CTR_05_Citas;
import WIN_2020_UTILS.Validators;
import static WIN_2020_UTILS.Validators.getSelectedButtonIndex;
import static WIN_2020_UTILS.Validators.inputStringIngresado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyFade;

/**
 *
 * @author lufra
 */
public class frm_03_reservar_cita extends javax.swing.JPanel {

    CTR_02_Patient cTR_02_Patient = new CTR_02_Patient();
    CTR_05_Citas cTR_05_Citas = new CTR_05_Citas();

    ArrayList<Service> service_list = null;
    ArrayList<Specialist> specialist_list = null;
    Patient patient = null;

    /**
     * Creates new form vista1
     */
    public frm_03_reservar_cita() {
        initComponents();
        LoadData();

        btn_nueva_cita.setEnabled(true);
        btn_cancelar_cambios1.setEnabled(false);
        btn_guardar_cita1.setEnabled(false);
    }

    void loadmam() {

    }

    public void LoadData() {
        try {
            checkbox_horario(false);
            // traer los servicios
            CTR_03_Service ctr_Service = new CTR_03_Service();
            service_list = new ArrayList<Service>();
            Service service = new Service();
            cbx_service.removeAllItems();
            service.setId(0);
            service.setName("--Seleccionar--");
            service.setPrice(0);
            service_list.add(service);
            service_list.addAll(ctr_Service.listService());
            if (service_list != null) {
                for (int i = 0; i < service_list.size(); i++) {
                    cbx_service.addItem(service_list.get(i).getName());
                }
            }

            // traer los especialistar por servicio
            reset_cbx_specialist();

            CTR_04_Specialist cTR_04_Specialist = new CTR_04_Specialist();

            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    //System.out.println("Selected: " + cbx_service.getSelectedItem());
                    //System.out.println(", Position: " + cbx_service.getSelectedIndex());
                    if (cbx_service.getSelectedIndex() > 0) {
                        try {
                            specialist_list = new ArrayList<Specialist>();
                            Specialist Specialist_e = new Specialist();
                            cbx_especialista.removeAllItems();
                            Specialist_e.setId(0);
                            Specialist_e.setName("--Seleccionar--");
                            Specialist_e.setFullname("--Seleccionar--");

                            specialist_list.add(Specialist_e);
                            Service parametro = service_list.get(cbx_service.getSelectedIndex());
                            specialist_list.addAll(cTR_04_Specialist.listSpecialist(parametro.getId()));
                            cbx_especialista.setEnabled(true);
                            if (specialist_list.size() > 0) {
                                for (int i = 0; i < specialist_list.size(); i++) {
                                    cbx_especialista.addItem(specialist_list.get(i).getFullname());
                                }
                            } else {
                                reset_cbx_specialist();
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(frm_03_reservar_cita.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        reset_cbx_specialist();
                    }
                }
            };
            // add event al cbs_Service

            cbx_service.addActionListener(actionListener);

        } catch (SQLException ex) {
            Logger.getLogger(frm_03_reservar_cita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DaoException ex) {
            Logger.getLogger(frm_03_reservar_cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reset_cbx_specialist() {

        specialist_list = new ArrayList<Specialist>();
        Specialist Specialist_e = new Specialist();
        cbx_especialista.removeAllItems();
        Specialist_e.setId(0);
        Specialist_e.setName("--Seleccionar--");
        Specialist_e.setFullname("--Seleccionar--");
        specialist_list.add(Specialist_e);
        cbx_especialista.addItem(Specialist_e.getFullname());
        cbx_especialista.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_contenedor = new javax.swing.JPanel();
        fSGradientPanel1 = new LIB.FSGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_nueva_cita = new RSMaterialComponent.RSButtonMaterialGradientOne();
        btn_cancelar_cambios1 = new RSMaterialComponent.RSButtonMaterialGradientOne();
        btn_guardar_cita1 = new RSMaterialComponent.RSButtonMaterialGradientOne();
        jPanel1 = new javax.swing.JPanel();
        btn_buscar_paciente = new RSMaterialComponent.RSButtonMaterialGradientOne();
        jLabel1 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_patient = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbx_service = new RSMaterialComponent.RSComboBoxMaterial();
        cbx_especialista = new RSMaterialComponent.RSComboBoxMaterial();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        txt_buscar_horarios = new RSMaterialComponent.RSButtonMaterialGradientOne();
        jPanel3 = new javax.swing.JPanel();
        rbx_1 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_2 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_3 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_4 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_5 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_6 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_7 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_8 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_9 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_10 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_11 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_12 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_13 = new RSMaterialComponent.RSRadioButtonMaterial();
        rbx_14 = new RSMaterialComponent.RSRadioButtonMaterial();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fSGradientPanel1.setFSEndColor(new java.awt.Color(3, 111, 198));
        fSGradientPanel1.setFSStartColor(new java.awt.Color(101, 208, 250));
        fSGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-calendario-100.png"))); // NOI18N
        fSGradientPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 110, 90));

        btn_nueva_cita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-hoy-30.png"))); // NOI18N
        btn_nueva_cita.setText("Nueva Cita");
        btn_nueva_cita.setBorderPainted(false);
        btn_nueva_cita.setColorPrimario(new java.awt.Color(42, 170, 232));
        btn_nueva_cita.setColorPrimarioHover(new java.awt.Color(101, 208, 250));
        btn_nueva_cita.setColorSecundario(new java.awt.Color(3, 102, 183));
        btn_nueva_cita.setColorSecundarioHover(new java.awt.Color(3, 102, 183));
        btn_nueva_cita.setFocusPainted(false);
        btn_nueva_cita.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 1, 15)); // NOI18N
        btn_nueva_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nueva_citaActionPerformed(evt);
            }
        });
        fSGradientPanel1.add(btn_nueva_cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, -1));

        btn_cancelar_cambios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-cancelar-30.png"))); // NOI18N
        btn_cancelar_cambios1.setText("Cancelar Cambios");
        btn_cancelar_cambios1.setBorderPainted(false);
        btn_cancelar_cambios1.setColorPrimario(new java.awt.Color(42, 170, 232));
        btn_cancelar_cambios1.setColorPrimarioHover(new java.awt.Color(101, 208, 250));
        btn_cancelar_cambios1.setColorSecundario(new java.awt.Color(3, 102, 183));
        btn_cancelar_cambios1.setColorSecundarioHover(new java.awt.Color(3, 102, 183));
        btn_cancelar_cambios1.setFocusPainted(false);
        btn_cancelar_cambios1.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 1, 15)); // NOI18N
        btn_cancelar_cambios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_cambios1ActionPerformed(evt);
            }
        });
        fSGradientPanel1.add(btn_cancelar_cambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 210, -1));

        btn_guardar_cita1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-guardar-como-30.png"))); // NOI18N
        btn_guardar_cita1.setText("Guardar Cita");
        btn_guardar_cita1.setBorderPainted(false);
        btn_guardar_cita1.setColorPrimario(new java.awt.Color(42, 170, 232));
        btn_guardar_cita1.setColorPrimarioHover(new java.awt.Color(101, 208, 250));
        btn_guardar_cita1.setColorSecundario(new java.awt.Color(3, 102, 183));
        btn_guardar_cita1.setColorSecundarioHover(new java.awt.Color(3, 102, 183));
        btn_guardar_cita1.setFocusPainted(false);
        btn_guardar_cita1.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 1, 15)); // NOI18N
        btn_guardar_cita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_cita1ActionPerformed(evt);
            }
        });
        fSGradientPanel1.add(btn_guardar_cita1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 210, -1));

        panel_contenedor.add(fSGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 740));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-encuentra-hombre-usuario-30.png"))); // NOI18N
        btn_buscar_paciente.setText("Buscar Paciente");
        btn_buscar_paciente.setBorderPainted(false);
        btn_buscar_paciente.setColorPrimario(new java.awt.Color(42, 170, 232));
        btn_buscar_paciente.setColorPrimarioHover(new java.awt.Color(101, 208, 250));
        btn_buscar_paciente.setColorSecundario(new java.awt.Color(3, 102, 183));
        btn_buscar_paciente.setColorSecundarioHover(new java.awt.Color(3, 102, 183));
        btn_buscar_paciente.setFocusPainted(false);
        btn_buscar_paciente.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 1, 16)); // NOI18N
        btn_buscar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DNI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 20));

        txt_dni.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        txt_dni.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        txt_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dniActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 120, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        jLabel4.setText("PACIENTE: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        lbl_patient.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_patient.setText("Nombres y apellidos");
        jPanel1.add(lbl_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 520, -1));

        panel_contenedor.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 770, 210));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserva de Servicios y Especialista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Especialista");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Servicios");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        cbx_service.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un servicio", "RSItem 2", "RSItem 3", "RSItem 4" }));
        cbx_service.setColorMaterial(new java.awt.Color(3, 111, 198));
        cbx_service.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 15)); // NOI18N
        jPanel4.add(cbx_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        cbx_especialista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un Especialista", "RSItem 2", "RSItem 3", "RSItem 4" }));
        cbx_especialista.setColorMaterial(new java.awt.Color(3, 111, 198));
        cbx_especialista.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 15)); // NOI18N
        jPanel4.add(cbx_especialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        panel_contenedor.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 770, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserva de cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel12.setText("Fecha de la Cita");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 51, -1, -1));

        rSDateChooser2.setColorBackground(new java.awt.Color(3, 111, 198));
        rSDateChooser2.setColorButtonHover(new java.awt.Color(3, 111, 198));
        rSDateChooser2.setColorDiaActual(new java.awt.Color(255, 0, 0));
        rSDateChooser2.setColorForeground(new java.awt.Color(3, 111, 198));
        rSDateChooser2.setFuente(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(rSDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        txt_buscar_horarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WIN34CLC_RESOURCES/icons8-horas-extras-30.png"))); // NOI18N
        txt_buscar_horarios.setText("Ver Horario Disponible");
        txt_buscar_horarios.setBorderPainted(false);
        txt_buscar_horarios.setColorPrimario(new java.awt.Color(42, 170, 232));
        txt_buscar_horarios.setColorPrimarioHover(new java.awt.Color(101, 208, 250));
        txt_buscar_horarios.setColorSecundario(new java.awt.Color(3, 102, 183));
        txt_buscar_horarios.setColorSecundarioHover(new java.awt.Color(3, 102, 183));
        txt_buscar_horarios.setFocusPainted(false);
        txt_buscar_horarios.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 1, 16)); // NOI18N
        txt_buscar_horarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscar_horariosActionPerformed(evt);
            }
        });
        jPanel2.add(txt_buscar_horarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 250, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbx_1);
        rbx_1.setForeground(new java.awt.Color(0, 0, 0));
        rbx_1.setText("8:00 - 8:30");
        rbx_1.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_1.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_1.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_1.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

        buttonGroup1.add(rbx_2);
        rbx_2.setForeground(new java.awt.Color(0, 0, 0));
        rbx_2.setText("8:30 - 9:00");
        rbx_2.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_2.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_2.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_2.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 5, -1, -1));

        buttonGroup1.add(rbx_3);
        rbx_3.setForeground(new java.awt.Color(0, 0, 0));
        rbx_3.setText("9:00 - 9:30");
        rbx_3.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_3.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbx_3.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_3.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 5, -1, -1));

        buttonGroup1.add(rbx_4);
        rbx_4.setForeground(new java.awt.Color(0, 0, 0));
        rbx_4.setText("9:30 - 10:00");
        rbx_4.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_4.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_4.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_4.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 5, -1, -1));

        buttonGroup1.add(rbx_5);
        rbx_5.setForeground(new java.awt.Color(0, 0, 0));
        rbx_5.setText("10:00 - 10:30");
        rbx_5.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_5.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_5.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_5.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 50, -1, -1));

        buttonGroup1.add(rbx_6);
        rbx_6.setForeground(new java.awt.Color(0, 0, 0));
        rbx_6.setText("10:30 - 11:00");
        rbx_6.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_6.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_6.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_6.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 50, -1, -1));

        buttonGroup1.add(rbx_7);
        rbx_7.setForeground(new java.awt.Color(0, 0, 0));
        rbx_7.setText("11:00 - 11:30");
        rbx_7.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_7.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_7.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_7.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 50, -1, -1));

        buttonGroup1.add(rbx_8);
        rbx_8.setForeground(new java.awt.Color(0, 0, 0));
        rbx_8.setText("11:30 - 12:00");
        rbx_8.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_8.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_8.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_8.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 50, -1, -1));

        rbx_9.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbx_9);
        rbx_9.setForeground(new java.awt.Color(0, 0, 0));
        rbx_9.setText("12:00 - 12:30");
        rbx_9.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_9.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_9.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_9.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 95, -1, -1));

        buttonGroup1.add(rbx_10);
        rbx_10.setForeground(new java.awt.Color(0, 0, 0));
        rbx_10.setText("12:30 - 13:00");
        rbx_10.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_10.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_10.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_10.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 95, -1, -1));

        buttonGroup1.add(rbx_11);
        rbx_11.setForeground(new java.awt.Color(0, 0, 0));
        rbx_11.setText("13:00 - 13:30");
        rbx_11.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_11.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_11.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_11.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 95, -1, -1));

        buttonGroup1.add(rbx_12);
        rbx_12.setForeground(new java.awt.Color(0, 0, 0));
        rbx_12.setText("13:30 - 14:00");
        rbx_12.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_12.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_12.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_12.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 95, -1, -1));

        buttonGroup1.add(rbx_13);
        rbx_13.setForeground(new java.awt.Color(0, 0, 0));
        rbx_13.setText("14:00 - 14:00");
        rbx_13.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_13.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_13.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_13.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 140, -1, -1));

        buttonGroup1.add(rbx_14);
        rbx_14.setForeground(new java.awt.Color(0, 0, 0));
        rbx_14.setText("14:30 - 15:00");
        rbx_14.setColorCheck(new java.awt.Color(3, 111, 198));
        rbx_14.setColorUnCheck(new java.awt.Color(3, 111, 198));
        rbx_14.setFont(new java.awt.Font("ITC Avant Garde Std Bk", 0, 14)); // NOI18N
        rbx_14.setRippleColor(new java.awt.Color(3, 111, 198));
        jPanel3.add(rbx_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 140, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 740, 210));

        panel_contenedor.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 770, 330));

        add(panel_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 740));
    }// </editor-fold>//GEN-END:initComponents
 public void deshabilitar_rbx(boolean b) {

        rbx_4.setVisible(b);
        rbx_8.setVisible(b);
        rbx_12.setVisible(b);
        rbx_3.setVisible(b);
        rbx_7.setVisible(b);
        rbx_11.setVisible(b);
        rbx_14.setVisible(b);
    }
    private void btn_buscar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_pacienteActionPerformed
        try {
            patient = cTR_02_Patient.SelectPatient(txt_dni.getText());
            lbl_patient.setText(patient.getName() + ", " + patient.getLastname() + " " + patient.getSurename());
        } catch (SQLException ex) {
            lbl_patient.setText(ex.getMessage());
        } catch (DaoException ex) {
            lbl_patient.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btn_buscar_pacienteActionPerformed

    private void txt_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dniActionPerformed

    private void txt_buscar_horariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscar_horariosActionPerformed
        if (rSDateChooser2.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(null, "Elija la fecha de la cita primero");
        } else {

            if (cbx_service.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Servicio");

            } else if (cbx_especialista.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Especialista");

            } else {
                validarFechaCita();//procedimiento para mostrar las horas disponibles segun la fecha elegida
            }
        }
    }//GEN-LAST:event_txt_buscar_horariosActionPerformed
    private void validarFechaCita() {
        java.util.Date capturar_fecha_sistema = new java.util.Date();

        DateFormat dateFormat_fecha = new SimpleDateFormat("yyyyMMdd");
        String fecha_sistema = dateFormat_fecha.format(capturar_fecha_sistema);

        DateFormat dateFormat_hora = new SimpleDateFormat("HH:mm");
        String hora_sistema = dateFormat_hora.format(capturar_fecha_sistema);

        String feSeleccionada;
        int fec;

        //para obtener la fecha
        String formato = "yyyyMMdd";
        java.util.Date date = rSDateChooser2.getDatoFecha();
        feSeleccionada = String.valueOf(date);
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        feSeleccionada = (sdf.format(date));

        if (feSeleccionada.compareTo(fecha_sistema) < 0) {
            JOptionPane.showMessageDialog(null, "Error, Verifique la fecha de la nueva cita");
            JOptionPane.showMessageDialog(null, "Fecha Actual " + fecha_sistema + " Fecha Elejida " + feSeleccionada);
        } else if (feSeleccionada.compareTo(fecha_sistema) > 0) {
            Service e_service = service_list.get(cbx_service.getSelectedIndex());
            Specialist e_especialista = specialist_list.get(cbx_especialista.getSelectedIndex());
            validar_hora_cita_posterior_al_dia(feSeleccionada, fecha_sistema, hora_sistema, e_especialista.getId(), e_service.getId());
        } else {
            Service e_service = service_list.get(cbx_service.getSelectedIndex());
            Specialist e_especialista = specialist_list.get(cbx_especialista.getSelectedIndex());
            validarHoraCita_Del_Dia(feSeleccionada, fecha_sistema, hora_sistema, e_especialista.getId(), e_service.getId());
        }
    }

    public void validarHoraCita_Del_Dia(String feSeleccionada, String fecha_sistema, String hora_sistema, long id_especialista, long id_servicio) {
        rbx_1.setEnabled(false);

        try {
            horario_citas ehorarios_citas = new horario_citas();
            horario_citas ehorarios_citas_disponible = new horario_citas();
            horario_citas ehorarios_citas_reservadas = new horario_citas();
            int registros = cTR_05_Citas.capturar_cantidad_fechas(feSeleccionada);

            if (registros > 0) {

                List horarios_citas_reservadas = cTR_05_Citas.capturar_cantidad_fechas_v1(feSeleccionada, id_especialista, id_servicio);
                List horarios_citas_disponible = cTR_05_Citas.listando_horario_disponible();

                if (horarios_citas_disponible != null && horarios_citas_disponible.size() != 0) {
                    if (horarios_citas_reservadas != null && horarios_citas_reservadas.size() != 0) {

                        for (int z = 0; z < horarios_citas_reservadas.size(); z++) {
                            ehorarios_citas_reservadas = (horario_citas) horarios_citas_reservadas.get(z);

                            for (int i = 0; i < horarios_citas_disponible.size(); i++) {
                                ehorarios_citas_disponible = (horario_citas) horarios_citas_disponible.get(i);

//                                if (ehorarios_citas_disponible.getCita_horario_inicio().equals(ehorarios_citas_reservadas.getCita_horario_inicio()) && ehorarios_citas_disponible.getCita_horario_fin().equals(ehorarios_citas_reservadas.getCita_horario_fin())) {
//                                    check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);
//
//                                } else {
                                // check_horario_validacion(ehorarios_citas_disponible.getId_horario(), true);
                                if (hora_sistema.compareTo(ehorarios_citas_disponible.getCita_horario_inicio()) >= 0 && hora_sistema.compareTo(ehorarios_citas_disponible.getCita_horario_fin()) >= 0) {

                                    check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);

                                } else {
                                    if (ehorarios_citas_disponible.getCita_horario_inicio().equals(ehorarios_citas_reservadas.getCita_horario_inicio()) && ehorarios_citas_disponible.getCita_horario_fin().equals(ehorarios_citas_reservadas.getCita_horario_fin())) {
                                        check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);
                                    } else {
                                        check_horario_validacion(ehorarios_citas_disponible.getId_horario(), true);

                                    }
                                }

                            }

                        }
                    } else {
                        if (horarios_citas_disponible != null) {
                            for (int i = 0; i < horarios_citas_disponible.size(); i++) {
                                ehorarios_citas = (horario_citas) horarios_citas_disponible.get(i);

                                if (hora_sistema.compareTo(ehorarios_citas.getCita_horario_inicio()) >= 0 && hora_sistema.compareTo(ehorarios_citas.getCita_horario_fin()) >= 0) {

                                    check_horario_validacion(ehorarios_citas.getId_horario(), false);

                                } else {
                                    check_horario_validacion(ehorarios_citas.getId_horario(), true);

                                }

                            }

                        } else {
                            checkbox_horario(false);
                        }
                    }
                } else {
                    checkbox_horario(false);
                }

            } else {

                List horarios_citas = cTR_05_Citas.listando_horario_disponible();
                if (horarios_citas != null) {
                    for (int i = 0; i < horarios_citas.size(); i++) {
                        ehorarios_citas = (horario_citas) horarios_citas.get(i);

                        if (hora_sistema.compareTo(ehorarios_citas.getCita_horario_inicio()) >= 0 && hora_sistema.compareTo(ehorarios_citas.getCita_horario_fin()) >= 0) {

                            check_horario_validacion(ehorarios_citas.getId_horario(), false);

                        } else {
                            check_horario_validacion(ehorarios_citas.getId_horario(), true);

                        }

                    }
                } else {
                    checkbox_horario(false);
                }

            }

        } catch (DaoException ex) {
        } catch (SQLException ex) {
        }
    }

    public void validar_hora_cita_posterior_al_dia(String feSeleccionada, String fecha_sistema, String hora_sistema, long id_especialista, long id_servicio) {
        try {
            horario_citas ehorarios_citas = new horario_citas();
            horario_citas ehorarios_citas_disponible = new horario_citas();
            horario_citas ehorarios_citas_reservadas = new horario_citas();
            int registros = cTR_05_Citas.capturar_cantidad_fechas(feSeleccionada);

            // if (registros > 0) {
            List horarios_citas_reservadas = cTR_05_Citas.capturar_cantidad_fechas_v1(feSeleccionada, id_especialista, id_servicio);
            List horarios_citas_disponible = cTR_05_Citas.listando_horario_disponible();

            if (horarios_citas_disponible != null && horarios_citas_disponible.size() != 0) {
                if (horarios_citas_reservadas != null && horarios_citas_reservadas.size() != 0) {
                    checkbox_horario(true);
                    for (int z = 0; z < horarios_citas_reservadas.size(); z++) {
                        ehorarios_citas_reservadas = (horario_citas) horarios_citas_reservadas.get(z);

                        for (int i = 0; i < horarios_citas_disponible.size(); i++) {
                            ehorarios_citas_disponible = (horario_citas) horarios_citas_disponible.get(i);

//                                if (ehorarios_citas_disponible.getCita_horario_inicio().equals(ehorarios_citas_reservadas.getCita_horario_inicio()) && ehorarios_citas_disponible.getCita_horario_fin().equals(ehorarios_citas_reservadas.getCita_horario_fin())) {
//                                    check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);
//
//                                } else {
                            // check_horario_validacion(ehorarios_citas_disponible.getId_horario(), true);
                            //   if (hora_sistema.compareTo(ehorarios_citas_disponible.getCita_horario_inicio()) >= 0 && hora_sistema.compareTo(ehorarios_citas_disponible.getCita_horario_fin()) >= 0) {
                            //     check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);
                            //  } else {
                            if (ehorarios_citas_disponible.getCita_horario_inicio().equals(ehorarios_citas_reservadas.getCita_horario_inicio()) && ehorarios_citas_disponible.getCita_horario_fin().equals(ehorarios_citas_reservadas.getCita_horario_fin())) {
                                check_horario_validacion(ehorarios_citas_disponible.getId_horario(), false);
                            }
//else {
//                                check_horario_validacion(ehorarios_citas_disponible.getId_horario(), true);
//
//                            }
                        }

                    }

                } else {

                    checkbox_horario(true);
                }
            } else {
                checkbox_horario(false);

            }
//            } else {
//
//                List horarios_citas = cTR_05_Citas.listando_horario_disponible();
//                if (horarios_citas != null) {
//                    for (int i = 0; i < horarios_citas.size(); i++) {
//                        ehorarios_citas = (horario_citas) horarios_citas.get(i);
//
//                        if (hora_sistema.compareTo(ehorarios_citas.getCita_horario_inicio()) >= 0 && hora_sistema.compareTo(ehorarios_citas.getCita_horario_fin()) >= 0) {
//
//                            check_horario_validacion(ehorarios_citas.getId_horario(), false);
//
//                        } else {
//                            check_horario_validacion(ehorarios_citas.getId_horario(), true);
//
//                        }
//
//                    }
//                } else {
//                    checkbox_horario(false);
//                }
//
//            }

        } catch (DaoException ex) {
        } catch (SQLException ex) {
        }
    }

    public void checkbox_horario(boolean bloqueo) {
        rbx_1.setEnabled(bloqueo);
        rbx_2.setEnabled(bloqueo);
        rbx_3.setEnabled(bloqueo);
        rbx_4.setEnabled(bloqueo);
        rbx_5.setEnabled(bloqueo);
        rbx_6.setEnabled(bloqueo);
        rbx_7.setEnabled(bloqueo);
        rbx_8.setEnabled(bloqueo);
        rbx_9.setEnabled(bloqueo);
        rbx_10.setEnabled(bloqueo);
        rbx_11.setEnabled(bloqueo);
        rbx_12.setEnabled(bloqueo);
        rbx_13.setEnabled(bloqueo);
        rbx_14.setEnabled(bloqueo);
    }

    public void check_horario_validacion(int tipo, boolean bloqueo) {
        if (tipo == 1) {
            rbx_1.setEnabled(bloqueo);
        }
        if (tipo == 2) {
            rbx_2.setEnabled(bloqueo);
        }
        if (tipo == 3) {
            rbx_3.setEnabled(bloqueo);
        }
        if (tipo == 4) {
            rbx_4.setEnabled(bloqueo);
        }
        if (tipo == 5) {
            rbx_5.setEnabled(bloqueo);
        }
        if (tipo == 6) {
            rbx_6.setEnabled(bloqueo);
        }
        if (tipo == 7) {
            rbx_7.setEnabled(bloqueo);
        }
        if (tipo == 8) {
            rbx_8.setEnabled(bloqueo);
        }
        if (tipo == 9) {
            rbx_9.setEnabled(bloqueo);
        }
        if (tipo == 10) {
            rbx_10.setEnabled(bloqueo);
        }
        if (tipo == 11) {
            rbx_11.setEnabled(bloqueo);
        }
        if (tipo == 12) {
            rbx_12.setEnabled(bloqueo);
        }
        if (tipo == 13) {
            rbx_13.setEnabled(bloqueo);
        }
        if (tipo == 14) {
            rbx_14.setEnabled(bloqueo);
        }

    }
public void enviar_confirmacion(Citas citas, Date fechacita, String horacita)

    {
    Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        
       
        
        String correoEnvia = "dentalpro.clinica.notificacion@gmail.com";
        String contrasena = "Redes2015";
        String destinatario = citas.getPatient().getEmail();
        String asunto_cita = "Dental`s pro: Cita Revervada con Exito" ;
        //String mensaje = txtMensaje.getText();
        String mensaje_cita = "DETALLE DE LA CITA:  \n"+
                              "===================  \n"+
                               "\n"+
                               "Nombre del Paciente= " +citas.getPatient().getName()+" "+citas.getPatient().getLastname()+" "+citas.getPatient().getSurename()
                                +"\n Nombre del Especialista= "+citas.getSpecialist().getName()+ " "+citas.getSpecialist().getLastname()+" "+citas.getSpecialist().getSurename()
                                +"\n Servicio odontologico= "+citas.getService().getName()
                                +"\n Fecha de la cita= "+ fechacita.toString()
                                +"\n Hora de la cita= "+horacita
                                +"\n" 
                                +"\n -- LLege 30 minutos antes de la hora de su cita. "
                                +"\n" 
                                +"\n Dental`s pro le agradece su preferencia."

                ;
                
              
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto_cita);
            mail.setText(mensaje_cita);
            
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(null, "DentalSys: Se envio la confirmacion de la cita al Email del paciente");
            
            
            
            
            
        } catch (AddressException ex) {
            Logger.getLogger(frm_UI_02_reservar_cita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(frm_UI_02_reservar_cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }         
    private void btn_guardar_cita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_cita1ActionPerformed
//    
//        //El paciente 
//        if (patient != null) {
//            // el servicio
//            Service e_service = service_list.get(cbx_service.getSelectedIndex());
//            if (e_service.getId() > 0) {
//                // el especialista
//                Specialist e_especialista = specialist_list.get(cbx_especialista.getSelectedIndex());
//                if (e_especialista.getId() > 0) {
//                    // select fecha
//                    //cal_fecha_cita.g
//                    // seleccionamos la hora
//
//                }
//            }
//        } else {
//            // mensaje de error
//        }
//
//        btn_cancelar_cambios1.setEnabled(false);
//        btn_guardar_cita1.setEnabled(false);
//        btn_nueva_cita.setEnabled(true);
        String msg = "";
        int focus = 0;
        if (txt_dni.getText().length() < 8 || txt_dni.getText().length() > 8) {
            msg = msg + "Ingrese un DNI válido \n";
            focus = 0;
        } else if (!inputStringIngresado(txt_dni.getText())) {
            msg = msg + "Ingrese Dni \n";
            focus = 1;
        } else if (cbx_service.getSelectedIndex() == 0) {
            msg = msg + "Seleccione Servicio \n";
            focus = 2;

        } else if (cbx_especialista.getSelectedIndex() == 0) {
            msg = msg + "Seleccione Especialista \n";
            focus = 3;

        }

        try {
            if (msg.length() > 0) {
                JOptionPane.showMessageDialog(null, msg,
                        "Dental SyS", JOptionPane.ERROR_MESSAGE);
                switch (focus) {
                    case 0:
                        txt_dni.requestFocus();
                        break;
                    case 1:
                        txt_dni.requestFocus();
                        break;
                    case 2:
                        cbx_service.requestFocus();
                        break;
                    case 3:
                        cbx_service.requestFocus();
                        break;
                    default:
                        txt_dni.requestFocus();
                        break;
                }
            } else {
                //patient = cTR_02_Patient.SelectPatient(txt_dni.getText());
               // if (patient.getId() == 0) {

                    Service e_service = service_list.get(cbx_service.getSelectedIndex());
                    Specialist e_especialista = specialist_list.get(cbx_especialista.getSelectedIndex());
                    Citas citas_e = new Citas();
                    java.util.Date date = rSDateChooser2.getDatoFecha();
                    java.sql.Date date1 = new java.sql.Date(date.getTime());
                    citas_e.setFechadecita(date1);
                    citas_e.setStatus(1);
                    citas_e.setPatient_id(patient.getId());
                    citas_e.setService_id(e_service.getId());
                    citas_e.setEspecialista_id(e_especialista.getId());
                    citas_e.setId_horario(getSelectedButtonIndex(buttonGroup1));

                    String hora = Validators.getSelectedButtonText(buttonGroup1);

                    enviar_confirmacion(citas_e,date1,hora);
                    
                 
                    
                    cTR_05_Citas.insert(citas_e);
                    
                    
                    new rojerusan.RSNotifyFade("DentalSys", "Se guardaron los cambios correctamente.", 7,
                            RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                    btn_cancelar_cambios1.setEnabled(false);
                    btn_guardar_cita1.setEnabled(false);
                    btn_nueva_cita.setEnabled(true);
                //} else {
                    //new rojerusan.RSNotifyFade("DentalSys", "No se guardaron los datos! \n Intente nuevamente", 7,
                            //RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
               // }
            }

        } catch (SQLException ex) {
            // Logger.getLogger(frm_02_register_patient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DaoException ex) {
            //Logger.getLogger(frm_02_register_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_guardar_cita1ActionPerformed

    private void btn_nueva_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nueva_citaActionPerformed
        // TODO add your handling code here:

        btn_guardar_cita1.setEnabled(true);
        btn_cancelar_cambios1.setEnabled(false);
    }//GEN-LAST:event_btn_nueva_citaActionPerformed

    private void btn_cancelar_cambios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_cambios1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelar_cambios1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialGradientOne btn_buscar_paciente;
    private RSMaterialComponent.RSButtonMaterialGradientOne btn_cancelar_cambios1;
    private RSMaterialComponent.RSButtonMaterialGradientOne btn_guardar_cita1;
    private RSMaterialComponent.RSButtonMaterialGradientOne btn_nueva_cita;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSComboBoxMaterial cbx_especialista;
    private RSMaterialComponent.RSComboBoxMaterial cbx_service;
    private LIB.FSGradientPanel fSGradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_patient;
    private javax.swing.JPanel panel_contenedor;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_1;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_10;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_11;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_12;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_13;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_14;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_2;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_3;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_4;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_5;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_6;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_7;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_8;
    private RSMaterialComponent.RSRadioButtonMaterial rbx_9;
    private RSMaterialComponent.RSButtonMaterialGradientOne txt_buscar_horarios;
    private javax.swing.JTextField txt_dni;
    // End of variables declaration//GEN-END:variables

}
