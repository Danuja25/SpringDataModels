package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import static org.danuja25.springdata.user.UserConstant.SG_USER_TABLE_NAME;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    @Query("SELECT t FROM " + org.danuja25.springdata.UserConstant.USER_TABLE_NAME + " t where t.username = :username")
//    @Query(value = "SELECT * FROM " + org.danuja25.springdata.UserConstant.USER_TABLE_NAME + " t where t.username = ?0", nativeQuery=true)
//    String findUserByUsername(@Param("username") String username);

    UserEntity findByUsername(String username);

    @Query(value = "SELECT t FROM " + SG_USER_TABLE_NAME + " t where t.username = :username and t.password = :password")
    public UserEntity findByCredentials(@Param("username") String username, @Param("password") String password);

}
