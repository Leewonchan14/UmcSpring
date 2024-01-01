package umc.spring.umcspring.Service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.Converter.RegionConverter;
import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Repository.RegionRepository;
import umc.spring.umcspring.Web.Dto.RegionRequestDTO;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService{

    private final RegionRepository regionRepository;
    @Override
    @Transactional
    public Region createRegion(RegionRequestDTO.RegionCreateDTO request) {
        Region newRegion = RegionConverter.toRegion(request);

        return regionRepository.save(newRegion);
    }
}
