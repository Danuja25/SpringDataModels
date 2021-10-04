package org.danuja25.springdata.user.mapper;

import org.danuja25.springdata.user.entity.UserProfileEntity;
import org.danuja25.springdata.user.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper extends DirectMapper<UserProfile, UserProfileEntity> {
}
