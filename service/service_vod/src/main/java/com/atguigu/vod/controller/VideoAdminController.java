package com.atguigu.vod.controller;

import com.atguigu.commonutils.R;
import com.atguigu.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(description="阿里云视频点播微服务")
@CrossOrigin //跨域
@RestController
@RequestMapping("/eduvod/video")
public class VideoAdminController {

	@Autowired
	private VodService videoService;
//上传视频方法
	@PostMapping("upload")
	public R uploadVideo(
			@ApiParam(name = "file", value = "文件", required = true)
			@RequestParam("file") MultipartFile file) throws Exception {

		String videoId = videoService.uploadVideo(file);
		return R.ok().data("videoId", videoId);
	}
	//根据视频id,删除阿里云上视频方法
	@DeleteMapping("removeAlyVideo/{id}")
	public R removeAlyVideo(@ApiParam(name = "videoId", value = "云端视频id", required = true) @PathVariable String id){
		videoService.removeVideo(id);

		return R.ok();

	}
	//删除多个阿里云视频的方法
	@DeleteMapping("delete-batch")
	public R removeVideoList(
			@ApiParam(name = "videoIdList", value = "云端视频id", required = true)
			@RequestParam("videoIdList") List<String> videoIdList){

		videoService.removeVideoList(videoIdList);
		return R.ok().message("视频删除成功");
	}
}