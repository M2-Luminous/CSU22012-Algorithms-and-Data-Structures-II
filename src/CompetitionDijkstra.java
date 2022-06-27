import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//HashMap is a Map based collection class that is used for storing Key & value pairs, 
//it is denoted as HashMap<Key, Value> or HashMap<K, V>. 
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CompetitionDijkstra {
	
	   public Double cost;
	   public ArrayList<String> startingStopID = new ArrayList<String>();
	   public ArrayList<String> endingStopID = new ArrayList<String>();
	   public ArrayList<edgeTo> edges = new ArrayList<edgeTo>();
	   public ArrayList<Double> weight = new ArrayList<Double>();
	   public HashMap<String,vertexTo> vertexHashMap = new HashMap<String,vertexTo>();
	   public ArrayList<String[]> stopTripID = new ArrayList<String[]>();	   
	
		
	   public CompetitionDijkstra(String stopsFile, String transfersFile, String stop_timesFile) throws FileNotFoundException { 
		   File stops = new File(stopsFile);
		   Scanner contestantA = new Scanner(stops);
		   while(contestantA.hasNextLine()){
			   String stop1 = contestantA.nextLine();
		   	   String stopArray1[] = stop1.split(",");//.trim().split("\\s+")
		   	   vertexTo vtmp = new vertexTo(stopArray1[0]);
		   	   vertexHashMap.put(stopArray1[0], vtmp);
		   	}	   
		   	contestantA.close();
	
	   		ArrayList<String> startStops = new ArrayList<String>();
	   		ArrayList<String> endStops = new ArrayList<String>();
	   		ArrayList<Double> Weights = new ArrayList<Double>();

			File transfers = new File(transfersFile);
		   	Scanner contestantB = new Scanner(transfers);

	   		while(contestantB.hasNextLine()){
	   			String stop2 = contestantB.nextLine();
	   			String stopArray2[] = stop2.split(",");//.trim().split("\\s+")
	   
	   			startStops.add(stopArray2[0]);	   
	   			endStops.add(stopArray2[1]);

	   			if(stopArray2[2]=="0") { 
	   				Weights.add(2.0); 
	   			}
	   			else if(stopArray2[2]=="2") { 
	   				Weights.add(Double.parseDouble(stopArray2[3])/100); 
	   			}
	   			else { 
	   				Weights.add(1.0); 
	   			} 	   
	   		}
	   		contestantB.close();
	   
	   		startingStopID = startStops;
	   		endingStopID = endStops;	   
	   		weight = Weights;	    
	    
	   		for(int i = 1;i < startStops.size();i++) {
	   			vertexTo vtmp1 = vertexHashMap.get(startingStopID.get(i));
	   			vertexTo vtmp2 = vertexHashMap.get(endingStopID.get(i));
	   			Double edgeWeight = weight.get(i);	    	
	    	
	   			vtmp1.addingNeighbours(new edgeTo(edgeWeight,vtmp1,vtmp2));
	   			vertexHashMap.put(startingStopID.get(i), vtmp1);	    	
	   		}
	    
	   		File stops_times = new File(stop_timesFile);
	   		Scanner contestantC = new Scanner(stops_times);
	  
	   		while(contestantC.hasNextLine()) {		  
	   			String stop3 = contestantC.nextLine();
	   			String stopArray3[] = stop3.split(",");//.trim().split("\\s+")		 
	   			String tripID = stopArray3[0];		 
	   			String stopID = stopArray3[3];
	   			String stopArray[] = {tripID,stopID};
		
	   			stopTripID.add(stopArray);
	   		}
			contestantC.close();
	  
		  
	   		String tripID1 = stopTripID.get(1)[0];//get a 2D index message
	   		String StopID1 = stopTripID.get(1)[1];
	   		vertexTo v1 = vertexHashMap.get(StopID1);
	   		for(int j = 2; j < stopTripID.size(); j++) {		  
		   		String tripID2 = stopTripID.get(j)[0];
		   		String StopID2 = stopTripID.get(j)[1];			    
		   		if(tripID1.equals(tripID2)) {
		   			vertexTo v2 = vertexHashMap.get(StopID2);
		   			v1.addingNeighbours(new edgeTo(1.0,v1,v2));				  
		   			vertexHashMap.put(v1.positionName, v1);
		   			v1 = v2;				  
		   		}			  
		  		else {
		   			tripID1 =tripID2;
		   			vertexTo v2 = vertexHashMap.get(StopID2);
		   			v1 = v2;
		   		}			  
		   	}	    
	   }
		 
	
   
  
    public void computePath(vertexTo sourceVertex) {
        sourceVertex.setMinimumDistance(0);
        PriorityQueue<vertexTo> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            vertexTo vertex = priorityQueue.poll();
            for (edgeTo edge : vertex.gettingEdges()) {
                vertexTo vtmp = edge.gettingEndingPoint();
                double edgeWeight = edge.gettingEdgeWeight();
                double minimumDistance = vertex.getMinimumDistance() + edgeWeight;
                if (minimumDistance < vtmp.getMinimumDistance()) {
                    priorityQueue.remove(vertex);
                    vtmp.setPreviousVertex(vertex);
                    vtmp.setMinimumDistance(minimumDistance);
                    priorityQueue.add(vtmp);
                }
            }
        }
    }

	/*
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
	*/

    public List<vertexTo> getShortestPath(vertexTo target) {
        List<vertexTo> shortestPath = new ArrayList<>();        
        cost = target.getMinimumDistance();        
        for (vertexTo vertex = target; vertex != null; vertex = vertex.getPreviousVertex()) { shortestPath.add(vertex);}
		/*
		Vertex vertex = targetVerte;
        if(vertex != null) {
        	vertex = vertex.getPreviosVertex();
        	path.add(vertex);
        }
		*/

        Collections.reverse(shortestPath);//used for reversing elements been there up in the object in which they are stored
		//{4,3,2,1} -> {1,2,3,4}
        return shortestPath;
    }

}