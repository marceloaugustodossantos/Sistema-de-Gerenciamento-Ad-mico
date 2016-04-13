/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;

import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import java.time.DayOfWeek;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface LocalService extends GenericService<LocalEntity> {
    public List<LocalEntity> listarTodosOsLocais();
    public List<LocalEntity> listarLaboratorios();
    public List<LocalEntity> listarSalas();
    public List<LocalEntity> listarLocaisAulaTurmaNoDia(long idTurma, DayOfWeek dia, String descricaHorario);

}
