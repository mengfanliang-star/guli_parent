package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
//fallback = VodFileDegradeFeignClient.class.熔断的配置,实现类
@FeignClient(name="service-vod", fallback = VodFileDegradeFeignClient.class)
//远程调用模块的接口..feigen调用..失败执行熔断实现类.
public interface VodClient {
//调用vod模块,删除视频..httpclient方式
    @DeleteMapping("/eduvod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    //定义调用删除多个视频的方法
    @DeleteMapping("/eduvod/video/delete-batch")
    public R removeVideoList(@RequestParam("videoIdList") List<String> videoIdList);

}
