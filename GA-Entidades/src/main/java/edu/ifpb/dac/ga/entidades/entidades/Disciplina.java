/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcelo Augusto
 */
@NamedQueries({
    @NamedQuery(name = "busca.periodo.listar", query = "SELECT DISTINCT p.periodo FROM Disciplina p"),
    @NamedQuery(name = "busca.disciplina.periodo", query = "SELECT d FROM Disciplina d WHERE d.periodo = :periodo"),
    @NamedQuery(name = "buscar.disciplinas.todas", query = "SELECT d FROM Disciplina d")
        
}
)
@Entity
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Curso curso;
    @NotBlank
    private String descricao;
    @NotBlank
    private String abreviacao;
    @Max(11)
    private int periodo;
    @Max(500)
    private int cargaHoraria;
    @Max(10)
    private int aulasSemana;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(int aulasSemana) {
        this.aulasSemana = aulasSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Disciplina other = (Disciplina) obj;
        return this.id == other.id;
    }
    
    public String toString(){
        return this.descricao;
    }

}
