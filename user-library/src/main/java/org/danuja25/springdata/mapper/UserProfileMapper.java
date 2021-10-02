package org.danuja25.springdata.mapper;

import org.danuja25.springdata.entity.UserProfileEntity;
import org.danuja25.springdata.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper extends DirectMapper<UserProfile, UserProfileEntity> {
}
