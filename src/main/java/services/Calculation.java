package services;

import dto.Ticket;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Calculation {
    /**
     * Расчет времени полета
     * @param ticket билет
     * @return время полета
     */
    public static long getFlightTime(Ticket ticket) {
        long time;
        time = ticket.getArrivalDateTime().toEpochSecond(ZoneOffset.of(ticket.getDestination().getTimezone())) -
                ticket.getDepartureDateTime().toEpochSecond(ZoneOffset.of(ticket.getOrigin().getTimezone()));
        if (time < 0)
            throw new RuntimeException("Время полета не может быть отрицательным!");
        return time;
    }

    /**
     * Расчет среднего времени полета
     * @param tickets билеты
     * @return среднее время полета
     */
    public static long avgFlightTime(List<Ticket> tickets) {
        long avg = 0;
        for (Ticket ticket : tickets) {
            avg += getFlightTime(ticket) / tickets.size();
        }
        return avg;
    }

    /**
     * Расчет процентиля времени полета
     * @param tickets билеты
     * @return k-й процентиль времени полета
     */
    public static long percentileFlightTime(List<Ticket> tickets, double k) {
        List<Long> times = new ArrayList<>();
        for (Ticket ticket : tickets) {
            times.add(getFlightTime(ticket));
        }
        times.sort(Long::compareTo);
        int countTimes = 0;
        for (long tm : times) {
            double percentile = 1.0 * (++countTimes) / times.size();
            if (k*0.01 <= percentile) {
                return tm;
            }
        }
        return 0;
    }
}
