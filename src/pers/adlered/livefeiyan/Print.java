package pers.adlered.livefeiyan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pers.adlered.livefeiyan.gson.Big;
import pers.adlered.livefeiyan.gson.small.Cities;
import pers.adlered.livefeiyan.gson.small.Province;
import pers.adlered.livefeiyan.inputstream_tostring.main.InputStreamToString;
import pers.adlered.livefeiyan.post_http_or_https.main.PostHttpOrHttps;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <h3>live-feiyan</h3>
 * <p>打印数据（写入缓存）</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 20:11
 **/
public class Print {
    public StringBuilder getString() throws ArrayIndexOutOfBoundsException, NullPointerException {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedInputStream bufferedInputStream = null;
            try {
                bufferedInputStream = PostHttpOrHttps.get("http://3g.dxy.cn/newh5/view/pneumonia", null);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            String data = InputStreamToString.convert(bufferedInputStream);
            // 截取数据位置
            String start1 = "try \\{ window.getAreaStat = ";
            String start2 = "try \\{ window.getStatisticsService = ";
            String stop1 = "\\}catch\\(e\\)\\{\\}</script>";
            String stop2 = "\\}catch\\(e\\)\\{\\}</script>";

            String p1 = data.split(start1)[1].split(stop1)[0];
            String p2 = data.split(start2)[1].split(stop2)[0];

            Big big = new Gson().fromJson(p2, Big.class);
            stringBuilder.append("\r");
            stringBuilder.append(" ########  新型肺炎疫情全国情况  ########" + "\n");
            stringBuilder.append(" #    确诊  " + big.getConfirmedCount() + "  疑似  " + big.getSuspectedCount() + "\n");
            stringBuilder.append(" #    康复  " + big.getCuredCount() + "  死亡  " + big.getDeadCount() + "\n");
            stringBuilder.append(" #    最后更新时间  " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(big.getModifyTime()) + "\n");
            stringBuilder.append(" ########  新型肺炎疫情全国情况  ########" + "\n");
            stringBuilder.append("\r");

            List<Province> provinces = new Gson().fromJson(p1, new TypeToken<List<Province>>(){}.getType());
            for (Province province : provinces) {
                stringBuilder.append(" ### " + province.getProvinceName() + " 确诊" + province.getConfirmedCount() + " 疑似" + province.getSuspectedCount() + " 康复" + province.getCuredCount() + " 死亡" + province.getDeadCount() + " ###" + "\n");
                List<Cities> cities = province.getCities();
                if (cities.size() != 0) {
                    stringBuilder.append("\n");
                }
                for (Cities city : cities) {
                    String status = " #  " + city.getCityName() + "  确" + city.getConfirmedCount() + "   疑" + city.getSuspectedCount() + "   康" + city.getCuredCount() + "   亡" + city.getDeadCount() + "   #" + "\n";
                    stringBuilder.append(status);
                }
                stringBuilder.append("\r\n");
            }
            return stringBuilder;
        }
    }
}
