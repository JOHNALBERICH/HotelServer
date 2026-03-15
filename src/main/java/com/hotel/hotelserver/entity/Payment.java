package com.hotel.hotelserver.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name="payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="booking_id", nullable=false)
    private Booking booking;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_method")
    private PaymentMethod method;

    @Column(name="amount", precision=10,scale=2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable=false)
    private Status status;

    @Column(name="created_at",updatable=false)
    private LocalDateTime createat;


    @PrePersist
    protected void onCreate()
    {
        this.createat = LocalDateTime.now();
        if(this.status == null)
        {
            this.status = Status.PENDING;
        }
    }

}
