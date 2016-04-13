package edu.ifpb.dac.service;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface GenericService<T> {

    public boolean cadastrar(T obj);

    public boolean atualizar(T obj);

    public boolean remover(T obj);

    /**
     * Bucar pela chave primária.
     *
     * @param chave
     * @return
     */
    public T buscar(Object chave);
}
