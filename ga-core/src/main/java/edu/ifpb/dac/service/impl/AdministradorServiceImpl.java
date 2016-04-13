package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.Administrador;
import edu.ifpb.dac.service.AdministradorService;
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
public class AdministradorServiceImpl implements AdministradorService {
    @EJB
    private  DAO<Administrador> dao;

    public AdministradorServiceImpl() {
        
    }

    @Override
    public boolean cadastrar(Administrador obj) {
        try {
            String senhaHash = atualizarSenhaHash(obj.getLogin(), obj.getSenha());
            obj.setSenha(senhaHash);
            return dao.salvar(obj);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return false;
        }        
    }

    @Override
    public boolean atualizar(Administrador obj) {
        return dao.atualizar(obj);
    }

    @Override
    public boolean remover(Administrador obj) {
        return dao.excluir(obj);
    }

    @Override
    public Administrador buscar(Object chave) {
        return dao.buscar(chave, Administrador.class);
    }

    @Override
    public List<Administrador> listarAdministradores() {
        return this.dao.consultaLista("busca.administrador.todos", null);
    }

    public Administrador login(String login, String senha) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        Administrador administrador = dao.consultaSimples("busca.administrador.login", params);
        try {
            if (administrador != null && administrador.getSenha().equals(atualizarSenhaHash(login, senha))) {
                return administrador;
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String atualizarSenhaHash(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest generator = MessageDigest.getInstance("MD5");
        String novaSenha = login + senha;
        byte[] hash = generator.digest(novaSenha.getBytes("UTF-8"));
        return new String(hash);
    }

}
