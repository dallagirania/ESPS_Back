package com.SAFRAN.ESPS.Service;


import com.SAFRAN.ESPS.Model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role ajouterRole(Role role);
    Role modifierRole(Role role);
    List<Role> listRole();
    void supprimerById(Long id);
    Optional<Role> getRoleById(Long id);
}
