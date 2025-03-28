
import java.lang.reflect.Array;
import java.util.*;

public class BST {

    private Node root;
    private int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int [] elements) {
        for(int e:  elements){
            add(e);
        }
    }
        /**
         * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
         * @param element o valor a ser adicionado na árvore.
         */

    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {

            Node aux = this.root;

            while (aux != null) {

                if (element < aux.value) {
                    if (aux.left == null) {
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.right;
                }
            }
        }

    }


    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação recursiva.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param node raiz da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação iterativa.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node max() {
        if (isEmpty()) return null;

        Node node = this.root;
        while(node.right != null)
            node = node.right;

        return node;
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param node da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    // Vulgo somar todos os filhos de nós de grau 2
    public int somaIrmaos() {
        int soma = 0;
        if (isEmpty()) return 0;
        Deque<Node> prox = new LinkedList<Node>();
        prox.push(this.root);
        while(!prox.isEmpty()){
            Node aux = prox.removeFirst();
            if (aux.left != null && aux.right != null){
                soma += aux.left.value + aux.right.value;
                prox.push(aux.left);
                prox.push(aux.right);
            } else if (aux.left != null){
                prox.push(aux.left);
            } else if (aux.right != null){
                prox.push(aux.right);
            } // os dois são nulos, faz nada
        }

        return soma;
    }
    public String printNivel(int niv) {
        ArrayList<Integer> lista = new ArrayList<>();

        printNivel(this.root,0,niv,lista);

        String out= "";
        for(int e:lista) out += e + " ";

        return out.trim();

    }

    public void printNivel(Node node,int niv_atual, int niv, ArrayList saida) {
        if(node == null){
            return;
        }
        if (niv_atual == niv){
            saida.add(node.value);
            return;
        }

        printNivel(node.left, niv_atual+1, niv, saida);
        printNivel(node.right,niv_atual+1, niv,saida);
    }

    // Vulgo somar todos os filhos de nós de grau 2
    public int somaIrmaosRecurcive() {
        return somaIrmaosRecurcive(this.root);
    }

    public int somaIrmaosRecurcive(Node node) {
        if (node == null){
            return 0;
        }
        int soma = 0;
        if(node.left != null && node.right != null){
            soma += node.left.value + node.right.value;
        }
        return  soma + somaIrmaosRecurcive(node.left) + somaIrmaosRecurcive(node.right);
    }


    /**
     * Retorna o nó cujo valor é sucessor do valor passado como parâmetro. 
     * @param node O valor para o qual deseja-se identificar o sucessor.
     * @return O nó contendo o sucessor do valor passado como parâmetro. O método retorna null
     * caso não haja sucessor.
     */
    public Node sucessor(Node node) {
        if(node.right != null){
            return min(node.right);
        }
        return sucessorParent(node);
    }
    public Node sucessorParent(Node node) {
        if(node.parent == null){
            return null;
        }
        if(node.parent.value > node.value){
            return node.parent;
        }
        return sucessorParent(node.parent);
    }


    /**
     * Remove the node with the value.
     * @param value
     */
    public void remove(int value) {
        Node nodeToRemove = search(value);

        if (nodeToRemove == null){
            return;
        }
        remove(nodeToRemove);
    }

    /**
     * Remove node. Private method to control recursion.
     * @param toRemove
     */
    private void remove(Node toRemove) {

        // First case: node is leaf.
        if (toRemove.isLeaf()) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }

            // Second case: node has only left child or only right child
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root)  {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }

            // Third case: node has two children
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }

    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {

        Node aux = this.root;

        while (aux != null) {
            if (aux.value == element) return aux;
            if (element < aux.value) aux = aux.left;
            if (element > aux.value) aux = aux.right;
        }

        return null;

    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * recursiva clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node recursiveSearch(int element) {
        return recursiveSearch(this.root, element);
    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro na sub-árvore cuja raiz é node. Trata-se de um método auxiliar
     * para a busca recursiva.
     * @param node a raiz da árvore.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    private Node recursiveSearch(Node node, int element) {
        if (node == null) return null;
        if (element == node.value) return node;
        if (element < node.value) return recursiveSearch(node.left, element);
        else return recursiveSearch(node.right, element);
    }

    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    /**
     * Método para auxiliar a recursão. Retorna
     * a altura da árvore cuja raiz é passada como parâmetro.
     */
    private int height(Node node) {
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Percorre a árvore em pré-ordem.
     */
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Percorre a árvore em-ordem.
     */
    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }

    }

    /**
     * Percorre a árvore em pos-ordem.
     */
    public void posOrder() {
        posOrder(this.root);
    }

    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.value);
        }

    }

    /**
     * Percorre a árvore em largura. 
     * @return Uma lista com a os elementos percorridos em largura.
     */
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();

        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();

                list.add(current.value);

                if(current.left != null)
                    queue.addLast(current.left);
                if(current.right != null)
                    queue.addLast(current.right);
            }
        }
        return list;
    }

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

}


class Node {

    int value;
    Node left;
    Node right;
    Node parent;
    int nivel;

    Node(int v) {
        this.value = v;
    }

    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }

    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

}