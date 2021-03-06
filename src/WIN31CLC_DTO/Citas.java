package WIN31CLC_DTO;

import java.util.Date;
import java.util.Objects;

public class Citas {

    private long id;
    private Date createAt;
    private int status;
    private long patient_id;
    private long service_id;
    private long especialista_id;
    private Date fechadecita;
    private int id_horario;

    
    private Patient patient;
    private Specialist specialist;
    private Service service;
    private horario_citas horario_citas;
    
    private String fecha_Registro;
    private String fecha_cita;
    private String Hora_inicio;

    private int total;
    private int totalpages;
    
    public Citas() { //instanciar un obejto de tipo cita

    }

    public Citas(long id, int status, long patient_id, long service_id, long especialista_id, Date fechadecita) {
        this.id = id;
        this.status = status;
        this.patient_id = patient_id;
        this.service_id = service_id;
        this.especialista_id = especialista_id;
        this.fechadecita = fechadecita;
    }

    public Citas(long id, Date createAt, int status, long patient_id, long especialista_id) {
        this.id = id;
        this.createAt = createAt;
        this.status = status;
        this.patient_id = patient_id;
        this.especialista_id = especialista_id;
    }

    // encapsulamiento - datos privado - nos ayuda a mantener la consistencia de la informacion
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public long getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }
 public int getStatus() {
        return status;
    }
    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public void setEspecialista_id(long especialista_id) {
        this.especialista_id = especialista_id;
    }

    public int isStatus() {
        return status;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public long getEspecialista_id() {
        return especialista_id;
    }

    public Date getFechadecita() {
        return fechadecita;
    }

    public void setFechadecita(Date fechadecita) {
        this.fechadecita = fechadecita;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public horario_citas getHorario_citas() {
        return horario_citas;
    }

    public void setHorario_citas(horario_citas horario_citas) {
        this.horario_citas = horario_citas;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getFecha_Registro() {
        return fecha_Registro;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public String getHora_inicio() {
        return Hora_inicio;
    }

    public void setFecha_Registro(String fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public void setHora_inicio(String Hora_inicio) {
        this.Hora_inicio = Hora_inicio;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    
    @Override
    public int hashCode() {  // necesitar que los objetos que estamos instanciamos seran 
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.createAt);
        hash = 97 * hash + this.status;
        hash = 97 * hash + (int) (this.patient_id ^ (this.patient_id >>> 32));
        hash = 97 * hash + (int) (this.especialista_id ^ (this.especialista_id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fechadecita);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Citas other = (Citas) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.patient_id != other.patient_id) {
            return false;
        }
        if (this.especialista_id != other.especialista_id) {
            return false;
        }
        if (!Objects.equals(this.createAt, other.createAt)) {
            return false;
        }
        if (!Objects.equals(this.fechadecita, other.fechadecita)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Citas{" + "id=" + id + ", createAt=" + createAt + ", status=" + status + ", patient_id=" + patient_id + ", especialista_id=" + especialista_id + ", fechadecita=" + fechadecita + '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
