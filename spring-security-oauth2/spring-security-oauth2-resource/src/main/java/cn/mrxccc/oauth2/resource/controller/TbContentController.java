package cn.mrxccc.oauth2.resource.controller;

import cn.mrxccc.oauth2.resource.domain.TbContent;
import cn.mrxccc.oauth2.resource.dto.ResponseResult;
import cn.mrxccc.oauth2.resource.service.TbContentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mrxccc
 * @create 2020/11/27
 */
@RestController
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    /**
     * 获取全部资源
     *
     * @return
     */
    @GetMapping("/")
    public ResponseResult<List<TbContent>> selectAll() {
        return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), tbContentService.selectAll());
    }
}
