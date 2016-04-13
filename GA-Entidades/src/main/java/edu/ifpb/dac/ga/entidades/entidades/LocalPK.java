package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author joaomarcos
 */
@Embeddable
public class LocalPK implements Serializable{
    
    private long id;
    private String tipo;

    public LocalPK() {
    }

    public LocalPK(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.tipo);
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
        final LocalPK other = (LocalPK) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
    
    

}
