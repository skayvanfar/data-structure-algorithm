package ir.sk.algorithm.tree;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * The lowest common ancestor (LCA) is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).
 * <p>
 * Created by sad.kayvanfar on 9/19/2020.
 */
public class LowestCommonAncestor {

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    @TimeComplexity("O(h)  where h is the height of the tree")
    public static TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
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

    /**
     * The lowest common ancestor (LCA) By using Parent For binary tree (BT)
     * like intersection of two linklist (findIntersection)
     *
     * @param p
     * @param q
     * @return
     * @see ir.sk.algorithm.linklist.LinkIntersection#findIntersectionByNodeCounts(SinglyLink, SinglyLink)
     */
    @TimeComplexity("0(d) time, where d is the depth of the deeper node")
    @SpaceComplexity("O(1)")
    public static TreeNode lCAByParentForBT(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // get difference in depths
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta)); // move deeper node up

        /* Find where paths intersect. */
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private static TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    private static int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }


    static int value;


    /**
     * The lowest common ancestor (LCA)
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    // TODO: 9/1/2021 not work when two values are on the same branch
    public static boolean lCAForBT(TreeNode node, int num1, int num2) {
        if (node == null)
            return false;
        if (node.value == num1 || node.value == num2)
            return true;

        boolean left = lCAForBT(node.left, num1, num2);
        boolean right = lCAForBT(node.right, num1, num2);

        if (left && right)
            value = node.value;

        if (left || right)
            return true;
        else
            return false;
    }

    /**
     * Alternatively, you could follow a chain in which p and q are on the same side. That is, if p and q are both on
     * the left of the node, branch left to look for the common ancestor. If they are both on the right, branch right
     * to look for the common ancestor. When p and q are no longer on the same side, you must have found the
     * first common ancestor.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static TreeNode lCAForBTBySameSide(TreeNode root, TreeNode p, TreeNode q) {
        /* Error check - one node is not in the tree. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    private static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean plsOnleft = covers(root.left, p);
        boolean qlsOnLeft = covers(root.left, q);
        if (plsOnleft != qlsOnLeft) {//Nodes are on different side
            return root;
        }
        TreeNode childSide = plsOnleft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    private static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
