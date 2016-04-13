/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalPK;
import java.time.DayOfWeek;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface HorarioService extends GenericService<Horario>{
    public List<Horario> listarTodosHorarios();
    public List<Horario> listarHorariosDeProfessor(long id);
    public List<Horario> listarHorariosDeLocais(LocalPK localPk);
    public String getDisciplinaELocalDeAula(long idProfessor, String descHorario, DayOfWeek dia);
    public String getDiscipELocalAluno(long idAluno, String descHorario, DayOfWeek dia);
    public String getDiscipTurmaProf(LocalPK localPk, String descHorario,DayOfWeek dia);
    public List<Horario> listarHorariosDeAluno(long id);
}
