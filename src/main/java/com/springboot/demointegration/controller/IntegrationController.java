package com.springboot.demointegration.controller;


import com.springboot.demointegration.model.Alumno;
import com.springboot.demointegration.model.Escuela;
import com.springboot.demointegration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integrate")
@CrossOrigin("*")
public class IntegrationController {

    @Autowired
    private IntegrationGateway integrationGateway;

    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
      //  return integrationGateway.sendMessage(name);
        return null;
    }


    @PostMapping("/student")
    public void processStudentDetails(@RequestBody Alumno alumno){
       // return integrationGateway.processStudentDetails(student);
        integrationGateway.process(alumno);
    }

    @PostMapping("/school")
    public void processAddressDetails(@RequestBody Escuela escuela){
        integrationGateway.process(escuela);
    }
}
