package dbflow.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A Appointment.
 */
@Entity
@Table(name = "appointment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "from")
    private String from;

    @Column(name = "to")
    private String to;

	@Column(name = "text")
    private String text;

    @Column(name = "description")
    private String description;

    @Column(name = "emitted_date")
    private LocalDate emittedDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "all_day")
    private Boolean allDay;

    @Column(name = "editable")
    private Boolean editable;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "text_color")
    private String textColor;

    @OneToOne(mappedBy = "appointment")
    @JsonIgnore
    private Notification notification;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Appointment title(String title) {
        this.text = title;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public Appointment description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEmittedDate() {
        return emittedDate;
    }

    public Appointment emittedDate(LocalDate emittedDate) {
        this.emittedDate = emittedDate;
        return this;
    }

    public void setEmittedDate(LocalDate emittedDate) {
        this.emittedDate = emittedDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Appointment start(LocalDateTime start) {
        this.startDate = start;
        return this;
    }

    public void setStartDate(LocalDateTime start) {
        this.startDate = start;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Appointment end(LocalDateTime end) {
        this.endDate = end;
        return this;
    }

    public void setEndDate(LocalDateTime end) {
        this.endDate = end;
    }

    public Boolean isAllDay() {
        return allDay;
    }

    public Appointment allDay(Boolean allDay) {
        this.allDay = allDay;
        return this;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Boolean isEditable() {
        return editable;
    }

    public Appointment editable(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public Appointment backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public Appointment textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Notification getNotification() {
        return notification;
    }

    public Appointment notification(Notification notification) {
        this.notification = notification;
        return this;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment)) {
            return false;
        }
        return id != null && id.equals(((Appointment) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + getId() +
            ", from='" + getFrom() + "'" +
            ", to='" + getTo() + "'" +
            ", text='" + getText() + "'" +
            ", description='" + getDescription() + "'" +
            ", emittedDate='" + getEmittedDate() + "'" +
            ", start='" + getStartDate() + "'" +
            ", end='" + getEndDate() + "'" +
            ", allDay='" + isAllDay() + "'" +
            ", editable='" + isEditable() + "'" +
            ", backgroundColor='" + getBackgroundColor() + "'" +
            ", textColor='" + getTextColor() + "'" +
            "}";
    }
}
