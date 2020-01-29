package pers.adlered.livefeiyan.gson.small;

/**
 * <h3>live-feiyan</h3>
 * <p>城市</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 19:49
 **/
public class Cities {
    private String cityName;
    private int confirmedCount;
    private int suspectedCount;
    private int curedCount;
    private int deadCount;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public int getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }
}