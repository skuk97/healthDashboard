package com.bandwidth.engineering.tools.portal.dashboard.api.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class DataCenter {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Cluster> clusters;

    public static List<String> getClusternames(List<Cluster> clusters){

        ArrayList<String>clusternames=new ArrayList<String>();
        for(Cluster cluster:clusters){
            clusternames.add(cluster.getName());
        }


        return clusternames;

    }


}
