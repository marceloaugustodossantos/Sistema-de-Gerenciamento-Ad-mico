/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service.impl;

import edu.ifpb.dac.ga.entidades.dao.DAO;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalPK;
import edu.ifpb.dac.service.HorarioService;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author Marcelo Augusto
 */
@Stateless
public class HorarioServiceImpl implements HorarioService {

    @EJB
    DAO<Horario> daoHorario;
    @EJB
    DAO<Object[]> daoLocalDisciplina;
    @EJB
    DAO<Object[]> daoDiscipTurmaProf;

    @Override
    public List<Horario> listarTodosHorarios() {
        return daoHorario.consultaLista("busca.horario.todos", null);
    }

    @Override
    public boolean cadastrar(Horario obj) {
        return daoHorario.salvar(obj);
    }

    @Override
    public boolean atualizar(Horario obj) {
        return daoHorario.atualizar(obj);
    }

    @Override
    public boolean remover(Horario obj) {
        return daoHorario.excluir(obj);
    }

    @Override
    public Horario buscar(Object chave) {
        return daoHorario.buscar(chave, Horario.class);
    }

    @Override
    public List<Horario> listarHorariosDeProfessor(long id) {
        Map<String, Object> parametros = new HashMap();
        parametros.put("id", id);
        return daoHorario.consultaLista("horario.listar.porProfessor", parametros);
    }

    @Override
    public String getDisciplinaELocalDeAula(long idProfessor, String descHorario, DayOfWeek dia) {
        Map<String, Object> parametros = new HashMap();
        parametros.put("idProfessor", idProfessor);
        parametros.put("descHorario", descHorario);
        parametros.put("dia", dia);
        List<Object[]> resultado = daoLocalDisciplina.consultaLista("horario.buscar.disciplinaelocal", parametros);
        String horarioEDia = "";
        Object[] resultadoIndex0 = resultado.get(0);
        for (int i = 0; i < resultadoIndex0.length; i++) {
            horarioEDia += (i!=1)?resultadoIndex0[i]+" ":resultadoIndex0[i];
        }
        return horarioEDia;
    }

    @Override
    public String getDiscipTurmaProf(LocalPK localPk, String descHorario, DayOfWeek dia) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("localPk", localPk);
        parametros.put("descHorario", descHorario);
        parametros.put("dia", dia);
        List<Object[]> resultado = daoDiscipTurmaProf.consultaLista("horario.buscar.discipturmaprof", parametros);
        String horarioEDia = "";

        if (!resultado.isEmpty()) {
            Object[] resultadoIndex0 = resultado.get(0);
            for (int i = 0; i < resultadoIndex0.length; i++) {
                horarioEDia += (i != 2) ? resultadoIndex0[i] + " " : resultadoIndex0[i];
            }
        }

        return horarioEDia;
    }

    @Override
    public List<Horario> listarHorariosDeLocais(LocalPK localPk) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("localPk", localPk);
        return daoHorario.consultaLista("horario.listar.porLocal", parametros);
    }

    @Override
    public List<Horario> listarHorariosDeAluno(long id) {
        Map<String, Object> parametros= new HashMap();
        parametros.put("id", id);
        return daoHorario.consultaLista("horario.listar.aluno", parametros);
    }

    @Override
    public String getDiscipELocalAluno(long idAluno, String descHorario, DayOfWeek dia) {
        Map<String, Object> parametros = new HashMap();
        parametros.put("idAluno", idAluno);
        parametros.put("descHorario", descHorario);
        parametros.put("dia", dia);
        List<Object[]> resultado = daoLocalDisciplina.consultaLista("horario.buscar.discipElocalAluno", parametros);
        String horarioEDia = "";
        Object[] resultadoIndex0 = resultado.get(0);
        for (int i = 0; i < resultadoIndex0.length; i++) {
            horarioEDia += (i!=1)?resultadoIndex0[i]+" ":resultadoIndex0[i];
        }
        return horarioEDia;
    }
}
