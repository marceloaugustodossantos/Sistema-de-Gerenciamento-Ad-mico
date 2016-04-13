/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcelo Augusto
 */
@NamedQueries({

    @NamedQuery(name ="busca.horario.todos" , 
                query ="SELECT h from Horario h"),
    @NamedQuery(name ="horario.listar.porProfessor", 
                query ="SELECT A.horario from Turma T Join T.aulas A where T.professor.id = :id"),
    @NamedQuery(name ="horario.buscar.disciplinaelocal", 
                query ="select t.disciplina.abreviacao, l.abreviacao "
                        + "from Turma t join t.aulas a join a.local l "
                        + "where t.professor.id =:idProfessor and a.horario.descricao = :descHorario and a.horario.dia = :dia"),
    @NamedQuery(name ="horario.buscar.discipElocalAluno", 
                query ="select t.disciplina.abreviacao, l.abreviacao FROM Turma t JOIN t.aulas a JOIN a.local l JOIN t.alunos al where al.id =:idAluno and a.horario.descricao = :descHorario and a.horario.dia = :dia"),
    @NamedQuery(name = "horario.buscar.discipturmaprof",query = "SELECT t.identificacao, t.disciplina, t.professor FROM Turma t JOIN t.aulas a JOIN a.local l WHERE l.pk = :localPk AND a.horario.descricao = :descHorario AND a.horario.dia = :dia"),
    @NamedQuery(name = "horario.listar.porLocal", 
            query ="SELECT a.horario FROM Aula a JOIN a.local l WHERE l.pk = :localPk"),
    @NamedQuery(name = "horario.listar.aluno", query = "SELECT a.horario FROM Turma t JOIN t.aulas a JOIN t.alunos al WHERE al.id = :id")
})
@Entity
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Temporal(TemporalType.TIME)
    private Date fim;
    private DayOfWeek dia;

    public Horario() {
    }

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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Horario other = (Horario) obj;
        return this.id == other.id;
    }

    public String toString() {
        LocalTime ltInicio = LocalDateTime.ofInstant(this.inicio.toInstant(), ZoneId.systemDefault()).toLocalTime();
        LocalTime ltFim = LocalDateTime.ofInstant(this.fim.toInstant(), ZoneId.systemDefault()).toLocalTime();
        return this.descricao + " " + ltInicio + " - " + ltFim;
    }

}
