package Utils;

import MST.Edge;
import MST.MinimumSpanningTree;

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
		List<Edge> le = new ArrayList<>();

//		MinimumSpanningTree mst = new MinimumSpanningTree();

		double matrix[][] = new double[da.size()][da.size()];

		for (int i = 0; i < da.size(); i++)
			for (int j = 0; j < da.size(); j++)
				matrix[i][j] = Utils.HaversineDistance.distance(da.get(i), da.get(j));

		le = MinimumSpanningTree.findMST(matrix);

		for(Edge edge: le)
		{
			System.out.println(edge.getFrom() + " -> " + edge.getTo());
			System.out.println(edge.getWeight());
		}
/*		List<Integer> oddDegreeVertices = new ArrayList<>();

		for(int i = 0; i< da.size(); i++)
		{
			int degree = 0;
			for(Edge edge : le)
			{
				if(edge.getFrom() == i || edge.getTo() == i)
				{
					degree++;
				}
			}
			if(degree % 2 != 0)

		}*/


	}
}
