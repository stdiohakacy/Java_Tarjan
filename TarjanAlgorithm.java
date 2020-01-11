package ConnectedComponent.Tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
	private Stack<Vertex> stack;
	private List<Vertex> vertexList;
	private List<List<Vertex>> connectedComponentList;
	private int time = 0;
	private int count;

	public TarjanAlgorithm(List<Vertex> vertexList) {
		this.stack = new Stack<Vertex>();
		this.vertexList = vertexList;
		this.connectedComponentList = new ArrayList<>();
	}

	public void runAlgorithm() {
		for (Vertex vertex : vertexList) {
			if (!vertex.isVisited())
				dfs(vertex);
		}
	}

	public void dfs(Vertex vertex) {
		vertex.setLowLink(time++);
		vertex.setVisited(true);
		this.stack.add(vertex);
		boolean isComponentRoot = true;

		for (Vertex v : vertex.getNeighbourList()) {
			if (!v.isVisited()) {
				System.out.println("Recursively visit vertex " + v);
				dfs(v);
			}

			if (vertex.getLowLink() > v.getLowLink()) {
				vertex.setLowLink(v.getLowLink());
				isComponentRoot = false;
			}
		}

		if (isComponentRoot) {
			count++;
			System.out.println("Vertex " + vertex + " is the root of an SCC");
			List<Vertex> component = new ArrayList<Vertex>();
			while (true) {
				Vertex actualVertex = stack.pop();
				System.out.println("So vertex " + actualVertex + " is in SCC " + count);
				component.add(actualVertex);
				actualVertex.setLowLink(Integer.MAX_VALUE);

				if (actualVertex.getName().equals(vertex.getName()))
					break;
			}
			connectedComponentList.add(component);
		}

	}
	
	public void printComponents() {
		System.out.println(connectedComponentList);
	}
}
