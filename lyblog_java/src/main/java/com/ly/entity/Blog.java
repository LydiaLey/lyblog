package com.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
@ApiModel(description="博客对象blog")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="博客id",name="id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value="用户id",name="userId")
    private Long userId;

    @ApiModelProperty(value="博客标题",name="title")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value="博客摘要",name="description")
    @NotBlank(message = "摘要不能为空")
    private String description;

    @ApiModelProperty(value="博客内容",name="content")
    @NotBlank(message = "内容不能为空")
    private String content;

    @ApiModelProperty(value="博客创建时间",name="created")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime created;

    @ApiModelProperty(value="博客状态",name="status")
    private Integer status;


}
