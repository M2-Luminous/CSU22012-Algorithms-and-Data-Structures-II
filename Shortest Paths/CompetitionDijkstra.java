import java.io.*;
import java.util.*;

/**
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    Each contestant walks at a given estimated speed.
 *    The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * @author 
 *
 *         This class implements the competition using Dijkstra's algorithm
 **/

public class CompetitionDijkstra {

	public String fileName;
	public int contestantA, contestantB, contestantC;
	public double distTo[][];
	public int edgeTo[][];
	public int count;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra(String filename, int contestantA, int contestantB, int contestantC) {

		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.contestantC = contestantC;

		try {
			File inputFile = new File(filename);
			Scanner scanner = new Scanner(inputFile);
			int i = 0;

			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().trim().split("\\s+");
				//.trim(): removes whitespace
				//.split("\\s+") will split the string into string of array with separator as space or multiple spaces.
				//\s+ is a regular expression for one or more spaces.
				if (i == 0) {
				//starting situation 1
					distTo = new double[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					//	distTo(int v):Returns the length of a shortest path from the source vertex s to vertex v.
					
					edgeTo = new int[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					//	edgeTo(int v):Returns a shortest path from the source vertex s to vertex v.
					
					for (int a = 0; a < distTo.length; a++) {
						for (int b = 0; b < distTo[a].length; b++) {
							distTo[a][b] = Integer.MAX_VALUE;
							if (a == b) {
								distTo[a][b] = 0;
								//if the starting point and the ending point are the same, then the distance should be zero
							}
						}
					}
				} else if (i == 1) {
				//starting situation 2
					count = Integer.parseInt(line[i - 1]);
				} else {
				//normal situation
					distTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Double.parseDouble(line[2]);
					edgeTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[0]);
					//Integer.parseInt:convert string to integer
					//Double.parseDouble:convert string to double

				}
				i+=1;
			}
			for (int j = 0; j < distTo.length; j++) {
				dijkstraShortestPath(j);
				//call subroutine to analyze shortest path
			}
			scanner.close();
			//close input file scanner
		} catch (Exception e) {
			distTo = new double[0][0];
			edgeTo = new int[0][0];
			return;
		}//catch exception
	}

	public void dijkstraShortestPath(int k) {

		boolean[] shortestPath = new boolean[distTo.length];//Returns true if there is a shortest path from the source vertex s to vertex v.
		shortestPath[k] = true;
		while (true) {
			int x = -1;
			for (int i = 0; i < distTo.length; i++) {
				if ((shortestPath[i] == false) && (distTo[k][i] != Integer.MAX_VALUE)) {
					x = i;
					break; 
					// break when the new vertex is found
				}
			}
			if (x == -1) {//represents two vertices that don't have a path
				return;
			}
			shortestPath[x] = true;

			for (int i = 0; i < distTo.length; i++) {
				if (distTo[k][x] + distTo[x][i] < distTo[k][i]) {
					distTo[k][i] = distTo[k][x] + distTo[x][i];
					//if there is a shorter path between two vertices, then replace the old shortest path to the new one
					shortestPath[i] = false;
					edgeTo[k][i] = x;
				}
			}
		}

	}

	/**
	 public double[] dijkstra(double[][] graph, int source) { 
    	double[] dist = new double[N];//shortest distances from the source
    	boolean[] visited = new boolean[N];//true if the vertex i is included in dist
    	for(int i = 0; i < N; i++) {
    		dist[i] = Double.POSITIVE_INFINITY;
    		//visited[i] = false;
    	}
    	dist[source] = 0;
    	
    	for(int j = 0; j < N - 1; j++) {
    		int v = findMinDistance(dist, visited);//finds shortest distance
    		visited[v] = true; 
    		for(int i = 0; i < N; i++) {
    			if(visited[i] == false && graph[v][i] != Double.POSITIVE_INFINITY) {
    				if(dist[v] + graph[v][i] < dist[i]) {
    					dist[i] = dist[v] + graph[v][i];
    				}
    			}
    		}
    		
    	}
    	return dist;
    } 
	 **/
	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {

		if ((contestantA < 50 || contestantA > 100) || 
			(contestantB < 50 || contestantB > 100) || 
			(contestantC < 50 || contestantC > 100)) {
			return -1;
		}
		int minimumSpeed = Math.min(contestantC, Math.min(contestantA, contestantB));
		//checking the smallest number of speed among 3 contestants using Math.min for 2 times
		double maximumDistance = 0.0;

		for (int i = 0; i < distTo.length; i++) {
			for (int j = 0; j < distTo[i].length; j++) {
				if (distTo[i][j] == Integer.MAX_VALUE) return -1;
				else if (distTo[i][j] > maximumDistance) {
					maximumDistance = distTo[i][j];
					//replace the maximum distance when distTO[i][j] has a larger value
				}
			}
		}
		int maxTime = (int) Math.ceil((maximumDistance * 1000) / minimumSpeed);
		//	Math.ceil:rounds a number UPWARDS to the nearest integer
		if (minimumSpeed <= 0 || maximumDistance == 0) return -1;
		return maxTime;

	}

}