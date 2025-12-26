package org.example.evangelhistory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="event", schema = "evangelical_history")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;
    private String title;
    private LocalDateTime dateTime;
    private String city;
    private String address;
    @Column(length = 2000)
    private String announcement;
    private String descriptionTitle;
    @Column(length = 2000)
    private String description;
    private String titleImage;
    @Column(nullable = false)
    private boolean isDone;

    @OneToOne(mappedBy = "event")
    private MediaAlbum album;

}
