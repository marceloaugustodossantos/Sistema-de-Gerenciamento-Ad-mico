package edu.ifpb.dac.ga.entidades.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * @author Marcelo Augusto
 * @param <T>
 */
@Stateless
public class DAOJPA<T> implements DAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public DAOJPA() {
    }

    @Override
    public boolean salvar(T obj) {
        try {
            entityManager.persist(obj);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public boolean atualizar(T obj) {
        try {
            entityManager.merge(obj);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean excluir(T obj) {
        try {
            entityManager.remove(obj);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public T buscar(Object chave, Class<T> entidade) {
        return entityManager.find(entidade, chave);
    }

    @Override
    public List<T> consultaLista(String consulta, Map<String, Object> parametros) {
        Query query = entityManager.createNamedQuery(consulta);
        if (parametros != null && !parametros.isEmpty()) {
            for (String parametro : parametros.keySet()) {
                query.setParameter(parametro, parametros.get(parametro));
            }
        }
        return query.getResultList();
    }

    @Override
    public T consultaSimples(String consulta, Map<String, Object> parametros) {
        try {
            Query query = entityManager.createNamedQuery(consulta);
            if (parametros != null && !parametros.isEmpty()) {
                for (String parametro : parametros.keySet()) {
                    query.setParameter(parametro, parametros.get(parametro));
                }
            }
            return (T) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
