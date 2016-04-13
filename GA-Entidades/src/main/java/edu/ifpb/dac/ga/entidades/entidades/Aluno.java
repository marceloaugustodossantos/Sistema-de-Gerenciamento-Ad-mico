/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.entidades.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Column;

@NamedQueries({
    @NamedQuery(name = "busca.aluno.email", query = "SELECT a from Aluno a WHERE a.email LIKE :email"),
    @NamedQuery(name = "busca.aluno.nome", query = "SELECT a from Aluno a WHERE a.nome LIKE :nome"),
    @NamedQuery(name = "busca.aluno.todos", query = "SELECT a from Aluno a"),
    @NamedQuery(name = "busca.aluno.porMatricula", query = "SELECT A from Aluno a WHERE a.matricula = :matricula")
})
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String nome;
    @CPF
    private String cpf;
    @Pattern(regexp = "[0-9]*")
    private String rg;
    @Pattern(regexp = "[0-9]*")
    @Column(unique = true)
    private String matricula;
    @Email
    private String email;
    @NotBlank
    private String senha;
    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.EAGER)
    private List<Turma> turmas;

    public Aluno() {
        this.turmas = new ArrayList<>();
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){  
        return this.nome + " mat: " + this.matricula; 
    }

}
