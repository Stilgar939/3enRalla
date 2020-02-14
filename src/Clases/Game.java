package Clases;

import java.time.LocalTime;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Game /*implements Chrono*/ {
    Persona p1, p2;

    ArrayList<Persona> ap1 = new ArrayList<>();

    public abstract void Start();
/*
    public void startChr(){
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
            try {
                Date date1 = simpleDateFormat.parse(LocalTime.now().toString());

            } catch (ParseException e) {
                e.printStackTrace();
            }
    }

    public void getActualTimeChr(Date startDate){
        Date endDate = null;
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
        try {
            endDate = simpleDateFormat.parse(LocalTime.now().toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;


        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d hours, %d minutes, %d seconds%n",

                elapsedHours, elapsedMinutes, elapsedSeconds);
    }*/
}
