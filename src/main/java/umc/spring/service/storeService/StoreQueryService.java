package umc.spring.service.storeService;

import umc.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
}
