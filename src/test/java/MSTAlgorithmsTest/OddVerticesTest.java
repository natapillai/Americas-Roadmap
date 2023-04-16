package MSTAlgorithmsTest;

import MSTAlgorithms.Edge;
import MSTAlgorithms.OddVertices;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OddVerticesTest
{
    @Test
    public void test1(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(0,1,10));
        edgeList.add(new Edge(1,2,25));
        edgeList.add(new Edge(0,2,30));
        edgeList.add(new Edge(0,3,15));

        OddVertices oddVertices=new OddVertices();
        List<Integer> circuit=oddVertices.OddVertex(edgeList,4);

        assertEquals(2,circuit.size());
    }

    @Test
    public void test2(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(0,1,10));
        edgeList.add(new Edge(0,2,25));
        edgeList.add(new Edge(3,2,30));
        edgeList.add(new Edge(2,3,15));

        OddVertices oddVertices=new OddVertices();
        List<Integer> circuit=oddVertices.OddVertex(edgeList,4);

        assertEquals(2,circuit.size());
    }


    @Test
    public void test3(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(0,1,10));
        edgeList.add(new Edge(0,2,25));
        edgeList.add(new Edge(0,3,30));

        OddVertices oddVertices=new OddVertices();
        List<Integer> circuit=oddVertices.OddVertex(edgeList,4);

        assertEquals(4,circuit.size());
    }
}
