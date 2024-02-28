package limit;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 取令牌，没有令牌就限流
 */
public class TokenBucket {

    public static long LAST_TIME = System.currentTimeMillis();
    // 桶的容量
    public static int CAPACITY = 2;
    // 令牌生成速度 /s
    public static int QPS = 2;
    // 当前令牌数量
    public static AtomicInteger tokens = new AtomicInteger(0);

    private static boolean limit() {
        long now = System.currentTimeMillis();
        long gap = now - LAST_TIME;
        int reverse_permits = (int) (gap * QPS / 1000);
        int all_permits = tokens.get() + reverse_permits;
        tokens.set(Math.min(CAPACITY, all_permits));
        if (tokens.get() < 1) {
                        return false;
        } else {
            tokens.getAndDecrement();
            LAST_TIME = now;

            return true;
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
