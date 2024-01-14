package umc.spring.service.storeService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store registerStore(StoreRequestDTO.registerStoreDTO request);
}
