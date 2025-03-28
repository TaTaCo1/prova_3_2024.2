public class KthFinder {

    public int kesimo(int[] v, int k) {
        Heap heap = new Heap(v);
        if(k < 0 || k > v.length){
            return -1;
        }
        int element = -1;
        for (int i = 0 ; i < k; i++){
            element = heap.remove();
        }
        return element;
    }
}