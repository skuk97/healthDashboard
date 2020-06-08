package com.bandwidth.engineering.tools.portal.dashboard.api.controllers;

import com.bandwidth.engineering.tools.portal.dashboard.api.service.ConnectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorController {

   private  ConnectorService  connectorService;

    public ConnectorController(final ConnectorService connectorService) {
        this.connectorService = connectorService;
    }


    @GetMapping("api/clusters/{dataCenterValue}/{clusterValue}")
    public String getConnectors(@PathVariable("dataCenterValue") String dataCenterValue, @PathVariable("clusterValue") String clusterValue) {


        return  connectorService.getConnectors(dataCenterValue,clusterValue);
    }



}
