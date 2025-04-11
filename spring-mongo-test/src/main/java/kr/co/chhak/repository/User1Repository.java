package kr.co.chhak.repository;

import kr.co.chhak.document.User1Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User1Repository extends MongoRepository<User1Document, String> {

    public Optional<User1Document> findByUid(String uid);
    public void deleteByUid(String uid);
    public boolean existsByUid(String uid);
    
}
