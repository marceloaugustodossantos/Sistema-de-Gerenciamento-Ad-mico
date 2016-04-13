package edu.ifpb.dac.ga.web.gerenciadores;

import edu.ifpb.dac.ga.entidades.entidades.Curso;
import edu.ifpb.dac.ga.entidades.entidades.Horario;
import edu.ifpb.dac.ga.entidades.entidades.LocalEntity;
import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.CursoService;
import edu.ifpb.dac.service.LocalService;
import edu.ifpb.dac.service.TurmaService;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author joaomarcos
 */
@Named("GerenciadorCurso")
@SessionScoped
public class GerenciadorCurso implements Serializable {

    @EJB
    private CursoService cursoService;
    @EJB
    private LocalService localService;
    @EJB
    private TurmaService turmaService;
    private Curso cursoSelecionado;
    private int totalSemestres;
    private int semestre;

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }

    public int getTotalSemestres() {
        return totalSemestres;
    }

    public void setTotalSemestres(int totalSemestres) {
        this.totalSemestres = totalSemestres;
    }

    public int getSemestre() {
        return semestre;
    }

    public String setSemestre(int semestre) {
        this.semestre = semestre;
        return null;
    }

    public List<Curso> listarTodosOsCursos() {
        List<Curso> cursos = cursoService.listarTodosOsCursos();
        return cursos;
    }

    public String exibirHorarioCurso(Curso curso) {
        this.cursoSelecionado = curso;
        this.totalSemestres = curso.getPeriodos();
        this.semestre = 1;
        return "horarioCurso.xhtml";
    }

    public String getAula(String dia, Horario horario) {
        String data = "";
        int count = 0;
        List<Turma> turmas = turmaService.listarTurmasPorCurso(cursoSelecionado.getId(), semestre);
        for (Turma turma : turmas) {
            List<LocalEntity> locais = localService.listarLocaisAulaTurmaNoDia(turma.getId(), parseDay(dia), horario.getDescricao());
            for (LocalEntity l : locais) {                
                if (count == 0) {
                    data += turma.getDisciplina().getAbreviacao();
                    count++;
                }
                data += " (" + l.getAbreviacao() + ")";
            }
            count = 0;
            break;
        }
        return data.isEmpty() ? "" : data;
    }

    public DayOfWeek parseDay(String dia) {
        DayOfWeek day = DayOfWeek.MONDAY;
        switch (dia) {
            case "seg":
                day = DayOfWeek.MONDAY;
                break;
            case "ter":
                day = DayOfWeek.TUESDAY;
                break;
            case "qua":
                day = DayOfWeek.WEDNESDAY;
                break;
            case "qui":
                day = DayOfWeek.THURSDAY;
                break;
            case "sex":
                day = DayOfWeek.FRIDAY;
                break;
        }
        return day;
    }

}
