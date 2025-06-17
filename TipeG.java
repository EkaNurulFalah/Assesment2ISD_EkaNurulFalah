
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TipeG {

    Map<String, Integer> resepToIndex = new HashMap<>();
    List<String> indexKeResep = new ArrayList<>();
    List<LinkedList<String>> adjListArray = new ArrayList<>();

    public void addResep(String resep) {
        if (!resepToIndex.containsKey(resep)) {
            resepToIndex.put(resep, indexKeResep.size());
            indexKeResep.add(resep);
            adjListArray.add(new LinkedList<>());
        }
    }

    public void addEdge(String src, String dest) {
        addResep(src);
        addResep(dest);
        int srcIndex = resepToIndex.get(src);
        adjListArray.get(srcIndex).add(dest);
    }

    public void bfs(String start) {
        boolean[] visited = new boolean[indexKeResep.size()];
        Queue<String> queue = new LinkedList<>();
        visited[resepToIndex.get(start)] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");
            for (String neighbor : adjListArray.get(resepToIndex.get(node))) {
                if (!visited[resepToIndex.get(neighbor)]) {
                    visited[resepToIndex.get(neighbor)] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(String start) {
        boolean[] visited = new boolean[indexKeResep.size()];
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited[resepToIndex.get(node)]) {
                visited[resepToIndex.get(node)] = true;
                System.out.print(node + " ");
                for (String neighbor : adjListArray.get(resepToIndex.get(node))) {
                    if (!visited[resepToIndex.get(neighbor)]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
