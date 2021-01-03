package ir.sk.algorithm.treeandgraph;

/**
 * Created by sad.kayvanfar on 9/19/2020.
 */
class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode parent;

    TreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Level order traversal using 'next' pointer
     */
    public void printLevelOrderByNextNode() {
        TreeNode nextLevelRoot = this;
        while(nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.value + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
