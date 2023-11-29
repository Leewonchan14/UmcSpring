package umc.spring.umcspring.Converter;


import umc.spring.umcspring.Domain.Enum.Gender;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Web.Dto.MemberRequestDTO;
import umc.spring.umcspring.Web.Dto.MemberResponseDTO;

import java.util.ArrayList;


public class MemberConverter {
    //Member -> joinResultDTO
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }
    // MemberRequestDTO -> Member
    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;
        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEAMLE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .age(request.getAge())
                .build();

    }
}
