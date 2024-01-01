package umc.spring.umcspring.Service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    @Override
    public boolean isExist(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
