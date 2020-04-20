package com.atguigu.springcloud.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangCheng
 * @describe
 * @create 2020-04-20 15:49
 */
@RestController
@RefreshScope // 支持Nacos动态刷新配置的功能
public class ConfigClientController {
}
