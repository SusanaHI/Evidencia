package bd;

import java.util.*;
import org.apache.logging.log4j.LogManager;

//Clase principal
public class Principal {

    Scanner sc = new Scanner(System.in);
    static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    
    //Constructor
    public Principal(){
        
    }
    
    public static void main(String[] args) {
        
        Principal obj1 = new Principal();
                
        String user = "";
        String password = "";
        
        try{
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Usuario:");
            user = sc.nextLine();
            System.out.println("Contraseña:");
            password = sc.nextLine();
            
            Conector persist = new Conector();
            persist.connect();
            List<Usuario> usuario = persist.getUsuarioByName(user, password);
            
            if (usuario.isEmpty()) {
                obj1.opciones();
            }else {
                System.out.println("No tiene autorización");
            }
        } catch (Exception ex) {
            logger.error("{}: {}", ex.getClass(), ex.getMessage());
            System.err.format("Ocurrió un error. Para más información consulta el log de la aplicación.");
        }
        
    }
    
    public void opciones(){
        
        boolean verdadero = true;
		
        while(verdadero) {

            System.out.println("B I E N V E N I D O \nSeleccione la opción deseada:");
            System.out.println("(1) Dar de alta pacientes.");
            System.out.println("(2) Dar de alta doctores.");
            System.out.println("(3) Crear una cita.");
            System.out.println("(4) Mostrar citas por doctor.");
            System.out.println("(5) Mostrar citas por paciente.");
            System.out.println("(0) Salir");
            
            int x = sc.nextInt();

            switch (x) {

                case 1:
                    
                    int idPac;
                    String nomPac, apePatPac, apeMatPac;

                    System.out.println("Introduce el id del paciente: ");
                    idPac = sc.nextInt();

                    System.out.println("Introduce el nombre del paciente: ");
                    nomPac = sc.next();

                    System.out.println("Introduce el apellido paterno del paciente: ");
                    apePatPac = sc.next();

                    System.out.println("Introduce el apellido materno del paciente: ");
                    apeMatPac = sc.next();
                   
                    Paciente paciente = new Paciente(idPac, nomPac, apePatPac, apeMatPac);
                    paciente.save();
                    
                    break;

                case 2:
                    
                    int idDr;
                    String nomDr, apePatDr, apeMatDr, espDr;

                    System.out.println("Introduce el id del doctor: ");
                    idDr = sc.nextInt();

                    System.out.println("Introduce el nombre del doctor: ");
                    nomDr = sc.next();

                    System.out.println("Introduce el apellido paterno del doctor: ");
                    apePatDr = sc.next();

                    System.out.println("Introduce el apellido materno del doctor: ");
                    apeMatDr = sc.next();
                    
                    System.out.println("Introduce la especialidad del doctor: ");
                    espDr = sc.next();
                   
                    Doctor doctor = new Doctor(idDr, nomDr, apePatDr, apeMatDr, espDr);
                    doctor.save();
                    
                    break;

                case 3:
                    
                    int idCita, diaCita, mesCita, anioCita, idHorario, idDrFK, idPacFK;
                    String motivoCita;

                    System.out.println("Introduce el id de la cita: ");
                    idCita = sc.nextInt();

                    System.out.println("Introduce el dia de la cita: ");
                    diaCita = sc.nextInt();
                    
                    System.out.println("Introduce el mes de la cita: ");
                    mesCita = sc.nextInt();
                    
                    System.out.println("Introduce el anio de la cita: ");
                    anioCita = sc.nextInt();
                    
                    System.out.println("ID DE HORARIOS\n1 : 10 - 12\n2 : 12 - 14\n3 : 14 - 16\n4 : 16 - 18");
                    System.out.println("Introduce el id de horario que prefieras: ");
                    idHorario = sc.nextInt();

                    System.out.println("Introduce el id del doctor con quieres la cita: ");
                    idDrFK = sc.nextInt();

                    System.out.println("Introduce tu id de paciente: ");
                    idPacFK = sc.nextInt();
                    
                    System.out.println("Introduce el motivo de la cita: ");
                    motivoCita = sc.next();
                   
                    Citas cita = new Citas(idCita, diaCita, mesCita, anioCita, idHorario, idDrFK, idPacFK, motivoCita);
                    cita.save();
                    
                    break;
                    
                case 4:
                                           
                    System.out.println("Introduce el id del doctor del que quieres consultar las citas: ");
                    int idDrS = sc.nextInt();
                    
                    Conector con = new Conector();
                    con.mostrarCitasDoctor(idDrS);
                                       
                    break;
                    
                case 5:
                        
                    System.out.println("Introduce el id del paciente del que quieres consultar las citas: ");
                    int idPacS = sc.nextInt();
                    
                    Conector con1 = new Conector();
                    con1.mostrarCitasPaciente(idPacS);
                    
                    break;

                case 0:
                    System.out.println("Salir ");
                    verdadero = false;
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo. ");
                    verdadero = true;
            }

        }
        
    }
    
}