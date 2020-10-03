package com.demo.biozid.repos;

import com.demo.biozid.models.Location;
import com.demo.biozid.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long > {

}