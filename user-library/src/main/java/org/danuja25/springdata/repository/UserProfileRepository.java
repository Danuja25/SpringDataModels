package org.danuja25.springdata.repository;

import org.danuja25.springdata.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {

}
