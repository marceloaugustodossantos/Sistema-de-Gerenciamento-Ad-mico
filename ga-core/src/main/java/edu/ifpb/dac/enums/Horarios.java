package edu.ifpb.dac.enums;

import edu.ifpb.dac.ga.entidades.entidades.Horario;
import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author joaomarcos
 */
public enum Horarios {

    M1(Time.valueOf(LocalTime.of(7, 0)), Time.valueOf(LocalTime.of(7, 50))),
    M2(Time.valueOf(LocalTime.of(7, 50)), Time.valueOf(LocalTime.of(8, 40))),
    M3(Time.valueOf(LocalTime.of(8, 40)), Time.valueOf(LocalTime.of(9, 30))),
    M4(Time.valueOf(LocalTime.of(9, 45)), Time.valueOf(LocalTime.of(10, 35))),
    M5(Time.valueOf(LocalTime.of(10, 35)), Time.valueOf(LocalTime.of(11, 25))),
    M6(Time.valueOf(LocalTime.of(11, 25)), Time.valueOf(LocalTime.of(12, 15))),
    T1(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(13, 50))),
    T2(Time.valueOf(LocalTime.of(13, 50)), Time.valueOf(LocalTime.of(14, 40))),
    T3(Time.valueOf(LocalTime.of(14, 40)), Time.valueOf(LocalTime.of(15, 30))),
    T4(Time.valueOf(LocalTime.of(15, 45)), Time.valueOf(LocalTime.of(16, 35))),
    T5(Time.valueOf(LocalTime.of(16, 35)), Time.valueOf(LocalTime.of(17, 25))),
    T6(Time.valueOf(LocalTime.of(17, 25)), Time.valueOf(LocalTime.of(16, 15))),
    N1(Time.valueOf(LocalTime.of(18, 50)), Time.valueOf(LocalTime.of(19, 40))),
    N2(Time.valueOf(LocalTime.of(19, 40)), Time.valueOf(LocalTime.of(20, 30))),
    N3(Time.valueOf(LocalTime.of(20, 40)), Time.valueOf(LocalTime.of(21, 30))),
    N4(Time.valueOf(LocalTime.of(21, 30)), Time.valueOf(LocalTime.of(22, 20))),
    N5(Time.valueOf(LocalTime.of(22, 20)), Time.valueOf(LocalTime.of(23, 10)));

    public Horario horario;

    private Horarios(Time inicio, Time fim) {
        this.horario = new Horario();
        this.horario.setDescricao(this.name());
        this.horario.setInicio(new Date(inicio.getTime()));
        this.horario.setFim(new Date(fim.getTime()));
    }

}
