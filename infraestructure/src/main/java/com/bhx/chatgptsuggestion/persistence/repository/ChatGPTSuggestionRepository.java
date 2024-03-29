package com.bhx.chatgptsuggestion.persistence.repository;

import com.bhx.category.Category;
import com.bhx.category.persistence.entities.CategoryEntity;
import com.bhx.chatgptsuggestion.persistence.entities.ChatGPTSuggestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Repository
public interface ChatGPTSuggestionRepository extends MongoRepository<ChatGPTSuggestionEntity, String> {
    /**
     * Retrieves a collection of chat suggestions by the type name.
     *
     * @param typeName the type name to search for
     * @return a collection of chat suggestions matching the type name
     */
    @Query("{'typeMessage' : ?0}")
    Collection<ChatGPTSuggestionEntity> findByTypeName(String typeName);
}
