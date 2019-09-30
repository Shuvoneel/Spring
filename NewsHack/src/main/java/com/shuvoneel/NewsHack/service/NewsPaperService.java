package com.shuvoneel.NewsHack.service;

import com.shuvoneel.NewsHack.entity.Post;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@Service
public interface NewsPaperService {
    void savePosts () throws Exception;
    HashSet<String> findPostIds() throws IOException;
    void saveAndAssignCategory(List<Post> posts);
}