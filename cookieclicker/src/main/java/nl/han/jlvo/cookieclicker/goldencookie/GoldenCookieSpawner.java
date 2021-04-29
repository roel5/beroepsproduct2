package nl.han.jlvo.cookieclicker.goldencookie;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class GoldenCookieSpawner implements IAlarmListener {

    private final IGoldenCookieSpawnerListener goldenCookieSpawnerListener;
    private final Random random;

    public GoldenCookieSpawner(IGoldenCookieSpawnerListener goldenCookieSpawnerListener) {
        this.goldenCookieSpawnerListener = goldenCookieSpawnerListener;
        random = new Random();
        startAlarm();
    }

    private void startAlarm() {
        int interval = random.nextInt(200);
        Alarm alarm = new Alarm(this.getClass().getName(), interval);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String s) {
        goldenCookieSpawnerListener.onGoldenCookieSpawnerTriggered();
        startAlarm();
    }
}
