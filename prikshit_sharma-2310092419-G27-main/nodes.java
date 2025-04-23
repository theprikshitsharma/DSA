class TreeAdvancedOperations {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int sumOfNodes(Node node) {
        if (node == null) return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    int countInternalNodes(Node node) {
        if (node == null || (node.left == null && node.right == null)) return 0;
        return 1 + countInternalNodes(node.left) + countInternalNodes(node.right);
    }

    int countNodesAtLevel(Node node, int level) {
        if (node == null) return 0;
        if (level == 1) return 1;
        return countNodesAtLevel(node.left, level - 1) + countNodesAtLevel(node.right, level - 1);
    }

    public static void main(String[] args) {
        TreeAdvancedOperations tree = new TreeAdvancedOperations();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

     
        System.out.println("Total number of nodes: " + tree.countNodes(root));
        System.out.println("Number of leaf nodes: " + tree.countLeafNodes(root));
        System.out.println("Height of the tree: " + tree.height(root));
        System.out.println("Sum of all nodes: " + tree.sumOfNodes(root));
        System.out.println("Number of internal nodes: " + tree.countInternalNodes(root));

        int k = 3;
        System.out.println("Number of nodes at level " + k + ": " + tree.countNodesAtLevel(root, k));
    }
}
