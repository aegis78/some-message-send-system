package com.cyworld.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "info.app")

@Data
public class InfoConfig {
    private String name;			// 시스템 명
    private String description;		// 시스템 설명
    private String version;			// 버전
}
