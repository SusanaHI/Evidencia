package bd;

//Clase Doctor
public class Doctor {
    
    int idDr;
    String nomDr, apePatDr, apeMatDr, espDr;
      
    public Doctor(int idDr, String nomDr, String apePatDr, String apeMatDr, String espDr) { 
        this.idDr = idDr;
        this.nomDr = nomDr;
        this.apePatDr = apePatDr;
        this.apeMatDr = apeMatDr;
        this.espDr = espDr;
    }

    public int getId() {
        return idDr;
    }

    public void setId(int idDr) {
        this.idDr = idDr;
    }

    public String getNombre() {
        return nomDr;
    }

    public void setNombre(String nomDr) {
        this.nomDr = nomDr;
    }

    public String getApellidoPat() {
        return apePatDr;
    }
    
    public String getApellidoMat() {
        return apeMatDr;
    }

    public void setApellidos(String apePatDr, String apeMatDr) {
        this.apePatDr = apePatDr;
        this.apeMatDr = apeMatDr;
    }
    
    public String getEsp() {
        return espDr;
    }

    public void setEsp(String espDr) {
        this.espDr = espDr;
    }

    public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveDoctor(this);
        con.close();
    }
    
}