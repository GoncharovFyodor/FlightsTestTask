import dto.Ticket;
import services.Calculation;
import services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class FlightsApp {
    public static void main(String[] args) {

        //JSON-парсинг
        List<Ticket> tickets = new ArrayList<>(
                TicketService.getTicketsJson("tickets.json"));

        // Расчет среднего времени полета
        long avgFlightTime = Calculation.avgFlightTime(tickets);
        System.out.println("Среднее время полета: " + avgFlightTime / 60 / 60 + " часов " + (avgFlightTime / 60) % 60 + " мин.");

        // Расчет процентиля времени полета
        long percentile = Calculation.percentileFlightTime(tickets, 90);
        System.out.println( "90-й процентиль времени полета между городами  Владивосток и Тель-Авив = "
                + percentile / 60 / 60 + " часов " + (percentile / 60) % 60 + " мин.");
    }
}
