package graph3;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class SimpleGraphView {
	public Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
	public Graph<String, String> g2 = new SparseMultigraph<String, String>();
	
	public SimpleGraphView(){
		
		g.addVertex((Integer)1);
		g.addVertex((Integer)2);
		g.addVertex((Integer)3);
		g.addVertex((Integer)4);
		g.addVertex((Integer)5);
		g.addEdge("Edge-A",1,2);
		g.addEdge("Edge-B",3,4);
//
		g2.addVertex("home");
//		g2.addVertex((Integer)2);
//		g2.addVertex((Integer)3);
//		g2.addEdge("Edge-A",1,3);
//		
//		g2.addEdge("Edge-P",2,3);
	}

}
