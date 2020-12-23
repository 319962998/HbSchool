package com.colin.service;

import javax.servlet.http.HttpSession;

public interface TeaSessionService {
    int init(HttpSession session);

    void logOut(HttpSession session);
}
