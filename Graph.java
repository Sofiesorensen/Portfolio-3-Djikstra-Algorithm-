import java.util.*;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }
    public Vertex getvertex(String s)
    {
        for(Vertex v : Vertices )
        {
            if (v.Name==s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge=new Edge(from,to);
        newedge.distance=dist;
        newedge.time=tim;
    }

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> DistanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex v: Vertices)
        {
            DistanceMap.put(v,1000);
            PredecessorMap.put(v, null);
        }
        public int[] Dijkstra(int source) {
        int[] shortestdistance = new int[graph.length];
        int[] predecessor = new int[graph.length];
        boolean[] handled = new boolean[graph.length];
        int a,b;
        int adist,bdist;

        //initialize
        for (int i = 0; i <graph.length ; i++) {
            shortestdistance[i]=200;
            predecessor[i]=-1;
            handled[i]=false;
        }
        shortestdistance[source-1]=0;
        for (int count = 0; count <graph.length ; count++) {
            a=findMin(shortestdistance,handled);
            for (int i = 0; i <graph.length ; i++) {
                if(graph[a][i]>0)
                {
                    if(shortestdistance[a]+graph[a][i]<shortestdistance[i])
                    {
                        shortestdistance[i]=shortestdistance[a]+graph[a][i];
                        predecessor[i]=a;
                    }
                }
            }
            handled[a]=true;
        }
        return predecessor ;
    }

        public int findMin(int[] dist, boolean[] done)
        {
            int vertex=0;
            int value=200;
            for (int i = 0; i < dist.length ; i++) {
                if (dist[i]<value && !done[i])
                {
                    vertex=i;
                    value=dist[i];
                }
            }
            return vertex;
        }

        public int[] BFS(int s){
        int current;
        int[] color=new int[graph.length];
        int[] depth= new int[graph.length];
        int[] predecessor = new int[graph.length];
        Queue<Integer> Q = new LinkedList<Integer>();
        Arrays.fill(predecessor,-1);
        color[s-1]=1;
        Q.add(s-1);
        while(!Q.isEmpty())
        {
            current=Q.remove();
            for (int i = 0; i <graph.length ; i++) {
                if graph[current][i]>0)
                {
                    color[i]=1;
                    predecessor[i]=current;
                    depth[i]=depth[current]+1;
                    Q.add(i);
                }

            }
        }

        return predecessor;
    }

        public void printPath(int[] predecesor, int target)
        {
            int current=target-1;
            System.out.print("\n");
            while (current!=-1 && current!=predecesor[current])
            {
                System.out.print((current+1) + " from ");
                current=predecesor[current];
            }
        }
    }

    class AdjacencyGraph {
        ArrayList<Vertex> vertices;
        public AdjacencyGraph() {
            vertices=new ArrayList<Vertex>();
        }
        public void addvertex(Vertex v) {
            vertices.add(v);
        }

        public void newedge(Vertex from, Vertex to, int dist) {
            Edge newEdge=new Edge(from, to);
            newEdge.distance=dist;
        }

        // A utility function to print the adjacency list
        // representation of graph
        public void printGraph() {
            //Uncomment when above is made;
            Vertex currentv;

            for (int v = 0; v < vertices.size(); v++) {
                currentv = vertices.get(v);
                System.out.print("\n Edges from Vertex: " + currentv.Name );
                for (int e = 0; e < currentv.getoutEdges().size(); e++) {
                    System.out.print("  To  " + currentv.getoutEdges().get(e).getTovertex().Name);
                }
                System.out.println("\n");
            }
        }



    }


class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}