package MSTAlgorithmsTest;

import MSTAlgorithms.Edge;
import MSTAlgorithms.Hungarian;
import Utils.CostTraversal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HungarianTest
{
    @Test
    public void test1(){

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        Hungarian hungarian=new Hungarian(graph);
        int a[]=hungarian.execute();

        assertEquals(4,a.length);
    }
    @Test
    public void test2(){

        double[][] graph = {
                {70,  40,   20,   55,12},
                {65,  60,   45,   90,34},
                {30,  45,   50,   75,56},
                {25,  30,   55,   40,67},
                {23,34,56,67,12}
        };

        Hungarian hungarian=new Hungarian(graph);
        int a[]=hungarian.execute();

        assertEquals(5,a.length);
    }

    @Test
    public void test3(){

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(1,1,10));
        edgeList.add(new Edge(0,3,25));
        edgeList.add(new Edge(3,2,30));
        edgeList.add(new Edge(2,0,15));

        Hungarian hungarian=new Hungarian(graph);
        int a[]=hungarian.execute();
        List<Integer> oddVertices=new ArrayList<>();
        oddVertices.add(0);
        oddVertices.add(1);
        oddVertices.add(2);
        oddVertices.add(3);

        int executor[]=new int[]{0,1,2,3};

        List<Edge> matching=hungarian.matching2(oddVertices,executor,graph,edgeList);

        assertEquals(3,matching.size());
    }

    @Test
    public void test4(){

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(0,1,10));
        edgeList.add(new Edge(0,3,25));
        edgeList.add(new Edge(3,2,30));
        edgeList.add(new Edge(2,0,15));

        Hungarian hungarian=new Hungarian(graph);
        int a[]=hungarian.execute();
        List<Integer> oddVertices=new ArrayList<>();
        oddVertices.add(0);
        oddVertices.add(1);
        oddVertices.add(3);
        oddVertices.add(2);

        int executor[]=new int[]{0,1,2,3};

        List<Edge> matching=hungarian.matching2(oddVertices,executor,graph,edgeList);

        assertEquals(2,matching.size());
    }

}
