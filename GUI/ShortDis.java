package GUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;


class ShortDis{

    int vertices;
    int[][] matrix;

    ShortDis(int vertices) throws FileNotFoundException, IOException {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];


        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("information.txt"),StandardCharsets.UTF_8))){
                        String line;
                          while((line=br.readLine())!=null){
                            String[] split=line.split(",");
                        // System.out.println(split[0]);
                              //use the data here
                              int u = Integer.parseInt(split[0]);
                              int v = Integer.parseInt(split[1]);
                              int w = Integer.parseInt(split[2]);   
                              addEdge(u, v, w);
                        }
                    }   

    }


    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }

  
    public String dijkstra(int source, int destination) {

        int[] distance = new int[vertices];
        int[] prevPath = new int[vertices];
        boolean[] visited = new boolean[vertices];

        String message = "";

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }
        //Distance from source to source is zero
        distance[source] = 0;

        for (int i = 0; i < vertices; i++) {
            //Finding minimum vertex i.e vertex having minimum distance
            int u = findMinVertex(distance, visited);
            visited[u] = true;

            //Finding adjacent nodes of u
            for (int j = 0; j < vertices; j++) {
                if (matrix[u][j] != 0 && !visited[j]) {
                    int v = j;
                    int newDistance = distance[u] + matrix[u][j];
                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                        prevPath[v] = u;
                    }
                }
            }
        }

        //Printing distance
        message += "\nShortest distance from source(" + source + ") to destination(" + destination + ") is : " + distance[destination];

        //Printing the shortest path

        int[] shortestPath = new int[vertices];
        int vertex = destination;
        int count = 0;
        
        while (vertex != -1){
            shortestPath[count] = vertex;
            vertex = prevPath[vertex];
            count++;
        }
        
        message += "\nShortest path is : ";
        for (int i = count -1;  i>=0; i--){
            message += shortestPath[i] + " , ";
        }
        System.out.println();

        return message;
    }

    public int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {

            if ((minVertex == -1 || distance[minVertex] > distance[i]) & !visited[i]) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}

