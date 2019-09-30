package com.shuvoneel.NewsHack.service;

import com.shuvoneel.NewsHack.entity.Post;

public interface TagService {
    void manageCatAndTags(String cat, Post post, String id) throws Exception;
    void assignTagForBDPosts(Post post, String id) throws Exception;
    void assignTagForIntPosts(Post post, String id) throws Exception;
    void assignTagForEconomy(Post post, String id) throws Exception;
    void assignTagForOpinion(Post post, String id) throws Exception;
}

