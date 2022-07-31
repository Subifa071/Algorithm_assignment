package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MST {
    int vertices;
    Edge edges[];
    MST(int vertices){
        this.vertices=vertices;
        edges=new Edge[vertices];
}
    
    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
}
    @Override
    public int compareTo(Edge o) {
        return this.w-o.w;
    }
}
    int indx=-1;
    void addEdge(int u, int v, int w){
    edges[++indx]=new Edge(u, v, w);
    }


    void  PipelinePlacing(){

        int mst[][]=new int[vertices][vertices];
   // Edge mst[]=new Edge[vertices];
        int edgecounter=-1;
        int edgeTaken=1;
        Arrays.sort(edges);

        int parent[]=new int[vertices];
        int size[]=new int[vertices];

        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }

        while(edgeTaken<=vertices-1){
            Edge e=edges[++edgecounter];
            if(find(e.u, parent, size)==find(e.v, parent, size)){
                System.out.println("Cycle is detected");
                // JOptionPane.showMessageDialog(f,"Invalid Password!");
                continue;
        }
        mst[e.u][e.v]=e.w;
        mst[e.v][e.u]=e.w;

        union(e.u, e.v, parent, size);
    edgeTaken++;
    }
  
}

    void union(int uroot, int vroot,int parent[],int size[]){

        if(size[uroot]>size[vroot]){
            parent[vroot]=uroot;
        }
       else if(size[uroot]<size[vroot]){
            parent[uroot]=vroot;
        }
        else{
            parent[uroot]=vroot;
            size[vroot]++;
        }
    }


    int find(int u,int parent[],int size[]){
        if(parent[u]==-1){
            return u;
        }
       return  parent[u]=find(parent[u],parent,size);
    }

    public int totalHouses(){
        File file = new File("information.txt");
        List<String> list = new ArrayList<>();
        if(file.exists()){
    try {
        list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    }
    return list.size();
    }
    public static void main(String[] args) throws IOException{      
        File file = new File("information.txt");
        List<String> list = new ArrayList<>();
        if(file.exists()){
    try {
        list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
        MST g=new MST(list.size());
        ShortDis sd = new ShortDis(list.size());
 
       // String line;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("information.txt"),StandardCharsets.UTF_8))){
            String line;
              while((line=br.readLine())!=null){
                FileWriter fr;
                List<String> infoList = new ArrayList<>();
                File info = new File("connection.txt");
                String[] split=line.split(",");
                  int u = Integer.parseInt(split[0]);
                  int v = Integer.parseInt(split[1]);
                  int w = Integer.parseInt(split[2]);   
                  g.addEdge(u, v, w);
                  
                //   System.out.println("source :"+u+" is connected to==> destination: "+v);   
                  String con = u+"  is connected to "+v+" and its weight is: "+w+"\n";
                  System.out.println(con);
                    infoList.add(con);
                    fr = new FileWriter(info, true);
                    fr.write(con);
                    fr.close();

            }
            
        }
}

}