import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- metahazer
/**
 *  This tests if MazeRunner jeroo runs the maze
 *  and it clears all the nets and flowers on 
 *  the Maze Island, always starts at the 
 *  southeast corner of the island at 
 *  (width - 2, height - 2), ending at(1, 1).
 *  
 *  @author metahazer(Xue)
 *  @version 2020.9.25
 */

public class MazeRunnerTest extends TestCase {
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest() {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp() {
        /*# Insert your own setup code here */
    }


    // ----------------------------------------------------------
    /**
     * The test checks the turnLeft() method works correctly.
     */
    public void testTurnLeft() {
        Island island = new MazeIsland(196);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 3, 5);
        shuttle.turnLeft();
        assertEquals(3, shuttle.getGridX());
        assertEquals(4, shuttle.getGridY());
        assertTrue(shuttle.isFacing(NORTH));
    }
    
    /**
     * The test checks the hopForward() method works correctly.
     */
    public void testHopForward() {
        Island island = new MazeIsland(71);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 1, 4);
        shuttle.turn(RIGHT);
        shuttle.hopForward();
        assertEquals(1, shuttle.getGridX());
        assertEquals(5, shuttle.getGridY());
        assertTrue(shuttle.isFacing(SOUTH));
    }
    
    /**
     * The test checks the checkingPlace() method works correctly.
     */
    public void testCheck() {
        Island island = new MazeIsland(92);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 3, 7);
        shuttle.turn(RIGHT);
        while (!shuttle.check()) {
            shuttle.run();
        }
        shuttle.check();
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(1, shuttle.getGridX());
        assertEquals(1, shuttle.getGridY());
    }

    /**
     * The test checks myProgram()works correctly.
     */
    public void testmyProgram() {
        Island island = new MazeIsland(46);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 3, 5);
        shuttle.myProgram();
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());
        assertEquals(1, shuttle.getGridX());
        assertEquals(1, shuttle.getGridY());
    }

    /**
     * The test checks myProgram()and the methods it calls work correctly.
     */
    public void testmyProgram1() {
        Island island = new MazeIsland(21);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 3, 5);
        shuttle.myProgram();
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());
        assertEquals(1, shuttle.getGridX());
        assertEquals(1, shuttle.getGridY());
    }

    /**
     * The test checks myProgram()and the methods it calls work correctly.
     */
    public void testmyProgram2() {
        Island island = new MazeIsland(4);
        MazeRunner shuttle = new MazeRunner();
        island.add(shuttle, 3, 9);
        shuttle.myProgram();
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());
        assertEquals(1, shuttle.getGridX());
        assertEquals(1, shuttle.getGridY());
    }
}
