/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;

/**
 *
 * @author hugo
 */
public interface AdoAbogadoInterfaz {

    public boolean registrarAbogado(Abogado abogado);

    public List<Abogado> listaAbogados();

    public boolean actualizarAbogado(Abogado abogado);

    public boolean eliminarAbogado(Abogado abogado);
}
