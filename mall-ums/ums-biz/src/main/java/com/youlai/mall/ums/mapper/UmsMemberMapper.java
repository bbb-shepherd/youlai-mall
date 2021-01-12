package com.youlai.mall.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.ums.pojo.UmsMember;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface UmsMemberMapper extends BaseMapper<UmsMember> {


    @Select("<script>" +
            " SELECT * from ums_member " +
            " <if test ='member.nickname !=null and member.nickname.trim() neq \"\" ' >" +
            "       AND nickname like concat('%',#{member.nickname},'%')" +
            " </if>" +
            " ORDER BY gmt_updated DESC, gmt_create DESC" +
            "</script>")
    @Results({
            @Result(property = "addressList", column = "id", many = @Many(select = "com.youlai.mall.ums.mapper.UmsMemberAddressMapper.listByMemberId"))
    })
    List<UmsMember> list(Page<UmsMember> page, UmsMember member);


}