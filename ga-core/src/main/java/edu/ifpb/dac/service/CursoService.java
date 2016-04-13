package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Curso;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface CursoService extends GenericService<Curso>{
    public List<Curso> listarTodosOsCursos();
}
