import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- metahazer
/**
 *  The MazeRunner jeroo runs the maze
 *  and it clears all the nets and flowers on 
 *  the Maze Island, always ending at(1, 1)
 *  
 *  @author metahazer(Xue)
 *  @version 2020.9.25
 */

public class MazeRunner extends Jeroo {
    //~ Fields ................................................................

    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunner object.
     */
    public MazeRunner() {
        super(15);
    }

    /**
     * check if the jeroo meets are requrements to finish.
     * the run and it runs until it satisfies.
     */
    public void myProgram() {
        while (!check()) {
            this.run();
        }
    }

    /**
     * Check if there's no net or flowers remain on the
     * island also end at (1,1)
     * @return if true it has no flowers or nets at (1, 1).
     */
    public boolean check() {
        return (this.getWorld().getObjects(Net.class).size() == 0 &&
                this.getWorld().getObjects(Flower.class).size() == 0) &&
            (this.getGridX() == 1 && this.getGridY() == 1);

    }
    /**
     * Jeroo picks whenever sees a flower at it's local pt.
     */
    public void pickFlower() {
        if (this.seesFlower(HERE)) {
            this.pick();
        }
    }


    /**
     * Jeroo toss whenever sees a net ahead.
     */
    public void tossFlower() {
        if (this.seesNet(AHEAD)) {
            this.toss();
        }
    }

    /**
     * The jeroo turns left if possible.
     * @return if true, it turns left. if false, it stays straight
     */
    public boolean turnLeft() {
        if (!this.seesWater(LEFT) && !this.seesNet(LEFT)) {
            this.turn(LEFT);
            this.hop();
            return (true);
        } 
        else 
        {
            return (false);
        }
    }

    /**
     * The jeroo go straight if possible.
     * @return if true,the jeroo hops. if false, it stops.
     */
    public boolean hopForward() {
        if (!this.seesWater(AHEAD) && !this.seesNet(AHEAD)) {
            this.hop();
            return (true);
        }
        else 
        {
            return (false);
        }
    }

    /**
     * The jeroo runs, turns right if it can either turn left
     * or hop foward, if there's water in 3 directions it
     * turns back. Picks and disables whenever possible.
     */
    public void run() {
        this.tossFlower();
        this.pickFlower();
        if (!this.turnLeft() && !this.hopForward()) {
            this.turn(RIGHT);
        }
        if (this.seesWater(AHEAD) && this.seesWater(RIGHT) &&
            this.seesWater(LEFT)) {
            this.turn(RIGHT);
            this.turn(RIGHT);
        }

    }
}