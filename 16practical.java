//Heap Sort.
public class tryHeapsort {

  static String[] heap;
  static int size;

  //Swap
  static void swap(int i, int j) {
    String temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
  //Minimum heap
  static void Min_heap(int i) {

    int smallest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    if(left < size && heap[left].compareTo(heap[smallest]) < 0)
      smallest = left;

    if(right < size && heap[right].compareTo(heap[smallest]) < 0)
      smallest = right;
  }
}

//Build Heap Bottom-up
static void BottomUp() {

  for (int i = size/2 - 1; i >= 0; i--) {
    Min_heap(i);
   }
}

//Build Heap Top-Down
static void insert(String word) {

  size = 0;

for(String word : words) {
  insert(word);
    }
}

//Heap Sort
static void heapSort() {

  int originalSize = size;

  for (int i = size-1; i > 0; i--) {

    swap(0, i);
    size--;

    Min_heap(0);
  }

  size = originalSize;
}

static void printArray(String[] arr) {

  for(Sting s : arr) {
    System.out.print(s + " ");
  }
  System.out.println();
}

public static void main(String[] args) {

  Scanner input = new Scanner(System.in);

  System.out.print("Please enter number of words (Words must be not more than 20): ");

  for(int i = 0; i < n; i++) {
    words[i] = imput.nextLine();
  }

  heap = Array.copyOf(words, words.length);
  size = heap.length;

  long startBottom = System.nanoTime();

  BottomUp();
  heapSort();

  long endBottom = System.nanoTime();

  long bottomTime = endBottom - startBottom;

  System.out.println("\nSorted words (Bottom-Up): ");
  printArray(heap);

  heap = new String[words.length];

  long startTop = System.nanoTime();

  Top_down(words);
  heapSort();

  long endTop = System.nanoTime();

  long topTime = endTop - startTop;

  System.out.println("\nSorted words (Top-Down): ");
  printArray(heap);

  
}
