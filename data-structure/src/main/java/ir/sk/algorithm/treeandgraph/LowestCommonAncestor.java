package ir.sk.algorithm.treeandgraph;

/**
 * The lowest common ancestor (LCA) is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).
 *
 * Created by sad.kayvanfar on 9/19/2020.
 */
public class LowestCommonAncestor {
    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null, then return null
        if (root == null)
            return null;

        // If both the nodes given are same, then there is no LCA, return null
        if (p.value == q.value)
            return null;

        // If either of the nodes is the root node then root node is the LCA (Lowest Common Ancestor)
        if ((p.value == root.value) || (q.value == root.value))
            return root;

        // If one of the nodes is greater than the root and another is less than the root then root is the LCA
        if (((p.value < root.value) && (q.value > root.value)) || ((q.value < root.value) && (p.value > root.value)))
            return root;

        // If both nodes are smaller than the root, then recursively call the LCA function to compute steps 1 to 4 on the left node of the root.
        if (p.value < root.value && q.value < root.value)
            return lowestCommonAncestorForBST(root.left, p, q);
        // If both nodes are greater than the root, then recursively call the LCA function to compute steps 1 to 4 on the right node of the root.
        else
            return lowestCommonAncestorForBST(root.right, p, q);

    }
}
