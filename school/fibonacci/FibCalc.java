package school.fibonacci;

public class FibCalc {
  Timer timer;

  FibCalc(){
    this.timer = new Timer();
  }

  private void printNumber(String n, String fib){
    System.out.println("Fibonacci number for: " + n + " : " + fib + "\n");
  }

  public int fibInt(int n){
    this.timer.start();
    int r = this.calcfibInt(n);
    this.timer.stop();

    this.printNumber(String.valueOf(n), String.valueOf(r));
    return r;
  }

  public long fibLong(long n){
    this.timer.start();
    long r = this.calcfibLong(n);
    this.timer.stop();

    this.printNumber(String.valueOf(n), String.valueOf(r));
    return r;
  }

  public double fibBinet(double n) {
    this.timer.start();
    double r = this.calcfibBinet(n);
    this.timer.stop();

    this.printNumber(String.valueOf(n), String.valueOf(r));
    return n;
  }

  private int calcfibInt(int n) {
    if(n <= 1) return n;
    return calcfibInt(n - 1) + calcfibInt(n - 2);
  }

  private long calcfibLong(long n) {
    if (n <= 1) return n;
    return calcfibLong(n - 1) + calcfibLong(n - 2);
  }

  /* private BigInteger calcfibBigInt(BigInteger n) {
    int compare = n.compareTo(new BigInteger("1"));
    if (compare == 0 || compare == -1) return n;
    return calcfibBigInt(n.subtract(new BigInteger("1"))).add(calcfibBigInt(n.subtract(new BigInteger("2"))));
  } */

  private double calcfibBinet(double n) {
    return (Math.pow((1 + Math.sqrt(5)) / 2,n) - Math.pow((1 - Math.sqrt(5)) / 2, n))/(Math.sqrt(5));
  }
}
