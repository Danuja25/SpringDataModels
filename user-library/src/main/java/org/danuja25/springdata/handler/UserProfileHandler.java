package org.danuja25.springdata.handler;

import org.danuja25.springdata.entity.UserProfileEntity;
import org.danuja25.springdata.mapper.UserProfileMapper;
import org.danuja25.springdata.model.UserProfile;
import org.danuja25.springdata.repository.UserProfileRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileHandler {

    private UserProfileRepository userProfileRepository;
    private UserProfileMapper userProfileMapper;

    public UserProfileHandler(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = Mappers.getMapper(UserProfileMapper.class);
    }

    public List<UserProfile> getUserProfiles()
    {
        return userProfileRepository.findAll().stream().map(userProfileMapper::daoToDto).collect(Collectors.toList());
    }

    public UserProfile getUserProfile( String userName )
    {
        return userProfileMapper.daoToDto(userProfileRepository.findAll().stream().filter( p-> p.getUser().getUsername().equals(userName)).findFirst().get());
    }

    public void addUserProfile( UserProfile userProfile )
    {
        userProfileRepository.save( userProfileMapper.dtoToDao( userProfile ) );
    }

    public void updateUserProfile( UserProfile userProfile )
    {
        userProfileRepository.save( userProfileMapper.dtoToDao( userProfile ) );
    }

    public void deleteUserProfile( String userName )
    {
        UserProfileEntity entity = userProfileRepository.findAll( ).
                stream().filter(p->p.getUser().getUsername().equals(userName)).findFirst().get();
        if ( entity != null )
        {
            userProfileRepository.delete( entity );
        }
    }

}

