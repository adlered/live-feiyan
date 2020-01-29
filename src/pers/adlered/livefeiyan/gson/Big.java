package pers.adlered.livefeiyan.gson;

/**
 * <h3>live-feiyan</h3>
 * <p>大数据</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-29 19:36
 **/
public class Big {
    private int confirmedCount;
    private int suspectedCount;
    private int curedCount;
    private int deadCount;
    private long modifyTime;

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

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
