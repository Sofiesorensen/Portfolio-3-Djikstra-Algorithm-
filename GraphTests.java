public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        Graph matrixGraph = new Graph(10);
        matrixGraph.addEdge(1,2, 10);
        matrixGraph.addEdge(1,4, 20);
        matrixGraph.addEdge(1,5, 20);
        matrixGraph.addEdge(1,6, 5);
        matrixGraph.addEdge(1,7, 15);
        matrixGraph.addEdge(1,8, 5);
        matrixGraph.addEdge(2,3, 15);
        matrixGraph.addEdge(2,4, 10);
        matrixGraph.addEdge(2,8, 20);
        matrixGraph.addEdge(2,9, 15);
        matrixGraph.addEdge(2,10, 5);
        matrixGraph.addEdge(3,2, 15);
        matrixGraph.addEdge(3,4, 5);
        matrixGraph.addEdge(3,10, 15);
        matrixGraph.addEdge(4,5, 10);
        matrixGraph.addEdge(5,6, 5);
        matrixGraph.addEdge(6,7, 10);
        matrixGraph.addEdge(7,8, 5);
        matrixGraph.addEdge(8,9, 20);
        matrixGraph.addEdge(9,10, 10);

        Graph.printGraph();
        System.out.println("Now we find the shortest path with Dijkstra");

        int[] path=matrixGraph.Dijkstra(1);

        System.out.println("The shortest path to " +1+ "It goes through nodes: ");

        matrixGraph.printPath(path,10);

        int[] BFSpath=matrixGraph.BFS(1);
        System.out.println(" \nWe will print the BFS bath from 1 to 10");

        matrixGraph.printPath(BFSpath, 10);

        AdjacencyGraph adjacencyGraph = new AdjacencyGraph();
        Vertex a=new Vertex("1");
        adjacencyGraph.addvertex(a);
        Vertex b=new Vertex("2");
        adjacencyGraph.addvertex(b);
        Vertex c=new Vertex("3");
        adjacencyGraph.addvertex(c);
        Vertex d=new Vertex("4");
        adjacencyGraph.addvertex(d);
        Vertex e=new Vertex("5");
        adjacencyGraph.addvertex(e);
        Vertex f=new Vertex("6");
        adjacencyGraph.addvertex(f);
        Vertex g=new Vertex("7");
        adjacencyGraph.addvertex(g);
        Vertex h=new Vertex("8");
        adjacencyGraph.addvertex(h);
        Vertex i=new Vertex("9");
        adjacencyGraph.addvertex(i);
        Vertex j=new Vertex("10");
        adjacencyGraph.addvertex(j);

        adjacencyGraph.newedge(a,b,11);
        adjacencyGraph.newedge(a,d,21);
        adjacencyGraph.newedge(a,e,21);
        adjacencyGraph.newedge(a,f,6);
        adjacencyGraph.newedge(a,g,16);
        adjacencyGraph.newedge(a,h,6);
        adjacencyGraph.newedge(b,c,16);
        adjacencyGraph.newedge(b,d,21);
        adjacencyGraph.newedge(b,h,21);
        adjacencyGraph.newedge(b,i,26);
        adjacencyGraph.newedge(b,j,16);//+j
        adjacencyGraph.newedge(c,b,27);
        adjacencyGraph.newedge(c,d,21);
        adjacencyGraph.newedge(c,j,31);
        adjacencyGraph.newedge(d,e,31);
        adjacencyGraph.newedge(e,f,26);
        adjacencyGraph.newedge(f,g,16);
        adjacencyGraph.newedge(g,h,21);
        adjacencyGraph.newedge(h,i,26);
        adjacencyGraph.newedge(i,j,36);
        adjacencyGraph.printGraph();

    }
}
