package edu.ifpb.dac.service.locator;

import edu.ifpb.dac.service.AdministradorService;
import edu.ifpb.dac.service.AlunoService;
import edu.ifpb.dac.service.AtividadeService;
import edu.ifpb.dac.service.AulaReposicaoService;
import edu.ifpb.dac.service.AulaService;
import edu.ifpb.dac.service.ComentarioService;
import edu.ifpb.dac.service.CursoService;
import edu.ifpb.dac.service.DisciplinaService;
import edu.ifpb.dac.service.HorarioService;
import edu.ifpb.dac.service.LocalService;
import edu.ifpb.dac.service.MaterialAulaService;
import edu.ifpb.dac.service.ProfessorService;
import edu.ifpb.dac.service.TurmaService;

/**
 *
 * @author joaomarcos
 */
public class ServicesFacade {

    private static final String LOCALSERVICE = "java:global/GA-Web/LocalServiceImpl!edu.ifpb.dac.service.LocalService";
    private static final String CURSOSERVICE = "java:global/GA-Web/CursoServiceImpl!edu.ifpb.dac.service.CursoService";
    private static final String DISCIPLINASERVICE = "java:global/GA-Web/DisciplinaServiceImpl!edu.ifpb.dac.service.DisciplinaService";
    private static final String AULAREPOSICAOSERVICE = "java:global/GA-Web/AulaReposicaoServiceImpl!edu.ifpb.dac.service.AulaReposicaoService";
    private static final String ATIVIDADESERVICE = "java:global/GA-Web/AtividadeServiceImpl!edu.ifpb.dac.service.AtividadeService";
    private static final String MATERIALAULASERVICE = "java:global/GA-Web/MaterialAulaServiceImpl!edu.ifpb.dac.service.MaterialAulaService";
    private static final String PROFESSORSERVICE = "java:global/GA-Web/ProfessorServiceImpl!edu.ifpb.dac.service.ProfessorService";
    private static final String AULASERVICE = "java:global/GA-Web/AulaServiceImpl!edu.ifpb.dac.service.AulaService";
    private static final String ADMINISTRADORSERVICE = "java:global/GA-Web/AdministradorServiceImpl!edu.ifpb.dac.service.AdministradorService";
    private static final String HORARIOSERVICE = "java:global/GA-Web/HorarioServiceImpl!edu.ifpb.dac.service.HorarioService";
    private static final String COMENTARIOSERVICE = "java:global/GA-Web/ComentarioServiceImpl!edu.ifpb.dac.service.ComentarioService";
    private static final String TURMASERVICE = "java:global/GA-Web/TurmaServiceImpl!edu.ifpb.dac.service.TurmaService";
    private static final String ALUNOSERVICE = "java:global/GA-Web/AlunoServiceImpl!edu.ifpb.dac.service.AlunoService";

    public static LocalService getLocalService() {
        return new ServiceLocator().lookup(LOCALSERVICE, LocalService.class);
    }

    public static CursoService getCursoService() {
        return new ServiceLocator().lookup(CURSOSERVICE, CursoService.class);
    }

    public static DisciplinaService getDisciplinaService() {
        return new ServiceLocator().lookup(DISCIPLINASERVICE, DisciplinaService.class);
    }

    public static AulaReposicaoService getAulaReposicaoService() {
        return new ServiceLocator().lookup(AULAREPOSICAOSERVICE, AulaReposicaoService.class);
    }

    public static AtividadeService getAtividadeService() {
        return new ServiceLocator().lookup(ATIVIDADESERVICE, AtividadeService.class);
    }

    public static MaterialAulaService getMaterialAulaService() {
        return new ServiceLocator().lookup(MATERIALAULASERVICE, MaterialAulaService.class);
    }

    public static ProfessorService getProfessorService() {
        return new ServiceLocator().lookup(PROFESSORSERVICE, ProfessorService.class);
    }

    public static AulaService getAulaService() {
        return new ServiceLocator().lookup(AULASERVICE, AulaService.class);
    }

    public static AdministradorService getAdministradorService() {
        return new ServiceLocator().lookup(ADMINISTRADORSERVICE, AdministradorService.class);
    }

    public static HorarioService getHorarioService() {
        return new ServiceLocator().lookup(HORARIOSERVICE, HorarioService.class);
    }

    public static ComentarioService getComentarioService() {
        return new ServiceLocator().lookup(COMENTARIOSERVICE, ComentarioService.class);
    }

    public static TurmaService getTurmaService() {
        return new ServiceLocator().lookup(TURMASERVICE, TurmaService.class);
    }

    public static AlunoService getAlunoService() {
        return new ServiceLocator().lookup(ALUNOSERVICE, AlunoService.class);
    }

}
