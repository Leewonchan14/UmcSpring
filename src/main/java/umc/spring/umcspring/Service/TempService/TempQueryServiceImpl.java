package umc.spring.umcspring.Service.TempService;

import org.springframework.stereotype.Service;
import umc.spring.umcspring.ApiPayload.Code.Status.ErrorStatus;
import umc.spring.umcspring.ApiPayload.Exception.Handler.TempHandler;

@Service
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
