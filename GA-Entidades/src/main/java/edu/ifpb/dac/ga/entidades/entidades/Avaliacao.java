package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author joaomarcos
 */
@Entity
public class Avaliacao implements Serializable {
    

    @Id
    @GeneratedValue
    private long id;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String link;

    public Avaliacao() {
    }

    public Avaliacao(String titulo, String link) {
        this.titulo = titulo;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
