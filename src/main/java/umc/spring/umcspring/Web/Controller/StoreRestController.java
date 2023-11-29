package umc.spring.umcspring.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.umcspring.ApiPayload.ApiResponse;
import umc.spring.umcspring.Converter.StoreConverter;
import umc.spring.umcspring.Domain.Store;
import umc.spring.umcspring.Service.StoreService.StoreCommandService;
import umc.spring.umcspring.Web.Dto.StoreRequestDTO;
import umc.spring.umcspring.Web.Dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.CreateDTO request
    ) {

        Store newStore = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(newStore));
    }
}
