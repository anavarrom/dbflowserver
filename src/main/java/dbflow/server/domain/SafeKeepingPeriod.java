package dbflow.server.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A SafeKeepingPeriod.
 */
@Entity
@Table(name = "safe_keeping_period")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SafeKeepingPeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "text")
    private String text;

    @Column(name = "description")
    private String description;

    @Column(name = "start")
    private ZonedDateTime start;

    @Column(name = "jhi_end")
    private ZonedDateTime end;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "text_color")
    private String textColor;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public SafeKeepingPeriod owner(String owner) {
        this.owner = owner;
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public SafeKeepingPeriod text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public SafeKeepingPeriod description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public SafeKeepingPeriod start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public SafeKeepingPeriod end(ZonedDateTime end) {
        this.end = end;
        return this;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public SafeKeepingPeriod backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public SafeKeepingPeriod textColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SafeKeepingPeriod)) {
            return false;
        }
        return id != null && id.equals(((SafeKeepingPeriod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SafeKeepingPeriod{" +
            "id=" + getId() +
            ", owner='" + getOwner() + "'" +
            ", text='" + getText() + "'" +
            ", description='" + getDescription() + "'" +
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            ", backgroundColor='" + getBackgroundColor() + "'" +
            ", textColor='" + getTextColor() + "'" +
            "}";
    }
}
