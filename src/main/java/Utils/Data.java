package Utils;

public class Data {
    private String ids;
    private double log;
    private double lat;

    public Data(String ids, double log, double lat) {
        this.ids = ids.substring(ids.length()-5);
        this.log = log;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Data{" +
                "ids='" + ids + '\'' +
                ", log=" + log +
                ", lat=" + lat +
                '}';
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }
}
