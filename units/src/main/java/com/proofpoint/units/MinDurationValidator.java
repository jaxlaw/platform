package com.proofpoint.units;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinDurationValidator
        implements ConstraintValidator<MinDuration, Duration>
{
    private Duration min;

    @Override
    public void initialize(MinDuration duration)
    {
        this.min = Duration.valueOf(duration.value());
    }

    @Override
    public boolean isValid(Duration duration, ConstraintValidatorContext context)
    {
        return duration == null || duration.compareTo(min) >= 0;
    }
}
