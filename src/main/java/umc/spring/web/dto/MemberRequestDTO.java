package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.Gender;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO {

        // TODO socialType, email

        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;
    }
}
