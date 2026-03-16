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

