package com.ly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.entity.Blog;
import com.ly.mapper.BlogMapper;
import com.ly.service.BlogService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
