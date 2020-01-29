package pers.adlered.livefeiyan.cache;

import pers.adlered.livefeiyan.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * <h3>live-feiyan</h3>
 * <p>循环打印日志</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 20:13
 **/
public class Logger {
    private StringBuilder stringBuilder;
    private int delay;

    public Logger(StringBuilder stringBuilder, int delay) {
        this.stringBuilder = stringBuilder;
        this.delay = delay;
    }

    public void print() {
        String string = stringBuilder.toString();
        String[] stringArr = string.split("\n");
        // 有些区县的内容过多，适当停顿，用 count 变量标记
        int count = 1;
        for (int i = 0; i < stringArr.length; i++) {
            if (i == 5) {
                Main.sleep(2000);
                count = 0;
            }
            if (stringArr[i].indexOf("\r") != -1) {
                count = 0;
                Main.sleep(1000);
                // Windows 系统不支持获取控制台高度，所以直接打印多个 \n
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            System.out.println(stringArr[i]);
            if (count > 13) {
                count = 0;
                Main.sleep(1000);
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException IE) {
                IE.printStackTrace();
            }
            count++;
        }
    }
}
