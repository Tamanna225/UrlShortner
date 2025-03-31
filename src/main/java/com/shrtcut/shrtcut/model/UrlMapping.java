package com.shrtcut.shrtcut.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity //make it a jpa entity to map with the table contents
@Getter
@Setter
@NoArgsConstructor  //constructor with no arguments
@AllArgsConstructor //constructor with all the fields as arguments
@Table(name = "url_mapping")    //name se pta chalta h kaunsi table se maped h to be specific if not specified then class name is assumed a s table name
public class UrlMapping {

    @Id     //makes this field as the primary key of the table
    @GeneratedValue(strategy = GenerationType.UUID) //UUID stands for Universally Unique Identifier(128 bit value). We can also use auto which decides for itself the best way to generate the id
    private String id;

    @Column(nullable = false, unique = true)
    private String longUrl;

    @Column(nullable = false, unique = true)
    private String shortCode;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
