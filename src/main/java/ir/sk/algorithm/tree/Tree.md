in Binary Tree (BT):
 InOrder traversal is Left-Root-Right (LVR)
 PreOrder traversal is Root-Left-Right (VLR)
 PostOrder traversal is left-right-root (LRV)

In BST:
PreOrder traverse is sorted.
In a PreOrder sequence, the leftmost element is the root of the tree.
In BST each node has a minimum and maximum value


 Recursive algorithms are well-suited to problems on trees. Remember to include
 space implicitly allocated on the function call stack when doing space complexity
 analysis.
 Some tree problems have simple brute-force solutions that use 0(n) space solution,
 but subtler solutions that uses the existing tree nodes to reduce space complexity
 to 0(1).
 Consider left- and right-skewed trees when doing complexity analysis. Note that
 0(h) complexity, where h is the tree height, translates into 0(log n) complexity for
 balanced trees, but 0(n) complexity for skewed trees.
 If each node has a parent field, use it to make your code simpler, and to reduce
 time and space complexity.
 It's easy to make the mistake of treating a node that has a single