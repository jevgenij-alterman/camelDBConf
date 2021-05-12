package com.jevgenij.dbconf.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "CONF")
public class Conf {
    @Id
    @Column(name = "GAME_NAME")
    private String gameName;
    @Column(name = "event_name")
    private String eventName;
    private int timing;
    private int duration;
    private String destination;
}
