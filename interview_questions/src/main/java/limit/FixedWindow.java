package limit;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定窗口
 */
public class FixedWindow {
    //阈值
    private static Integer QPS=2;
    //窗口
    private static long WINDOW=1000;
    //计数器
    private static AtomicInteger COUNT=new AtomicInteger();
    //开始时间
    private static long START_TIME = System.currentTimeMillis();

    public synchronized  static boolean limit(){
        if((System.currentTimeMillis()-START_TIME)>WINDOW){
            COUNT.set(0);
            START_TIME=System.currentTimeMillis();
        }
        return COUNT.incrementAndGet()<QPS;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (!limit()) {
                System.out.println(now + " 限流");
            } else {
                System.out.println(now + " 放行");
            }
        }
    }


}
