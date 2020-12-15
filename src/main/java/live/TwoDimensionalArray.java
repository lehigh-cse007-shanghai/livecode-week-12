package live;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoDimensionalArray {

    public void helloWorld(){
        System.out.println("Hello world!");
        int[] arr = {1, 2};
        System.out.println(arr[2]);
    }

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

    public void starsMrWang(int size){
        for(int i = 1; i <= size; i ++){
            for(int j = size; j >= i; j --)
                System.out.print(" ");
            for(int j = 1; j <= i; j ++)
                System.out.print("*" + " ");
            System.out.println();
        }
    }

    public void printTriangleStar(int size){
        char[][] arr2 = new char[size][2 * size - 1];
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < 2 * size - 1; j ++){
                if(Math.abs(j - (size - 1)) <= i)
                    arr2[i][j] = '*';
                else
                    arr2[i][j] = ' ';
            }
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < 2 * size - 1; j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printPower2TriangleMrBao(int size){
        for(int i = 1; i <= size; i ++){
            int k = 1;
            for(int j = 1; j <= size * 2 - 1; j ++){
                if(j > size - i && j < size) {
                    System.out.printf("%5d", k);
                    k *= 2;
                }
                else if(j == size)
                    System.out.printf("%5d", k);
                else if(j > size && j < size + i){
                    k /= 2;
                    System.out.printf("%5d", k);
                }
                else
                    System.out.print("     ");
            }
            System.out.println();
        }
    }

    public void printPower2Triangle(int size){
        int[][] arr2 = new int[size][2 * size - 1];
        int n = 1;
        int m = -1;
        for(int i = 0; i < size; i ++) {
            m = n;
            for (int j = size - 1; j < 2 * size - 1; j ++)
                if (m >= 1) {
                    arr2[i][j] = m;
                    m /= 2;
                }
            m = n;
            for (int j = size - 1; j >= 0; j --)
                if (m >= 1) {
                    arr2[i][j] = m;
                    m /= 2;
                }
            n *= 2;
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < 2 * size - 1; j++){
                if(arr2[i][j] == 0)
                    System.out.print("    ");
                else
                    System.out.printf("%4d", arr2[i][j]);
            }
            System.out.println();
        }
    }

    public void printPower2TriangleMrXiaoNanYang(int size){
        int[][] arr2 = new int[size][2 * size - 1];
        int n = 1;
        for(int j = 0; j < size; j ++){
            arr2[size - 1][j] = n;
            n *= 2;
        }
        for(int j = 1; j <= size - 1; j ++){
            arr2[size - 1][size - 1 + j] = arr2[size - 1][size - 1 - j];
        }
        for(int i = size - 2; i >= 0; i --){
            for(int j = 0; j < 2 * size - 1; j ++)
                arr2[i][j] = arr2[i + 1][j] / 2;
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < 2 * size - 1; j++){
                if(arr2[i][j] == 0)
                    System.out.print("    ");
                else
                    System.out.printf("%4d", arr2[i][j]);
            }
            System.out.println();
        }
    }


    public void printTriangleTwoDimensionalArray(int size){
        int[][] arr2 = new int[size][size];
        for(int i = 0; i < size; i ++){
            int num = 1;
            for(int j = 0; j <= i; j ++){
                arr2[i][j] = num;
                num += 1;
            }
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(arr2[i][j] + " ");
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

    public void printTriangleUsingHashMapAndClone(int size){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= size; i ++){
            arr.add(i);
            map.put(i, (ArrayList<Integer>) arr.clone());
        }

        for(int i = size; i >= 1; i --){
            for(int j = 0; j < map.get(i).size(); j ++){
                System.out.print(map.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void printTriangleABCDEFT(int size) {
        char[] arrABCDEFG = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        for (int i = 0; i < size; i++) {
            int num = 1;
            for (int j = 0; j < size - i; j++) {
                System.out.print(arrABCDEFG[num - 1] + " ");
                num += 1;
            }
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

    public void func2(String s){
        System.out.println(s);
    }

    public void func1(){
        System.out.println("Hello");
        func2("world");
    }

    public static void main(String[] args){
        TwoDimensionalArray td = new TwoDimensionalArray();
//        td.printTriangle(8);
//        td.printTriangleUsingArrayList(8);
//        td.printTriangleUsingHashMapAndClone(8);
//        td.printPower2Triangle(9);
//        td.printPower2TriangleMrBao(9);
//        td.printPower2TriangleMrXiaoNanYang(8);
//        td.starsMrWang(8);
//        System.out.printf("%4d\n", 128);
//        System.out.printf("%4d\n", 8);
//        System.out.printf("%4d\n", 1228);
//        td.func1();
        td.helloWorld();
    }

}
