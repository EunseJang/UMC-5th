package umc.spring.service.storeService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.Repository.RegionRepository;
import umc.spring.Repository.StoreRepository;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store registerStore(StoreRequestDTO.registerStoreDTO request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
