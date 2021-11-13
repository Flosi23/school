package school.fibonacci;

public class Timer {
  
  long startTime;

  Timer() {

  }

  public void start() {
    this.startTime = System.nanoTime();
  }

  public long stop() {
    long time = System.nanoTime() - this.startTime;
    this.printTime(time);
    return time;
  }

  private void printTime(long time) {
    System.out.println("Time: " + time + " ns");
  }
}
