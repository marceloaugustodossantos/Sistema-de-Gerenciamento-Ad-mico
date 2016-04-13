/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import edu.ifpb.dac.ga.entidades.entidades.LocalPK;
import edu.ifpb.dac.service.LocalService;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marcelo Augusto
 */
@Stateless
public class LocalServiceImpl implements LocalService {

    @EJB
    private DAO<LocalEntity> daoLocal;

    @Override
    public List<LocalEntity> listarTodosOsLocais(){
        return this.daoLocal.consultaLista("busca.local.todos", null);
    }
    @Override
    public List<LocalEntity> listarLaboratorios() {
        return this.daoLocal.consultaLista("busca.local.lab", null);
    }

    @Override
    public List<LocalEntity> listarSalas() {
        return this.daoLocal.consultaLista("busca.local.sala", null);
    }
    
    @Override
    public boolean cadastrar(LocalEntity obj) {
        return this.daoLocal.salvar(obj);
    }

    @Override
    public boolean atualizar(LocalEntity obj) {
        return daoLocal.atualizar(obj);
    }

    @Override
    public boolean remover(LocalEntity obj) {
        return daoLocal.excluir(obj);
    }

    @Override
    public LocalEntity buscar(Object chave) {
        return daoLocal.buscar(chave, LocalEntity.class);
    }

    @Override
    public List<LocalEntity> listarLocaisAulaTurmaNoDia(long idTurma, DayOfWeek dia, String horario) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", idTurma);
        params.put("dia", dia);
        params.put("horario", horario);
        return this.daoLocal.consultaLista("busca.local.turma.dia", params);
    }
}
