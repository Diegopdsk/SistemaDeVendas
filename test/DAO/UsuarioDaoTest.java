/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author suporteti
 */
public class UsuarioDaoTest {
    
    public UsuarioDaoTest() {
    }
    
    
    @Test
    public void testSalvar() throws Exception {
        System.out.println("Testando metodo salvar");
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        UsuarioDao instance = new UsuarioDao();
       
        usuario.setNome("di");
        
        instance.buscar(usuario);
               
        System.out.println("Fim de teste!");
        
    }
    
}
