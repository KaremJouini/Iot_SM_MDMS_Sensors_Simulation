package com.example.mdms.config;

import java.util.ArrayList;
import java.util.List;

public final class Config {
    public static final String HOSTNAME="localhost";

    public static final ArrayList<String> PUBLISHING_TOPICS = new ArrayList<String>(List.of("tension","pricing"));
    public static final ArrayList<String> SUBSCRIPTION_TOPICS = new ArrayList<String>(List.of("stock"));
}
