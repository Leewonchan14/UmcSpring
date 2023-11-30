package umc.spring.umcspring.Service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.Converter.MissionConverter;
import umc.spring.umcspring.Domain.Mission;
import umc.spring.umcspring.Repository.MissionRepository;
import umc.spring.umcspring.Repository.StoreRepository;
import umc.spring.umcspring.Web.Dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        newMission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(newMission);
    }
}
