package dbflow.server.service.dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.io.Serializable;

/**
 * A DTO for the {@link dbflow.server.domain.SafeKeepingPeriod} entity.
 */
public class SafeKeepingPeriodDTO implements Serializable {
    
    private Long id;

    private String owner;

    private String text;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String backgroundColor;

    private String textColor;

    private Boolean allDay;
    
    public SafeKeepingPeriodDTO() {
    	this.allDay = false;
    }
    
    public Boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SafeKeepingPeriodDTO)) {
            return false;
        }

        return id != null && id.equals(((SafeKeepingPeriodDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SafeKeepingPeriodDTO{" +
            "id=" + getId() +
            ", owner='" + getOwner() + "'" +
            ", text='" + getText() + "'" +
            ", description='" + getDescription() + "'" +
            ", start='" + getStartDate() + "'" +
            ", end='" + getEndDate() + "'" +
            ", backgroundColor='" + getBackgroundColor() + "'" +
            ", textColor='" + getTextColor() + "'" +
            "}";
    }
}
