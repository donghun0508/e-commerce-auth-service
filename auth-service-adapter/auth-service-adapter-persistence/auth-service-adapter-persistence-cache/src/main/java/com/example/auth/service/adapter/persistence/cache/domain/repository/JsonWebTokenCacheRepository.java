package com.example.auth.service.adapter.persistence.cache.domain.repository;

import com.example.auth.service.adapter.persistence.cache.domain.entity.JsonWebTokenCacheEntity;
import org.springframework.data.repository.CrudRepository;

public interface JsonWebTokenCacheRepository extends CrudRepository<JsonWebTokenCacheEntity, String> {
}
