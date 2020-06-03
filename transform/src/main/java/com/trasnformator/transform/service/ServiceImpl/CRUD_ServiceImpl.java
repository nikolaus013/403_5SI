package com.trasnformator.transform.service.ServiceImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import com.trasnformator.transform.service.CRUD_Service;

import org.json.JSONObject;


public class CRUD_ServiceImpl implements CRUD_Service {
    DB db;

    @Override
    public void createEntitet(String kolekcija) {
        db.createCollection(kolekcija,null);


    }

    @Override
    public void saveEntitet(String kolekcija, JSONObject nazivEntiteta) {
        DBCollection collection = db.getCollection(kolekcija);

      if  (db.collectionExists(kolekcija)){

         collection.insert((DBObject) nazivEntiteta);

        }
    }

    @Override
    public void updateEntitet(String entitet) {
        BasicDBObject query = new BasicDBObject();

    }

    @Override
    public void readEntitet(String entitet) {

    }

    @Override
    public void deleteEntitet(String kolekcija,JSONObject entitet) {
        DBCollection collection = db.getCollection(kolekcija);

        collection.remove((DBObject) entitet);
    }

/*
    //insert into collection

    DBObject dbObject = (DBObject)JSON.parse(json);

collection.insert(dbObject);

//delete

    DBObject dbObject = (DBObject)JSON.parse(json);

collection.remove(dbObject);

//update

    //izvuci iz jsona sta menjamo i staviti u query
    BasicDBObject query = new BasicDBObject();
query.put("name", "Shubham");

    //sa cim to menjamo
    DBObject dbObject = (DBObject)JSON.parse(json);

collection.update(query, dbObject);
*/

}
