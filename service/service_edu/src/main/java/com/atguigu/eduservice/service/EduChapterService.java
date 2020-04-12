package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-07
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoBycourseId(String courseId);

    Boolean deleteChapter(String chapterId);

    void removeByCourseId(String courseId);
}
