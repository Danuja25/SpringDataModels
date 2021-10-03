package org.danuja25.springdata.user.mapper;

import org.danuja25.springdata.user.entity.UserGroupEntity;
import org.danuja25.springdata.user.model.UserGroup;
import org.mapstruct.Mapper;

@Mapper
public interface UserGroupMapper extends DirectMapper<UserGroup, UserGroupEntity> {
}
