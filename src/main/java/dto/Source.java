package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Source {
    VVO ("Владивосток", "+10"),
    TLV ("Тель-Авив", "+3");

    private String name;
    private String timezone;
    public void setName(String name) {
        this.name = name;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
