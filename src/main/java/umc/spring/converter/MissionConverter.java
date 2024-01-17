package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public  static MissionResponseDTO.ChallengingMissionResultDTO toChallengingMissionResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.ChallengingMissionResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDTO request) {
        return Mission.builder()
                .reword(request.getReword())
                .deadline(request.getDeadline())
                .specMission(request.getSpecMission())
                .build();
    }

    public static MemberMission toMemberMission() {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
