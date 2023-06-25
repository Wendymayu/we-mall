package org.wendy.mall.service.admin;

import org.springframework.transaction.annotation.Transactional;
import org.wendy.mall.common.CommonPage;
import org.wendy.mall.dao.entity.PmsBrand;
import org.wendy.mall.dto.brand.PmsBrandParam;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/6/23 22:53
 * @Version 1.0
 */
public interface BrandService {
    /**
     * 获取品牌详情
     */
    PmsBrand getBrand(Long id);

    /**
     * 获取所有品牌
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     */
    int createBrand(PmsBrandParam pmsBrandParam);

    /**
     * 修改品牌
     */
    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 批量删除品牌
     */
    int deleteBrand(List<Long> ids);

    /**
     * 分页查询品牌
     */
    CommonPage<PmsBrand> listBrand(String keyword, Integer showStatus, int pageNum, int pageSize);
}