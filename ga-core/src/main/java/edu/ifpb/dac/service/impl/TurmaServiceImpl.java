package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.TurmaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class TurmaServiceImpl implements TurmaService {

    @EJB
    private DAO<Turma> dao;
    
    @Override
    public List<Turma> listarTodasAsTurmas() {
        return this.dao.consultaLista("busca.turma.todas", null);
    }

    @Override
    public boolean cadastrar(Turma obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Turma obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(Turma obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public Turma buscar(Object chave) {
        return this.dao.buscar(chave, Turma.class);
    }

    @Override
    public List<Turma> listarTurmasPorCurso(long idCurso, int semestre) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", idCurso);
        params.put("semestre", semestre);
        return this.dao.consultaLista("busca.turma.curso.semestre", params);
    }
    
    public Turma buscarTurmaPorIdentificacao(String identificacao){
        Map<String, Object> params = new HashMap<>();
        params.put("identificacao", identificacao);
        return dao.consultaSimples("busca.turma.porIdentificacao", params);
    }
    
}
