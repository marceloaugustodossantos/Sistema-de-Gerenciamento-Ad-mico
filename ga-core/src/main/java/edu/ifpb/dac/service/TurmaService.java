package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Turma;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface TurmaService extends GenericService<Turma>{
    public List<Turma> listarTodasAsTurmas();
    public List<Turma> listarTurmasPorCurso(long idCurso, int semestre);
    public Turma buscarTurmaPorIdentificacao(String identificacao);
}
