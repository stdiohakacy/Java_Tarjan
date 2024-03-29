package ConnectedComponent.Tarjan;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		Vertex vertex6 = new Vertex("6");
		Vertex vertex7 = new Vertex("7");
		
		vertex1.addNeighbour(vertex5);
		
		vertex2.addNeighbour(vertex1);
		
		vertex3.addNeighbour(vertex2);
		
		vertex4.addNeighbour(vertex3);
		
		vertex5.addNeighbour(vertex2);
		
		vertex6.addNeighbour(vertex2);
		vertex6.addNeighbour(vertex5);
		
		vertex7.addNeighbour(vertex3);
		vertex7.addNeighbour(vertex6);
		
		List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);
		vertexList.add(vertex7);
		
		TarjanAlgorithm alg = new TarjanAlgorithm(vertexList);
		alg.runAlgorithm();
		alg.printComponents();
	}
}
