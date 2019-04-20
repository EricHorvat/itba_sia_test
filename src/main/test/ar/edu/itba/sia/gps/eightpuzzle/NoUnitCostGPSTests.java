package ar.edu.itba.sia.gps.eightpuzzle;

import ar.edu.itba.sia.gps.GPSEngine;
import ar.edu.itba.sia.gps.SearchStrategy;
import ar.edu.itba.sia.gps.walk.WalkingHeuristic;
import ar.edu.itba.sia.gps.walk.WalkingProblem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.MessageFormat;

import static ar.edu.itba.sia.gps.eightpuzzle.utils.TestUtils.runEngineTiming;

public class NoUnitCostGPSTests {
	
	private static GPSEngine aStarEngine;
	private static GPSEngine bfsEngine;
	
	@BeforeClass
	public static void setUp(){
		WalkingProblem aStarProblem = new WalkingProblem();
		WalkingProblem bfsProblem = new WalkingProblem();
		bfsEngine = new GPSEngine(bfsProblem, SearchStrategy.BFS, null);
		aStarEngine = new GPSEngine(aStarProblem , SearchStrategy.ASTAR, WalkingHeuristic.instance());

		System.out.println("Running NoUnitCost engines");
		runEngineTiming(bfsEngine, "BFS");
		runEngineTiming(aStarEngine, "A*");
		System.out.println("NoUnitCost engine ran, running the tests");
		
	}

	@Test
	public void differCostSolution(){
		assert aStarEngine.getSolutionNode().getCost() < bfsEngine.getSolutionNode().getCost() :
				MessageFormat.format("As differ rule cost, A* have less cost than BFS solution. " +
								"A* cost: {0}, BFS cost: {1}",
						aStarEngine.getSolutionNode().getCost(), bfsEngine.getSolutionNode().getCost());
	}

	@Test
	public void differDepthSolution(){
		assert aStarEngine.getSolutionNode().getDepth() > bfsEngine.getSolutionNode().getDepth() :
				MessageFormat.format("In this case, A* have a deeper solution than BFS. " +
								"A* depth: {0}, BFS depth: {1}",
						aStarEngine.getSolutionNode().getDepth(), bfsEngine.getSolutionNode().getDepth());
	}
	
	@Test
	public void generalTests(){
		GenericTests.solutionFound(aStarEngine);
		GenericTests.solutionFound(bfsEngine);
	}
}
