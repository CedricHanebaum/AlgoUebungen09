package bellmanFord;


public class BellmanFord {

	public static void printBellmanFord(int startknoten, int[] kantenliste){
		int weight[] = new int[kantenliste[0] + 1];
		int predecessor[] = new int[kantenliste[0] + 1];
		
		for(int i = 1; i < kantenliste[0] + 1; ++i){
			if(i == startknoten){
				weight[i] = 0;
			} else {
				weight[i] = Integer.MAX_VALUE;
			}
			predecessor[i] = 0;
		}
		
		for(int i = 1; i < kantenliste[0] - 1; ++i){
			for(int j = 1; j < kantenliste.length; j += 3){
				int from = kantenliste[j];
				int to = kantenliste[j + 1];
				int cWeight = BellmanFord.getWeight(from, to, kantenliste);
				
				if(weight[from] + cWeight < weight[to]){
					weight[to] = weight[from] + cWeight;
					predecessor[to] = from;
				}
			}
		}
		
		System.out.println("Knoten\tDistanz\tVorgaenger");
		
		for(int i = 1; i < weight.length; ++i){
			System.out.print(i + "\t");
			System.out.print(weight[i] + "\t");
			System.out.println(predecessor[i]);
			
		}
		
		
	}
	
	private static int getWeight(int from, int to, int[] edgeList){
		if(from < 1 || from > edgeList[0]) throw new RuntimeException();
		if(to < 1 || to > edgeList[0]) throw new RuntimeException();
		
		for(int i = 1; i < edgeList.length; i += 3){
			if(edgeList[i] == from){
				if(edgeList[i + 1] == to){
					return edgeList[i + 2];
				}
			}
		}
		
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		int[] graph1 = {4, 1, 2, 2, 1, 4, 5, 2, 4, 1, 2, 3, 4, 3, 1, 1, 4, 3, 1};
		BellmanFord.printBellmanFord(1, graph1);
		
		System.out.println();
		System.out.println();
		
		int[] graph2 = {10, 1, 2, 30, 1, 3, 10, 2, 5, 15, 2, 8, 55, 3, 4, 5, 3, 9, 35, 4, 2, 10, 4, 5, 45, 4, 6, 10, 5, 3, 20, 5, 7, 15, 5, 9, 25, 6, 7, 5, 7, 10, 20, 8, 10, 15, 9, 8, 10, 9, 10, 30};
		BellmanFord.printBellmanFord(1, graph2);
	}
	
}
