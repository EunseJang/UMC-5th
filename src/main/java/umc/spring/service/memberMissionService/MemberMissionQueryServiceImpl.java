package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MemberMissionRepository;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<MemberMission> findMemberMission(Long missionId) {
        return memberMissionRepository.findByMissionId(missionId);
    }
}
