package com.servis.broker.service.ServiceImpl;

import com.servis.broker.model.Context;
import com.servis.broker.model.Service1;
import com.servis.broker.model.ServiceRequest;
import com.servis.broker.service.State;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class StateImpl implements State {

    private final CRUDService crudService;

    public StateImpl(CRUDService crudService) {

        this.crudService = crudService;
    }


    @Override
    public Context callService(Context context) {

        String Uri_final  = context.getService1().getHostServisa() + '/' + context.getEndpoint().getNaziv() + '/' + context.getParametar();
        RestTemplate restTemplate = new RestTemplate();
        String Uri  = "localhost:8080" + '/' + context.getEndpoint().getNaziv() + '/' + context.getParametar();
        JSONObject jsonString = restTemplate.getForObject(Uri, JSONObject.class);
        context.setBody(jsonString);

        String temp_uri =    "localhost:8081" + '/' + context.getEndpoint().getNaziv() + '/' + context.getParametar();
        restTemplate.postForObject(temp_uri,context,Context.class);

        return restTemplate.postForObject(Uri_final,context,Context.class);


    }
}
