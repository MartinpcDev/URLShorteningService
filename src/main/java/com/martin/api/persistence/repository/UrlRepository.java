package com.martin.api.persistence.repository;

import com.martin.api.persistence.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

}
