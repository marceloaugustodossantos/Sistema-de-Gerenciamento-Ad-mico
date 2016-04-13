package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author joaomarcos
 */
@Entity
public class Comentario implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String toString(){
        LocalDate ltInicio = LocalDateTime.ofInstant(this.data.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return descricao + " \n   Data: "+ltInicio;
    }
    
}
