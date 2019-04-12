package pl.ave.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.ave.model.UserDetails;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDao {
    private EntityManager entityManager;

    @Autowired
    public UserDetailsDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public UserDetails get(Long id){
        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        return userDetails;
    }
}
