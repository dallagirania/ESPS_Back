package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Document;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository < Document, Long> {
   
    Document findIdById(long id);
    boolean existsById(long id);
    public List< Document> findByEtatactive(Boolean actif);
    
}