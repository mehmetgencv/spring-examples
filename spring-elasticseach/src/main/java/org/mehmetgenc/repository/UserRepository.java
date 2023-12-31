package org.mehmetgenc.repository;

import org.mehmetgenc.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    default void logExceptionInConstructor(Exception e) {
        // Log the exception details for further analysis
        e.printStackTrace();
    }
}