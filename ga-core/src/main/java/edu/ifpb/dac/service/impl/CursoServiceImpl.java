package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Curso;
import edu.ifpb.dac.service.CursoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class CursoServiceImpl implements CursoService {

    @EJB
    private DAO<Curso> dao;
    

    @Override
    public List<Curso> listarTodosOsCursos() {
        return this.dao.consultaLista("busca.curso.todos", null);
    }

    @Override
    public boolean cadastrar(Curso obj) {
        return this.dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Curso obj) {
        return this.dao.atualizar(obj);
    }

    @Override
    public boolean remover(Curso obj) {
        return this.dao.excluir(obj);
    }

    @Override
    public Curso buscar(Object chave) {
        return this.dao.buscar(chave, Curso.class);
    }

}
