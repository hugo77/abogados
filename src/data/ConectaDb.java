package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;


public class ConectaDb {

    private String user, pass, urlConectar, driver;// definicion de variables para la coneccion
    public Connection conection; // variable de la clase conect para conectar la base de datos
    private java.sql.Statement statement; // estatement controla las coneciones y las ejecuciones de las sql   
    //---------------------metodo constructor para la clase conectar

    public ConectaDb() {

    }
    //---------------------fin del constructor

    public void conectar() {
        user = "hugo";
        pass = "hugo77";
        driver = "org.postgresql.Driver";
        urlConectar = "jdbc:postgresql://localhost/abogados";

        try {
            Class.forName(driver);
            conection = DriverManager.getConnection(urlConectar, user, pass);
            System.out.println("SI SE CONECTA A LA DB");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("No conecto a la db");
        }
        
    }


//-------------------metodo para cerrar la coneccion a la db
    public void cerrarConexion() {
        try {
            conection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//metodo para generar las consultas
    public ResultSet retornarconsultas(String cadConsulta) {
        ResultSet resultado = null;

        try {
            statement = conection.createStatement();
            resultado = statement.executeQuery(cadConsulta);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    //------------------------------
    //----------------metodo para cerrar el resultado
    public void cierraResultado(ResultSet resutado) {
        try {

            resutado.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // ---------------------fin del metodo

    public boolean transaccion(String cadenaSql) {
        //boolean ejecuta= false;
        try {
            statement = conection.createStatement();
            statement.execute(cadenaSql);
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    //----------------------fin del metodo

    //------------
    public int rowConut(ResultSet resultado) {
        int i = 0;
        try {

            resultado.last();
            i = resultado.getRow();
            resultado.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;

    }

    //----------------------
//
//    public static void main(String arsg[] ){
//    ConectaDb cc = new ConectaDb();
//      cc.conectar();
//    }
}
