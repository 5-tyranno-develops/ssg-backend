//package com.tyranno.ssg.text;
//
//
//import lombok.RequiredArgsConstructor;
//import net.nurigo.java_sdk.api.Message;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import com.tyranno.ssg.text.infrastructure.SmsCertification;
//
//import java.util.HashMap;
//import java.util.Random;
//
//@Service
//@RequiredArgsConstructor
//public class MessageService {
//    private final SmsCertification smsCertification;
//
//    @Value("${COOLSMS.APIKEY}")
//    private String apiKey;
//
//    @Value("${COOLSMS.APISECRET}")
//    private String apiSecret;
//
//    @Value("${COOLSMS.FROMNUMBER}")
//    private String fromNumber;
//
//    private String createRandomNumber() {
//        Random rand = new Random();
//        String randomNum = "";
//        for (int i = 0; i < 4; i++) {
//            String random = Integer.toString(rand.nextInt(10));
//            randomNum += random;
//        }
//
//        return randomNum;
//    }
//
//    private HashMap<String, String> makeParams(String to, String randomNum) {
//        HashMap<String, String> params = new HashMap<>();
//        params.put("from", fromNumber);
//        params.put("type", "SMS");
//        params.put("app_version", "test app 1.2");
//        params.put("to", to);
//        params.put("text", randomNum);
//        return params;
//    }
//
//    // 인증번호 전송하기
//    public String sendSMS(String phonNumber) {
//        Message coolsms = new Message(apiKey, apiSecret);
//
//        // 랜덤한 인증 번호 생성
//        String randomNum = createRandomNumber();
//        System.out.println(randomNum);
//
//
//        // DB에 발송한 인증번호 저장
//        smsCertification.createSmsCertification(phonNumber, randomNum);
//
//        return "문자 전송이 완료되었습니다.";
//    }
//
//    // 인증 번호 검증
//    public String verifySms(SmsCertificationDto requestDto) {
//        if (isVerify(requestDto)) {
//            throw new IllegalArgumentException("인증번호가 일치하지 않습니다.");
//        }
//        smsCertification.deleteSmsCertification(requestDto.getPhoneNumber());
//
//        return "인증 완료되었습니다.";
//    }
//
//    private boolean isVerify(SmsCertificationDto requestDto) {
//        return !(smsCertification.hasKey(requestDto.getPhoneNumber()) &&
//                smsCertification.getSmsCertification(requestDto.getPhoneNumber())
//                        .equals(requestDto.getRandomNumber()));
//    }
//}