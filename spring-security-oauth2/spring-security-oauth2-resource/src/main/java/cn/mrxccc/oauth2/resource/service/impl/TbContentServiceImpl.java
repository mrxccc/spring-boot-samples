package cn.mrxccc.oauth2.resource.service.impl;

import cn.mrxccc.oauth2.resource.domain.TbContent;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.oauth2.resource.mapper.TbContentMapper;
import cn.mrxccc.oauth2.resource.service.TbContentService;
@Service
public class TbContentServiceImpl implements TbContentService{

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }

}
