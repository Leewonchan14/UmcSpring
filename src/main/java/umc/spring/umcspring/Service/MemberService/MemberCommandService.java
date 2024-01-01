package umc.spring.umcspring.Service.MemberService;

import umc.spring.umcspring.Domain.Mapping.MemberMission;
import umc.spring.umcspring.Domain.Member;
import umc.spring.umcspring.Web.Dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
