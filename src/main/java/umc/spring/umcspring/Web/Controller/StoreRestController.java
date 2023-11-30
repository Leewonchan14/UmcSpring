package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.StoreConverter;
import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Service.StoreService.StoreCommandService;
import umc.spring.umcspring.Validation.Annotation.ExistRegion;
import umc.spring.umcspring.Web.Dto.StoreRequestDTO;
import umc.spring.umcspring.Web.Dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
@Validated
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(
            @PathVariable @ExistRegion Long regionId,
            @RequestBody @Valid StoreRequestDTO.CreateStoreDTO request
    ) {

        Store newStore = storeCommandService.createStore(request, regionId);

        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(newStore));
    }
}
