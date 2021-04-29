package nl.han.jlvo.cookieclicker.goldencookie;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class GoldenCookieSpawner implements IAlarmListener {
    private Alarm alarm;
    private final IGoldenCookieSpawnerListener goldenCookieSpawnerListener;
    private final Random random;
    private boolean isCancelled;

    public GoldenCookieSpawner(IGoldenCookieSpawnerListener goldenCookieSpawnerListener) {
        this.goldenCookieSpawnerListener = goldenCookieSpawnerListener;
        random = new Random();
        startAlarm();
    }

    private void startAlarm() {
        int interval = random.nextInt(120);
        alarm = new Alarm(this.getClass().getName(), interval);
        alarm.addTarget(this);
        alarm.start();
    }

    public void stopAlarm() {
        isCancelled = true;
        alarm.stop();
        alarm = null;
    }

    @Override
    public void triggerAlarm(String s) {
        if (isCancelled) return;
        goldenCookieSpawnerListener.onGoldenCookieSpawnerTriggered();
        startAlarm();
    }
}
