package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.Comentario;
import edu.ifpb.dac.service.ComentarioService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class ComentarioServiceImpl implements ComentarioService {

    @EJB
    private DAO<Comentario> dao;
    

    @Override
    public boolean cadastrar(Comentario obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Comentario obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(Comentario obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public Comentario buscar(Object chave) {
        return this.dao.buscar(chave, Comentario.class);
    }

}
