package umc.spring.umcspring.Service.StoreService;

import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Web.Dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.StoreCreateDTO request, Long regionId);
}
