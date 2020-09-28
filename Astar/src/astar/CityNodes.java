package astar;

import java.util.*;


public class CityNodes {
    
    public int INF = Integer.MAX_VALUE;
    
     class Node {

            public Node left,right;
            public String name;
            public int key;
            public int gn;
            public int hn;
            public int traincost;
            public int buscost;
            public Node(int item,String x,int a,int b,int c,int d){
                key = item;
                name = x;
                gn = a;
                hn = b;
                traincost = c;
                buscost= d;
            }

            
}
    class BinaryTree{
            Node root;
            BinaryTree(String name,int key,int gn, int hn,int traincost,int buscost){
                root = new Node(key,name,gn,hn,traincost,buscost);
            }
            BinaryTree(){
                root = null;
            }
            
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.root  = new Node(1,Budapest,0,230,0,0);
    }
        

}