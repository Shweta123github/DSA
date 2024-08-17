package BinarySearchTrees;

import javax.swing.tree.TreeNode;

//lowest value<= key
/*
public class Floor {
    public static int  findfloor (TreeNode<Integer> root, int key ) {
        int floor=-1;
        while(root!=null){
            if(root.data ==key){
                floor=root.data;
                return floor;
            }
            if(key>root.data){
                //update floor and go left
                floor=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return floor;
    }
}
*/