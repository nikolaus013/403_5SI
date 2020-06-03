package com.trasnformator.transform.model;

import lombok.Data;
import org.json.JSONObject;

import javax.persistence.Id;


@Data
public class Dokument {
   @Id
   Long id;
   JSONObject doc;


}
