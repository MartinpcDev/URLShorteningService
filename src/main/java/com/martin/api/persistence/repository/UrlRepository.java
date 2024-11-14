package com.martin.api.persistence.repository;

import com.martin.api.persistence.model.Url;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

  Optional<Url> findByShortCode(String shortCode);
}
