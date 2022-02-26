package main.java.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*

https://leetcode.com/problems/shortest-path-visiting-all-nodes/

You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
Return the length of the shortest path that visits every node. You may start and stop at any node,
you may revisit nodes multiple times, and you may reuse edges.

Example 1:
Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]

Example 2:
Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]

Constraints:
n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.
 */
public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int[][] graph1 = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph2 = new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.print(new ShortestPathInUndirectedGraph().shortestPathLength(graph1));
        System.out.print(new ShortestPathInUndirectedGraph().shortestPathLength(graph2));
    }

    // online solution: https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/549233/Breadth-First-Search(BFS)with-intuitive-approach-Thinking-process-or-13-ms

    public int shortestPathLength(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = graph.length;

        // preparing adjancy list
        for (int i = 0; i < n; i++) {
            // putting node
            if (!map.containsKey(i)) map.put(i, new ArrayList<>());
            //putting adjacent nodes to the map
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        //dist 2d array
        //row: bitmask -> visited node set bits are 1
        //column: leading node
        int row = (int) Math.pow(2, n);
        int[][] dist = new int[row][n];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], -1);
        }

        //Queue: [{leading node 1, mask},{leading node 2, mask} ... ]
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            // lead is i
            queue.add(new int[]{i, mask});
            dist[mask][i] = 0;
        }

        // Applying simulatneous BFS
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] path = queue.remove();
                int lead = path[0];
                int mask = path[1];
                if (mask == row - 1) {   //all nodes visited
                    return dist[mask][lead];
                }
                // iterate over neighbours of lead
                if (map.containsKey(lead)) {
                    for (int child : map.get(lead)) {
                        int newmask = mask | (1 << child);
                        // avoid cycle: intelligent bfs : checking if this set is already visited
                        // set : lead, mask(visited nodes)
                        if (dist[newmask][child] != -1) {
                            continue;
                        }
                        dist[newmask][child] = dist[mask][lead] + 1;
                        queue.add(new int[]{child, newmask});
                    }
                }
            }
        }
        return 0;
    }
}
