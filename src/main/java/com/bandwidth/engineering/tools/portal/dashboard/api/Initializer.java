package com.bandwidth.engineering.tools.portal.dashboard.api;



import com.bandwidth.engineering.tools.portal.dashboard.api.model.Cluster;
import com.bandwidth.engineering.tools.portal.dashboard.api.model.DataCenter;
import com.bandwidth.engineering.tools.portal.dashboard.api.repository.DatacenterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

//Manual database initialization
@Component
class Initializer implements CommandLineRunner {

    private final DatacenterRepository repository;

    public Initializer(DatacenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {



        Stream.of("lab", "atl", "rdu").forEach(name ->
                repository.save(new DataCenter(name))
        );
        DataCenter lab = repository.findByName("lab");
        Cluster labGeneric = new Cluster("connect-generic");
        Cluster labReplicator=new Cluster("connect-replicator");
        Cluster labReplicatorCCC=new Cluster("connect-replicator-ccc");
        Cluster labAws=new Cluster("connect-aws-mks-billing");
        List<Cluster> labClusters=new ArrayList<Cluster>(){{
            add(labGeneric);
            add(labReplicator);
            add(labReplicatorCCC);
            add(labAws);
        }};
        lab.setClusters(labClusters);
        repository.save(lab);


        DataCenter rdu = repository.findByName("rdu");
        Cluster rduGeneric = new Cluster("connect-generic");
        Cluster rduReplicator=new Cluster("connect-replicator");
        Cluster rduReplicatorCCC=new Cluster("connect-replicator-ccc");
        Cluster rduAws=new Cluster("connect-aws-mks-billing");
        List<Cluster> rduClusters=new ArrayList<Cluster>(){{
            add(rduGeneric);
            add(rduReplicator);
            add(rduReplicatorCCC);
            add(rduAws);
        }};
        rdu.setClusters(rduClusters);
        repository.save(rdu);

        DataCenter atl = repository.findByName("atl");
        Cluster atlGeneric = new Cluster("connect-generic");
        Cluster atlReplicator=new Cluster("connect-replicator");
        Cluster atlReplicatorCCC=new Cluster("connect-replicator-ccc");
        Cluster atlAws=new Cluster("connect-aws-mks-billing");
        List<Cluster> atlClusters=new ArrayList<Cluster>(){{
            add(atlGeneric);
            add(atlReplicator);
            add(atlReplicatorCCC);
            add(atlAws);
        }};
        atl.setClusters(atlClusters);
        repository.save(atl);

    }

}
