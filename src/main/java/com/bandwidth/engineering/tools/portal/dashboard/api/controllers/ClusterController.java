package com.bandwidth.engineering.tools.portal.dashboard.api.controllers;

import com.bandwidth.engineering.tools.portal.dashboard.api.model.Cluster;
import com.bandwidth.engineering.tools.portal.dashboard.api.model.DataCenter;
import com.bandwidth.engineering.tools.portal.dashboard.api.repository.DatacenterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ClusterController {

    private DatacenterRepository datacenterRepository;
    public ClusterController(DatacenterRepository datacenterRepository) {
        this.datacenterRepository = datacenterRepository;
    }


    @GetMapping("api/clusters/{dataCenterValue}")
    public List<String> getClusters(@PathVariable("dataCenterValue") String dataCenterValue) {
     DataCenter dataCenter = datacenterRepository.findByName(dataCenterValue);
        List<String> clusters=DataCenter.getClusternames(dataCenter.getClusters());
        return clusters;
    }



}
