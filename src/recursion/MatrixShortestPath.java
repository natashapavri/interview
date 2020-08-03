package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixShortestPath {

	public static void main(String[] args) {
		char[][] matrix = { { 'S', '0', '1', '1' }, { '1', '1', '0', '1' }, { '0', '1', '1', '1' },
				{ '1', '0', 'D', '1' } };

		int path = findShortestPath(matrix, 0, 0);
		System.out.println(path);
	}

	private static int findShortestPath(char[][] matrix, int i, int j) {
		MatrixNode source = new MatrixNode(i, j, 0);
		Queue<MatrixNode> queue = new LinkedList<MatrixNode>();
		queue.add(source);
		
		while(!queue.isEmpty()) 
		{
			MatrixNode node = queue.poll();
			if(matrix[node.getX()][node.getY()] == 'D') {
				return node.getDistance();
			}
			
			matrix[node.getX()][node.getY()] = '0';
			
			addNeighbors(queue, node, matrix);
		}
		
		return -1;
	}

	private static void addNeighbors(Queue<MatrixNode> queue, MatrixNode node, char[][]matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		if( (node.getY()+1) > 0 && (node.getY()+1) < m && matrix[node.getX()][node.getY() + 1] != '0') {
			MatrixNode nnode = new MatrixNode(node.getX(), node.getY()+1, node.getDistance() + 1);
			queue.add(nnode);
		}
		if((node.getY() -1) > 0 && (node.getY() -1) < m && matrix[node.getX()][node.getY() -1 ] != '0') {
			MatrixNode nnode = new MatrixNode(node.getX(), node.getY()-1, node.getDistance() + 1);
			queue.add(nnode);
		}
		if((node.getX()+1) > 0 && (node.getX()+1) < n && matrix[node.getX()+1][node.getY()] != '0') {
			MatrixNode nnode = new MatrixNode(node.getX() + 1, node.getY(), node.getDistance() + 1);
			queue.add(nnode);
		}
		if((node.getX()-1) > 0 && (node.getX()-1) < n && matrix[node.getX()-1][node.getY()] != '0') {
			MatrixNode nnode = new MatrixNode(node.getX() - 1, node.getY(), node.getDistance() + 1);
			queue.add(nnode);
		}
	}
	
	
}
class MatrixNode {
	private int x;
	private int y;
	private int distance;
	
	
	public MatrixNode(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
