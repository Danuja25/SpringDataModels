package org.danuja25.springdata.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hareen
 * Date : 6/29/2019
 * Time : 3:10 PM
 */

public class User
{

    private String username;
    private String password;
    private UserProfile userProfile;

    private List<UserGroup> userGroups;

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public List<UserGroup> getUserGroups()
    {
        if( userGroups == null )
        {
            userGroups = new ArrayList<>();
        }
        return userGroups;
    }

    public void setUserGroups( List<UserGroup> userGroups )
    {
        this.userGroups = userGroups;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
