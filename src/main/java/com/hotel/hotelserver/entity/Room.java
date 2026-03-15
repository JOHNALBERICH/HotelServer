package com.hotel.hotelserver.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rooms")
@Getter
@Setter

public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hotel_id",nullable=false)
    private Hotel hotel;

    @Column(name="room_number",nullable=false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="room_type",nullable=false)
    private Roomtype roomType;

    @Column(name="price",nullable=false,precision=10,scale=2)
    private BigDecimal price;

    @Column(name="capacity",nullable=false)
    private int capacity;

    @Column(columnDefinition="TEXT")
    public String description;

    @Column(name="is_active")
    private boolean active=true;
}
