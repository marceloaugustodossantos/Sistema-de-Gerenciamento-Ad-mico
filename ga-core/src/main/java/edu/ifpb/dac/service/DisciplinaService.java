package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Disciplina;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface DisciplinaService extends GenericService<Disciplina>{
    public List<Disciplina> listarTodasDisciplinas();
}
