package limit;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 水满了就限流
 */
public class LeakyBucket {
    //阈值
    private static Integer QPS=2;


    private static Integer capacity=1;

    private static AtomicInteger WATER = new AtomicInteger(0);

    private static long START_TIME = System.currentTimeMillis();

    private static long LAST_TIME=System.currentTimeMillis();
    //水溢出则放行
    private static boolean limit(){
        if(WATER.get()==0){
            LAST_TIME=System.currentTimeMillis();
            WATER.incrementAndGet();
            return true;
        }

        int WATER_LEAK=(int) (System.currentTimeMillis()-LAST_TIME)/1000*QPS;
        int WATER_LEFT=WATER.get()-WATER_LEAK;
        WATER.set(WATER_LEFT);
        LAST_TIME=System.currentTimeMillis();
        if ((WATER.get()) < capacity) {
            WATER.addAndGet(1);
            return true;
        } else {
            // 水满，拒绝加水， 限流
            return false;
        }

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
