class MaxInBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }


    int findMax(Node node) {
        if (node == null) return Integer.MIN_VALUE;

        int rootVal = node.data;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        return Math.max(rootVal, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        MaxInBinaryTree tree = new MaxInBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Maximum value in the tree: " + tree.findMax(root));
    }
}
