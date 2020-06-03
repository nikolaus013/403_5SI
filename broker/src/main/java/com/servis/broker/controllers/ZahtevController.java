package com.servis.broker.controllers;

import com.servis.broker.model.Context;
import com.servis.broker.model.Endpoint;
import com.servis.broker.model.Service1;
import com.servis.broker.repositories.EndpointRepository;
import com.servis.broker.repositories.ServiceRpository;
import com.servis.broker.service.ServiceImpl.StateImpl;
import com.servis.broker.utils.Constants;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.ZAHTEV)
public class ZahtevController {


    private StateImpl state;
    private ServiceRpository serviceRpository;
    private EndpointRepository endpointRepository;










    @RequestMapping(path ="/{hostServisa}/{endpoint}/{body}")
    public void rutiranjeZahteva(@PathVariable("hostServisa") String nazivHosta,
                                 @PathVariable("endopoint") String endpoint,
                                 @PathVariable("body") JSONObject body) {

    Service1 service1;
    service1 = serviceRpository.findByHostServisa(nazivHosta);
    String novi="";
    String novi1="";
    int i;

    for( i=0;i<endpoint.length();i++){
        if(endpoint.charAt(i)=='?'){

            novi = endpoint.substring(0,i-1);

        }
        if(endpoint.charAt(i)=='='){
            novi1= endpoint.substring(i+1,endpoint.length());
        }

    }

    Endpoint ep1 = endpointRepository.findByNaziv(novi);
    Context c1 = new Context();
    c1.setEndpoint(ep1);
    c1.setParametar(novi1);
    c1.setService1(service1);
    c1.setBody(body);
    state.callService(c1);


    }
}
