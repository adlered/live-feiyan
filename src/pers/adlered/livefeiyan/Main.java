package pers.adlered.livefeiyan;

import pers.adlered.livefeiyan.cache.Logger;

/**
 * <h3>live-feiyan</h3>
 * <p>主方法</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 17:47
 **/
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n" + "[Live-FeiYan] https://github.com/AdlerED");
            System.out.println("[Live-FeiYan] Please wait...");
            StringBuilder stringBuilder = new Print().getString();
            System.out.println("[Live-FeiYan] Fighting, China!\n");
            Main.sleep(1000);
            Logger logger = new Logger(stringBuilder, 50);
            logger.print();
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException IE) {
            IE.printStackTrace();
        }
    }
}
