package com.bhx.chatgptsuggestion.persistence.repository;

import com.bhx.category.Category;
import com.bhx.category.persistence.entities.CategoryEntity;
import com.bhx.chatgptsuggestion.persistence.entities.ChatGPTSuggestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Repository
public interface ChatGPTSuggestionRepository extends MongoRepository<ChatGPTSuggestionEntity, String> {
}
