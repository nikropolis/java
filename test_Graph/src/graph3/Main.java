package graph3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.xml.transform.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class Main {

	public static void main(String[] args) {

		SimpleGraphView sgv = new SimpleGraphView(); // We create our graph in
														// here
		// The Layout<V, E> is parameterized by the vertex and edge types
		Layout<Integer, String> layout = new CircleLayout(sgv.g);
		layout.setSize(new Dimension(300, 300)); // sets the initial size of the
													// space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<Integer, String>(layout);
		vv.setPreferredSize(new Dimension(350, 350)); // Sets the viewing area
														// size
//		Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {
//			public Paint transform(Integer i) {
//				return Color.GREEN;
//			}
//		};
		// Set up a new stroke Transformer for the edges
		float dash[] = { 10.0f };
		final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash,
				0.0f);
//		Transformer<String, Stroke> edgeStrokeTransformer = new Transformer<String, Stroke>() {
//			public Stroke transform(String s) {
//				return edgeStroke;
//			}
//		};
//		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
//		vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		//vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.W);
		
		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

		// Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
		// // Add some vertices. From above we defined these to be type Integer.
		// g.addVertex((Integer)1);
		// g.addVertex((Integer)2);
		// g.addVertex((Integer)3);
		// // Add some edges. From above we defined these to be of type String
		// // Note that the default is for undirected edges.
		// g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes
		// primitives
		// g.addEdge("Edge-B", 2, 3);
		// // Let's see what we have. Note the nice output from the
		// // SparseMultigraph<V,E> toString() method
		// System.out.println("The graph g = " + g.toString());
		// // Note that we can use the same nodes and edges in two different
		// graphs.
		// Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
		// g2.addVertex((Integer)1);
		// g2.addVertex((Integer)2);
		// g2.addVertex((Integer)3);
		// g2.addEdge("Edge-A", 1,3);
		//// g2.addEdge("Edge-B", 2,3, EdgeType.DIRECTED);
		//// g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
		// g2.addEdge("Edge-P", 2,3); // A parallel edge
		// System.out.println("The graph g2 = " + g2.toString());
	}

}
