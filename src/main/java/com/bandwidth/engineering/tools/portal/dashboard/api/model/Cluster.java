package com.bandwidth.engineering.tools.portal.dashboard.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Cluster {


    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;


}
