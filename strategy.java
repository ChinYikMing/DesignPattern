interface Sorter {
    void sort();
}

class QuickSort implements Sorter {

    @Override
    public void sort() {
        System.out.println("This is quicksort!");
    }
}

class MergeSort implements Sorter {

    @Override
    public void sort() {
        System.out.println("This is mergesort!");
    }
}

class HeapSort implements Sorter {

    @Override
    public void sort() {
        System.out.println("This is heapsort!");
    }
}

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new QuickSort();

        sorter.sort();
    }
}
