package Utils;

import GUI.TSP_GUI;
import GUI.Vertex;
import MSTAlgorithms.*;
import OptimizationAlgorithms.AntColonyOptimization;
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
}
