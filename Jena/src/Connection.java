import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;


public class Connection {

	private TripleStore store;
	
	/**
	 * eenamlige connectie naar de datbase
	 * @param query
	 * @param store
	 */
	public Connection(String query, TripleStore store) {
		query = "SELECT ?subject ?predicate ?object \n" + "WHERE { \n" + "?subject ?predicate ?object }";
		ResultSet rs = QueryExecutionFactory.sparqlService("http://localhost:3030/TestData/", query).execSelect();
		
		/**
		 * haal de gegevens uit elkaar
		 */
		while(rs.hasNext()) {
			//haal volgende resultaat op
			QuerySolution s = rs.nextSolution();
			
			//de gegevens voor in de tabel worden naar string omgezet
			String object = s.get("object").toString();
			String predicate = s.get("predicate").toString();
			String subject = s.get("subject").toString();
			
			//voeg toe aan de tabel
			store.addTriple(subject, predicate, object);
		}
	}
}
