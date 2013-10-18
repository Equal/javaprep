/*A "Bacon Number" as defined on Wikipedia is: "the number of degrees of separation an actor has from Kevin Bacon".
 Given a list of actors with corresponding names of actors they have starred in a movie with, write a program that prints out actors for a given Bacon number. Actor's data is provided in the following format; "[actor], [co-star], [co-star], ....".
 There are no direct back-references in the data set such as; "Kevin Bacon, Tom Hanks" , "Tom Hanks, Kevin Bacon". The output must be sorted in alphabetical order by the actor's name.
 Example input:
 data: [ "Kevin Bacon, Tom Hanks, Gary Sinise, Ed Harris, Bill Paxton, Tom Cruise, Jack Nicholson, Demi Moore, Kiefer Sutherland",
 "Tom Cruise, Nicole Kidman, Dustin Hoffman, Val Kilmer, Meg Ryan, Billy Connolly, Ken Watanabe, Renée Zellweger, Cuba Gooding Jr.",
 "Nicole Kidman, Hugh Jackman, Ed Harris, Meryl Streep, Jeff Daniels, Toni Collette, Val Kilmer, Tommy Lee Jones, Jim Carrey",
 "Tom Hanks, Meg Ryan, Tim Allen, Michael Keaton, Jean Reno, Vin Diesel, Matt Damon, Ted Danson, Ted Danson, Sally Field, Denzel Washington",
 "Jeff Goldblum, Kevin Kline, William Hurt, Meg Tilly, Glenn Close, Tom Berenger, Bill Pullman, Will Smith, Vivica A. Fox, Brent Spiner",
 "Jack Nicholson, Michael Keaton, Kim Basinger, Helen Hunt, Cuba Gooding Jr., Diane Keaton, Keanu Reeves, Marisa Tomei, Adam Sandler",
 "Demi Moore, Patrick Swayze, Billy Bob Thornton, Billy Connolly, Woody Harrelson, Burt Reynolds, Jason Alexander, Jim Cummings",
 "Brent Spiner, Patrick Stewart, Jonathan Frakes, LeVar Burton, Michael Dorn, Gates McFadden, Marina Sirtis, James Cromwell",
 "Kiefer Sutherland, Charlie Sheen, Chris O'Donnell, Tim Curry, Sandra Bullock, Matthew McConaughey, Samuel L. Jackson, Julia Roberts",
 "Dustin Hoffman, Robin Williams, Julia Roberts, Sharon Stone, Samuel L. Jackson, Liev Schreiber, Angelina Jolie, Jack Black, Jackie Chan",
 "Meg Ryan, Billy Crystal, Carrie Fisher, Tim Robbins, Stephen Fry, Nicolas Cage, Sam Neill, Hugh Grant, Robert Downey Jr., Jean Reno",
 "Sam Neill, Jeff Goldblum, Richard Attenborough, Samuel L. Jackson, Wayne Knight, Sean Connery, Alec Baldwin, James Earl Jones, Tim Curry"]
 baconNumber: 5
 Example output:
 Bill Pullman
 Brent Spiner
 Glenn Close
 Kevin Kline
 Meg Tilly
 Tom Berenger
 Vivica A. Fox
 Will Smith
 William Hurt
 
 Explanation: For example, Will Smith has a Bacon number of 5 because he is connected to Bacon by the following path: 
 Will Smith->Jeff Goldblum->Sam Neill->Meg Ryan->Tom Cruise->Kevin Bacon
 
 */

//Taken from talentbuddy.co

