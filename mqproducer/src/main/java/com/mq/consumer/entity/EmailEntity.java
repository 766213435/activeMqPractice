package com.mq.consumer.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangminghui
 */
@Data
@Builder
@AllArgsConstructor
public class EmailEntity implements Serializable {

    /** 发件人 **/
    private String from;
    /** 收件人 **/
    private String to;
    /** 主题 **/
    private String subject;
    /** 邮件内容 **/
    private String content;

}
