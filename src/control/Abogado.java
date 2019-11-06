
package control;



/**
 *
 * @author hugo
 */
public class Abogado {
    private int abogadoDni;
    private String abogadoNombre;
    private String abogadoDireccion;
    private long abogadoTelefono;
    private String abogadoEspcilidad;
//----------------------------Metodo constructor
    public Abogado() {
    }
  //--------------------------------------
  
//----------------------------Metodo constructor parametrisado 

    public Abogado(int abogadoDni, String abogadoNombre, String abogadoDireccion, long abogadoTelefono, String abogadoEspcilidad) {
        this.abogadoDni = abogadoDni;
        this.abogadoNombre = abogadoNombre;
        this.abogadoDireccion = abogadoDireccion;
        this.abogadoTelefono = abogadoTelefono;
        this.abogadoEspcilidad = abogadoEspcilidad;
    }
   //---------------------------------------------------
    //---------------------------------Metodos get y Set

    public int getAbogadoDni() {
        return abogadoDni;
    }

    public void setAbogadoDni(int abogadoDni) {
        this.abogadoDni = abogadoDni;
    }

    public String getAbogadoNombre() {
        return abogadoNombre;
    }

    public void setAbogadoNombre(String abogadoNombre) {
        this.abogadoNombre = abogadoNombre;
    }

    public String getAbogadoDireccion() {
        return abogadoDireccion;
    }

    public void setAbogadoDireccion(String abogadoDireccion) {
        this.abogadoDireccion = abogadoDireccion;
    }

    public long getAbogadoTelefono() {
        return abogadoTelefono;
    }

    public void setAbogadoTelefono(long abogadoTelefono) {
        this.abogadoTelefono = abogadoTelefono;
    }

    public String getAbogadoEspcilidad() {
        return abogadoEspcilidad;
    }

    public void setAbogadoEspcilidad(String abogadoEspcilidad) {
        this.abogadoEspcilidad = abogadoEspcilidad;
    }
    
    
    //-----------------------------------------------------------
    
    //------------------------metodo para retornar cadena de abogado
    public String toStrong(){
        return getAbogadoDni()+"    "+getAbogadoNombre()+"     "+getAbogadoDireccion()+"      "
        +getAbogadoTelefono()+"        "+getAbogadoEspcilidad();
    
    }
    
    
}
