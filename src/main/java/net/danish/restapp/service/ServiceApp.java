package net.danish.restapp.service;

import net.danish.restapp.model.base.BaseEntity;
import java.text.ParseException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by a.danishevskyi on 11/21/17.
 */

@Service
public class ServiceApp {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    boolean isValidDate(BaseEntity baseEntity) {
        try {
            format.parse(baseEntity.getTradeDate());
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }

    public boolean isValidQueueDate(BaseEntity baseEntity) {
        try {
            Date date1 = format.parse(baseEntity.getTradeDate());
            Date date2 = format.parse(baseEntity.getValueDate());
            if (date1.before(date2)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isWeekendOrNonWorkDay(BaseEntity baseEntity) {
        boolean isDayOff = false;
        try {
            Date date = format.parse(baseEntity.getValueDate());
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                isDayOff = true;
            }
            return isDayOff;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isDayOff;
    }

}
