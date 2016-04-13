package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Aluno;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface AlunoService extends GenericService<Aluno>{
    public List<Aluno> buscarPorNome(String nome);
    public List<Aluno> listarTodosAlunos();
    public Aluno login(String id, String senha);
}
