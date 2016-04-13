package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Administrador;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface AdministradorService extends GenericService<Administrador> {

    public Administrador login(String login, String senha);
    public List<Administrador> listarAdministradores();
    
}
