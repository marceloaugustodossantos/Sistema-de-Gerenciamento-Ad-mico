package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author joaomarcos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "busca.administrador.login", query = "SELECT a from Administrador a WHERE a.login = :login"),
    @NamedQuery(name = "busca.administrador.todos", query = "SELECT a from Administrador a")
})
public class Administrador implements Serializable {

    @Id
    @GeneratedValue
    private long id;    
    @NotBlank()
    private String nome;
    @Column(unique = true)
    @NotBlank
    private String login;
    @NotBlank
    private String senha;

    public Administrador() {
    }

    public Administrador(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        return this.nome;
    }
}
