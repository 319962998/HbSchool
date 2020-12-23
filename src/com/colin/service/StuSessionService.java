package com.colin.service;

import javax.servlet.http.HttpSession;

public interface StuSessionService {
    int init(HttpSession session);

    void logOut(HttpSession session);
}
