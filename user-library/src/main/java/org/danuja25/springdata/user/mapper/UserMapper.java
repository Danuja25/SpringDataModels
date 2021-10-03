package org.danuja25.springdata.user.mapper;

import org.danuja25.springdata.user.entity.UserEntity;
import org.danuja25.springdata.user.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends DirectMapper<User, UserEntity>{

}
