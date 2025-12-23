package org.example.evangelhistory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    @Column(length = 2000)
    private String description;
    private String titleImage;

    @OneToOne(mappedBy = "event")
    private MediaAlbum album;
}
