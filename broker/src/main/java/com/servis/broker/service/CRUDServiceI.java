package com.servis.broker.service;

import com.servis.broker.model.Endpoint;
import com.servis.broker.model.Service1;

import java.util.List;

public interface CRUDServiceI {

    List<Service1> getServiceList();
    Service1 getService(String host);
    Endpoint getEndpoint(String naziv);
    Service1 createNewService(Service1 service1);
    Boolean deleteService(Long id);
    Service1 updateService(Long id, Service1 service1);

}
