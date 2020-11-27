package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector extends Principal {
    
    Connection connect;
    Statement statement;
       
    public void connect(){
        
        String url = "consultorio.db";
        
        try {
            
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            statement = connect.createStatement();
            
            if (connect != null) {
                
                System.out.println("Conectado.");
            
            }
        
        }catch (SQLException ex) {
            
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        
        }
    
    }
    
    public void close(){
        
        try {
            
            connect.close();
        
        }catch (SQLException ex) {
            
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
    
    public List<Usuario> getUsuarioByName(String nombre, String password) throws SQLException {
        ResultSet rs = this.statement.executeQuery("select * from usuario where nombre='" + nombre.toUpperCase() + "' and password='" + password.toUpperCase() + "'");
        ArrayList<Usuario> usuario = new ArrayList<>();
        while (rs.next()) {
            Usuario temp = new Usuario();
            temp.setIdUsuario(rs.getInt("id_usuario"));
            temp.setIdUsuario(rs.getInt("nombre"));
            temp.setIdUsuario(rs.getInt("password"));
            temp.setIdUsuario(rs.getInt("rol"));
            usuario.add(temp);
        }
        return usuario;
    }
    
    public void savePaciente(Paciente paciente){
        try {
            PreparedStatement st = connect.prepareStatement("INSERT INTO paciente(idPac, nomPac, apePatPac, apeMatPac) VALUES (?,?,?,?)");
            st.setInt(1, paciente.getId());
            st.setString(2, paciente.getNombre());
            st.setString(3, paciente.getApellidoPat());
            st.setString(4, paciente.getApellidoMat());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void saveDoctor(Doctor doctor){
        try {
            PreparedStatement st = connect.prepareStatement("INSERT INTO doctor (idDr, nomDr, apePatDr, apeMatDr, espDr) VALUES (?,?,?,?,?)");
            st.setInt(1, doctor.getId());
            st.setString(2, doctor.getNombre());
            st.setString(3, doctor.getApellidoPat());
            st.setString(4, doctor.getApellidoMat());
            st.setString(5, doctor.getEsp());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void saveCita(Citas cita){
        try {
            PreparedStatement st = connect.prepareStatement("INSERT INTO citas (idCita, diaCita, mesCita, anioCita, idHorario, idDr, idPac, motivoCita) VALUES (?,?,?,?,?,?,?,?)");
            st.setInt(1, cita.getId());
            st.setInt(2, cita.getDia());
            st.setInt(3, cita.getMes());
            st.setInt(4, cita.getAnio());
            st.setInt(5, cita.getHorario());
            st.setInt(6, cita.getDr());
            st.setInt(7, cita.getPac());
            st.setString(8, cita.getMot());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void mostrarCitasDoctor(int a){
        
        ResultSet result;
        try {
            connect();
            PreparedStatement st = connect.prepareStatement("SELECT citas.*, doctor.nomDr, paciente.nomPac, horarios.* FROM citas JOIN horarios ON citas.idHorario = horarios.idHorario JOIN paciente ON citas.idPac = paciente.idPac JOIN doctor ON citas.idDr = doctor.idDr WHERE citas.idDr ='" +a+ "'");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Id de cita: ");
                System.out.println(result.getInt("idCita"));

                System.out.print("Fecha de cita: ");
                System.out.println(result.getInt("diaCita")+"/"+result.getInt("mesCita")+"/"+result.getInt("anioCita"));

                System.out.print("Horario de cita: ");
                System.out.println(result.getInt("horaInicial")+":00 - "+result.getInt("horaFinal")+":00");
                
                System.out.print("Nombre de doctor: ");
                System.out.println(result.getString("nomDr"));
                
                System.out.print("Nombre de paciente: ");
                System.out.println(result.getString("nomPac"));
                
                System.out.print("Motivo de cita: ");
                System.out.println(result.getString("motivoCita"));
                
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        close();
    }
    
    public void mostrarCitasPaciente(int a){
        
        ResultSet result = null;
        try {
            connect();
            PreparedStatement st = connect.prepareStatement("SELECT citas.*, doctor.nomDr, paciente.nomPac, horarios.* FROM citas JOIN horarios ON citas.idHorario = horarios.idHorario JOIN paciente ON citas.idPac = paciente.idPac JOIN doctor ON citas.idDr = doctor.idDr WHERE citas.idPac ='" +a+ "'");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Id de cita: ");
                System.out.println(result.getInt("idCita"));

                System.out.print("Fecha de cita: ");
                System.out.println(result.getInt("diaCita")+"/"+result.getInt("mesCita")+"/"+result.getInt("anioCita"));

                System.out.print("Horario de cita: ");
                System.out.println(result.getInt("horaInicial")+":00 - "+result.getInt("horaFinal")+":00");
                
                System.out.print("Nombre de doctor: ");
                System.out.println(result.getString("nomDr"));
                
                System.out.print("Nombre de paciente: ");
                System.out.println(result.getString("nomPac"));
                
                System.out.print("Motivo de cita: ");
                System.out.println(result.getString("motivoCita"));
                
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}