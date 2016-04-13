package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joaomarcos
 */
@Entity
public class AulaReposicao implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Horario> horarios;
    @OneToOne
    private Turma turma;
    
    public AulaReposicao (){
        this.horarios = new ArrayList<>();
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }
    
    public void addHorario(Horario horario){
        this.horarios.add(horario);
    } 

    public void setHorario(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AulaReposicao other = (AulaReposicao) obj;
        return this.id == other.id;
    }
    
    

}
