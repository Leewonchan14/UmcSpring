package umc.spring.umcspring.Service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.umcspring.Repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements  StoreQueryService{
    private final StoreRepository storeRepository;
    @Override
    public boolean isExist(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}
