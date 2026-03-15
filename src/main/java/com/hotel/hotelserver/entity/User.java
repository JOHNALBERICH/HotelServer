package com.hotel.hotelserver.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, unique=true)
    private String username;

    private String phone;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="is_active")
    private boolean active;

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
}
