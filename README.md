# INFO6205_Project

AIM

The aim of this report is to investigate the effectiveness of the Christofides algorithm and its optimization methods, including tactical methods such as random swapping and 2-opt improvement, and strategic methods such as simulated annealing and ant colony optimization. Using these methods, we can obtain high-quality approximate solutions to the traveling salesman problem. This report will also explore the limitations and challenges associated with these methods and provide recommendations for future research in this area.

Approach:

We used IntelliJ IDE to develop a Java program to accomplish the aim of this report. The program was designed to implement the Christofides algorithm and optimize it using tactical and strategic methods. To increase modularity, reusability and readability of the program, we use Object-Oriented Programming (OOP) concepts.
The development of the program happened in several stages. First, we designed the data structures and classes necessary to implement the algorithm, such as Vertex, Edge and Data. Next, we implemented the Christofides algorithm and the optimization methods, including random swapping, 2-opt improvement, simulated annealing, and ant colony optimization. We also developed invariants to make sure the algorithm and its results are accurate.
To test the above algorithms we use a kaggle dataset, which had IDs, latitude and longitude values. From there we calculated the distance using the Haversine formula, and then we used Prims algorithm to derive the MST Value to find out the odd vertices. Using perfect matching algorithm, we match the edges, so that they form the minimum value. After that, the cycle is discovered by using the eulerian graph and cycle, and Hamiltonian cycle to remove redundant vertices. This tour was then forwarded to random swap, 2-opt, simulated annealing and ant colony. With the help of these algorithms, we were able to find the optimal tour value.
We analyzed the program’s results and used graphical representations to illustrate the program’s accuracy and performance.
Overall, the approach we used in this report combined theoretical analysis, programming, and experimentation to achieve the aim of investigating the effectiveness of the Christofides algorithm and its optimization methods in obtaining high-quality approximate solutions to the traveling salesman problem.
Program:
Data Structures used :
● Lists
● HashMaps
● Customized classes ( Data, Vertex and Edges)
Classes used :
● Edge: used to store the vertex v1 and vertex v2
● Eulerian Circuit: Used to calculate the eulerian graph and cycle
● Hungarian: Used to calculate the value of minimum cost edges among the odd
vertices
● Odd Vertices: Used to calculate the odd vertices in MST
● Prims: Used to calculate the Minimum Spanning Tree
● Ant Colony: Will help in determining the optimized value using the hamiltonian circuit.
● RandomSwap:Used to calculate the optimized value using random swap algorithm.
● TwoOpt: Used to calculate the tour and optimizing the tour length.
● Simulated Annealing: used to calculate the value of the optimized tour.
● CostTraversal: Used to calculate the cost of the entire tour traversal.
● Haversine Distance: Used to calculate the distance between two longitude and
latitude
● ReadingData: Used to read values from the csv file.
● MapPanel: Used to plot out the vertices and the edges
● TSP_GUI: Used to add the panel and buttons into a single frame
● Vertex: Used to send the X, Y coordinate and IDs
● ExecutorMain: Used to execute the main function and all the other optimized values.Algorithm used: Christofides:
The Christofides algorithm is a heuristic algorithm that provides an approximate solution to the traveling salesman problem.
The process by which it works is by
1. Finding a minimum spanning tree
2. Creating a subgraph of odd degree vertices
3. Finding a minimum weight perfect matching
4. Combining the minimum spanning tree and the perfect matching that includes all
vertices with an even degree
5. Finding an Eulerian circuit (traversing each edge of the graph exactly once)
6. Transforming it into a Hamiltonian circuit (traversing each vertex of the graph exactly
once by skipping previously visited vertices)



This algorithm guarantees that the solution will be at most 1.5 times the optimal solution, with a time complexity of O(N2 log(N)) for a graph with N vertices.


Random Swapping:
This method of tactical optimization involves randomly switching the order of two cities (vertices) in the solution to see whether it improves it. It is a straightforward strategy that has the potential to enhance the solution but also runs the risk of becoming caught in local optima since the algorithm only explores the neighboring solution by swapping two cities.


2-Opt:
This tactical optimization method involves removing two edges from the solution and reconnecting them in a different way, checking if it results in a better solution. It can be more effective in improving the solution, but is more computationally expensive than random swapping.


Simulated Annealing:
The metaheuristic algorithm for strategic optimization is based on the annealing process in metallurgy. It starts with a high temperature and gradually cools down the system, allowing for more exploration at the beginning and more exploitation at the end. It can be useful in finding local optima, but careful parameter adjustment is necessary.


Ant Colony:
This strategic optimization method is based on the swarm intelligence of ants, who use pheromone trails to locate the shortest route between their nest and a food source. By laying virtual pheromone trails on the graph, the algorithm employs a similar method to determine the shortest path. It can be effective in finding good solutions quickly but require careful tuning of its parameters and can get stuck in local optima.


Invariants:
The graph must be undirected and connected
The minimum spanning tree must be connected
The subgraph of odd degree vertices must have an even number of vertices
The edges in the minimum weight perfect matching must connect odd degree vertices
The combined graph must have even degree vertices
The Eulerian circuit must start and end at the same vertex
Throughout the program, the edges, which are produced by the primality methods used to calculate the Minimum Spanning Tree, will have the same value.
The data that is read from the dataset is moved to the list of type data that is used by the UI to identify the vertices.
Every tour is recorded in a separate list so that it may be used to determine the traversal cost and fed to other algorithms to get the most efficient value.

