package org.danuja25.springdata.repository;

import org.danuja25.springdata.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {

    UserGroupEntity findByCode(String groupCode);
}
