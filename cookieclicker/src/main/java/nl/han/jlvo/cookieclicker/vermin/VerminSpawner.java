package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class VerminSpawner implements IAlarmListener {
    private final IVerminSpawnerListener spawnerListener;

    public VerminSpawner(IVerminSpawnerListener spawnerListener) {
        this.spawnerListener = spawnerListener;
        startAlarm();
    }

    private void startAlarm() {
        int randomVermin = new Random().nextInt(20);
        Alarm alarm = new Alarm("New Vermin", randomVermin);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        spawnerListener.onVerminSpawnerTriggered();
        startAlarm();
    }
}
