package com.rz.xnetwork.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rz.xnetwork.dto.UserListElem;
import com.rz.xnetwork.models.AppUser;
import com.rz.xnetwork.repos.AppUserRepository;
import com.rz.xnetwork.security.UserHandler;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AppUserService {
    
    private final AppUserRepository appUserRepository;

    public List<UserListElem> getSubscriberList(int page, int size) {
        AppUser appUser = UserHandler.getAuthorizedUser().getAppUser();
        List<UserListElem> users = appUserRepository.getSubscribersForUser(appUser.getUserId(), PageRequest.of(page, size, Sort.by("username").descending()));
        return users;
    }

    public List<UserListElem> getSubscriptionList(int page, int size) {
        AppUser appUser = UserHandler.getAuthorizedUser().getAppUser();
        List<UserListElem> users = appUserRepository.getSubscribersForUser(appUser.getUserId(), PageRequest.of(page, size, Sort.by("username").descending()));
        return users;
    }

    public List<UserListElem> getUsersByQuery(String query, int page, int size) {

        AppUser appUser = UserHandler.getAuthorizedUser().getAppUser();
        List<UserListElem> users = appUserRepository.getUsersByQuery(query, appUser.getUserId(), PageRequest.of(page, size, Sort.by("username").ascending()));
        return users;
    }
}
