/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.web.gerenciadores;

import edu.ifpb.dac.enums.Horarios;
import edu.ifpb.dac.service.AlunoService;
import edu.ifpb.dac.service.HorarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.ifpb.dac.ga.entidades.entidades.Aluno;
import edu.ifpb.dac.ga.entidades.entidades.Comentario;
import edu.ifpb.dac.ga.entidades.entidades.Duvida;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.TurmaService;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.component.UIViewRoot;

/**
 *
 * @author Pris
 */
@Named("GerenciadorAluno")
@SessionScoped
public class GerenciadorAluno implements Serializable {

    @EJB
    private AlunoService alunoService;
    @EJB
    private HorarioService horarioService;
    @EJB
    private TurmaService turmaService;
    private Aluno aluno;
    List<Horario> horariosAluno;
    List<Horario> horariosEmBranco;
    private String matricula;
    private String senha;
    private Turma turmaDuvida;
    private String descDuvida;

    public String login() {
        aluno = alunoService.login(matricula, senha);
        if (aluno != null) {
            return "alunoindex.xhtml";
        }
        alertStatus("Matrícula ou senha inválidos!");
        return null;
    }

    public String logout() {
        aluno = null;
        matricula = null;
        senha = null;
        return "index.xhtml";
    }

    public String enviarDuvida() {
        Duvida duvida = new Duvida();
        duvida.setDescricao(descDuvida);
        duvida.setAluno(aluno);
        turmaDuvida.adicionarDuvida(duvida);
        if (turmaService.atualizar(turmaDuvida)) {
            alertStatus("Dúvida envida!");
            descDuvida = "";
        } else {
            alertStatus("Erro ao enviar dúvida!");
        }
        return null;
    }

    public List<Duvida> listarDuvidasDaTurma() {
        List<Turma> turmas = aluno.getTurmas();
        List<Duvida> duvidas = new ArrayList();
        for (Turma turma : turmas) {
            for (Duvida duvida : turma.getDuvidas()) {
                duvidas.add(duvida);
            }
        }
        return duvidas;
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

    public String visualizarHorario() {
        aluno = alunoService.buscar(aluno.getId());
        horariosAluno = listarHorarioAluno();
        return "horarioaluno.xhtml";
    }

    public GerenciadorAluno() {
        horariosEmBranco = listarHorariosEmBranco();
    }

    public List<Aluno> listarAlunos() {
        return alunoService.listarTodosAlunos();
    }

    public List<Horario> listarHorarioAluno() {
        return horarioService.listarHorariosDeAluno(aluno.getId());
    }

    public String visualizarHorarios(long id) {
        aluno = alunoService.buscar(id);
        horariosAluno = listarHorarioAluno();
        return "horarioaluno.xhtml";
    }

    private boolean existeEsteHorarioParaAluno(String descricao, DayOfWeek dia) {
        for (Horario horario : horariosAluno) {
            if (horario.getDescricao().equals(descricao) && horario.getDia().equals(dia)) {
                return true;
            }
        }
        return false;
    }

    public String getHorarioDoAluno(String descricao, String dia) {

        switch (dia) {
            case "segunda":
                if (existeEsteHorarioParaAluno(descricao, DayOfWeek.MONDAY)) {
                    return horarioService.getDiscipELocalAluno(aluno.getId(), descricao, DayOfWeek.MONDAY);
                }
                break;
            case "terca":
                if (existeEsteHorarioParaAluno(descricao, DayOfWeek.TUESDAY)) {
                    return horarioService.getDiscipELocalAluno(aluno.getId(), descricao, DayOfWeek.TUESDAY);
                }
                break;
            case "quarta":
                if (existeEsteHorarioParaAluno(descricao, DayOfWeek.WEDNESDAY)) {
                    return horarioService.getDiscipELocalAluno(aluno.getId(), descricao, DayOfWeek.WEDNESDAY);
                }
                break;
            case "quinta":
                if (existeEsteHorarioParaAluno(descricao, DayOfWeek.THURSDAY)) {
                    return horarioService.getDiscipELocalAluno(aluno.getId(), descricao, DayOfWeek.THURSDAY);
                }
                break;
            case "sexta":
                if (existeEsteHorarioParaAluno(descricao, DayOfWeek.FRIDAY)) {
                    return horarioService.getDiscipELocalAluno(aluno.getId(), descricao, DayOfWeek.FRIDAY);
                }
                break;
        }
        return "";
    }

    private List<Horario> listarHorariosEmBranco() {
        List<Horario> horariosEmBranco = new ArrayList();
        for (Horarios h : Horarios.values()) {
            horariosEmBranco.add(h.horario);
        }
        return horariosEmBranco;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public HorarioService getHorarioService() {
        return horarioService;
    }

    public void setHorarioService(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Horario> getHorariosAluno() {
        return horariosAluno;
    }

    public void setHorariosAluno(List<Horario> horariosAluno) {
        this.horariosAluno = horariosAluno;
    }

    public List<Horario> getHorariosEmBranco() {
        return horariosEmBranco;
    }

    public void setHorariosEmBranco(List<Horario> horariosEmBranco) {
        this.horariosEmBranco = horariosEmBranco;
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

    public Turma getTurmaDuvida() {
        return turmaDuvida;
    }

    public void setTurmaDuvida(Turma turmaDuvida) {
        this.turmaDuvida = turmaDuvida;
    }

    public String getDescDuvida() {
        return descDuvida;
    }

    public void setDescDuvida(String descDuvida) {
        this.descDuvida = descDuvida;
    }

    private void alertStatus(String m) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, m, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
