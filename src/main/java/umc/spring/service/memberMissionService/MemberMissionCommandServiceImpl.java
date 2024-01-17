package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MemberMissionRepository;
import umc.spring.Repository.MemberRepository;
import umc.spring.Repository.MissionRepository;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    /** 미션 도전하기 */
    @Override
    @Transactional
    public MemberMission challengingMission(Long memberId, Long missionId) {

        MemberMission memberMission = MissionConverter.toMemberMission();

        memberMission.setMember(memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)));
        memberMission.setMission(missionRepository.findById(missionId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND)));

        return memberMissionRepository.save(memberMission);
    }
}
