package umc.spring.umcspring.Converter;

import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Web.Dto.StoreRequestDTO;
import umc.spring.umcspring.Web.Dto.StoreResponseDTO;

import java.util.ArrayList;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.CreateStoreDTO dto){
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .reviewList(new ArrayList<>())
                .build();
    }
    public static StoreResponseDTO.CreateStoreResultDTO toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
