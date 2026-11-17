package com.klef.soa.endsemexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.endsemexam.entity.Tourist;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {

}