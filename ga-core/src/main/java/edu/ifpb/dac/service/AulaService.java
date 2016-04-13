package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Aula;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface AulaService extends GenericService<Aula>{
     public List<Aula> listarTodasAulas(String namedQuery, Map<String, Object> parametros);
}
