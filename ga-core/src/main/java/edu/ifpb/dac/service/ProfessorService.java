package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Professor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface ProfessorService extends GenericService<Professor>{
    public List<Professor> listarTodosProfessores();
    public Professor login(String id, String senha);
}
