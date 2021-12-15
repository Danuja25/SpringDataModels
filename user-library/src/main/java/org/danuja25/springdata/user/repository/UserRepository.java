package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static org.danuja25.springdata.user.UserConstant.SG_USER_TABLE_NAME;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);


}
