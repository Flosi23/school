import java.util.concurrent.TimeUnit;

public class Timer {

  long startTime;

  public void start() {
    this.startTime = System.nanoTime();
  }

  private long stop() {
    return System.nanoTime() - this.startTime;
  }

  public long stopMS() {
    long timeMillis = TimeUnit.MILLISECONDS.convert(stop(), TimeUnit.NANOSECONDS);
    System.out.println("Time: " + timeMillis + " ms");
    return timeMillis;
  }

  public long stopNS() {
    long time = stop();
    System.out.println("Time: " + time + " ns");
    return time;
  }

  private void printTime(long time) {
    long timeMillis = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
    System.out.println("Time: " + timeMillis + " ms");
  }
}
