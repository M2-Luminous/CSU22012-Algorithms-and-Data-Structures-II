import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CompetitionTest {

	@Test
	public void testDijkstraConstructor() {

		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int contestantA = 50;
		int contestantB = 80;
		int contestantC = 60;
		map = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		// TODO
		CompetitionFloydWarshall map;
		String fileName = "tinyEWD.txt";
		int contestantA = 50;
		int contestantB = 80;
		int contestantC = 60;
		map = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	// TODO - more tests

	// Dijkstra: testing for using an invalid filename
	@Test
	public void testDInvalidFileName() {
		CompetitionDijkstra map;
		String fileName = "numbers.txt";
		int contestantA = 50;
		int contestantB = 70;
		int contestantC = 60;
		map = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
	}

	// Floyd-Warshall: testing for using an invalid filename
	@Test
	public void testFWInvalidFileName() {
		CompetitionFloydWarshall map;
		String fileName = "numbers.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		map = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Dijkstra: testing for when speed <= 0
	@Test
	public void testDNegativeSpeed() {
		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int contestantA = 0;
		int contestantB = 70;
		int contestantC = 60;
		map = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, map.timeRequiredforCompetition());
		contestantA = -3;
		contestantB = -7;
		contestantC = -4;
		map = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	// Dijkstra: testing for when speed <= 0
	@Test
	public void testFWNegativeSpeed() {
		CompetitionFloydWarshall map;
		String fileName = "tinyEWD.txt";
		int contestantA = 0;
		int contestantB = 70;
		int contestantC = 60;
		map = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, map.timeRequiredforCompetition());
		contestantA = -3;
		contestantB = -7;
		contestantC = -4;
		map = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	// Testing the requirements for speed A, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedA <= 100)
	//
	@Test
	public void testSpeedA() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed a < 50
		int contestantA = 40;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed a > 100
		contestantA = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing the requirements for speed B, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedB <= 100)
	//
	@Test
	public void testSpeedB() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed b < 50
		int contestantA = 60;
		int contestantB = 40;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed b > 100
		contestantB = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing the requirements for speed C, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedC <= 100)
	//
	@Test
	public void testSpeedC() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed c < 50
		int contestantA = 60;
		int contestantB = 50;
		int contestantC = 40;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed c > 100
		contestantC = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing Dijkstra and Floyd-Warshall for the input file: tinyEWD.txt
	// note: Running the tests on 1000EWD.txt works, but takes a long time (>10
	// seconds)
	@Test
	public void testTinyEWD() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-A.txt
	@Test
	public void testInputA() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-A.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-B.txt
	@Test
	public void testInputB() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-B.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-C.txt
	@Test
	public void testInputC() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-C.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-D.txt
	@Test
	public void testInputD() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-D.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-F.txt
	@Test
	public void testInputF() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-F.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-G.txt
	@Test
	public void testInputG() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-G.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-I.txt
	@Test
	public void testInputI() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-I.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-J.txt
	@Test
	public void testInputJ() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-J.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-K.txt
	@Test
	public void testInputK() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-K.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-L.txt
	@Test
	public void testInputL() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-L.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-M.txt
	@Test
	public void testInputM() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-M.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-N.txt
	@Test
	public void testInputN() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-N.txt";
		int contestantA = 50;
		int contestantB = 60;
		int contestantC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, contestantA, contestantB, contestantC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, contestantA, contestantB, contestantC);
	}

}