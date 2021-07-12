package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCostSearchAlgo {

	public static void main(String[] args) {
		Node n1 = new Node("Arad");
		Node n2 = new Node("Zerind");
		Node n3 = new Node("Oradea");
		Node n4 = new Node("Sibiu");
		Node n5 = new Node("Fagaras");
		Node n6 = new Node("Rimnicu Vilcea");
		Node n7 = new Node("Pitesti");
		Node n8 = new Node("Timisoara");
		Node n9 = new Node("Lugoj");
		Node n10 = new Node("Mehadia");
		Node n11 = new Node("Drobeta");
		Node n12 = new Node("Craiova");
		Node n13 = new Node("Bucharest");
		Node n14 = new Node("Giurgiu");

// initialize the edges
		n1.adjacencies = new Edge[] { new Edge(n2, 75), new Edge(n4, 140), new Edge(n8, 118) };

		n2.adjacencies = new Edge[] { new Edge(n1, 75), new Edge(n3, 71) };

		n3.adjacencies = new Edge[] { new Edge(n2, 71), new Edge(n4, 151) };

		n4.adjacencies = new Edge[] { new Edge(n1, 140), new Edge(n5, 99), new Edge(n3, 151), new Edge(n6, 80), };

		n5.adjacencies = new Edge[] { new Edge(n4, 99), new Edge(n13, 211) };

		n6.adjacencies = new Edge[] { new Edge(n4, 80), new Edge(n7, 97), new Edge(n12, 146) };

		n7.adjacencies = new Edge[] { new Edge(n6, 97), new Edge(n13, 101), new Edge(n12, 138) };

		n8.adjacencies = new Edge[] { new Edge(n1, 118), new Edge(n9, 111) };

		n9.adjacencies = new Edge[] { new Edge(n8, 111), new Edge(n10, 70) };

		n10.adjacencies = new Edge[] { new Edge(n9, 70), new Edge(n11, 75) };

		n11.adjacencies = new Edge[] { new Edge(n10, 75), new Edge(n12, 120) };

		n12.adjacencies = new Edge[] { new Edge(n11, 120), new Edge(n6, 146), new Edge(n7, 138) };

		n13.adjacencies = new Edge[] { new Edge(n7, 101), new Edge(n14, 90), new Edge(n5, 211) };

		n14.adjacencies = new Edge[] { new Edge(n13, 90) };

		UniformCostSearch(n1, n13);

		List<Node> path = printPath(n13);

//		System.out.println("Path: " + path);
//		System.out.println(path);
		System.out.println(path.get(0));

	}

	public static void UniformCostSearch(Node source, Node goal) {

		List<Node> list = new ArrayList<Node>();
		source.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {

			// override compare method
			public int compare(Node i, Node j) {
				if ((i.pathCost > j.pathCost)) {
					return 1;
				}

				else if (i.pathCost < j.pathCost) {
					return -1;
				}

				else {
					return 0;
				}
			}
		}

		);

		queue.add(source);
		Set<Node> explored = new HashSet<Node>();
		List<Node> path = new ArrayList<Node>();

// while frontier is not empty
		do {

			path.clear();
			Node current = queue.poll();
			explored.add(current);
			for (Node node = current; node != null; node = node.parent) {
				path.add(node);
			}
			if (current.value.equals(goal.value)) {
				goal.parent = current.parent;
				goal.pathCost = current.pathCost;
				break;

			}

			for (Edge e : current.adjacencies) {
				Node child = e.target;
				double cost = e.cost;
				if ((queue.contains(child) || explored.contains(child)) && !path.contains(child)) {
					Node n = new Node(child);
					list.add(n);
					list.get(list.size() - 1).pathCost = current.pathCost + cost;
					list.get(list.size() - 1).parent = current;
					queue.add(list.get(list.size() - 1));
				} else if (!path.contains(child)) {
					child.pathCost = current.pathCost + cost;
					child.parent = current;
					queue.add(child);
				}

			}
		} while (!queue.isEmpty());

	}

	public static List<Node> printPath(Node target) {
		List<Node> path = new ArrayList<Node>();
		for (Node node = target; node != null; node = node.parent) {
			path.add(node);
		}

		Collections.reverse(path);

		return path;

	}
}

class Node {
	public final String value;
	public double pathCost;
	public Edge[] adjacencies;
	public Node parent;

	public Node(String val) {

		value = val;

	}

	public Node(Node node) {
		int i = 0;
		adjacencies = new Edge[node.adjacencies.length];
		value = node.value;
		pathCost = node.pathCost;
		for (Edge e : node.adjacencies) {
			adjacencies[i++] = e;
		}
		parent = node.parent;
	}

	public String toString() {
		return value;
	}

}

class Edge {
	public final double cost;
	public final Node target;

	public Edge(Node targetNode, double costVal) {
		cost = costVal;
		target = targetNode;

	}

}