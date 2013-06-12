package synopsys;

/*
 * http://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
 * http://betamoore.wordpress.com/2012/04/15/binary-heap-in-java/
 */
public class HeapTest<T extends Comparable<T>> {

    private T[] heap;
    private int numOfEl;

    @SuppressWarnings("unchecked")
    public HeapTest(int size) {

	heap = (T[]) new Comparable[size];
    }

    public HeapTest(T[] arr) {

	heap = arr;
	numOfEl = heap.length - 1;

	build();
    }

    private int getParentIndex(int n) {

	return n % 2 == 0 ? n / 2 - 1 : n / 2;
    }

    public void build() {

	int parentIndex = getParentIndex(numOfEl);
	while (parentIndex >= 0) {
	    moveDown(parentIndex);
	    --parentIndex;
	}
    }

    private void moveDown(int parentIndex) {

	T parentValue = heap[parentIndex];
	int childIndex = parentIndex * 2 + 1;

	while (childIndex <= numOfEl) {
	    if (childIndex + 1 <= numOfEl && heap[childIndex].compareTo(heap[childIndex + 1]) > 0) {
		childIndex = childIndex + 1;
	    }
	    if (parentValue.compareTo(heap[childIndex]) > 0) {
		heap[parentIndex] = heap[childIndex];
		parentIndex = childIndex;
		childIndex = parentIndex * 2 + 1;
	    } else {
		break;
	    }
	}
	heap[parentIndex] = parentValue;
    }

    public void insert(T e) {

	if (numOfEl == heap.length) {
	    return;
	}
	heap[numOfEl] = e;
	moveUp(numOfEl++);
    }

    private void moveUp(int index) {

	int parentIndex = getParentIndex(index);
	T elValue = heap[index];
	while (parentIndex >= 0) {
	    if (elValue.compareTo(heap[parentIndex]) < 0) {
		heap[index] = heap[parentIndex];
		index = parentIndex;
		parentIndex = getParentIndex(index);
	    } else {
		break;
	    }
	}

	heap[index] = elValue;
    }

    public String toString() {

	String out = "";
	for (int k = 0; k < heap.length; k++)
	    out += heap[k] + " ";
	return out;
    }

    public static void main(String[] args) {

	HeapTest<String> h = new HeapTest<String>(4);

	h.insert("p");
	h.insert("r");
	h.insert("i");
	h.insert("o");
	System.out.println(h);
	Integer[] a = { 4, 7, 7, 7, 5, 0, 2, 3, 5, 1 };
	System.out.println(new HeapTest<Integer>(a));
    }

}
