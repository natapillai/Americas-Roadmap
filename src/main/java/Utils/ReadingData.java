package Utils;

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

		double matrix[][] = new double[da.size()][da.size()];

		for (int i = 0; i < da.size(); i++)
			for (int j = 0; j < da.size(); j++)
				matrix[i][j] = Utils.HaversineDistance.distance(da.get(i), da.get(j));

		for (int i = 0; i < da.size(); i++)
		{
			for (int j = 0; j < da.size(); j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
}
