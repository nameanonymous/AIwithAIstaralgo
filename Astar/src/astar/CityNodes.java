package astar;

import java.util.*;


public class CityNodes {
    
    public int INF = Integer.MAX_VALUE;
    
     class Node implements Comparable{

            public Node left,right;
            public String name;
            public int key;
            public int gn;
            public int position;
            public int traincost;
            public int buscost;
            public Node(int item,String x,int a,int b,int c,int d){
                key = item;
                name = x;
                gn = a;
                position = b;
                traincost = c;
                buscost= d;
            }
            @Override
            public int compareTo(Object o){
            Node that = (Node) o;
            return (int)((this.gn + this.position)-(that.gn + that.position));
                    }
            
}
    class BinaryTree{
            Node root;
            BinaryTree(String name,int key,int gn, int position,int traincost,int buscost){
                root = new Node(key,name,gn,position,traincost,buscost);
            }
            BinaryTree(){
                root = null;
            }
            
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.root  = new Node(1,Budapest,230,0,
    }
        

}