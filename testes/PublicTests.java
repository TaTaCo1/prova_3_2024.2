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
    public void testKesimo() {
        KthFinder finder = new KthFinder();
        int[] v = new int[] {13, 9, 5, 2, 87, 4};

        assertEquals(87, finder.kesimo(v, 1));
        assertEquals(13, finder.kesimo(v, 2));
        assertEquals(9, finder.kesimo(v, 3));
        assertEquals(5, finder.kesimo(v, 4));
        assertEquals(4, finder.kesimo(v, 5));
        assertEquals(2, finder.kesimo(v, 6));

        assertEquals(5, finder.kesimo(new int[]{3, 2, 1, 5, 6, 4}, 2));

        int[] x = new int[] {37, 0, 45, 2, 87, 103};
        assertEquals(103, finder.kesimo(x, 1));
        assertEquals(87, finder.kesimo(x, 2));
        assertEquals(45, finder.kesimo(x, 3));
        assertEquals(37, finder.kesimo(x, 4));
        assertEquals(2, finder.kesimo(x, 5));
        assertEquals(0, finder.kesimo(x, 6));

        int[] y = new int[] {1, 2, 3, 4, 5, 6};
        assertEquals(6, finder.kesimo(y, 1));
        assertEquals(5, finder.kesimo(y, 2));
        assertEquals(4, finder.kesimo(y, 3));
        assertEquals(3, finder.kesimo(y, 4));
        assertEquals(2, finder.kesimo(y, 5));
        assertEquals(1, finder.kesimo(y, 6));
        assertEquals(-1, finder.kesimo(y, 7));

    }

    @Test
    public void printNivel() {
        BST bst = new BST();
        bst.add(new int[] {36,78,95,58, 61, 15, 1, 48, 23, 8, 68, 56, 37, 86, 14, 22, 44, 46, 17, 19});

        assertEquals("36", bst.printNivel(0));
        assertEquals("15 78", bst.printNivel(1));
        assertEquals("1 23 58 95", bst.printNivel(2));
        assertEquals("8 22 48 61 86", bst.printNivel(3));
        assertEquals("14 17 37 56 68", bst.printNivel(4));
        assertEquals("19 44", bst.printNivel(5));
        assertEquals("46", bst.printNivel(6));
    }

    @Test
    public void printNivel2() {
        BST bst = new BST();

        int [] list = new int[] {13, 20, 18, 25, 23};
        for(int e:list){
            bst.add(e);
        }
        assertEquals("13", bst.printNivel(0));
        assertEquals("20", bst.printNivel(1));
        assertEquals("18 25", bst.printNivel(2));
        assertEquals("23", bst.printNivel(3));

    }



}

