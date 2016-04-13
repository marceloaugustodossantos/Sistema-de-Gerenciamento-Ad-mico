/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Marcelo Augusto
 */
//@NamedQueries({
//    @NamedQuery(name = "busca.aula.pordiaehorario" , 
//            query = "SELECT al from Aula al JOIN al.horario WHERE al.horario.descricao = :descricao AND al.horario.dia = :dia AND exists (select d from al.local d where d.descricao = :descricaoLocal)")
//})
@Entity
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Horario horario;
    @OneToMany(fetch = FetchType.EAGER)
    private List<LocalEntity> local;
    
    public Aula() {
        this.local = new ArrayList<>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public List<LocalEntity> getLocal() {
        return local;
    }

    public void setLocal(List<LocalEntity> local) {
        this.local = local;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Aula other = (Aula) obj;
        return this.id == other.id;
    }
    
    

}
