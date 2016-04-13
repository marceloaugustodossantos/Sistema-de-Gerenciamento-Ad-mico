/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.web.gerenciadores;

import edu.ifpb.dac.enums.Horarios;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.Professor;
import edu.ifpb.dac.service.HorarioService;
import edu.ifpb.dac.service.ProfessorService;
import java.io.Serializable;
import java.time.DayOfWeek;
import javax.ejb.EJB;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Marcelo Augusto
 */
@Named("gerenciadorProfessor")
@SessionScoped
public class GerenciadorProfessor implements Serializable {

    @EJB
    private ProfessorService professorService;
    @EJB
    private HorarioService horarioService;
    private List<Horario> horariosEmbranco;
    private Professor professor;
    List<Horario> horariosProfessor;

    public GerenciadorProfessor() {
        horariosEmbranco = listarHorariosEmBranco();
    }

    public List<Professor> listarProfessores() {
        return professorService.listarTodosProfessores();
    }

    public String visualizarHorario(long id) {
        professor = professorService.buscar(id);
        horariosProfessor = listarHorarioDeProfessor();
        return "horarioprofessor.xhtml";
    }

    private boolean existeEsteHorarioParaProfessor(String descricao, DayOfWeek dia) {
        for (Horario horario : horariosProfessor) {
            if (horario.getDescricao().equals(descricao) && horario.getDia().equals(dia)) {
                return true;
            }
        }
        return false;
    }

    public String getHorarioDoProfessor(String descricao, String dia) {
        
        switch (dia) {
            case "segunda":
                if (existeEsteHorarioParaProfessor(descricao, DayOfWeek.MONDAY)) {
                    return horarioService.getDisciplinaELocalDeAula(professor.getId(), descricao, DayOfWeek.MONDAY);
                }break;
            case "terca":
                if (existeEsteHorarioParaProfessor(descricao, DayOfWeek.TUESDAY)) {
                    return horarioService.getDisciplinaELocalDeAula(professor.getId(), descricao, DayOfWeek.TUESDAY);
                }break;
            case "quarta":
                if (existeEsteHorarioParaProfessor(descricao, DayOfWeek.WEDNESDAY)) {
                    return horarioService.getDisciplinaELocalDeAula(professor.getId(), descricao, DayOfWeek.WEDNESDAY);
                }break;
            case "quinta":
                if (existeEsteHorarioParaProfessor(descricao, DayOfWeek.THURSDAY)) {
                    return horarioService.getDisciplinaELocalDeAula(professor.getId(), descricao, DayOfWeek.THURSDAY);
                }break;
            case "sexta":
                if (existeEsteHorarioParaProfessor(descricao, DayOfWeek.FRIDAY)) {
                    return horarioService.getDisciplinaELocalDeAula(professor.getId(), descricao, DayOfWeek.FRIDAY);
                }break;
        }
        return "";
    }

    public List<Horario> listarHorarioDeProfessor() {
        return horarioService.listarHorariosDeProfessor(professor.getId());
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Horario> getHorariosEmbranco() {
        return horariosEmbranco;
    }

    public void setHorariosEmbranco(List<Horario> horariosEmbranco) {
        this.horariosEmbranco = horariosEmbranco;
    }

    private List<Horario> listarHorariosEmBranco() {
        List<Horario> horariosEmBranco = new ArrayList();        
        for (Horarios h : Horarios.values()) {
            horariosEmBranco.add(h.horario);
        }
        return horariosEmBranco;
    }

}
