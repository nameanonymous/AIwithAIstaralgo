//package astar;
//
//import java.util.*;
//
//
//public class CityNodes {
//    
//    public int INF = Integer.MAX_VALUE;
//    
//         class Node {
//
//            public Node left,right;
//            public String name;
//            public int key;
//            public int gn;
//            public int hn;
//            public int traincost;
//            public int buscost;
//            public Node(int key,String name,int gn,int hn,int traincost,int buscost){
//                this.key = key;
//                this.name = name;
//                this.gn = gn;
//                this.hn = hn;
//                this.traincost = traincost;
//                this.buscost= buscost;
//            }
//
//            
//}
//        class BinaryTree{
//                Node root;
//                BinaryTree(int key,String name,int gn, int hn,int traincost,int buscost){
//                root = new Node(key,name,gn,hn,traincost,buscost);
//            }
//            BinaryTree(){
//                root = null;
//            }
//            
//        }
//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        
//        tree.root  = new Node(1,Budapest,0,230,0,0);
//    }
//        
//
//}