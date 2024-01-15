package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MemberRepository;
import umc.spring.Repository.MissionRepository;
import umc.spring.Repository.StoreRepository;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.MissionDTO request) {

        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
}
