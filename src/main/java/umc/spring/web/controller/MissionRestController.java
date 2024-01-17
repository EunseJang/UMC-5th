package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.ChallengingMission;
import umc.spring.validation.annotation.ExistMember;import umc.spring.web.dto.MissionResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    // TODO 실제 Custom Validator 적용 안됨 (그 전에 이미 서비스 단에서 오류 처리 실행되기 때문)
    @PostMapping("/{missionId}/challenging")
    public ApiResponse<MissionResponseDTO.ChallengingMissionResultDTO> challengingMission(
            @ExistMember @RequestParam(name = "memberId") Long memberId,
            @ExistMember @ChallengingMission @PathVariable(name = "missionId") Long missionId) {

        MemberMission memberMission = memberMissionCommandService.challengingMission(memberId, missionId);
        return ApiResponse.onSucces(MissionConverter.toChallengingMissionResultDTO(memberMission));
    }
}
