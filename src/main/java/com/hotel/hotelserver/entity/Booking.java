package com.hotel.hotelserver.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="bookings")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id",nullable=false)
    private Room room;

    @Column(name="check_in",nullable=false)
    private LocalDateTime checkin;

    @Column(name="check_out",nullable=false)
    private LocalDateTime checkout;

    @Column(nullable=false,precision=10,scale=2)
    private BigDecimal totalprice;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Column(name="created_at",updatable=false)
    private LocalDateTime createdat;

    @PrePersist
    protected void onCreate()
    {
        this.createdat = LocalDateTime.now();
        if(this.status == null)
        {
            this.status = Status.PENDING;
        }
    }




}
