package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Role;
import com.SAFRAN.ESPS.Repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Role ajouterRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role modifierRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> listRole() {
        return roleRepository.findByEtatactive(true);
    }

    @Override
    public void supprimerById(Long id) {
        roleRepository.deleteById(id);
        
    }
    @Override
     public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    
 
}

