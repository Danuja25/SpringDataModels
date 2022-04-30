package org.danuja25.springdata.user.repository;

import org.danuja25.springdata.user.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userProfiles", path = "userProfiles")
public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {

}
