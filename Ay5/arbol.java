import java.util.*;
import java.io.*;

public class arbol {

    public static class Nodo{
        int valor;
        Nodo left;
        Nodo right;

        Nodo(int valor){
            this.valor = valor;
            this.left = null;
            this.right = null;
        }
    }

    public static class BST{
        Nodo root;

        BST(){
            this.root = null;
        }

        void insert(int valor){
            if(this.root == null){
                this.root = new Nodo(valor);
            }else if(this.root.valor > valor){
                System.out.printf("%d -> ", this.root.valor);
                this.root.left = insertRec(valor, this.root.left);
            }else{
                System.out.printf("%d -> ", this.root.valor);
                this.root.right = insertRec(valor, this.root.right);
            }
        }

        Nodo insertRec(int valor, Nodo subroot){
            if(subroot == null){
                System.out.printf("%d\n", valor);
                subroot = new Nodo(valor);
                return subroot;
            }
            System.out.printf("%d ->", subroot.valor);
            if(subroot.valor > valor){
                subroot.left = insertRec(valor, subroot.left);
            }else{
                subroot.right = insertRec(valor, subroot.right);
            }

            return subroot;
        }

        Nodo search(int valor){
            if(this.root.valor == valor || this.root == null){
                return this.root;
            }else if(this.root.valor > valor){
                return searchRec(valor, this.root.left);
            }else{
                return searchRec(valor, this.root.right);
            }
        }

        Nodo searchRec(int valor, Nodo subroot){
            if(subroot == null || subroot.valor == valor){
                return subroot;
            }else if(subroot.valor > valor){
                return searchRec(valor, subroot.left);
            }else{
                return searchRec(valor, subroot.right);
            }
        }

        void inorder(){
            inorderRec(this.root.left);
            System.out.printf("%d ", this.root.valor);
            inorderRec(this.root.right);
        }

        void inorderRec(Nodo nodito){
            if(nodito == null){
                return;
            }

            inorderRec(nodito.left);
            System.out.printf("%d ", nodito.valor);
            inorderRec(nodito.right);
        }
        // System.out.printf("%.4f \n", respuesta);
        // 0.732462412312321 => 0.7324
    }


    public static void main(String[] args){
        BST arbolito = new BST();

        arbolito.insert(5);
        arbolito.insert(10);
        arbolito.insert(3);
        arbolito.insert(-1);
        arbolito.insert(50);
        arbolito.insert(8);
        arbolito.insert(7);
        arbolito.insert(4);

        Nodo resultado = arbolito.search(4);
        if(resultado == null){
            System.out.println("Nulo");
        }else{
            System.out.println(resultado.valor);
        }

        resultado = arbolito.search(2);
        if(resultado == null){
            System.out.println("Nulo");
        }else{
            System.out.println(resultado.valor);
        }

        arbolito.inorder();

    }
}
