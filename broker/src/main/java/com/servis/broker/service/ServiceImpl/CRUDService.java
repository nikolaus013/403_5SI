package com.servis.broker.service.ServiceImpl;


import com.servis.broker.model.Endpoint;
import com.servis.broker.model.Service1;
import com.servis.broker.repositories.EndpointRepository;
import com.servis.broker.repositories.ServiceRpository;
import com.servis.broker.service.CRUDServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CRUDService implements CRUDServiceI {

    private final ServiceRpository serviceRepository;
    private final EndpointRepository endpointRepository;

    @Autowired
    public CRUDService(ServiceRpository serviceRepository, EndpointRepository endpointRepository) {
        this.serviceRepository = serviceRepository;

        this.endpointRepository = endpointRepository;
    }

    @Override
    public List<Service1> getServiceList() {
        return serviceRepository.findAll();
    }

    @Override
    public Service1 getService(String host) {
        Service1 service1 = serviceRepository.findByHostServisa(host);
        return service1;
    }

    @Override
    public Endpoint getEndpoint(String naziv) {
        Endpoint endpoint = endpointRepository.findByNaziv(naziv);
        return endpoint;
    }




    @Override
    public Service1 createNewService(Service1 service1) {
        return null;
    }

    @Override
    public Boolean deleteService(Long id) {
        Optional<Service1> toDelete = serviceRepository.findById(id);


        if(!toDelete.isPresent())
            return false;

        serviceRepository.deleteById(id);
        return true;
    }

    @Override
    public Service1 updateService(Long id, Service1 service1) {
        service1.setId(id);
        return saveAndReturnDTO(service1);
    }

    private Service1 saveAndReturnDTO(Service1 service1){

        serviceRepository.save(service1);
        return service1;

    }
}
