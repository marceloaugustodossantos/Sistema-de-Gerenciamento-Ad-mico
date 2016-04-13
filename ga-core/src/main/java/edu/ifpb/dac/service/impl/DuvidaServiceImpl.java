/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.Duvida;
import edu.ifpb.dac.service.DuvidaService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author Marcelo Augusto
 */
@Stateless
public class DuvidaServiceImpl implements DuvidaService {

    @EJB
    private DAO<Duvida> dao;

    @Override
    public boolean cadastrar(Duvida obj) {
        return dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Duvida obj) {
        return dao.atualizar(obj);
    }

    @Override
    public boolean remover(Duvida obj) {
        return dao.excluir(obj);
    }

    @Override
    public Duvida buscar(Object chave) {
        return dao.buscar(chave, Duvida.class);
    }

}
