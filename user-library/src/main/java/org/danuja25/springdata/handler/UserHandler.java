package org.danuja25.springdata.handler;

import org.danuja25.springdata.entity.UserEntity;
import org.danuja25.springdata.entity.UserGroupEntity;
import org.danuja25.springdata.mapper.UserGroupMapper;
import org.danuja25.springdata.mapper.UserMapper;
import org.danuja25.springdata.model.User;
import org.danuja25.springdata.model.UserGroup;
import org.danuja25.springdata.repository.UserGroupRepository;
import org.danuja25.springdata.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserHandler
{
    private UserRepository userRepository;
    private UserGroupRepository userGroupRepository;
    private UserMapper userMapper;
    private UserGroupMapper userGroupMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserHandler( UserRepository userRepository, UserGroupRepository userGroupRepository, BCryptPasswordEncoder bCryptPasswordEncoder )
    {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = Mappers.getMapper( UserMapper.class );
        this.userGroupMapper = Mappers.getMapper( UserGroupMapper.class );
    }

    public User getUser( String userName )
    {
        UserEntity userEntity = userRepository.findByUsername( userName );
        return userMapper.daoToDto( userEntity );
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll()
                .stream()
                .map( userMapper::daoToDto )
                .collect( Collectors.toList() );
    }

    public void addUser( User user )
    {
        user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
        userRepository.save( userMapper.dtoToDao( user ) );
    }

    public UserGroup getUserGroup(String groupCode )
    {
        UserGroupEntity userGroupEntity = userGroupRepository.findByCode( groupCode );
        return userGroupMapper.daoToDto( userGroupEntity );
    }

    public List<UserGroup> getAllUserGroups()
    {
        return userGroupRepository.findAll()
                .stream()
                .map( userGroupMapper::daoToDto )
                .collect( Collectors.toList() );
    }

    public void addUserGroup( UserGroup userGroup )
    {
        userGroupRepository.save( userGroupMapper.dtoToDao( userGroup ) );
    }

    public void addUserGroupToUser( String userName, String groupCode )
    {
        UserEntity userEntity = userRepository.findByUsername( userName );
        UserGroupEntity userGroupEntity = userGroupRepository.findByCode( groupCode );

        userEntity.getUserGroups().add( userGroupEntity );
        userRepository.save( userEntity );
    }

    public void updateUser( User user )
    {
        userRepository.save( userMapper.dtoToDao( user ) );
    }

}
