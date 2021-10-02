package org.danuja25.springdata.mapper;

import org.danuja25.springdata.entity.UserEntity;
import org.danuja25.springdata.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends DirectMapper<User, UserEntity>{

}
