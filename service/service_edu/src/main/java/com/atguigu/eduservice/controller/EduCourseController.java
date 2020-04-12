package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-07
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;
    @GetMapping
    public R getCourseList(){
        List<EduCourse> list = eduCourseService.list(null);
        return R.ok().data("list",list);
    }

    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String id=eduCourseService.saveCourseInfoVo(courseInfoVo);

        return R.ok().data("courseId",id);

    }

    //根据课程id查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
       CourseInfoVo courseInfoVo= eduCourseService.getCourseInfo(courseId);
       return R.ok().data("courseInfoVo",courseInfoVo);
    }

    //修改课程的信息
    @PostMapping("updateCourseinfo")
    public R updateCourseinfo(@RequestBody CourseInfoVo courseInfoVo){
        eduCourseService.updateCourseinfo(courseInfoVo);
        return R.ok();

    }
    //根据课程id查询课程确认信息
    @GetMapping("getPublishInfo/{id}")
    public R getPublishInfo(@PathVariable String id){
         CoursePublishVo coursePublishVo=eduCourseService.publishCourseInfo(id);
         return R.ok().data("publishCourse",coursePublishVo);

    }

    //课程最终发布
    //修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");//设置课程状态为发布
        eduCourseService.updateById(eduCourse);
        return R.ok();

    }
    //删除课程
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId){
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }







}

