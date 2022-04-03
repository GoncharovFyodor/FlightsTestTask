package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket {
    private Source origin;
    private Source destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String carrier;
    private Integer stopoverCount;
    private Integer price;
}
