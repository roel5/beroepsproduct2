package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class VerminSpawner implements IAlarmListener {
    private int verminPerSecond;
    private final IVerminSpawnerListener spawnerListener;

    public VerminSpawner(IVerminSpawnerListener spawnerListener) {
        this.verminPerSecond = 1;
        this.spawnerListener = spawnerListener;
        startAlarm();
    }

    private void startAlarm() {
        Alarm alarm = new Alarm("New Vermin", 1 / verminPerSecond);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        spawnerListener.onVerminSpawnerTriggered();
        startAlarm();
    }
}
