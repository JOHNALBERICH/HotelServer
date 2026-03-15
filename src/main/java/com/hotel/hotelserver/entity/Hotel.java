package com.hotel.hotelserver.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="hotels")
@Getter
@Setter

public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String hotelname;

    private String address;
    private String city;
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by", nullable=false)
    private User createdby;

    @Column(name="created_at",updatable=false)
    private LocalDateTime createdat;

    @Column(name="updated_at")
    private LocalDateTime updatedat;
    @PrePersist
    protected void onCreate()
    {
        this.createdat = LocalDateTime.now();
        this.updatedat = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate()
    {
        this.updatedat = LocalDateTime.now();
    }
    @Column(name="is_active")
    private boolean active=true;

   
}
