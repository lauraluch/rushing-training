package com.example.rushingtraining.persistence.utils;

import java.util.List;
import java.util.Optional;

public interface GenericDAO <T, K>{

    void save(T entidade);
    void update(T entidade);
    void saveOrUpdate(T entidade);
    void delete(K key);
    Optional<T> select(K key);
    List<T> selectAll();
}
