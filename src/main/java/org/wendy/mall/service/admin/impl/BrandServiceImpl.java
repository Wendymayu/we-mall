package org.wendy.mall.service.admin.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.wendy.mall.common.CommonPage;
import org.wendy.mall.dao.PmsBrandMapper;
import org.wendy.mall.dao.entity.PmsBrand;
import org.wendy.mall.dto.brand.PmsBrandParam;
import org.wendy.mall.service.admin.BrandService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 品牌管理的业务实现类
 * @Author wendyma
 * @Date 2023/6/24 8:48
 * @Version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectById(id);
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectList(null);
    }

    @Override
    public int createBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);

        // 如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);

        // 如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }

        // 更新品牌时要更新商品中的品牌名称
        // TODO
        return pmsBrandMapper.updateById(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteById(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        return pmsBrandMapper.deleteBatchIds(ids);
    }

    @Override
    public CommonPage<PmsBrand> listBrand(String keyword, Integer showStatus, int pageNum, int pageSize) {
        IPage<PmsBrand> page = new Page<>(pageNum, pageSize);
        IPage<PmsBrand> dataPage = pmsBrandMapper.queryByName(page, keyword, showStatus);

        return CommonPage.data(dataPage.getTotal(), dataPage.getRecords());
    }
}
