package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Atividade;
import edu.ifpb.dac.service.AtividadeService;
import javax.ejb.Stateless;
import javax.ejb.EJB;
/**
 *
 * @author joaomarcos
 */
@Stateless
public class AtividadeServiceImpl implements AtividadeService {
    @EJB
    private DAO<Atividade> dao;

    public AtividadeServiceImpl() {
        
    }

    @Override
    public boolean cadastrar(Atividade obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Atividade obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(Atividade obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public Atividade buscar(Object chave) {
        return this.dao.buscar(chave, Atividade.class);
    }

}
