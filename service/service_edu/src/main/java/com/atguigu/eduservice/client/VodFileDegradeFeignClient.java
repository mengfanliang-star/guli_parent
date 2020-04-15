package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//开启熔断机制,熔断执行熔断实现类
public class VodFileDegradeFeignClient implements VodClient {
//feigen调用方法正确不会执行..调用方法错误才执行
    @Override
    public R removeAlyVideo(String id) {
        return R.error().message("删除一个视频出错");
    }

    @Override
    public R removeVideoList(List<String> videoIdList) {
        return R.error().message("删除多个视频出错");
    }
}