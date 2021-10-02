package org.danuja25.springdata.mapper;

import org.danuja25.springdata.entity.UserGroupEntity;
import org.danuja25.springdata.model.UserGroup;
import org.mapstruct.Mapper;

@Mapper
public interface UserGroupMapper extends DirectMapper<UserGroup, UserGroupEntity> {
}
