package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.AulaReposicao;
import edu.ifpb.dac.service.AulaReposicaoService;
import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class AulaReposicaoServiceImpl implements AulaReposicaoService {

    @EJB
    private DAO<AulaReposicao> dao;

    public AulaReposicaoServiceImpl() {
    }

    @Override
    public boolean cadastrar(AulaReposicao obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(AulaReposicao obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(AulaReposicao obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public AulaReposicao buscar(Object chave) {
        return this.dao.buscar(chave, AulaReposicao.class);
    }

}
