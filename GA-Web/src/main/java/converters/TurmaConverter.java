/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import edu.ifpb.dac.ga.entidades.entidades.Turma;
import edu.ifpb.dac.service.TurmaService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.ejb.EJB;
import java.util.Map;

/**
 *
 * @author Marcelo Augusto
 */
@FacesConverter(value = "turmaConverter", forClass = Turma.class)
public class TurmaConverter implements Converter {

    @EJB
    private TurmaService turmaService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Turma turma = turmaService.buscarTurmaPorIdentificacao(value);
            return turma;
        } catch (Exception e) {
        }        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
