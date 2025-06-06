package com.shopnest.shopnest.users.repository;

import com.shopnest.shopnest.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {

}
