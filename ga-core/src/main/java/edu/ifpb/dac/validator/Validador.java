package edu.ifpb.dac.validator;

import edu.ifpb.dac.enums.Horarios;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author joaomarcos
 * @param <T> tipo da entidade a ser validada
 */
public class Validador<T> {

    private final Validator validador;
    private final List<String> listaDeErros;

    public Validador() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validador = factory.getValidator();
        listaDeErros = new ArrayList<>();
    }

    private void validarEntidade(T obj) {
        Set<ConstraintViolation<T>> violacoes = validador.validate(obj);
        if (violacoes.size() > 0) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<T> violacao : violacoes) {
                listaDeErros.add(violacao.getPropertyPath() + " " + violacao.getMessage());
                msg.append(violacao.getPropertyPath()).append(" ").append(violacao.getMessage()).append("\n");
            }            
        }
    }
    
    public List<String> getErros(){
        return this.listaDeErros;
    }
    
    public boolean ehValido(T obj){
        validarEntidade(obj);
        return this.listaDeErros.isEmpty();
    }    

}
