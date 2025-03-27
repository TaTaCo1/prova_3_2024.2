import java.util.Arrays;

public class Heap {

    private int[] heap;
    private int tail;

    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public int[] getHeap() {
        return heap;
    }

    private void buildHeap() {
        if (isEmpty()) return;
        for (int i = parent(this.tail); i >= 0; i--){
            heapify(i);
        }
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) return;

        int indiceDoMaior = max_index(index, left(index), right(index));

        if (indiceDoMaior == index) return;

        else {
            swap(index, indiceDoMaior);
            heapify(indiceDoMaior);
        }
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
        return 2*i+1;
    }

    public int right(int i) {
        return (i+1)*2;
    }

    public int parent(int i) {
        return Math.floorDiv(i-1, 2);
    }

    public void add(int n) {
        if (tail >= (heap.length - 1))
            resize();

        this.tail += 1;
        this.heap[tail] = n;

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    public int Kmaior(int k_maior) {

        if(k_maior< 0 || k_maior - 1 > tail){
            return -1;
        }

        Heap aux = new Heap(heap.length);;
        for(int i = 0 ; i <= tail;i++){
            aux.add(heap[i]);
        }
        int element = -1;
        for(int i = 0 ; i < k_maior;i++){
            element = aux.remove();
        }

        return element;
    }


    public int remove() {
        if (isEmpty()) throw new RuntimeException("Empty");
        int element = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail -= 1;

        this.heapify(0);

        return element;
    }

    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            return index;

        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            }

            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];

        this.heap = novoHeap;
    }

    public int size() {
        return this.tail + 1;
    }

    public String toString() {
        return Arrays.toString(this.heap);
    }

}