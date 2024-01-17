package umc.spring.service.memberMissionService;

import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionCommandService {

    MemberMission challengingMission(Long memberId, Long missionId);
}
