package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Aula;
import edu.ifpb.dac.service.AulaService;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class AulaServiceImpl implements AulaService {

    @EJB
    private DAO<Aula> dao;

    public AulaServiceImpl() {
    }

    @Override
    public boolean cadastrar(Aula obj) {
        return dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Aula obj) {
        return dao.atualizar(obj);
    }

    @Override
    public boolean remover(Aula obj) {
        return dao.excluir(obj);
    }

    @Override
    public Aula buscar(Object chave) {
        return dao.buscar(chave, Aula.class);
    }

    @Override
    public List<Aula> listarTodasAulas(String namedQuery, Map<String, Object> parametros) {
        return dao.consultaLista(namedQuery, parametros);
    }

}
