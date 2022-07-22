package com.nmu.training.controller;


import com.nmu.training.common.ResponseResult;
import com.nmu.training.common.ResultInfo;
import com.nmu.training.domain.entity.SamplingInformationDO;
import com.nmu.training.handler.exception.MyRuntimeException;
import com.nmu.training.service.ISamplingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * (SamplingInformation)表控制层
 *
 * @author makejava
 * @since 2022-07-22 14:37:16
 */
@RestController
@RequestMapping("/samplingInformation")
public class SamplingInformationController {

    @Autowired
    private ISamplingInformationService samplingInformationService;

    @PostMapping("/add")
    public ResponseResult<Boolean> add(@RequestBody SamplingInformationDO samplingInformationDO){
        boolean save = samplingInformationService.save(samplingInformationDO);
        if (!save){
            throw new MyRuntimeException(ResultInfo.SAVE_SAMPLING_INFORMATION_ERROR);
        }
        return ResponseResult.success();
    }

}

