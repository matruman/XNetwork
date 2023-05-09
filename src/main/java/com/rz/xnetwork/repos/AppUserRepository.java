package com.rz.xnetwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rz.xnetwork.dto.AppUserDto;
import com.rz.xnetwork.dto.UserListElem;
import com.rz.xnetwork.models.AppUser;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public AppUser findByUserID(Long id);
    public AppUser findByUsername(String username);
    public AppUser findByEmail(String email);

    @Query(name = "getChatUsers", nativeQuery = true)
    public List<AppUserDto> getChatUsers(Long userID, int offset);

    
    @Query(value = "select userid, email, reg_date, username, validate, password, last_login, friendid AS friend" +
            " from app_user inner join (select * from friendship where usrid=?1) t1 on t1.friendid=app_user.userid" +
            " ORDER BY t1.noteid DESC LIMIT ?2, 50", nativeQuery = true)
    public List<UserListElem> getFriendsForUser(Long userID, int offset);

    @Query(name = "getUsersByQuery", nativeQuery = true)
    public List<UserListElem> getUsersByQuery(String query, Long user_id, int offset);

}
