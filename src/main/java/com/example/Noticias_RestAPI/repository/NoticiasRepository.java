package com.example.Noticias_RestAPI.repository;

import org.springframework.stereotype.Repository;
import com.example.Noticias_RestAPI.model.NoticiasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface NoticiasRepository extends MongoRepository<NoticiasEntity, String>{
}






