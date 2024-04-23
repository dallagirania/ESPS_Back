package com.SAFRAN.ESPS.Repository;


import com.SAFRAN.ESPS.Model.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   
    Role findIdById(long id);
    boolean existsById(long id);
    public List<Role> findByEtatactive(Boolean actif);
}
