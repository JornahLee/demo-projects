package com.jornah.jetcachedemo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author licong
 * @date 2021/6/3 14:56
 */
@Builder
@Data
public class UserDO implements Serializable {
    private Long id;
    private String username;
}
