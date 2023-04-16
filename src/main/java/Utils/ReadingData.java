package Utils;

import GUI.TSP_GUI;
import GUI.Vertex;
import MSTAlgorithms.*;
import OptimizationAlgorithms.RandomSwap;
import OptimizationAlgorithms.SimulatedAnnealing;
import OptimizationAlgorithms.TwoOpt;

import java.io.*;
import java.util.*;


public class ReadingData {
	
	public static List<Data> FetchFile(String filePath)
	{
		List<Data> values = new ArrayList<Data>();

		File file= new File(filePath);
		try {
			Scanner sc=new Scanner(file);
			sc.nextLine();
			while(sc.hasNextLine())
			{
				String split[]=sc.nextLine().split(",");
				Data data = new Data(split[0],Double.parseDouble(split[1]),Double.parseDouble(split[2]));
				values.add(data);
			}
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "crimeSample.csv";
		List<Data> da = FetchFile(filePath);

		double graph[][] = new double[da.size()][da.size()];

		System.out.println(da.size()+"  "+"size");

		for (int i = 0; i < da.size(); i++)
			for (int j = 0; j < da.size(); j++)
				graph[i][j] = Utils.HaversineDistance.distance(da.get(i), da.get(j));

//		Prims pr =new Prims();
//		List<Edge> li=pr.PrimsAlgorithms(matrix);
//		int count=0;double sum=0.0;
//
//		for(int i=0;i<li.size();i++) {
//			sum+=li.get(i).getWeight();
//			System.out.println(li.get(i).getEdge1() + "------->" + li.get(i).getEdge2() + "---------->" + li.get(i).getWeight() + "  " + count++ +"  "+sum);
//		}

//		Prims Algorithm testing
//		double graph[][] = new double[][] { { 0, 5, 8, 0},
//				{ 5, 0, 10, 15 },
//				{ 8, 10, 0, 20 },
//				{ 0, 15, 20, 0 },};
//
//		double graph[][] = {{0, 10, 15, 20},
//				{10, 0, 35, 25},
//				{15, 35, 0, 30},
//				{20, 25, 30, 0}};

//		double graph[][] = {{0, 5, 8, 999},
//				{5, 0, 10, 15},
//				{8, 10, 0, 20},
//				{999, 15, 20, 0}};

//		double graph[][]={{0,60,100,50,90},{60,0,70,40,30},{100,70,0,65,55},{50,40,65,0,110},{90,30,55,110,0}};

//		double graph[][]={{0,7,3,4,5,8},{7,0,8,3,2,1},{3,8,0,8,8,7},{4,3,8,0,7,2},{5,2,8,7,0,6},{8,1,7,2,6,0}};

//		double graph[][]={{0,0,1,0,0},{0,0,1,0,0},{1,1,0,1,0},{0,0,1,0,1},{0,0,0,1,0}};

		Prims pr =new Prims();
		List<Edge> li=pr.PrimsAlgorithms(graph);

//		for(Edge e: li) {
//			sum+=e.getWeight();
//			System.out.println(e.getEdge1() + "  " + e.getEdge2() + "   =" + e.getWeight()+"  "+sum);
//		}

		OddVertices ov=new OddVertices();

		List<Integer> oddVert = ov.OddVertex(li, graph.length);

//		for(int i:oddVert)
//			System.out.println(i);

		double oddVertices[][]=ov.oddVertexCostMatrix(oddVert,graph);

//		for(int i=0;i< oddVertices.length;i++) {
//			for (int j = 0; j < oddVertices[0].length; j++)
//				System.out.print(oddVertices[i][j]+"  ");
//			System.out.println();
//		}

//		double[][] dataMatrix = {
//				{70,  40,   20,   55},
//				{65,  60,   45,   90},
//				{30,  45,   50,   75},
//				{25,  30,   55,   40}
//		};
// 		2,1,0,3

		Hungarian hungarian=new Hungarian(oddVertices);
		int orderexecture[] = hungarian.execute();

//		for(int i=0;i<orderexecture.length;i++)
//			System.out.println(orderexecture[i]);

//		List<Edge> matching=hungarian.matching(oddVert,orderexecture,graph);

		List<Edge> matching=hungarian.matching2(oddVert,orderexecture,graph,li);
//
//		for(Edge e:matching)
//			System.out.println(e.getEdge1()+"------>"+e.getEdge2());

		List<Edge> hungarianmatch = new ArrayList<>(li);
		hungarianmatch.addAll(matching);

//		for(Edge e:eulerian)
//			System.out.println(e.getEdge1()+" ------> "+e.getEdge2());


//		List<Integer> oddVerti = ov.OddVertex(hungarianmatch, graph.length);
//		for(int i:oddVerti)
//			System.out.println(i+"  "+oddVerti.size());

//		double g[][]=new double[graph.length][graph.length];
//		for(Edge e: hungarianmatch)
//		{
//			g[e.getEdge1()][e.getEdge2()]=e.getWeight();
//			g[e.getEdge2()][e.getEdge1()]=e.getWeight();
//		}
//
//		for(int i=0;i< graph.length;i++) {
//			for (int j = 0; j < graph.length; j++)
//				System.out.print(g[i][j] + "  ");
//			System.out.println();
//		}


		EulerianCircuit ec = new EulerianCircuit(hungarianmatch, graph.length);

		List<Integer> ecircuit= ec.EulerianCircuitAlgorithm();

//		HashMap<Integer,Integer> map=new HashMap<>();
//
//		for(int i:ecircuit){
//			System.out.println(i);
//			map.put(i,map.getOrDefault(i,0)+1);
//		}

		List<Integer> hamiltonianCircuit = new ArrayList<>();
		boolean[] visited = new boolean[graph.length];
		int prev=0;
		visited[0]=true;
		hamiltonianCircuit.add(prev);
		for (int i = 1; i < ecircuit.size(); i++) {
			int vertex = ecircuit.get(i);
			if (!visited[vertex]) {
				visited[vertex] = true;
				hamiltonianCircuit.add(vertex);
			}
		}
		List<Double> costAlgo=new ArrayList<>();
		hamiltonianCircuit.add(0);

		CostTraversal costTraversal=new CostTraversal();
		double cost = costTraversal.costTraversal(hamiltonianCircuit,graph.length,graph,0);
		costAlgo.add(cost);
//		for(int i:hamiltonianCircuit)
//			System.out.println(i);

		System.out.println(cost+"......cost");


		RandomSwap randomSwap=new RandomSwap();
		List<Integer> newtours = randomSwap.RandomSwapOpt(hamiltonianCircuit,graph,1000000);

		cost = costTraversal.costTraversal(newtours,graph.length,graph,0);
		costAlgo.add(cost);

		System.out.println(cost+"   New Node");

//		for(int i:newtours)
//			System.out.println("New tour  "+i+"   "+cost);

		TwoOpt twoOpt=new TwoOpt();
		List<Integer> tOpt = twoOpt.TwoOptAlgorithm(hamiltonianCircuit,graph);

		cost=costTraversal.costTraversal(tOpt,graph.length,graph,tOpt.get(0));
		costAlgo.add(cost);
		System.out.println(cost+"  Two New Node");

		SimulatedAnnealing simulatedAnnealing=new SimulatedAnnealing();
		List<Integer> simulatedTour = simulatedAnnealing.simulatedAnnealing(hamiltonianCircuit,graph,1);

		cost=costTraversal.costTraversal(simulatedTour,graph.length,graph,simulatedTour.get(0));
		costAlgo.add(cost);
		System.out.println(cost+"  simulated");


		List<Double> xAxis=new ArrayList<>();
		List<Double> yAxis=new ArrayList<>();

		Random random = new Random();
		double rn1=0.0;

		for (int i = 0; i<tOpt.size()-1; i++) {
			rn1 = random.nextDouble(10, 1190);
			if(!xAxis.contains(rn1))
				xAxis.add(rn1);
		}

		for (int i = 0; i<tOpt.size()-1; i++) {
			rn1 = random.nextDouble(10, 890);
			if(!yAxis.contains(rn1))
				yAxis.add(rn1);
		}

		List<Vertex> vertexLists=new ArrayList<>();
		for(int i=0;i<tOpt.size()-1;i++){
			vertexLists.add(new Vertex(xAxis.get(i),yAxis.get(i),da.get(tOpt.get(i)).getIds()));
		}
		vertexLists.add(new Vertex(xAxis.get(0),yAxis.get(0),da.get(tOpt.get(0)).getIds()));

//		System.out.println(vertexLists.size()+"........."+tOpt.size());

		TSP_GUI tsp_gui=new TSP_GUI(vertexLists,hamiltonianCircuit,newtours,tOpt,simulatedTour,costAlgo);





	}
}
