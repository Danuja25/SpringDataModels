package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {

}
