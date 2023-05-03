import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addEdge(String person1, String person2) {
        adjList.putIfAbsent(person1, new ArrayList<>());
        adjList.putIfAbsent(person2, new ArrayList<>());
        adjList.get(person1).add(person2);
        adjList.get(person2).add(person1);
    }

    public List<String> canDeliverLetter(String start, String end) {
        List<String> path = new ArrayList<>();
        dfs(start, end, new HashMap<>(), path);
        return path;
    }

    private boolean dfs(String current, String end, Map<String, Boolean> visited, List<String> path) {
        path.add(current);
        if (current.equals(end)) {
            return true;
        }
        visited.put(current, true);
        for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.getOrDefault(neighbor, false)) {
                if (dfs(neighbor, end, visited, path)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
