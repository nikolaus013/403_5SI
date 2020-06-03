package com.trasnformator.transform.service;


import org.json.JSONObject;

public interface CRUD_Service {

    void createEntitet(String kolekcija);
    void saveEntitet(String kolekcija, JSONObject nazivEntiteta);
    void updateEntitet(String entitet);
    void  readEntitet(String entitet);
    void deleteEntitet(String kolekcija,JSONObject entitet);
}
