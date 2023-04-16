package MSTAlgorithmsTest;

import MSTAlgorithms.Edge;
import MSTAlgorithms.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EulerianCircuit {
    @Test
    public void test1(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(0,1,10));
        edgeList.add(new Edge(1,3,25));
        edgeList.add(new Edge(3,2,30));
        edgeList.add(new Edge(2,0,15));

        MSTAlgorithms.EulerianCircuit eulerianCircuit=new MSTAlgorithms.EulerianCircuit(edgeList,4);
        List<Integer> circuit=eulerianCircuit.EulerianCircuitAlgorithm();

        assertEquals(edgeList.size(),circuit.size(),1);
    }

    @Test
    public void test2(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(1,1,10));
        edgeList.add(new Edge(0,3,25));
        edgeList.add(new Edge(3,2,30));
        edgeList.add(new Edge(2,0,15));

        MSTAlgorithms.EulerianCircuit eulerianCircuit=new MSTAlgorithms.EulerianCircuit(edgeList,4);
        List<Integer> circuit=eulerianCircuit.EulerianCircuitAlgorithm();

        assertEquals(edgeList.size(),circuit.size(),1);
    }

    @Test
    public void test3(){

        List<Edge> edgeList=new ArrayList<>();
        edgeList.add(new Edge(1,1,10));
        edgeList.add(new Edge(0,3,25));
        edgeList.add(new Edge(0,3,25));
        edgeList.add(new Edge(2,3,25));
        edgeList.add(new Edge(0,3,25));

        MSTAlgorithms.EulerianCircuit eulerianCircuit=new MSTAlgorithms.EulerianCircuit(edgeList,4);
        List<Integer> circuit=eulerianCircuit.EulerianCircuitAlgorithm();

        assertEquals(edgeList.size(),circuit.size(),3);
    }
}
