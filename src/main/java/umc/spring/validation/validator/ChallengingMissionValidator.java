package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionQueryService;
import umc.spring.validation.annotation.ChallengingMission;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChallengingMissionValidator implements ConstraintValidator<ChallengingMission, Long> {

    private final MemberMissionQueryService memberMissionQueryService;

    @Override
    public void initialize(ChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<MemberMission> target = memberMissionQueryService.findMemberMission(value);

        if(target.isPresent() && target.get().getStatus() == MissionStatus.CHALLENGING) {
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.getMessage()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
