package school.Graph;

import java.util.Arrays;

public class Graph {

    private final Knoten[] knoten;
    private final int[][] matrix;
    int n;

    public Graph(int size){
        knoten = new Knoten[size];
        matrix = new int[size][size];
        n = 0;
    }

    public void knotenEinfuegen(Knoten k){
        knoten[n++] = k;
    }

    public void kanteEinfuegen(int i, int j){
        matrix[j][i] = 1;
    }

    public void kanteEntfernen(int i, int j){
        matrix[j][i] = 0;
    }

    public int knotenIndexSuchen(Knoten find){
        for(int i = 0; i < n; i++){
            if(knoten[i].equals(find)) return i;
        }
        return -1;
    }

    public void matrixAusgeben(){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < matrix.length; i++){
            for (int[] ints : matrix) {
                builder.append(ints[i]);
            }
            builder.append("\n");
        }

        System.out.println(builder);
    }

    public void knotenListeAusgeben(){
        System.out.println(Arrays.toString(knoten));
    }
}
