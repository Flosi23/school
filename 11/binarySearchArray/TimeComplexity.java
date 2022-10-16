package school.binarySearchArray;

public class TimeComplexity {

    public static int[] longArray() {
        int[] array = new int[1000000000];

        for(int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        return array;
    }

    public static int linearSearch(int[] array, int x) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] a, int x) {
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
        int[] array = longArray();
        Timer timer = new Timer();
        timer.start();
        linearSearch(array, -1);
        timer.stopMS();

        timer.start();
        binarySearch(array, -1);
        timer.stopNS();
    }
}