import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BaconNumber
{
    public static class Node implements Comparator<Node>{
        public String value;
        public Set<Node> neighbours;
        public Node(String val)
        {
            this.value = val;
            this.neighbours = new HashSet<Node>();
        }

        public Set<Node> getNeighbours()
        {
            return neighbours;
        }

        public void addNeighbour(Node newNode)
        {
            neighbours.add(newNode);
        }

        public int compare(Node n1, Node n2)
        {
            return n1.value.compareTo(n2.value);
        }
    }
    public static void main(String[] args)
    {
        String[] data = { "Kevin Bacon, Tom Hanks, Gary Sinise, Ed Harris, Bill Paxton, Tom Cruise, Jack Nicholson, Demi Moore, Kiefer Sutherland",
            "Tom Cruise, Nicole Kidman, Dustin Hoffman, Val Kilmer, Meg Ryan, Billy Connolly, Ken Watanabe, Renée Zellweger, Cuba Gooding Jr.",
            "Nicole Kidman, Hugh Jackman, Ed Harris, Meryl Streep, Jeff Daniels, Toni Collette, Val Kilmer, Tommy Lee Jones, Jim Carrey",
            "Tom Hanks, Meg Ryan, Tim Allen, Michael Keaton, Jean Reno, Vin Diesel, Matt Damon, Ted Danson, Ted Danson, Sally Field, Denzel Washington",
            "Jeff Goldblum, Kevin Kline, William Hurt, Meg Tilly, Glenn Close, Tom Berenger, Bill Pullman, Will Smith, Vivica A. Fox, Brent Spiner",
            "Jack Nicholson, Michael Keaton, Kim Basinger, Helen Hunt, Cuba Gooding Jr., Diane Keaton, Keanu Reeves, Marisa Tomei, Adam Sandler",
            "Demi Moore, Patrick Swayze, Billy Bob Thornton, Billy Connolly, Woody Harrelson, Burt Reynolds, Jason Alexander, Jim Cummings",
            "Brent Spiner, Patrick Stewart, Jonathan Frakes, LeVar Burton, Michael Dorn, Gates McFadden, Marina Sirtis, James Cromwell",
            "Kiefer Sutherland, Charlie Sheen, Chris O'Donnell, Tim Curry, Sandra Bullock, Matthew McConaughey, Samuel L. Jackson, Julia Roberts",
            "Dustin Hoffman, Robin Williams, Julia Roberts, Sharon Stone, Samuel L. Jackson, Liev Schreiber, Angelina Jolie, Jack Black, Jackie Chan",
            "Meg Ryan, Billy Crystal, Carrie Fisher, Tim Robbins, Stephen Fry, Nicolas Cage, Sam Neill, Hugh Grant, Robert Downey Jr., Jean Reno",
            "Sam Neill, Jeff Goldblum, Richard Attenborough, Samuel L. Jackson, Wayne Knight, Sean Connery, Alec Baldwin, James Earl Jones, Tim Curry"};
        SortedSet<Node> baconed = list_actors(data, 5);
        Iterator it = baconed.iterator();
        while (it.hasNext())
        {
            System.out.println(((Node)it.next()).value);
        }

    }

    public static SortedSet<Node> list_actors(String[] data, Integer baconNumber)
    {
        Hashtable<String, Node> allNodes = new Hashtable<String, Node>();
        for (String movieCredits : data)
        {
            String[] actors = movieCredits.split(", ");
            Node[] movieNodes = new Node[actors.length];
            for (int i = 0; i < actors.length; i++)
            {
                if (!allNodes.containsKey(actors[i]))
                {
                    Node node = new Node(actors[i]);
                    allNodes.put(actors[i], node);
                }
                movieNodes[i] = allNodes.get(actors[i]);
            }

            //Ugh, O(n^2)... =(
            for (int i = 0; i < movieNodes.length; i++)
            {
                for (int j = 0; j < movieNodes.length; j++)
                {
                    if (i != j)
                    {
                        movieNodes[i].addNeighbour(movieNodes[j]);
                    }
                }
            }
        }

        //Okay, we have the graph, now we have to traverse it
        Node baconNode = allNodes.get("Kevin Bacon");
        System.out.println("TOTAL " + allNodes.size());
        //Assume baconNode always exists
        
        Set<Node> traversedNodes = new HashSet<Node>();
        Set<Node> currentDegree = new HashSet<Node>();
        Set<Node> nextDegree = new HashSet<Node>();
        currentDegree.add(baconNode);
        for (int i = 1; i < baconNumber; i++)
        {
            for (Node degreeNode : currentDegree)
            {
                //For each node in the current depth, add their neighbours to nextDegree only if they have not been traversed already
                Set<Node> neighbours = degreeNode.getNeighbours();
                for (Node n : neighbours)
                {
                    if (!traversedNodes.contains(n) && !currentDegree.contains(n) && !nextDegree.contains(n))
                    {
                        nextDegree.add(n);
                    }
                }
            }
            traversedNodes.addAll(currentDegree);
            currentDegree.clear();
            currentDegree.addAll(nextDegree);
            nextDegree.clear();
        }
        SortedSet<Node> response = new TreeSet<Node>();
        for (Node n : currentDegree)
        {
            response.add(n);
        }
        return response;
    }
}
