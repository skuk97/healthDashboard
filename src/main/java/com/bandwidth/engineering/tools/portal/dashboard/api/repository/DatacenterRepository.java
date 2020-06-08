package com.bandwidth.engineering.tools.portal.dashboard.api.repository;
import com.bandwidth.engineering.tools.portal.dashboard.api.model.DataCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatacenterRepository extends JpaRepository<DataCenter,Long>{
    DataCenter findByName(String name);
}
