package MSTAlgorithmsTest;

import MSTAlgorithms.Edge;

import MSTAlgorithms.Prims;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimsTest
{
    @Test
    public void test1(){

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double cost=0.0;
        for(int i=0;i<mst.size();i++)
            cost+=mst.get(i).getWeight();
        assertEquals(42,cost,cost*.20);
    }

    @Test
    public void test2(){

        double graph[][] = {{0, 20, 15, 30},
                {20, 0, 35, 25},
                {15, 35, 0, 30},
                {30, 25, 30, 0}};

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double cost=0.0;
        for(int i=0;i<mst.size();i++)
            cost+=mst.get(i).getWeight();
        assertEquals(60,cost,cost*.20);
    }

    @Test
    public void test3(){

        double[][] graph = {
                {70,  40,   20,   55},
                {65,  60,   45,   90},
                {30,  45,   50,   75},
                {25,  30,   55,   40}
        };

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double cost=0.0;
        for(int i=0;i<mst.size();i++)
            cost+=mst.get(i).getWeight();
        assertEquals(110,cost,cost*.20);
    }
}
