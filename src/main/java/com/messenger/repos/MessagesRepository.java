package com.messenger.repos;
import com.messenger.model.TextMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

// dependency injection spring
//auto wired // service // repository //rest controller // controller // component
@Repository
public interface MessagesRepository extends CrudRepository<TextMessage,UUID>{
}