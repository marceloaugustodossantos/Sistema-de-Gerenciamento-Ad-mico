package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.dao.DAOJPA;
import edu.ifpb.dac.ga.entidades.entidades.Aluno;
import edu.ifpb.dac.service.AlunoService;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.EJB;
/**
 *
 * @author joaomarcos
 */
@Stateless
public class AlunoServiceImpl implements AlunoService {
    @EJB
    private  DAO<Aluno> dao;

    public AlunoServiceImpl() {
    }

    public Aluno login(String id, String senha) {
        Map<String, Object> params = new HashMap<>();
        params.put("matricula", id);
        try {
            Aluno aluno = dao.consultaSimples("busca.aluno.porMatricula", params);
            if (aluno != null && aluno.getSenha().equals(senha)) {
            return aluno;
        }
        } catch (Exception e) {
        e.printStackTrace();}
        
        
        return null;
    }

    @Override
    public boolean cadastrar(Aluno obj) {
        return dao.salvar(obj);
    }

    @Override
    public boolean atualizar(Aluno obj) {
        return dao.atualizar(obj);
    }

    @Override
    public boolean remover(Aluno obj) {
        return dao.excluir(obj);
    }

    @Override
    public Aluno buscar(Object chave) {
        return dao.buscar(chave, Aluno.class);
    }

    @Override
    public List<Aluno> buscarPorNome(String nome) {
        Map<String, Object> params = new HashMap<>();
        params.put("nome", nome);
        return dao.consultaLista("busca.aluno.nome", params);
    }

    public List<Aluno> listarTodosAlunos(){
        return this.dao.consultaLista("busca.aluno.todos", null);
    }
}
