package com.example.Artifex.Image;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {


}
