package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.MaterialAula;
import edu.ifpb.dac.service.MaterialAulaService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class MaterialAulaServiceImpl implements MaterialAulaService {

    @EJB
    private DAO<MaterialAula> dao;

   
    @Override
    public boolean cadastrar(MaterialAula obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(MaterialAula obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(MaterialAula obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public MaterialAula buscar(Object chave) {
        return this.dao.buscar(chave, MaterialAula.class);
    }

}
