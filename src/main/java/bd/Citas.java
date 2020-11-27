package bd;

public class Citas {
    
    int idCita, diaCita, mesCita, anioCita, idHorario, idDr, idPac;
    String motivoCita;
    
    public Citas(int idCita, int diaCita, int mesCita, int anioCita, int idHorario, int idDr, int idPac, String motivoCita) { 
        this.idCita = idCita;
        this.diaCita = diaCita;
        this.mesCita = mesCita;
        this.anioCita = anioCita;
        this.idHorario = idHorario;
        this.idDr = idDr;
        this.idPac = idPac;
        this.motivoCita = motivoCita;
        
    }

    public int getId() {
        return idCita;
    }

    public void setId(int idCita) {
        this.idCita = idCita;
    }

    public int getDia() {
        return diaCita;
    }

    public void setDia(int diaCita) {
        this.diaCita = diaCita;
    }
    
    public int getMes() {
        return mesCita;
    }

    public void setMes(int mesCita) {
        this.mesCita = mesCita;
    }
    
    public int getAnio() {
        return anioCita;
    }

    public void setAnio(int anioCita) {
        this.anioCita = anioCita;
    }
    
    public int getHorario() {
        return idHorario;
    }

    public void setHorario(int idHorario) {
        this.idHorario = idHorario;
    }
    
    public int getDr() {
        return idDr;
    }

    public void setDr(int idDr) {
        this.idDr = idDr;
    }
    
    public int getPac() {
        return idPac;
    }

    public void setPac(int idPac) {
        this.idPac = idPac;
    }
    
    public String getMot() {
        return motivoCita;
    }

    public void setMot(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveCita(this);
        con.close();
    }
        
}