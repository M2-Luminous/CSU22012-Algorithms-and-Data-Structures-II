public class printMessages {
    int trip_id;
    String arrival_time;
    String departure_time;
    int stop_id;
    int stop_sequence;
    int stop_headsign;
    int pickup_type;
    int drop_off_type;
    float shape_dist_traveled;

    // trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type,shape_dist_traveled

    public printMessages(int trip_id, String arrival_time, String departure_time, int stop_id, int stop_sequence, int stop_headsign, int pickup_type, int drop_off_type, float shape_dist_traveled) {
        this.trip_id = trip_id;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.stop_id = stop_id;
        this.stop_sequence = stop_sequence;
        this.stop_headsign = stop_headsign;
        this.pickup_type = pickup_type;
        this.drop_off_type = drop_off_type;
        this.shape_dist_traveled = shape_dist_traveled;
    }

    public void printTripDetails() {
        String result0 = "trip_id: ";
        String result1 = " arrival_time: ";
        String result2 = " departure_time: ";
        String result3 = " stop_id: ";
        String result4 = " stop_sequence: ";
        String result5 = " stop_headsign: ";
        String result6 = " pickup_type: ";
        String result7 = " drop_off_type: ";
        String result8 = " shape_dist_traveled: ";
        System.out.println(
              result0 + trip_id 
            + result1 + arrival_time 
            + result2 + departure_time
            + result3 + stop_id 
            + result4 + stop_sequence 
            + result5 + stop_headsign 
            + result6 + pickup_type 
            + result7 + drop_off_type 
            + result8 + shape_dist_traveled);
    }
}
//ArrayList<String> element = new ArrayList<>(Arrays.asList(stopTimes.get(i)));
//String[] trip_id = element.get(1)[0];
//String arrival_time = element.get(2)[1];
//String departure_time = element.get(3)[2];
//String stop_id = element.get(4)[3];
//String stop_sequence = element.get(5)[4];
//String stop_headsign = element.get(6)[5];
//String pickup_type = element.get(7)[6];
//String drop_off_type = element.get(8)[7];
//String shape = element.get(9)[8];
//results.add(trip_id);
//results.add(arrival_time);
//results.add(departure_time);
//results.add(stop_id);
//results.add(stop_sequence);
//results.add(stop_headsign);
//results.add(pickup_type);
//results.add(drop_off_type);
//results.add(shape);

//for(int j = 0; j < result.length; j++){
//	String[] data = result[j].trim().split(",");
//	System.out.println("Trip ID" + data[0] + "\n");
//	System.out.println("Arrival Time" + data[1] + "\n");
//	System.out.println("Departure Time" + data[2] + "\n");
//	System.out.println("Stop ID" + data[3] + "\n");
//	System.out.println("Stop sequence" + data[4] + "\n");
//	System.out.println("Stop Headsign" + data[5] + "\n");
//	System.out.println("Pickup Type" + data[6] + "\n");
//	System.out.println("Drop Off Type" + data[7] + "\n");
//	System.out.println("Shape" + data[8] + "\n");
//}