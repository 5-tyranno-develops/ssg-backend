package com.tyranno.ssg.global;

public record ResponseEntity<T>(Boolean isSuccess, String message, int code, T result) {
    /**
     * 필요값 : 성공여부, 메시지, 에러코드, 결과값
     */

    // 요청에 성공한 경우 -> return 객체가 필요한 경우
    public ResponseEntity(T result) {
        this(true, ResponseStatus.SUCCESS.getMessage(), ResponseStatus.SUCCESS.getCode(), result);
    }

    // 요청에 성공한 경우 -> return 객체가 필요 없는 경우
    public ResponseEntity() {
        this(true, ResponseStatus.SUCCESS.getMessage(), ResponseStatus.SUCCESS.getCode(), null);
    }

    // 요청 실패한 경우
    public ResponseEntity(ResponseStatus status, String message) {
        this(false, message, status.getCode(), null);
    }

    //요청에 실패한 경우 @Vaild annotantion error 판매자
    public ResponseEntity(Exception e, String message) {
        this(false, message, 3000, null);
    }

}

