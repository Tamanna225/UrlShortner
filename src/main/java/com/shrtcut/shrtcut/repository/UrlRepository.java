package com.shrtcut.shrtcut.repository;

import com.shrtcut.shrtcut.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //marks the repo as spring bean for databse operations. Aapne aap detect kar lega interface ko runtime pe
//@repo ke bina bhi detect kar sakta hai at runtime but exception translation might be lost

//although no need of @repository as JpaRepository includes it internally
public interface UrlRepository extends JpaRepository<UrlMapping, String> {
    //JpaRepository provides built in CRUD operation for the table which is mapped with UrlMapping table
    //optional means that this thing can return null value instead of no value and will avoid nullpointerexception
    //we can check .empty() to check if it is empty
    Optional<UrlMapping> findByShortCode(String shortCode);
    Optional<UrlMapping> findByLongUrl(String longUrl);
}
