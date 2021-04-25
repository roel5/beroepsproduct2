package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class VerminSpawner implements IAlarmListener {
    private final IVerminSpawnerListener spawnerListener;
    private final Random random;

    public VerminSpawner(IVerminSpawnerListener spawnerListener) {
        this.spawnerListener = spawnerListener;
        random = new Random();
        startAlarm();
    }

    private void startAlarm() {
        int interval = random.nextInt(20);
        Alarm alarm = new Alarm(this.getClass().getName(), interval);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        spawnerListener.onVerminSpawnerTriggered();
        startAlarm();
    }
}
