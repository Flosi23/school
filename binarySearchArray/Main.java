package school.binarySearchArray;

public class Main {

    public static int find(int[] a, int x) {
        return find0(a, x, 0, a.length -1);
    }

    public static int find0(int[] a, int x, int n1, int n2) {
        int t = (n1 + n2) /2;
        if(a[t] == x) {
            return t;
        }
        if(n1 >= n2) {
            return -1;
        }
        if(x > a[t]) {
            return find0(a,x,t+1,n2);
        }
        if(x < a[t]){
            return find0(a,x,n1, t-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = find(new int[]{0,1,2,3,4,5,12}, 12);
        System.out.println(res);
    }
}
