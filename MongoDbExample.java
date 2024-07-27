package com.example.mongodb;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDbExample {

	    public static void main(String[] args) {
	        // Create a MongoClient instance
	        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

	        // Connect to the database
	        MongoDatabase database = mongoClient.getDatabase("TaskBoarddb");

	        // Access a collection
	        MongoCollection<Document> collection = database.getCollection("TaskBoard");

	        // Perform operations (e.g., find a document)
	        Document doc = collection.find().first();
	        System.out.println(doc.toJson());
	        
	        Document document = new Document()
	        	    .append("taskId", "1")
	        	    .append("date", ("2022-01-01"))
	        	    .append("taskType", "FEATURE");
	        	    // ...
	        	collection.insertOne(document);
	        	System.out.println("Document inserted: " + document);
	        	
	        	Document task = collection.find(Filters.eq("taskId", "1")).first();
	        	System.out.println(task.toJson());
	        	
	        	Bson filter = Filters.eq("taskId", "1");
	        	Document updatedDoc = collection.find(filter).first();
	        	System.out.println("Updated Document: " + updatedDoc.toJson());
	        	
	        	Document deletedDoc = collection.findOneAndDelete(Filters.eq("taskId", "1"));
	        	System.out.println("Deleted Document:" + deletedDoc.toJson());
	        	// Close the client
	        mongoClient.close();
	    }
	}
	
	


