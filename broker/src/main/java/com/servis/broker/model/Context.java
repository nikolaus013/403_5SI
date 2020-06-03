package com.servis.broker.model;

import lombok.Data;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.persistence.*;


@Data
public class Context {




    Service1 service1;

    Endpoint endpoint;

    String parametar;

    JSONObject body;

}
