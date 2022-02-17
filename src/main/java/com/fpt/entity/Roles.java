package com.fpt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "roles")
@NoArgsConstructor  // không tham số
@AllArgsConstructor // có tham số
@Getter
@Setter
public class Roles implements Serializable {
    private static final long serialVersionUID = 1057758655898430335L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
    private Long id;

    @Column(name = "description")
    private String description;
}
