/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.CascadeType;

/**
 *
 * @author Marcelo Augusto
 */
@NamedQueries({
    @NamedQuery(name = "busca.turma.todas", query = "SELECT t from Turma t"),
    @NamedQuery(name = "busca.turma.curso.semestre", query = "SELECT t FROM Turma t WHERE t.disciplina.curso.id = :id AND t.disciplina.periodo = :semestre"),
    @NamedQuery(name = "busca.turma.porIdentificacao", query = "SELECT t from Turma t where t.identificacao = :identificacao")
})
@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String identificacao;
    @ManyToOne
    private Professor professor;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MaterialAula> materiais;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Atividade> atividades;
    @OneToMany(cascade =CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Duvida> duvidas;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Aluno> alunos;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Aula> aulas;
    @OneToOne
    private Disciplina disciplina;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoes;

    public long getId() {
        return id;
    }

    public Turma() {
        this.alunos = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.aulas = new ArrayList<>();
        this.duvidas = new ArrayList<>();
        this.materiais = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarMaterial(MaterialAula material) {
        this.materiais.add(material);
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<MaterialAula> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MaterialAula> materiais) {
        this.materiais = materiais;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Duvida> getDuvidas() {
        return duvidas;
    }

    public void setDuvidas(List<Duvida> duvidas) {
        this.duvidas = duvidas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void adicionarAula(Aula aula) {
        this.aulas.add(aula);
    }

    public void adicionarDuvida(Duvida duvida) {
        this.duvidas.add(duvida);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Turma other = (Turma) obj;
        return this.id == other.id;
    }

    public String toString() {
        return this.identificacao;
    }
}
