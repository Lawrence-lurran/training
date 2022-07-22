package com.nmu.training.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nmu.training.domain.entity.SamplingInformationDO;
import com.nmu.training.mapper.SamplingInformationMapper;
import com.nmu.training.service.ISamplingInformationService;
import org.springframework.stereotype.Service;

/**
 * (SamplingInformation)表服务实现类
 *
 * @author makejava
 * @since 2022-07-22 14:37:30
 */
@Service("samplingInformationService")
public class SamplingInformationServiceImpl extends ServiceImpl<SamplingInformationMapper, SamplingInformationDO> implements ISamplingInformationService {

}
