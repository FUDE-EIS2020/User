package com.eis.fudeuser.repository;

import com.eis.fudeuser.entity.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long> {

    Broker findByName(String name);

    boolean existsByName(String name);
}
