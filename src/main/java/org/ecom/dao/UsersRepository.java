package org.ecom.dao;

import org.ecom.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Admin, String> {

}
