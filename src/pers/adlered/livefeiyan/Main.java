package pers.adlered.livefeiyan;

import pers.adlered.livefeiyan.inputstream_tostring.main.InputStreamToString;
import pers.adlered.livefeiyan.post_http_or_https.main.PostHttpOrHttps;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * <h3>live-feiyan</h3>
 * <p>主方法</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 17:47
 **/
public class Main {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = PostHttpOrHttps.get("https://3g.dxy.cn/newh5/view/pneumonia", null);
            String data = InputStreamToString.convert(bufferedInputStream);
            // 截取数据位置
            String start1 = "try \\{ window.getAreaStat = \\[";
            String start2 = "try \\{ window.getStatisticsService = ";
            String stop = "\\]\\}catch\\(e\\)\\{\\}</script>";

            String p1 = data.split(start1)[1].split(stop)[0];
            String p2 = data.split(start2)[1].split(stop)[0];
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
