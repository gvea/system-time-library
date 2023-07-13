package com.gvea.library.system_time;

import org.springframework.stereotype.Component;

@Component
public class CurrentTimeInMillisProvider {
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
