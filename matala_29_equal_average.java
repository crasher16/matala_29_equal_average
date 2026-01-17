package ex1;
import unit4.collectionsLib.Node;

public class matala_29_equal_average {

    // Exercise 29: Equal Above / Below Average
    // Input: head of linked list of real numbers
	// By: Idan Dror
    
    public static boolean equalAboveBelowAverage(Node<Double> h) {

        // Empty list
        if (h == null)
            return true;

        Node<Double> current = h;
        double sum = 0;
        int count = 0;

        // First scan: calculate sum and count
        while (current != null) {
            sum += current.getValue();
            count++;
            current = current.getNext();
        }

        double avg = sum / count;

        int above = 0;
        int below = 0;
        current = h;

        // Second scan: count above and below average
        while (current != null) {
            if (current.getValue() > avg)
                above++;
            else if (current.getValue() < avg)
                below++;

            current = current.getNext();
        }

        return above == below;
    }

    // ---------- helper methods (same style as example) ----------

    public static void printList(Node<Double> h) {
        Node<Double> tmp = h;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + " ");

        System.out.println();
    }

    public static Node<Double> createList(double[] arr) {
        Node<Double> head = null;
        Node<Double> tmp = null;

        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new Node<Double>(arr[i]);
                tmp = head;
            } else {
                tmp.setNext(new Node<Double>(arr[i]));
                tmp = tmp.getNext();
            }
        }
        return head;
    }

    // -------------------- main tests --------------------

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Exercise 29: Equal Above / Below Avg");
        System.out.println("====================================");
        System.out.println();

        // Test 1
        System.out.println("Test 1: [1.0, 2.0, 3.0, 4.0]");
        Node<Double> h1 = createList(new double[]{1.0, 2.0, 3.0, 4.0});
        printList(h1);
        System.out.println("Result: " + equalAboveBelowAverage(h1));
        System.out.println();

        // Test 2
        System.out.println("Test 2: [1.0, 2.0, 3.0]");
        Node<Double> h2 = createList(new double[]{1.0, 2.0, 3.0});
        printList(h2);
        System.out.println("Result: " + equalAboveBelowAverage(h2));
        System.out.println();

        // Test 3
        System.out.println("Test 3: Empty list");
        Node<Double> h3 = null;
        printList(h3);
        System.out.println("Result: " + equalAboveBelowAverage(h3));
    }
}
