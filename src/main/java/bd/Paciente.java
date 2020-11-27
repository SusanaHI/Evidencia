package bd;

import java.sql.*;

//Clase Paciente
public class Paciente {
  
    int idPac;
    String nomPac, apePatPac, apeMatPac;
      
    public Paciente(int idPac, String nomPac, String apePatPac, String apeMatPac) { 
        this.idPac = idPac;
        this.nomPac = nomPac;
        this.apePatPac = apePatPac;
        this.apeMatPac = apeMatPac;
    }

    public int getId() {
        return idPac;
    }

    public void setId(int idPac) {
        this.idPac = idPac;
    }

    public String getNombre() {
        return nomPac;
    }

    public void setNombre(String nomPac) {
        this.nomPac = nomPac;
    }

    public String getApellidoPat() {
        return apePatPac;
    }
    
    public String getApellidoMat() {
        return apeMatPac;
    }

    public void setApellidos(String apePatPac, String apeMatPac) {
        this.apePatPac = apePatPac;
        this.apeMatPac = apeMatPac;
    }
    
    public void save(){
        Conector con = new Conector();
        con.connect();
        con.savePaciente(this);
        con.close();
    }
    
}