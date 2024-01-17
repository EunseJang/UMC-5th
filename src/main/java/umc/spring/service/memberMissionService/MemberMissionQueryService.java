package umc.spring.service.memberMissionService;

import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionQueryService {

    Optional<MemberMission> findMemberMission(Long missionId);
}
