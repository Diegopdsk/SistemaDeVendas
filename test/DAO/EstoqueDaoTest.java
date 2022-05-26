/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produto;
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
public class EstoqueDaoTest {
    
    public EstoqueDaoTest() {
    }
    
    
    @Test
    public void testBuscar() throws Exception {
        System.out.println("Testando metodo Buscar");
        Produto produto = new Produto();
        EstoqueDao instance = new EstoqueDao();
        produto.setDescricao("Lapizeira");
        List<Produto> produtos = instance.buscar(produto);
        
        for (int i = 0; i < produtos.size(); i++) {
            produto = produtos.get(i);
            System.out.println("Codigo: "+produto.getCodigo()+" Descrição: "+produto.getDescricao()+" Valor de Custo: "+produto.getValorCusto());
        }
        
        System.out.println("___________________________________________");
        System.out.println("Final de Teste");
    }
    
}
