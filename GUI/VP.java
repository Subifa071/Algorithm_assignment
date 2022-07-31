package GUI;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;

public class VP {
    
     int V; // No. of vertices
 
     LinkedList<Integer> adjacent[];

    VP(int v) throws FileNotFoundException, IOException
    {
        V = v;
        adjacent = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacent[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adjacent[v].add(w);
    }
 
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjacent[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal
    void DFS(int v)
    {
        // Marks all the vertices as not visited
        boolean visited[] = new boolean[V];
 
        // recursive function to call dfs
        DFSUtil(v, visited);
    }
 
    // Driver Code
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        VP g = new VP(6);

        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("information.txt"),StandardCharsets.UTF_8))){
            String line;
              while((line=br.readLine())!=null){
                String[] split=line.split(",");
            // System.out.println(split[0]);
                  //use the data here
                  int u = Integer.parseInt(split[0]);
                  int v = Integer.parseInt(split[1]);
 
                  g.addEdge(u, v);
            }
        }   

        g.DFS(4);
    }

}

