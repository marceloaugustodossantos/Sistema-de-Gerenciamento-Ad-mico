package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Disciplina;
import edu.ifpb.dac.service.DisciplinaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class DisciplinaServiceImpl implements DisciplinaService {

    @EJB
    private DAO<Disciplina> dao;
    
    @Override
    public boolean cadastrar(Disciplina obj) {
        return dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Disciplina obj) {
        return dao.atualizar(obj);
    }

    @Override
    public boolean remover(Disciplina obj) {
        return dao.excluir(obj);
    }

    @Override
    public Disciplina buscar(Object chave) {
        return dao.buscar(chave, Disciplina.class);
    }

    @Override
    public List<Disciplina> listarTodasDisciplinas() {
        return this.dao.consultaLista("buscar.disciplinas.todas", null);
    }

}
