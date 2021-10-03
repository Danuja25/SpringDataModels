package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    @Query("SELECT t FROM " + org.danuja25.springdata.UserConstant.USER_TABLE_NAME + " t where t.username = :username")
//    @Query(value = "SELECT * FROM " + org.danuja25.springdata.UserConstant.USER_TABLE_NAME + " t where t.username = ?0", nativeQuery=true)
//    String findUserByUsername(@Param("username") String username);

    UserEntity findByUsername(String username);

}
