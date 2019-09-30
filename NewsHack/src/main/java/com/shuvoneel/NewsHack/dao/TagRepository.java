package com.shuvoneel.NewsHack.dao;

import com.shuvoneel.NewsHack.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByTagName(String tagName);
}

