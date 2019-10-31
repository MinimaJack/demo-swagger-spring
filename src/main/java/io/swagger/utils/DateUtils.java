package io.swagger.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils
{
    public static Date atEndOfDay( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.HOUR_OF_DAY, 23 );
        calendar.set( Calendar.MINUTE, 59 );
        calendar.set( Calendar.SECOND, 59 );
        calendar.set( Calendar.MILLISECOND, 999 );
        return calendar.getTime();
    }

    public static Date atStartOfDay( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );
        return calendar.getTime();
    }

    public static Date atStartOfMonth( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.DAY_OF_MONTH, 1 );
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );
        return calendar.getTime();
    }

    public static Date atEndOfMonth( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.DAY_OF_MONTH, calendar.getActualMaximum( Calendar.DAY_OF_MONTH ) );
        calendar.set( Calendar.HOUR_OF_DAY, 23 );
        calendar.set( Calendar.MINUTE, 59 );
        calendar.set( Calendar.SECOND, 59 );
        calendar.set( Calendar.MILLISECOND, 999 );
        return calendar.getTime();
    }

    public static Date atStartOfYear( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.MONTH, 0 );
        calendar.set( Calendar.DAY_OF_MONTH, 1 );
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );
        return calendar.getTime();
    }

    public static Date atEndOfYear( Date date )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set( Calendar.MONTH, 11 );
        calendar.set( Calendar.DAY_OF_MONTH, calendar.getActualMaximum( Calendar.DAY_OF_MONTH ) );
        calendar.set( Calendar.HOUR_OF_DAY, 23 );
        calendar.set( Calendar.MINUTE, 59 );
        calendar.set( Calendar.SECOND, 59 );
        calendar.set( Calendar.MILLISECOND, 999 );
        return calendar.getTime();
    }
}
