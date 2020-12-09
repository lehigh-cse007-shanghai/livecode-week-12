package live;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoDimensionalArray {

    public void printTriangle(int size){
        for(int i = 0; i < size; i ++){
            int num = 1;
            for(int j = 0; j < size - i; j ++) {
                System.out.print(num + " ");
                num += 1;
            }
            System.out.println();
        }
    }

    public void printTriangleUsingArrayList(int size){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= size; i ++)
            arr.add(i);
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < arr.size(); j ++){
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
            arr.remove(arr.size() - 1);
        }
    }

    public void printTriangleUsingHashMap(int size){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1; i <= size; i ++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 1; j <= i; j ++){
                arr.add(j);
            }
            map.put(i, arr);
        }

        for(int i = size; i >= 1; i --){
            for(int j = 0; j < map.get(i).size(); j ++){
                System.out.print(map.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public void printTriangleABCDEFT(int size){
        char[] arrABCDEFG = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        for(int i = 0; i < size; i ++){
            int num = 1;
            for(int j = 0; j < size - i; j ++) {
                System.out.print(arrABCDEFG[num - 1] + " ");
                num += 1;
            }
            System.out.println();
        }
    }

    public void printTriangleABCDEFTUpperLowerCase(int size){
        char[] arrABCDEFG = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        for(int i = 0; i < size; i ++){
            int num = 1;
            for(int j = 0; j < size - i; j ++) {
                if((i + j) % 2 == 0)
                    System.out.print(arrABCDEFG[num - 1] + " ");
                else
                    System.out.print(Character.toLowerCase(arrABCDEFG[num - 1]) + " ");
                num += 1;
            }
            System.out.println();
        }
    }

    public void printTriangleAtRight(int size){
        for(int i = 0; i < size; i ++){
            int num = 1;
            for(int j = 0; j <= i; j ++)
                System.out.print(" " + " ");
            for(int j = 0; j < size - i; j ++) {
                System.out.print(num + " ");
                num += 1;
            }
            System.out.println();
        }
    }


    public void printTwoTriangles(int size){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= size; i ++)
            arr.add(i);
        for(int i = size - 1; i >= 1; i --)
            arr.add(i);
        
        for(int i = 1; i <= size; i ++){
            for(int j = 0; j < arr.size(); j ++){
                if(arr.get(j) >= i + 1)
                    System.out.print(" " + " ");
                else
                    System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        TwoDimensionalArray td = new TwoDimensionalArray();
//        td.printTriangle(8);
//        td.printTriangleUsingArrayList(8);
        td.printTwoTriangles(8);
    }

}
