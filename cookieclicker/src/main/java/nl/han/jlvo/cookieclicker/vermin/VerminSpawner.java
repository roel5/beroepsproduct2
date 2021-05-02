package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class VerminSpawner implements IAlarmListener {

    private Alarm alarm;
    private final IVerminSpawnerListener spawnerListener;
    private final Random random;
    private boolean isCancelled = false;

    public VerminSpawner(IVerminSpawnerListener spawnerListener) {
        this.spawnerListener = spawnerListener;
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
    public void triggerAlarm(String alarmName) {
        if (isCancelled) return;
        spawnerListener.onVerminSpawnerTriggered();
        startAlarm();
    }
}
