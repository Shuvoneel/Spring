package com.shuvoneel.NewsHack.dao;

import com.shuvoneel.NewsHack.entity.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}

