import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;


public class PublicTests {

    @Test
    public void testSomaIrmaos() {

        BST bst = new BST();
        assertEquals(0, bst.somaIrmaosRecurcive());
        bst.add(50);
        assertEquals(0, bst.somaIrmaosRecurcive());
        bst.add(20);
        assertEquals(0, bst.somaIrmaosRecurcive());
        bst.add(70);
        assertEquals(90, bst.somaIrmaosRecurcive());
        bst.add(95);
        assertEquals(90, bst.somaIrmaosRecurcive());
        bst.add(10);
        assertEquals(90, bst.somaIrmaosRecurcive());
        bst.add(60);
        assertEquals(245, bst.somaIrmaosRecurcive());
        bst.add(25);
        assertEquals(280, bst.somaIrmaosRecurcive());

        bst.add(1);
        assertEquals(280, bst.somaIrmaos());
        bst.add(27);
        assertEquals(280, bst.somaIrmaos());
        bst.add(65);
        assertEquals(280, bst.somaIrmaos());
        bst.add(93);
        assertEquals(280, bst.somaIrmaos());
        bst.add(92);
        assertEquals(280, bst.somaIrmaos());
        bst.add(26);
        assertEquals(280, bst.somaIrmaos());

        bst.add(11);
        assertEquals(292, bst.somaIrmaos());

        bst.add(29);
        assertEquals(347, bst.somaIrmaos());

        // testes do exemplo 1
        bst = new BST();
        bst.add(92);
        bst.add(75);
        bst.add(96);
        bst.add(24);
        bst.add(85);
        bst.add(97);
        bst.add(21);
        bst.add(43);
        bst.add(83);
        bst.add(14);
        assertEquals(344, bst.somaIrmaos());


        // testes do exemplo 2
        bst = new BST();
        bst.add(41);
        bst.add(20);
        bst.add(65);
        bst.add(11);
        bst.add(29);
        bst.add(50);
        bst.add(91);
        bst.add(32);
        bst.add(72);
        bst.add(99);
        assertEquals(437, bst.somaIrmaos());
    }
    @Test
    public void testNivel0_ApenasRaiz() {
        BST tree = new BST();
        tree.add(10);  // Inserir apenas a raiz
        String resultado = tree.printNivel(0);  // Nível 0 deve retornar "10"
        assertEquals("10", resultado, "Deve retornar '10' para o nível 0.");
    }

    @Test
    public void testNivel1_ArvoreComVariosNiveis() {
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(3);
        tree.add(7);
        // No nível 1, esperamos "5 20"
        String resultado = tree.printNivel(1);
        assertEquals("5 20", resultado, "Deve retornar '5 20' para o nível 1.");
    }

    @Test
    public void testNivel2_ArvoreComMaisDeDoisNiveis() {
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(3);
        tree.add(7);
        // No nível 2, esperamos "3 7"
        String resultado = tree.printNivel(2);
        assertEquals("3 7", resultado, "Deve retornar '3 7' para o nível 2.");
    }

    @Test
    public void testNivelNaoExistente() {
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        // Nível 3 não existe, então deve retornar ""
        String resultado = tree.printNivel(3);
        assertEquals("", resultado, "Deve retornar uma string vazia para um nível inexistente.");
    }

    @Test
    public void testNivelComArvoreBalanceada() {
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(25);
        tree.add(35);

        // No nível 1, esperamos "5 20"
        String resultadoNivel1 = tree.printNivel(1);
        assertEquals("5 20", resultadoNivel1, "Deve retornar '5 20' para o nível 1.");

        // No nível 2, esperamos "15 30"
        String resultadoNivel2 = tree.printNivel(2);
        assertEquals("15 30", resultadoNivel2, "Deve retornar '15 30' para o nível 2.");

        // No nível 3, esperamos "25 35"
        String resultadoNivel3 = tree.printNivel(3);
        assertEquals("25 35", resultadoNivel3, "Deve retornar '25 35' para o nível 3.");
    }

    @Test
    public void testArvoreComApenasUmFilho() {
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(3);

        // Nível 1: "5"
        String resultadoNivel1 = tree.printNivel(1);
        assertEquals("5", resultadoNivel1, "Deve retornar '5' para o nível 1.");

        // Nível 2: "3"
        String resultadoNivel2 = tree.printNivel(2);
        assertEquals("3", resultadoNivel2, "Deve retornar '3' para o nível 2.");
    }

    @Test
    public void testKmaior() {
        Heap queue = new Heap(10);
        queue.add(10);
        queue.add(5);
        queue.add(3);
        queue.add(2);
        queue.add(20);

        assertEquals(20, queue.Kmaior(1));
        assertEquals(10, queue.Kmaior(2));
        assertEquals(5, queue.Kmaior(3));
        assertEquals(3, queue.Kmaior(4));
        assertEquals(2, queue.Kmaior(5));



    }


}