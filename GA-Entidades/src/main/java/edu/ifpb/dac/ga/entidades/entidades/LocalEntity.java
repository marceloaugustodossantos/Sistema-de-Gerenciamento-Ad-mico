package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "busca.local.todos", query = "SELECT l from LocalEntity l"),
    @NamedQuery (name = "busca.local.lab", query = "SELECT l FROM LocalEntity l WHERE l.pk.tipo = 'Laboratório'"),
    @NamedQuery (name = "busca.local.sala", query = "SELECT l from LocalEntity l WHERE l.pk.tipo = 'Sala'"),
    @NamedQuery(name = "busca.local.turma.dia", query = "SELECT DISTINCT l FROM Turma t join t.aulas a join a.local l WHERE t.id = :id AND a.horario.dia = :dia AND a.horario.descricao = :horario")

})
@Entity
@Table(name = "local")
public class LocalEntity implements Serializable {

    @EmbeddedId
    private LocalPK pk;
    private String descricao;
    private String abreviacao;

    public LocalEntity() {

    }

    public LocalEntity(long id, String descricao, String abreviacao, String tipo) {
        this.pk = new LocalPK(id, tipo);
        this.descricao = descricao;
        this.abreviacao = abreviacao;
    }

    public String getTipo() {
        return this.pk.getTipo();
    }

    public LocalPK getPk() {
        return pk;
    }

    public void setPk(LocalPK pk) {
        this.pk = pk;
    }

    public long getId() {
        return this.pk.getId();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }   
    
    @Override
    public String toString() {
        return this.abreviacao;
    }

}
