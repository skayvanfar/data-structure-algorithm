# Frameworks: are used in paradigms and patterns
## method:
1. clarification: constraints
2. ideas: ( 1. brute force algorithm 2. ...)
     1. simplify the task
     2. Try a few examples
     3. think a data structure, patterns, paradigms
     4. Think related problems
3. implementation
    1. clean code
    2. review before running
4. test
    1. functional test
    2. edge tests
    3. no solution test
    3. load test
   

## Array traversal framework, typical linear iterative structure：
```
void traverse(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        // iteratively visit arr[i]
    }
}
```
## Linked list traversal framework has both iterative and recursive structure：
```
/* Basic node of the single linked list */
class Link {
    int val;
    Link next;
}

void traverse(Link head) {
    Link current = head;
    while (current != null) {
        // iteratively current.val
        current = current.next;
    }
}

void traverse(Link head) {
    // recusively head.val
    traverse(head.next)
}
```
Remember using previous, current, next pointers when is needed
## Binary tree traversal framework, typical nonlinear recursive traversal structure：
```
/* Basic node of the binary tree */
class TreeNode {
int val;
Node left, right;
}

// each node is a stack frame and in each frame. the state is different
void DFSTraverse(Node root) {
    // pre order traverse
    traverse(root.left)
    // middle order traverse
    traverse(root.right)
    // post order traverse
}
```

## the framework for almost all BT resolve
1. base case
2. recursive on left;
3. recursive on right;
4. join

##The binary tree framework can be extended to the n-tree traversal framework：
```
/* Basic node of the N-tree */
class Node {
    int val;
    Node[] children;
}

void DFSTraverse(Node root) {
    for (Node child : root.children)
        traverse(child)
}

void BFSTraverse(Node root) {
    Queue queue = new Queue();
    queue.add(root)
    while (!queue.isEmpty()) {
        Node node = queue.dequeue();
        // iteratively node.val
        queue.addAll(node.children);
    }
}
```

## There is a template for backtracking algorithms:
```
result = []
def backtrack(Path, selection List):
     if meet the End Condition:       
        result.add(Path)
        return

     for selection in selection List:
        select(Remove this Selection from the Selection List, Path.add(Selection))
        backtrack(Path, selection List)
        deselect (Path.remove(selection), Add the selection to the Selection List)
```


## template for Sliding Window Algorithm pattern:
### [window)
#### Static
```
int left = 0, right = k;
for (int i = 0; i < k; i++)
     currentSum += array[i];

while (right < s.size()) {
    window.add(s[right]);
    right++;
    window.remove(s[left]);
    left++;
}
```
#### Dynamic
```
int left = 0, right = 0;

while (right < s.size()) {
    window.add(s[right]);
    right++;

    while (valid) {
        window.remove(s[left]);
        left++;
    }
}
```

## template for recurtion by sample:
How many hairs does Monkey King have? Answer: One plus the rest.

How old are you this year? Answer: One year plus my age of last year, I was born in 1999.
```
int func(How old are you this year) {
    // simplest sub-problem, end condition
    if (this year equals 1999) return my age 0;
    // self-calling to decompose problem
    return func(How old are you last year) + 1;   
}
```
