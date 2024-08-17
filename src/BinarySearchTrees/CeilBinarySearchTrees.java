//left<node<right
//entire left and right sub tree should be a BST
//ideally duplicates not allowed
//if duplicates are there --->left<=node<right
//but why BST? --->as in BT if we want to search elemnt it take tc-->o(n) but in BST it take tc-->log base to 2 n


/*
import javax.swing.tree.TreeNode;

//ceil --->lowest value >= key
public class CeilBinarySearchTrees{

    public static int  findceil(TreeNode<Integer> root, int key ) {
        int ceil=-1;
        while(root!=null){
            if(root.data ==key){
                ceil=root.data;
                return ceil;
            }
            if(key>root.data){
                root=root.right;
            }
            else{
            //update ceil and go left
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;

    }
    }
*/
