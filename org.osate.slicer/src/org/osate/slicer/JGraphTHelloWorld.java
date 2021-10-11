package org.osate.slicer;

import java.net.URI;
import java.net.URISyntaxException;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class JGraphTHelloWorld {

	public void placeholderMethod() {
    Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

	try {
		URI google = new URI("http://www.google.com");
		URI wikipedia = new URI("http://www.wikipedia.org");
		URI jgrapht = new URI("http://www.jgrapht.org");

		// add the vertices
		g.addVertex(google);
		g.addVertex(wikipedia);
		g.addVertex(jgrapht);

		// add edges to create linking structure
		g.addEdge(jgrapht, wikipedia);
		g.addEdge(google, jgrapht);
		g.addEdge(google, wikipedia);
		g.addEdge(wikipedia, google);
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
