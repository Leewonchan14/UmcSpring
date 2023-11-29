package umc.spring.umcspring.Service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService {
    private final RegionRepository regionRepository;

    @Override
    public boolean isExist(Long regionId) {
        return regionRepository.existsById(regionId);
    }
}
