package com.atguigu.voidtest;

import ch.qos.logback.core.net.server.Client;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;

public class VoidTest {
    public static void main(String[] args) throws Exception {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4FmP1zf3sc3XYpjm1ri1", "XTNSUraGISJnWIlrtart84aKKljBO8");
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        request.setVideoId("124bf00f7e7b498b9b45589f9696e30d");
        response = client.getAcsResponse(request);

    }
}
