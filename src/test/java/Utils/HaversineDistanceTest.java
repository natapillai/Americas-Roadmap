package Utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HaversineDistanceTest {

    @Test
    public void test1(){

        Data data1=new Data("efghhthgfdsertyuh",-74.0060,40.7128);
        Data data2=new Data("fghd7654434566558",-87.6750,41.8499);
        HaversineDistance haversineDistance=new HaversineDistance();
        double cost = haversineDistance.distance(data1,data2);

        assertEquals(1110000,cost,40000);
    }

    @Test
    public void test2(){

        Data data1=new Data("efghhthgfdsertyuh",-74.0060,40.7128);
        Data data2=new Data("fghd7654434566558",-119.5300,39.7400);
        HaversineDistance haversineDistance=new HaversineDistance();
        double cost = haversineDistance.distance(data1,data2);

        assertEquals(3822000,cost,1000);
    }

    @Test
    public void test3(){

        Data data1=new Data("efghhthgfdsertyuh",-122.4194,37.7749);
        Data data2=new Data("fghd7654434566558",-119.5300,39.7400);
        HaversineDistance haversineDistance=new HaversineDistance();
        double cost = haversineDistance.distance(data1,data2);

        assertEquals(332000,cost,1000);
    }
}
