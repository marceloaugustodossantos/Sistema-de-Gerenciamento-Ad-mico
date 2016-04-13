/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.web.gerenciadores;

import edu.ifpb.dac.ga.entidades.entidades.Avaliacao;
import edu.ifpb.dac.ga.entidades.entidades.Comentario;
import edu.ifpb.dac.ga.entidades.entidades.Duvida;
import edu.ifpb.dac.ga.entidades.entidades.MaterialAula;
import edu.ifpb.dac.ga.entidades.entidades.Professor;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.ComentarioService;
import edu.ifpb.dac.service.DuvidaService;
import edu.ifpb.dac.service.ProfessorService;
import edu.ifpb.dac.service.TurmaService;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Augusto
 */
@Named("gerenciadorProfessorServicos")
@SessionScoped
public class GerenciadorProfessorServicosDeTurma implements Serializable {

    @EJB
    private ProfessorService professorService;
    @EJB
    private TurmaService turmaService;
    @EJB
    private DuvidaService duvidaService;
    private Professor professor;
    private String matricula;
    private String senha;
    private String comentarioDuvida;
    private Avaliacao avaliacao;
    private MaterialAula material;
    private Turma turma;

    @PostConstruct
    private void init() {
        this.avaliacao = new Avaliacao("", "");
        this.material = new MaterialAula("", "", null, "");
    }

    public String login() {
        try {
            professor = professorService.login(matricula, senha);
        } catch (Exception e) {
        }
        if (professor != null) {
            return "professorindex.xhtml";
        }
        alertStatus("Matrícula ou senha iválidos!");
        return null;
    }

    public String logout() {
        professor = null;
        matricula = null;
        senha = null;
        return "index.xhtml";
    }
    
    public List<Duvida> listarDuvidasDaTurma(){
        List<Turma> turmas = professor.getTurmas();
        List<Duvida> duvidas = new ArrayList();
        for (Turma turma : turmas) {
            for (Duvida duvida : turma.getDuvidas()) {
                duvidas.add(duvida);
            }
        }
        return duvidas;
    }
    public String comentarDuvida(long id){
        List<Turma> turmas = professor.getTurmas();
        List<Duvida> duvidas = new ArrayList();
        for (Turma turma : turmas) {
            for (Duvida duvida : turma.getDuvidas()) {
                if(duvida.getId() == id){
                    duvida.addComentario(comentarioDuvida);
                    duvidaService.atualizar(duvida);
                    turmaService.atualizar(turma);
                    comentarioDuvida = "";
                }
            }
        }
        return null;
    }

    public String comentariosDuvida(List<Comentario> comentarios) {
        String comentariosString = "";
        if (comentarios != null) {
            for (Comentario comentario : comentarios) {
                comentariosString += comentario.toString() + "\n";
            }
        }
        return comentariosString;
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public MaterialAula getMaterial() {
        return material;
    }

    public void setMaterial(MaterialAula material) {
        this.material = material;
    }

    public String cadastrarAvaliacao() {
        if (!avaliacao.getLink().isEmpty() && !avaliacao.getTitulo().isEmpty());
        {
            turma.addAvaliacao(avaliacao);
            turmaService.atualizar(turma);
            this.professor = professorService.buscar(professor.getId());
            this.avaliacao = new Avaliacao("", "");
        }
        return null;
    }
    
    public String cadastrarMaterial(){
        if(!material.getTitulo().isEmpty() && !material.getDescricao().isEmpty() && !material.getLink().isEmpty()){
            material.setData(Calendar.getInstance().getTime());
            turma.adicionarMaterial(material);
            turmaService.atualizar(turma);
            this.professor = professorService.buscar(professor.getId());
            this.material = new MaterialAula("", "", null, "");
        }
        return null;
    }

    private void alertStatus(String m) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, m, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getComentario() {
        return comentarioDuvida;
    }

    public void setComentario(String comentario) {
        this.comentarioDuvida = comentario;
    }
    
}
