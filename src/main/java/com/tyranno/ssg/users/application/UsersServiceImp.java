package com.tyranno.ssg.users.application;

import com.tyranno.ssg.delivery.domain.Delivery;
import com.tyranno.ssg.delivery.infrastructure.DeliveryRepository;
import com.tyranno.ssg.security.JwtTokenProvider;
import com.tyranno.ssg.users.domain.MarketingInformation;
import com.tyranno.ssg.users.domain.Users;
import com.tyranno.ssg.users.dto.LoginDto;
import com.tyranno.ssg.users.dto.SignUpDto;
import com.tyranno.ssg.users.dto.UserIdentifyDto;
import com.tyranno.ssg.users.dto.UsersModifyDto;
import com.tyranno.ssg.users.infrastructure.MarketingInformationRepository;
import com.tyranno.ssg.users.infrastructure.MarketingRepository;
import com.tyranno.ssg.users.infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImp implements UsersService {
    private final UsersRepository usersRepository;
    private final MarketingRepository marketingRepository;
    private final MarketingInformationRepository marketingInformationRepository;
    private final DeliveryRepository deliveryRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // 반복이 될수 있음. 모든 곳에서 붙이는건 생각해봐야함  이유가 명확해야함
    @Override
    public void createUsers(SignUpDto signUpDto) {
        //회원
        String generatedUuid = UUID.randomUUID().toString();

        Users users = Users.builder()
                .loginId(signUpDto.getLoginId())
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .gender(signUpDto.getGender())
                .phoneNumber(signUpDto.getPhoneNumber())
                .birth(signUpDto.getBirth())
                .status(0) // 활동중
                .uuid(generatedUuid)
                .build();

        users.hashPassword(signUpDto.getPassword());
        usersRepository.save(users);

        //마케팅
        MarketingInformation marketingInformation1 = MarketingInformation.builder()
                .isAgree(signUpDto.getShinsegaeMarketingAgree())
                .users(users)
                .marketing(marketingRepository.findById(1L).orElseThrow())// 예외처리 필요
                .build();

        marketingInformationRepository.save(marketingInformation1);

        MarketingInformation marketingInformation2 = MarketingInformation.builder()
                .isAgree(signUpDto.getShinsegaeOptionAgree())
                .users(users)
                .marketing(marketingRepository.findById(2L).orElseThrow())// 예외처리 필요
                .build();

        marketingInformationRepository.save(marketingInformation2);

        MarketingInformation marketingInformation3 = MarketingInformation.builder()
                .isAgree(signUpDto.getSsgMarketingAgree())
                .users(users)
                .marketing(marketingRepository.findById(3L).orElseThrow())// 예외처리 필요
                .build();

        marketingInformationRepository.save(marketingInformation3);

        // 배송지
        Delivery delivery = Delivery.builder()
                .users(users)
                .isBaseDelivery((byte) 11)
                .deliveryName(signUpDto.getName())
                .zipCode(signUpDto.getZipCode())
                .deliveryBase(signUpDto.getDeliveryBase())
                .deliveryDetail(signUpDto.getDeliveryDetail())
                .receiverName(signUpDto.getName())
                .phoneNumber(signUpDto.getPhoneNumber())
                .build();

        deliveryRepository.save(delivery);
    }

    @Override
    public void checkLoginId(String loginId) {
        if (usersRepository.existsByLoginId(loginId)) {
            //throw new BaseException(POST_EXISTS_LOGIN_ID);
        }
    }
    // 아이디 찾기 로직은 에러로 넘겨야해서 에러 생성 후
    @Override
    public String loginUsers(LoginDto loginDto) {
        Users users = usersRepository.findByLoginId(loginDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다"));
        //아이디 찾기 로직으로 가도 될듯
        if (bCryptPasswordEncoder.matches(loginDto.getPassword(), users.getPassword())) {
            return jwtTokenProvider.generateToken(users);
        }
        return "NO LOGIN";
    }



    @Override
    public String findLoginId(UserIdentifyDto userIdentifyDto) {
        Users users = usersRepository.findByNameAndPhoneNumberAndGenderAndBirth(
                userIdentifyDto.getName(), userIdentifyDto.getPhoneNumber(), userIdentifyDto.getGender(), userIdentifyDto.getBirth()
        ).orElseThrow();
        return users.getLoginId();
    }

    @Override
    public Void changePassword(String password) {
        //헤더로 uuid 받기

    }


    @Transactional
    @Override
    public SignUpDto modifyUsersInfo(UsersModifyDto usersModifyDto) {
        validateModifyUsers(usersModifyDto);
        // String token =jwtTokenProvider.generateToken();
        Users users = usersRepository.findByPhoneNumber(usersModifyDto.getPhoneNumber()).orElseThrow(// 찾았는데 null일 경우
                //            () -> new UsersExcetion(No_USERS)
        );
//        // 기존 entity에 있던 정보 + 새로 set 정보
//        users.setEmail(usersModifyDto.getEmail());
//        users.setPassword(usersModifyDto.getPassword());
//        users.setPhoneNumber(usersModifyDto.getPhoneNumber());

        return SignUpDto.builder()
                .loginId(users.getLoginId())
                .password(users.getPassword())
                .name(users.getName())
                .email(users.getEmail())
                .gender(users.getGender())
                .phoneNumber(users.getPhoneNumber())
                .birth(users.getBirth())
                //.status(users.getStatus())
                .build();
    }


    private void validateModifyUsers(UsersModifyDto usersModifyDto) {
    }

    @Transactional
    @Override
    public void modifyMaketing() {

    }

    @Override
    public SignUpDto getUsersInfo(String uuid) {
        return null;
    }

    @Transactional
    @Override
    public void resignUsers(String uuid) {

    }

    @Transactional // patch가 아니라 put 이기 때문에
    @Override
    public void modifyPassword() {

    }


}
