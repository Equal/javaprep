/*A robot in a factory is tasked with getting exactly L litres of water into any one of two containers A and B. Unfortunately, the robot is not very sophisticated and can only execute the following simple operations:
fill A/B: Completely fills the given container
empty A/B: Completely empties the given container
pour A/B into B/A: Pours water from between the two containers, until either the source container is empty, or the destination container is full
Print out the shortest sequence of moves that results in any of the containers holding L litres of water, given CA and CB (the capacities of the containers, in litres) and L (the target). The containers always start out empty. If there is no way to get the specified amount in any number of moves, print "impossible".
Notes:
1 ≤ L ≤ 1000
0 ≤ CA, CB ≤ 1000
Example input:
L: 1
CA: 5
CB: 3
Example output:
fill B
pour B into A
fill B
pour B into A
Example input:
L: 3
CA: 6
CB: 4
Example output:
impossible*/

//Taken from talentbuddy.co


public class Pouring {
    
    public static void main(String[] args)
    {

    }

    public static void pour_water(Integer l, Integer ca, Integer cb)
    {
        //I need a terminating condition.

    }

}
