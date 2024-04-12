package com.career.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.career.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
}
