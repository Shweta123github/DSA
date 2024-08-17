package BinaryTrees;
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.
//reverse preorder kr
//first approch ---> recursion --->tc,sc--->o(n)
/*

public class FlattenBtToLinkesList {

    TreeNode prev = null;

    void flatten(TreeNode node) {
        if (node == null) {
            return;
        }
        flatten(node.right);
        flatten(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
    }
//both left/right =null goto 17 ,18
}*/


//second approch --->morris --->tc--->n  ,  sc--->1
