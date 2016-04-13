/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ga.web.gerenciadores;

import edu.ifpb.dac.enums.Horarios;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import edu.ifpb.dac.ga.entidades.entidades.LocalPK;
import edu.ifpb.dac.service.HorarioService;
import edu.ifpb.dac.service.LocalService;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pris
 */
@ManagedBean(name = "gerenciadorLocal")
@SessionScoped
public class GerenciadorLocal {
    
    @EJB
    private LocalService localService;
    @EJB
    private HorarioService horarioService;
    List<Horario> horariosLocal;
    private List<Horario> horariosEmBranco;
    private LocalEntity localEntity;
    private LocalPK localpk;

    public GerenciadorLocal() {
        horariosEmBranco = listarHorariosEmBranco();
    }
    
    
    public List<LocalEntity> listarLaboratorios(){
        return localService.listarLaboratorios();
    }
    
    public List<LocalEntity> listarSalas(){
        return localService.listarSalas();
    }
    
    public String visualizarHorarioLaboratorio(long id, String tipo){
        localEntity = localService.buscar(new LocalPK(id, tipo));
        horariosLocal = listarHorarioDeLocal();
        return "horariolaboratorio.xhtml";
    }
    
    public String visualizarHorarioSala(long id, String tipo){
        localEntity = localService.buscar(new LocalPK(id, tipo));
        horariosLocal = listarHorarioDeLocal();
        return "horariosala.xhtml";
    }
    
    private boolean existeEsteHorarioParaLocal(String descricao, DayOfWeek dia) {
        for (Horario horario : horariosLocal) {
            if (horario.getDescricao().equals(descricao) && horario.getDia().equals(dia)) {
                return true;
            }
        }
        return false;
    }

    public String getHorarioDoLocal(String descricao, String dia) {
        switch (dia) {
            case "segunda":
                if (existeEsteHorarioParaLocal(descricao, DayOfWeek.MONDAY)) {
                    return horarioService.getDiscipTurmaProf(new LocalPK(localEntity.getId(),localEntity.getTipo()), descricao, DayOfWeek.MONDAY);
                }break;
            case "terca":
                if (existeEsteHorarioParaLocal(descricao, DayOfWeek.TUESDAY)) {
                    return horarioService.getDiscipTurmaProf(new LocalPK(localEntity.getId(),localEntity.getTipo()), descricao, DayOfWeek.TUESDAY);
                }break;
            case "quarta":
                if (existeEsteHorarioParaLocal(descricao, DayOfWeek.WEDNESDAY)) {
                    return horarioService.getDiscipTurmaProf(new LocalPK(localEntity.getId(),localEntity.getTipo()), descricao, DayOfWeek.WEDNESDAY);
                }break;
            case "quinta":
                if (existeEsteHorarioParaLocal(descricao, DayOfWeek.THURSDAY)) {
                    return horarioService.getDiscipTurmaProf(new LocalPK(localEntity.getId(),localEntity.getTipo()), descricao, DayOfWeek.THURSDAY);
                }break;
            case "sexta":
                if (existeEsteHorarioParaLocal(descricao, DayOfWeek.FRIDAY)) {
                    return horarioService.getDiscipTurmaProf(new LocalPK(localEntity.getId(),localEntity.getTipo()), descricao, DayOfWeek.FRIDAY);
                }break;
        }
        return "";
    }
    
    private List<Horario> listarHorarioDeLocal() {
        return horarioService.listarHorariosDeLocais(localEntity.getPk());
    }
    
    public List<Horario> listarHorariosEmBranco() {
        List<Horario> horariosEmBranco = new ArrayList();        
        for (Horarios h : Horarios.values()) {
            horariosEmBranco.add(h.horario);
        }
        return horariosEmBranco;
    }

    public LocalService getLocalService() {
        return localService;
    }

    public void setLocalService(LocalService localService) {
        this.localService = localService;
    }

    public HorarioService getHorarioService() {
        return horarioService;
    }

    public void setHorarioService(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    public List<Horario> getHorariosLocal() {
        return horariosLocal;
    }

    public void setHorariosLocal(List<Horario> horariosLocal) {
        this.horariosLocal = horariosLocal;
    }

    public List<Horario> getHorariosEmBranco() {
        return horariosEmBranco;
    }

    public void setHorariosEmBranco(List<Horario> horariosEmBranco) {
        this.horariosEmBranco = horariosEmBranco;
    }

    public LocalEntity getLocalEntity() {
        return localEntity;
    }

    public void setLocalEntity(LocalEntity localEntity) {
        this.localEntity = localEntity;
    }

    public LocalPK getLocalpk() {
        return localpk;
    }

    public void setLocalpk(LocalPK localpk) {
        this.localpk = localpk;
    }
    
}
