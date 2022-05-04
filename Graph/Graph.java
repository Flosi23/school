package school.Graph;

import java.util.ArrayList;
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
        for(int i = 0; i < n; i++) {
            if (knoten[i].equals(find)) return i;
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

    public void tiefenSucheVariation(){
        ArrayList<Knoten> results = new ArrayList<>();
        boolean[] visited = new boolean[matrix.length];
        tiefenSucheAbiVariationRec(visited, results, 0);
    }

    public void tiefenSucheAbiVariationRec(boolean[] visited, ArrayList<Knoten> results, int knotIndex){
        results.add(knoten[knotIndex]);
        visited[knotIndex] = true;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][knotIndex] >= 10 && !visited[i]){
                tiefenSucheAbiVariationRec(visited, results, knotIndex);
            }
        }
    }

    public void knotenListeAusgeben(){
        System.out.println(Arrays.toString(knoten));
    }
}
