package com.tyranno.ssg.users.application;

import com.tyranno.ssg.users.dto.MarketingDto;
import com.tyranno.ssg.users.dto.SignUpDto;
import com.tyranno.ssg.users.dto.UsersModifyDto;

public interface UsersService {
    void createUsers(SignUpDto signUpDto);

    SignUpDto modifyUsersInfo(UsersModifyDto usersIdentityDto);

    void modifyMaketing(MarketingDto marketingDto);

    SignUpDto getUsersInfo(String uuid); // api 응답값 이상 - 확인 필요

    void resignUsers(String uuid);

    void modifyPassword(); // 파라미터 보류
}