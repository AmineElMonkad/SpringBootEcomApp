package org.ecom.dao;

import org.ecom.entities.Admin;
import org.ecom.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}
