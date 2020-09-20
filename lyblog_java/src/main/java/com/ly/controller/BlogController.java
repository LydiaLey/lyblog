package com.ly.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.common.lang.Result;
import com.ly.entity.Blog;
import com.ly.service.BlogService;
import com.ly.util.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 博客接口
 *
 * @author Lydia
 * @date 2020/9/17
 */
@Api(value="博客controller",tags={"博客操作接口"})
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @ApiOperation("查询多页博客")
    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") @ApiParam(name="起始页码",value="起始页码",required=true) Integer currentPage) {

        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));

        return Result.succ(pageData);
    }

    @ApiOperation("按id查询博客")
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") @ApiParam(name="id",value="博客id",required=true) Long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");

        return Result.succ(blog);
    }

    @ApiOperation("博客编辑")
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody  @ApiParam(name="博客对象",value="json格式",required=true) Blog blog) {

        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");

        } else {
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);

        return Result.succ(null);
    }

    @ApiOperation("博客删除")
    @RequiresAuthentication
    @DeleteMapping("/blog/delete/{id}")
    public Result delete(@PathVariable("id") @ApiParam(name="博客id",value="博客id",required=true)  Integer id) {
        blogService.removeById(id);
        return Result.succ(null);

    }


}
