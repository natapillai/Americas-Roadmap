package Utils;

public class HaversineDistance {

    private static final int EARTH_RADIUS = 6371;

    public static double distance(Data data1,Data data2)
    {
        double lat2=data2.getLat();
        double lat1=data1.getLat();
        double lon2=data2.getLog();
        double lon1= data1.getLog();

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double hav = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(hav), Math.sqrt(1 - hav));
        double dist = EARTH_RADIUS * c;
        return dist;
    }

}
