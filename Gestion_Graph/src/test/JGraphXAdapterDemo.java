package test;

import com.mxgraph.layout.*;
import com.mxgraph.swing.*;
import com.mxgraph.view.mxGraph;

import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;

import javax.swing.*;
import java.awt.*;

/**
 * A demo applet that shows how to use JGraphX to visualize JGraphT graphs. Applet based on
 * JGraphAdapterDemo.
 *
 */
public class JGraphXAdapterDemo
    extends
    JApplet
{
    private static final long serialVersionUID = 2202072534703043194L;

    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;

    /**
     * An alternative starting point for this demo, to also allow running this applet as an
     * application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void init()
    {
    	

    
        //--------------------------------------------
        mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, "v1", 20, 20, 30,30);
			Object v2 = graph.insertVertex(parent, null, "v2", 20, 20, 30,30);
			Object v3 = graph.insertVertex(parent, null, "v3", 20, 20, 30,30);
			Object v4 = graph.insertVertex(parent, null, "v4", 20, 20, 30,30);
			Object v5 = graph.insertVertex(parent, null, "v5", 20, 20, 30,30);
			Object v6 = graph.insertVertex(parent, null, "v6", 20, 20, 30,30);
			Object v7 = graph.insertVertex(parent, null, "v7", 20, 20, 30,30);
			Object v8 = graph.insertVertex(parent, null, "v8", 20, 20, 30,30);
			graph.insertEdge(parent, null, "Edge", v3, v4);
			graph.insertEdge(parent, null, "Edge",v1, v2);
			graph.insertEdge(parent, null, "Edge",v2, v3);
			graph.insertEdge(parent, null, "Edge",v3, v1);
			graph.insertEdge(parent, null, "Edge",v4, v3);
	        
			graph.insertEdge(parent, null, "Edge",v2, v1);
	        graph.insertEdge(parent, null, "Edge",v5, v6);
	        graph.insertEdge(parent, null, "Edge",v6, v7);
	        graph.insertEdge(parent, null, "Edge",v7, v5);
	        graph.insertEdge(parent, null, "Edge",v8, v7);
			
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
}
