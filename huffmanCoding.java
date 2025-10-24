
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }

    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class huffmanCoding {

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            if (root.ch != '$')
                System.out.print(root.ch + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of unique characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.print("Enter characters: ");
        for (int i = 0; i < n; i++)
            chars[i] = sc.next().charAt(0);

        System.out.print("Enter frequencies: ");
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            pq.add(new Node(chars[i], freq[i]));

        // Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('$', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        Node root = pq.peek();
        System.out.print("\nInorder traversal of Huffman Tree: ");
        inorder(root);
        System.out.println();

        sc.close();
    }
}