package org.wendy.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.wendy.mall.dao.entity.PmsBrand;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/6/24 8:50
 * @Version 1.0
 */
@Mapper
public interface PmsBrandMapper extends BaseMapper<PmsBrand> {
    IPage<PmsBrand> queryByName(IPage<PmsBrand> page, String keyword, Integer showStatus);
}