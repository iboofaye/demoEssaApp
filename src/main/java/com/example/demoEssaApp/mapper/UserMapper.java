/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.mapper;

import com.example.demoEssaApp.model.AppUser;
import org.apache.ibatis.annotations.Mapper;
/**
 *
 * @author LENOVO
 */
@Mapper
public interface UserMapper {
/** User signup
     * @param user
     * @return  */
public int insertOne(AppUser user);
public int saveOne(AppUser user);
}
