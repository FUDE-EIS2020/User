package com.eis.fudeuser.repository;

import com.eis.fudeuser.entity.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {

    Trader findByCompNameAndName(String compName, String name);

    boolean existsByCompNameAndName(String compName, String name);
}
