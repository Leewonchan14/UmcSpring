package umc.spring.umcspring.Service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;

    @Override
    public boolean isExist(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
