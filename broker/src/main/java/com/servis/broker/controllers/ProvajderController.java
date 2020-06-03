package com.servis.broker.controllers;

import com.servis.broker.model.Service1;
import com.servis.broker.service.ServiceImpl.CRUDService;
import com.servis.broker.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(Constants.PROVIDER)
public class ProvajderController {

    private final CRUDService crudService;

    @Autowired
    public ProvajderController(CRUDService crudService) {
        this.crudService = crudService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Service1>> getAll() {
        return new ResponseEntity<>(crudService.getServiceList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Service1> createNewService(@RequestBody Service1 service1){
        return new ResponseEntity<>(crudService.createNewService(service1), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "save/{id}")
    public ResponseEntity<Service1> updateService (@PathVariable Long id, @RequestBody Service1 service1){
        return new ResponseEntity<>(crudService.updateService(id, service1), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
    public ResponseEntity<Boolean> deleteOneById(@PathVariable Long id){
        return new ResponseEntity<>(crudService.deleteService(id), HttpStatus.OK);
    }

}
