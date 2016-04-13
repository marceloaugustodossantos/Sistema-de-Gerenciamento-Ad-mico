/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.ifpb.dac.ga.entidades.entidades.Aluno;
import edu.ifpb.dac.validator.Validador;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author joaomarcos
 */
public class AlunoTest {

    private static Validador<Aluno> validador;

    public AlunoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        validador = new Validador();
    }

    @Test
    public void validarEntidade() {
        Aluno aluno = new Aluno();
        aluno.setCpf("095.417.084-98");
        aluno.setEmail("joao@mail.com");
        aluno.setMatricula("1233452323");
        aluno.setNome("joao");
        aluno.setRg("1235353");
        aluno.setSenha("123");
        
        Assert.assertTrue(validador.ehValido(aluno));        
    }

}
