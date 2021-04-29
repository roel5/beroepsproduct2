package nl.han.jlvo.cookieclicker.autohelper;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class AutoHelperUpdateTimer implements IAlarmListener {
    private Alarm alarm;
    private final IAutoHelperUpdateListener listener;
    private boolean isCancelled = false;

    public AutoHelperUpdateTimer(IAutoHelperUpdateListener listener) {
        this.listener = listener;
        startAlarm();
    }

    private void startAlarm() {
        alarm = new Alarm(this.getClass().getName(), 1);
        alarm.addTarget(this);
        alarm.start();
    }

    public void stopAlarm() {
        isCancelled = true;
        alarm.removeTarget(this);
        alarm.stop();
        alarm = null;
    }

    @Override
    public void triggerAlarm(String s) {
        if (isCancelled) return;
        listener.onAutoHelperUpdate();
        startAlarm();
    }
}
