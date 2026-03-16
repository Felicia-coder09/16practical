import java.util.Scanner;
import java.util.Arrays;

public class tryHeapsort {

    static String[] heap;
    static int size;

    
    // SWAP
    static void swap(int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

   
    // HEAPIFY
    static void heapify(int i) {

        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < size && heap[left].compareTo(heap[smallest]) < 0)
            smallest = left;

        if(right < size && heap[right].compareTo(heap[smallest]) < 0)
            smallest = right;

        if(smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

   
    // BUILD HEAP BOTTOM-UP
    
    static void buildBottomUp() {

        for(int i = size/2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    
    // INSERT (TOP-DOWN)
    
    static void insert(String word) {

        heap[size] = word;
        int i = size;
        size++;

        while(i > 0 && heap[(i-1)/2].compareTo(heap[i]) > 0) {

            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }

   
    // BUILD HEAP TOP-DOWN
    
    static void buildTopDown(String[] words) {

        size = 0;

        for(String word : words) {
            insert(word);
        }
    }

    
    // HEAP SORT
    static void heapSort() {

        int originalSize = size;

        for(int i = size-1; i > 0; i--) {

            swap(0, i);
            size--;

            heapify(0);
        }

        size = originalSize;
    }

    
    // PRINT ARRAY
    static void printArray(String[] arr) {

        for(String s : arr) {
            System.out.print(s + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = input.nextInt();
        input.nextLine();

        String[] words = new String[n];

        System.out.println("Enter the words:");

        for(int i = 0; i < n; i++) {
            words[i] = input.nextLine();
        }

       
        // Bottom-Up Heap
       

        heap = Arrays.copyOf(words, words.length);
        size = heap.length;

        long startBottom = System.nanoTime();

        buildBottomUp();
        heapSort();

        long endBottom = System.nanoTime();

        long bottomTime = endBottom - startBottom;

        System.out.println("\nSorted words (Bottom-Up):");
        printArray(heap);

        
        // Top-Down Heap
       
        heap = new String[words.length];

        long startTop = System.nanoTime();

        buildTopDown(words);
        heapSort();

        long endTop = System.nanoTime();

        long topTime = endTop - startTop;

        System.out.println("\nSorted words (Top-Down):");
        printArray(heap);

        
        // Timing Results
       
        System.out.println("\n--- Timing Results ---");
        System.out.println("Bottom-Up Heap Time: " + bottomTime + " ns");
        System.out.println("Top-Down Heap Time:  " + topTime + " ns");

        input.close();
    }
}
