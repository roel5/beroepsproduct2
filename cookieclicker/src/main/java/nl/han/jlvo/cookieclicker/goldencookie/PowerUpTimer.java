package nl.han.jlvo.cookieclicker.goldencookie;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PowerUpTimer implements IAlarmListener {
    private static final int TIMER_LENGTH = 20;

    private final IPowerUpTimerListener listener;
    private Alarm clickTimerAlarm;
    private Alarm helperTimerAlarm;
    private LocalDateTime clickTimerStart;
    private LocalDateTime helperTimerStart;

    public PowerUpTimer(IPowerUpTimerListener listener) {
        this.listener = listener;
    }

    public void startTimerForClick() {
        clickTimerAlarm = new Alarm(PowerUpKind.MULTIPLY_CLICK.name(), TIMER_LENGTH);
        clickTimerAlarm.addTarget(this);
        clickTimerAlarm.start();
        clickTimerStart = LocalDateTime.now();
    }

    public void startTimerForHelper() {
        helperTimerAlarm = new Alarm(PowerUpKind.MULTIPLY_HELPER.name(), TIMER_LENGTH);
        helperTimerAlarm.addTarget(this);
        helperTimerAlarm.start();
        helperTimerStart = LocalDateTime.now();
    }

    public int getRemainingSecondForClickPowerUp() {
        if (clickTimerAlarm == null) {
            return 0;
        }
        return (int) ChronoUnit.SECONDS.between(LocalDateTime.now(), clickTimerStart.plusSeconds(TIMER_LENGTH));
    }

    public int getRemainingSecondForHelperPowerUp() {
        if (helperTimerAlarm == null) {
            return 0;
        }
        return (int) ChronoUnit.SECONDS.between(LocalDateTime.now(), helperTimerStart.plusSeconds(TIMER_LENGTH));
    }

    private void removeHelperTimerAlarm() {
        helperTimerStart = null;
        helperTimerAlarm.removeTarget(this);
        helperTimerAlarm.stop();
        helperTimerAlarm = null;
    }

    private void removeClickTimerAlarm() {
        clickTimerStart = null;
        clickTimerAlarm.removeTarget(this);
        clickTimerAlarm.stop();
        clickTimerAlarm = null;
    }

    @Override
    public void triggerAlarm(String s) {
        if (PowerUpKind.valueOf(s) == PowerUpKind.MULTIPLY_CLICK) {
            listener.onClickPowerUpEnded();
            removeClickTimerAlarm();
        } else if (PowerUpKind.valueOf(s) == PowerUpKind.MULTIPLY_HELPER) {
            listener.onHelperPowerUpEnded();
            removeHelperTimerAlarm();
        }
    }
}
