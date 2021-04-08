
package test;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class HelloWorld extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
	public HelloWorld()
	{
		//super("Hello, World!");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);
			Object v3 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v4 = graph.insertVertex(parent, null, "World!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v3, v4);
			graph.insertEdge(parent, null, "Edge", v4, v3	);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		mxCircleLayout layout = new mxCircleLayout(graph);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);
        layout.execute(graph.getDefaultParent());
        new mxParallelEdgeLayout(graph).execute(graph.getDefaultParent());
	}

	public static void main(String[] args)
	{
		HelloWorld frame = new HelloWorld();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

}


