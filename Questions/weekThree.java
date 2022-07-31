package Questions;

class weekThree {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited=new boolean[points.length];
        Node[] nodes=new Node[points.length];
        int ans=0;
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            nodes[i]=new Node(point[0], point[1], Integer.MAX_VALUE);
        }
        nodes[0].dist=0;

        int numNodes=points.length;
        while(numNodes>0){
            numNodes--;
            int minIndex=findNextNode(nodes, visited);
            ans+=nodes[minIndex].dist;
            visited[minIndex]=true;
            updateDistToAllNodes(nodes, minIndex, visited);
        }
        return ans;
    }

    public void updateDistToAllNodes(Node[] nodes, int index, boolean[] visited){
        int x=nodes[index].x;
        int y=nodes[index].y;
        // traverses each node and estimates their distance
        for(int i=0;i<nodes.length;i++){
            if(!visited[i]){
                int newDist=Math.abs(nodes[i].x-x)+Math.abs(nodes[i].y-y);
                nodes[i].dist=Math.min(nodes[i].dist, newDist);
                // distance between nodes that have not been visited is estimated and updated.
            }
        }
    }

    //detects the subsequent node to be visited
    public int findNextNode(Node[] nodes, boolean[] visited){
        int min=Integer.MAX_VALUE;
        int ans=-1;
        //iterates over every node and finds the node with the shortest distance
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].dist<min && !visited[i]){
                min=nodes[i].dist;
                ans=i;
            }
        }
        return ans;
    }

    class Node{
        int x, y;
        int dist;
        Node(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
     public static void main(String[] args) {
        weekThree q=new weekThree();
        int[][] points={{0,0},{2,2},{3,10},{4,4},{5,2},{7,0}};

        System.out.println("\n"+"Minimum distance to connect all points is==>"+q.minCostConnectPoints(points));
    }

}

