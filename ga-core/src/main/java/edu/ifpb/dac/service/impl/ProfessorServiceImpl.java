package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.Aluno;
import edu.ifpb.dac.ga.entidades.entidades.Professor;
import edu.ifpb.dac.service.ProfessorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class ProfessorServiceImpl implements ProfessorService {
    @EJB
    private DAO<Professor> dao;

    public ProfessorServiceImpl() {
        
    }
    public Professor login(String matricula, String senha) {
        Map<String, Object> params = new HashMap<>();
        params.put("matricula", matricula);
        Professor professor = dao.consultaSimples("busca.professor.porMatricula", params);
        if (professor != null && professor.getSenha().equals(senha)) {
            return professor;
        }
        return null;
    }
    @Override
    public boolean cadastrar(Professor obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Professor obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(Professor obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public Professor buscar(Object chave) {
        return this.dao.buscar(chave, Professor.class);
    }

    @Override
    public List<Professor> listarTodosProfessores() {
        return this.dao.consultaLista("busca.professor.todos", null);
    }

}
