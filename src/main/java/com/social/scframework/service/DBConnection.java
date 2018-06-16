package com.social.scframework.service;

import com.mongodb.DB;
import com.mongodb.MongoClient;  
 


public class DBConnection { 
	static  MongoClient mongoClient = null;
	

	public DB getDB(String dbName){  
		try{  

			//---------- Connecting DataBase -------------------------//  
			System.out.println("mongoClient " + mongoClient);
			if(mongoClient == null ) {
				mongoClient = new MongoClient( "localhost" , 27017 ); ;
			}
			//---------- Creating DataBase ---------------------------//  
			DB db = mongoClient.getDB(dbName);  
			return db;

		}catch(Exception e){  
			System.out.println(e);  

		}
		return null;  
	}  
}  
