import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Read people from file
        try{
            BufferedReader reader = new BufferedReader(new FileReader("people.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] splited = line.split("\\s+");
                graph.addEdge(splited[0], splited[1]);
                line = reader.readLine();
            }
            reader.close();
        }catch(IOException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }


        String source = "Dominykas";
        String destination = "Jogaila";
        List<String> hasPath = graph.canDeliverLetter(source, destination);
        if (!hasPath.isEmpty()) {
            System.out.println(source + " can deliver a letter to " + destination + " through friends.");
            System.out.println("Path: " + hasPath);
        } else {
            System.out.println(source + " can't deliver a letter to  " + destination + " through friends.");
        }
    }
}
