package umc.spring.umcspring.Service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.umcspring.Converter.StoreConverter;
import umc.spring.umcspring.Domain.Region;
import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Repository.RegionRepository;
import umc.spring.umcspring.Repository.StoreRepository;
import umc.spring.umcspring.Web.Dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.StoreCreateDTO request, Long regionId) {
        
        Store newStore = StoreConverter.toStore(request);

        Region region = regionRepository.findById(regionId).get();

        newStore.setRegion(region);

        return storeRepository.save(newStore);
    }
}
