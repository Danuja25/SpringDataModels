package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userGroups", path = "userGroups")
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {

    UserGroupEntity findByCode(String groupCode);
}
