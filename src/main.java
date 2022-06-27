import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

//Author Michael Sweeney
public class main {

	public static void main(String[] args) throws FileNotFoundException {
		CompetitionDijkstra algorithm = new CompetitionDijkstra("stops.txt", "transfers.txt", "stop_times.txt");
		boolean quit = false;

		do {
			System.out.println("---------------------------Welcome to Vancouver Bus Stop Information System---------------------------------" + "\n");
			Scanner input = new Scanner(System.in);
			System.out.println("Please select following options for further information or exit system");
			System.out.println("Enter: 1 --- Provide recommend path between your starting point and destination");
			System.out.println("Enter: 2 --- Provide bus stop information");
			System.out.println("Enter: 3 --- Provide arriving bus information");
			System.out.println("Enter: 0 --- Exit Vancouver Bus System");
			if (input.hasNextInt()) {
				int choice = input.nextInt();
				input.nextLine();
				if (choice >= 0 && choice <= 3) {
					try {
						if (choice == 0) {
							System.out.println("Thank you and have a nice and safe trip!");
							System.exit(0);
						}
						if (choice == 1) {

							String inputStartingPoint = "";
							String inputDestination = "";
							HashMap<String, vertexTo> vertexes = algorithm.vertexHashMap; 
							boolean runable = true;

							while (runable != false) {								
								System.out.println("Enter Stop ID of starting point: ");
								String userInputSource = input.nextLine();
								inputStartingPoint = userInputSource; 
								
								System.out.println("Enter Stop ID of destination");
								String userInputDestination = input.nextLine();
								inputDestination = userInputDestination;

								String regex = "[0-9]+";
								if (!(inputStartingPoint.matches(regex)) || !(inputDestination.matches(regex)) ) {
										System.out.println("Inputted stop ID should only contain numbers");
								} else {
									if (vertexes.get(inputStartingPoint) == null && vertexes.get(inputDestination) == null) {
										System.out.println("Bus stops entered does not exist");}
									else {
										runable = false;
									}
								}

							}

							vertexTo source = vertexes.get(inputStartingPoint); 
							vertexTo destination = vertexes.get(inputDestination);																
							algorithm.computePath(source);


							System.out.println("The recommended path from " 
							+ source.positionName 
							+ " to " 
							+ destination.positionName 
							+ " is " 
							+ algorithm.getShortestPath(destination));
							Double cost = algorithm.cost;
							System.out.println("Cost of the Path: " + cost + "\n");

						} else if (choice == 2) {
							TST ternarySearchTree = new TST("stops.txt");
							System.out.print("Please enter the bus stop's name or first few letters for further information: ");
							String UserInput = input.nextLine();
							String userInput = UserInput.toUpperCase();
							ternarySearchTree.getStopInformation(userInput).forEach((info) -> {System.out.println(info);});
						} else if (choice == 3) {
							try {
								ArrayList<String> stopTimes = (ArrayList<String>) Files.readAllLines(Paths.get("stop_times.txt"));
								ArrayList<String> results = new ArrayList<String>();
								//String[] result = new String[1000];
					
								System.out.println("Enter an arrival time in the format (HH:MM:SS): ");
								System.out.println("(If your arrival time is less than 10:00:00, please add a 0 before the hour unit you inputted.)");
								boolean validTime = false;
								try {
									String time = input.next().trim();
									if (time.trim().matches("(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]")) {
									
										for (int i = 1; i < stopTimes.size(); i++) {
											if (stopTimes.get(i).trim().contains(time.trim())) {
												
												results.add(stopTimes.get(i).trim());
												//result[i]= stopTimes.get(i);
											}
											validTime = true;
										}
									}
							
									
									else if((time.charAt(2) == ':') && (time.charAt(5) == ':') && ((int)time.charAt(1) >= 4)) {
										System.out.println("Your input exceeds 23:59:59.");
										
									}
									else {
										System.out.println("Your input is not in the format HH:MM:SS");
									}
								} catch (Exception e) {
									System.out.println("Not a valid input.");
								}
								if (validTime) {
									System.out.println("Trip ID, Arrival Time, Departure Time, Stop ID, Stop sequence, Stop Headsign, Pickup Type, Drop Off Type, Shape, Distance Traveled  ");
									for (int i = 0; i < results.size(); i++){
										
										System.out.println(results.get(i));
									}
								} else if(!validTime) {
									System.out.println("The arrival time could not be found.");
								}
								
							} catch (FileNotFoundException e) {
								System.out.println("File not found");			
							}
						//bus arrival time
						}
					} catch (Exception e) {
						System.out.println("Bus stops entered does not exist");
					}
				}
				else {
					System.out.println("Not a valid input number, please type numbers from 0 to 3!");
				}
		}
		else{
			System.out.println("Invalid input, please type in numbers instead of word");
		}

		} while (!quit);
	}

}
